package net.rch.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"net.rch.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	//Oracle DB Configuration
	private final static String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final static String DATABASE_USERNAME = "system";
	private final static String DATABASE_PASSWORD = "manager";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.OracleDialect";
	
	//dataSource bean will be available
	@Bean("dataSource")
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		//Providing the DB connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	//SessionFactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.rch.shoppingbackend.dto");
		
		return builder.buildSessionFactory();
	}

	//All the Hibernate properties will be return in this method
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		//properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true"); 
		//properties.put("hibernate.pool_size", "50");

		return properties;
	}
	
	//Create Hibernate transactionManager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	
}
