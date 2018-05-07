package net.web.shoppingbackend.config;


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


/*@configuration : Indicates certian configurations or  beans will be managed by Spring framework
@ComponentScan : Tells where the entity classes reside which will be used by hibernate
@EnableTransactionManagement : Manages transactions*/

@Configuration
@ComponentScan(basePackages={"net.web.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	// Change the below based on the DBMS you choose
		private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshoppingnew";
		private final static String DATABASE_DRIVER = "org.h2.Driver";
		private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
		private final static String DATABASE_USERNAME = "sa";
		private final static String DATABASE_PASSWORD = "";
		
		// dataSource bean will be available
		@Bean
		public DataSource getDataSource(){
			
			//BasicDataSource is comig from connection pooling. This dependency was added in POM
			BasicDataSource dataSource = new BasicDataSource();
			
			dataSource.setDriverClassName(DATABASE_DRIVER);
			dataSource.setUrl(DATABASE_URL);
			dataSource.setUsername(DATABASE_USERNAME);
			dataSource.setPassword(DATABASE_PASSWORD);
			
			return dataSource;
		}
		
		// sessionFactory bean will be available
		
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource) {
			
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
			builder.addProperties(getHibernateProperties());
			builder.scanPackages("net.web.shoppingbackend.dto");
			return builder.buildSessionFactory();
		}

		// All the hibernate properties will be returned in this method	
		private Properties getHibernateProperties() {
			
			Properties properties = new Properties();
			properties.put("hibernate.dialect", DATABASE_DIALECT);		
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");
			//properties.put("hibernate.hbm2ddl.auto", "create");
			
			return properties;
		}
		
		// transactionManager bean
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}
}
