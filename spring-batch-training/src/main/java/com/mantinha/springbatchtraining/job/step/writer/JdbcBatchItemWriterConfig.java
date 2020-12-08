package com.mantinha.springbatchtraining.job.step.writer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mantinha.springbatchtraining.entity.Conta;

/**
 * Configura a saide de dados para o banco de dados especificado
 * banco setado no metodo secondDataSource (VER MyDataSource)
 * 
 * @author adriano
 *
 */
@Configuration
public class JdbcBatchItemWriterConfig {
	
	@Bean
	public JdbcBatchItemWriter<Conta> jdbcWriter(
			@Qualifier("secondDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Conta>()
				.dataSource(dataSource)
				.sql("INSERT INTO conta (tipo, limite, cliente_id) VALUES(?, ?, ?)")
				.itemPreparedStatementSetter(itemPreparedStatementSetter())
				.build();
	}

	private ItemPreparedStatementSetter<Conta> itemPreparedStatementSetter() {
		return new ItemPreparedStatementSetter<Conta>() {

			@Override
			public void setValues(Conta item, PreparedStatement ps) throws SQLException {
				ps.setString(1, item.getTipo().name());
				ps.setDouble(2, item.getLimite());
				ps.setString(3, item.getClienteId());
			}
			
		};
	}

}
