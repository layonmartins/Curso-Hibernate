package curso.hibernate.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import curso.hibernate.heranca.VeiculoDuasRodas;
import curso.hibernate.heranca.VeiculoQuatroRodas;
import curso.hibernate.modelo.Funcionario;
import curso.hibernate.modelo.Projeto;

public class VeiculoHerancaTeste {

	public static void main(String[] args) {
		
		StandardServiceRegistry standardRegistry = 
			       new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				Metadata metaData = 
			        new MetadataSources(standardRegistry).getMetadataBuilder().build();
				SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
				
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		VeiculoQuatroRodas fusca = new VeiculoQuatroRodas();
		fusca.setMarca("VW");
		fusca.setModelo("Fusca");
		fusca.setAno(1996);
		fusca.setQuantidadePortas(2);
		
		VeiculoDuasRodas moto = new VeiculoDuasRodas();
		moto.setMarca("Honda");
		moto.setModelo("CG");
		moto.setAno(2015);
		moto.setCilindras(150);
		
		session.save(fusca);
		session.save(moto);
		
		
		session.getTransaction().commit();
		session.close();
		
	}
}
