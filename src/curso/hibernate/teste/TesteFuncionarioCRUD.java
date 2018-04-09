package curso.hibernate.teste;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import curso.hibernate.modelo.Funcionario;

public class TesteFuncionarioCRUD {
	

	public static void main(String[] args) {
		//Create
		Funcionario funcionario = new Funcionario("Luciana Paula", 2500.0, "1234", new Date());
		funcionario.setId(1);
		create(funcionario);
		
		// Read
		//Funcionario funcionarioBanco = read(1);
		//System.out.println("Nome: " + funcionarioBanco.getName());
		
		// Update
		//funcionarioBanco.setName("Manuela");
		//funcionarioBanco.setCpf("8998");
		//update(funcionarioBanco);
		
		//Save or Update
		//SalvarOuAlterar(funcionarioBanco);
		
		// Delete
		Funcionario funcionarioRemover = read(1);
		delete(funcionarioRemover);
		
		/*Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		
		session.getTransaction().commit();
		session.close();*/
	}
	
	private static void update(Funcionario funcionario) {
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		
		Funcionario funcBanco = session.get(Funcionario.class, 1);
		funcBanco.setName("Manuel Alterado");
		
		//session.update(funcionario);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	private static void SalvarOuAlterar(Funcionario funcionario) {
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(funcionario);
		
		session.getTransaction().commit();
		session.close();
		
	}

	public static void create(Funcionario funcionario){
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(funcionario);
		
		session.getTransaction().commit();
		session.close();
	}

	public static Funcionario read(Integer idFuncionario) {
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
	
		Funcionario funcionario = (Funcionario) session.get(Funcionario.class, idFuncionario);
		
		session.close();
		
		return funcionario;
	}
	
	public static void delete (Funcionario funcionario) {
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(funcionario);
		
		session.getTransaction().commit();
		session.close();
	}
	
	private static SessionFactory obterSessionFactory() {
		StandardServiceRegistry standardRegistry = 
			       new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				Metadata metaData = 
			        new MetadataSources(standardRegistry).getMetadataBuilder().build();
				SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		return sessionFactory;
	}
}
