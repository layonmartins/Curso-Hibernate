package curso.hibernate.teste;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class GeradorSessionFactory {

	public static SessionFactory obterSessionFactory() {
		StandardServiceRegistry standardRegistry = 
			       new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				Metadata metaData = 
			        new MetadataSources(standardRegistry).getMetadataBuilder().build();
				SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		return sessionFactory;
	}
	
}
