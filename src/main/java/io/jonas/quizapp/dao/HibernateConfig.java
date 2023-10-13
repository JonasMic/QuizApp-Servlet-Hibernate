package io.jonas.quizapp.dao;

import org.hibernate.service.*;

import io.jonas.quizapp.entity.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;


public class HibernateConfig {
	  private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	                Configuration configuration = new Configuration();

	                // Hibernate settings equivalent to hibernate.config.xml's properties
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/teluskodb?useSSL=false");
	                settings.put(Environment.USER, "root");
	                settings.put(Environment.PASS, "------");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
	                settings.put(Environment.SHOW_SQL, "true");
	                settings.put(Environment.FORMAT_SQL,"true");

	                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	                //settings.put(Environment.HBM2DDL_AUTO, "create");
	               settings.put(Environment.HBM2DDL_AUTO, "update");

	                configuration.setProperties(settings);

	                configuration.addAnnotatedClass(Questzion.class);
	                configuration.addAnnotatedClass(Userh.class);

	                ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();

	                sessionFactory = configuration.buildSessionFactory( serviceRegistry);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }
	    
	    public static SessionFactory createSessionfactory() {
	    	SessionFactory sessionFactory=new Configuration().configure("/hibernate.config.xml").buildSessionFactory();
			return sessionFactory;
	    	
	    }

}
