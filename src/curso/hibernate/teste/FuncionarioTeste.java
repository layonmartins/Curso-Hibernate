package curso.hibernate.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import curso.hibernate.modelo.Funcionario;
import curso.hibernate.modelo.Projeto;

public class FuncionarioTeste {

	public static void main(String[] args) {
		
		StandardServiceRegistry standardRegistry = 
			       new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				Metadata metaData = 
			        new MetadataSources(standardRegistry).getMetadataBuilder().build();
				SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
				
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setName("João Batista");
		funcionario1.setSalario(200.0);
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setName("Manuel Oliveira");
		funcionario2.setSalario(2500.0);
		
		Projeto projeto1 = new Projeto();
		projeto1.setNome("Projeto 1");
		
		Projeto projeto2 = new Projeto();
		projeto2.setNome("Projeto 2");
		
		funcionario1.getProjetos().add(projeto1);
		funcionario1.getProjetos().add(projeto2);
		
		funcionario2.getProjetos().add(projeto1);
		
		
		projeto1.getFuncionarios().add(funcionario1);
		
		projeto2.getFuncionarios().add(funcionario1);
		projeto2.getFuncionarios().add(funcionario2);
		
		session.save(funcionario1);
		session.save(funcionario2);
		//session.save(projeto1);
		//session.save(projeto2);
		
		
		session.getTransaction().commit();
		session.close();
		
	}
}
