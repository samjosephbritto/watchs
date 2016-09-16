package com.niit.backend.config;

 

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
import org.springframework.web.servlet.config.annotation.EnableWebMvc; 
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter; 
import com.niit.backend.model.Blog;
import com.niit.backend.model.Chat;
import com.niit.backend.model.Event;
import com.niit.backend.model.Friend;
import com.niit.backend.model.Job;
import com.niit.backend.model.Role;
import com.niit.backend.model.User_Detail;
import com.niit.backend.model.User_Role;

 
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.niit.backend")
public class WebConfig extends WebMvcConfigurerAdapter{

	
	 
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("hr");
		dataSource.setPassword("manager");
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
     	properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
    	return properties;
    }
	
	@Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
     
    	sessionBuilder.addAnnotatedClass(Blog.class);
    	sessionBuilder.addAnnotatedClass(Event.class);
    	sessionBuilder.addAnnotatedClass(Job.class);
    	sessionBuilder.addAnnotatedClass(Friend.class);
    	sessionBuilder.addAnnotatedClass(User_Detail.class);
    	sessionBuilder.addAnnotatedClass(User_Role.class);
    	sessionBuilder.addAnnotatedClass(Role.class);
    	sessionBuilder.addAnnotatedClass(Chat.class);
    	 
        return sessionBuilder.buildSessionFactory();
    }
    
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
   

	
	
}
