//package com.mantinha.springbatchtraining.job.step.reader.flat;
//
//import org.springframework.batch.item.ExecutionContext;
//import org.springframework.batch.item.ItemStreamException;
//import org.springframework.batch.item.ItemStreamReader;
//
//import com.mantinha.springbatchtraining.entity.ClienteWithTransacao;
//import com.mantinha.springbatchtraining.entity.Transacao;
//
//public class MyReaderWithFlatMultiLinesImpl implements ItemStreamReader<ClienteWithTransacao> {
//
//	private Object currentObj;
//	private ItemStreamReader<Object> delegate;
//	
//	public MyReaderWithFlatMultiLinesImpl(ItemStreamReader<Object> delegate) {
//		this.delegate = delegate;
//	}
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
//	public ClienteWithTransacao read() throws Exception {
//		if(currentObj == null)
//			currentObj = delegate.read();
//					
//		ClienteWithTransacao cache = (ClienteWithTransacao) currentObj;
//		currentObj = null;
//		
//		if(cache != null) {
//			while( peek() instanceof Transacao )
//				cache.getTransacoes().add( (Transacao) currentObj );
//		}
//			
//		return cache;
//	}
//	
//	private Object peek() throws Exception {
//		currentObj = delegate.read();
//		return currentObj;
//	}
//
//}
