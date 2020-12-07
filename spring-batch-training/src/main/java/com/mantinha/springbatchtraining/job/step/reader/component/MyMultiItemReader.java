//package com.mantinha.springbatchtraining.job.step.reader.component;
//
//import org.springframework.batch.item.ExecutionContext;
//import org.springframework.batch.item.ItemStreamException;
//import org.springframework.batch.item.ItemStreamReader;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Component;
//
//import com.mantinha.springbatchtraining.entity.GrupoLancamento;
//
///**
// * Componente usado para leitura de dados em varios arquivos
// * Padrão Delegate
// * Faz o cache do Objeto lido e espia o proximo
// * 
// * @author adriano
// *
// */
//@Component
//public class MyMultiItemReader implements ItemStreamReader<GrupoLancamento>, ResourceAwareItemReaderItemStream<GrupoLancamento> {
//	
//	@Autowired
//	private FlatFileItemReader<GrupoLancamento> delegate;
//	private GrupoLancamento objetoAtual;
//	
//	@Override
//	public void open(ExecutionContext executionContext) throws ItemStreamException {
//		delegate.open(executionContext);
//	}
//
//	@Override
//	public void update(ExecutionContext executionContext) throws ItemStreamException {
//		delegate.update(executionContext);
//	}
//
//	@Override
//	public void close() throws ItemStreamException {
//		delegate.close();
//	}
//	
//	@Override
//	public void setResource(Resource resource) {
//		delegate.setResource(resource);		
//	}
//
//	@Override
//	public GrupoLancamento read() throws Exception {
//		if(objetoAtual == null)
//			objetoAtual = delegate.read();
//					
//		GrupoLancamento cache = objetoAtual;
//		objetoAtual = null;
//		
//		if(cache != null) {
//			GrupoLancamento proxObjeto = peek();
//			while( isCodigoIgual(cache, proxObjeto) ) {
//				cache.getLancamentos().add( objetoAtual.getLancamentoTmp() );
//				proxObjeto = peek();
//			}				
//			cache.getLancamentos().add( cache.getLancamentoTmp() );
//		}			
//		return cache;
//	}
//	
//	private boolean isCodigoIgual(GrupoLancamento cache, GrupoLancamento proxObjeto) {
//		return proxObjeto != null && proxObjeto.getCodigoNaturezaDespesa().equals(cache.getCodigoNaturezaDespesa());
//	}
//	
//	private GrupoLancamento peek() throws Exception {
//		objetoAtual = delegate.read();
//		return objetoAtual;
//	}		
//	
//}
