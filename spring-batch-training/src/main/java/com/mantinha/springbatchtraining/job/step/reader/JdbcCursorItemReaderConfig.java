//package com.mantinha.springbatchtraining.job.step.reader.jdbc;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.RowMapper;
//
//import com.mantinha.springbatchtraining.entity.GrupoLancamento;
//import com.mantinha.springbatchtraining.entity.Lancamento;
//
//@Configuration
//public class JdbcCursorItemReaderConfig {
//	
//	@Bean
//	public JdbcCursorItemReader<GrupoLancamento> reader(@Qualifier("firstDataSource") DataSource dataSource) {
//		return new JdbcCursorItemReaderBuilder<GrupoLancamento>()
//				.name("reader")
//				.dataSource(dataSource)
//				.sql("select * from lancamento")
////				.rowMapper(new BeanPropertyRowMapper<GrupoLancamento>(GrupoLancamento.class))
//				.rowMapper(rowMapper())
//				.build();
//	}
//
//	private RowMapper<GrupoLancamento> rowMapper() {
//		return new RowMapper<GrupoLancamento>() {
//
//			@Override
//			public GrupoLancamento mapRow(ResultSet rs, int rowNum) throws SQLException {
//				GrupoLancamento grpl = new GrupoLancamento();
//				grpl.setCodigoNaturezaDespesa(rs.getInt("codigoNaturezaDespesa"));
//				grpl.setDescricaoNaturezaDespesa(rs.getString("descricaoNaturezaDespesa"));				
//				grpl.setLancamentoTmp(new Lancamento());
//				grpl.getLancamentoTmp().setData(rs.getDate("dataLancamento"));
//				grpl.getLancamentoTmp().setDescricao(rs.getString("descricaoLancamento"));
//				grpl.getLancamentoTmp().setValor(rs.getDouble("valorLancamento"));
//				return grpl;
//			}
//			
//		};
//	}
//
//}
