package com.poslovna.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableTransactionManagement
public class PersistenceJPAConfig {
	
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource(){
		return DataSourceBuilder.create().build();
	}
	 
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean emf(){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(new String[] {"com.poslovna.model"});
		
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
		emf.getJpaPropertyMap().put("hibernate.show_sql", "true");
		return emf;
		
	}
	 
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(){
	   JpaTransactionManager tm = new JpaTransactionManager();
	   tm.setEntityManagerFactory(emf().getObject());
	   return tm;
	}
	
	
}
