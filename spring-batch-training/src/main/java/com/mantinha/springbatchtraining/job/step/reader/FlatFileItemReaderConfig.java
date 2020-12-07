package com.mantinha.springbatchtraining.job.step.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mantinha.springbatchtraining.entity.GrupoLancamento;
import com.mantinha.springbatchtraining.entity.Lancamento;

@Configuration
public class FlatFileItemReaderConfig {
	
	@Bean
	public FlatFileItemReader<GrupoLancamento> reader() {
		return new FlatFileItemReaderBuilder<GrupoLancamento>()
				.name("reader")				
				.delimited()
				.names("codigoNaturezaDespesa", 
						"descricaoNaturezaDespesa", 
						"descricaoLancamento", 
						"dataLancamento", 
						"valorLancamento")
				.fieldSetMapper(fieldSetMapper())
				.build();
	}

	private FieldSetMapper<GrupoLancamento> fieldSetMapper() {
		return new FieldSetMapper<GrupoLancamento>() {

			@Override
			public GrupoLancamento mapFieldSet(FieldSet fieldSet) {
				GrupoLancamento grpl = new GrupoLancamento();
				grpl.setCodigoNaturezaDespesa(fieldSet.readInt("codigoNaturezaDespesa"));
				grpl.setDescricaoNaturezaDespesa(fieldSet.readString("descricaoNaturezaDespesa"));				
				grpl.setLancamentoTmp(new Lancamento());
				grpl.getLancamentoTmp().setData(fieldSet.readDate("dataLancamento"));
				grpl.getLancamentoTmp().setDescricao(fieldSet.readString("descricaoLancamento"));
				grpl.getLancamentoTmp().setValor(fieldSet.readDouble("valorLancamento"));
				return grpl;
			}
			
		};
	}

}
