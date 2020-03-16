package com.adailsilva.eventosfacid;

// importações para MySQL
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * @author AdailSilva
 */

@Configuration
@Profile("dev") // pegando o perfil de desenvolvimento (pega configuração do banco que uso localmente)
public class DataConfigurationMySQL {

	// configuração (Bean) de conexão com o banco de dados MySQL
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dbeventosfacid");
		dataSource.setUsername("root");
		dataSource.setPassword("Hacker101");
		return dataSource;
	}

	// configuração (Bean) para conexão com o Hibernate
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL); // definindo o banco de dados
		adapter.setShowSql(true); // como "true" mostra o tramite dos dados com o banco no console
		adapter.setGenerateDdl(true); // como "true" permite que o Hibernate crie as tabelas automaticamente
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect"); // definição do dialeto que será utilizado
		adapter.setPrepareConnection(true); // como "true" para que o Hibernate prepare a conexão automaticamente
		return adapter;
	}

}
