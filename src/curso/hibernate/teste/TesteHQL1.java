package curso.hibernate.teste;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import curso.hibernate.modelo.Funcionario;

public class TesteHQL1 {

	public static void main(String[] args) {
		
		Session session = GeradorSessionFactory.obterSessionFactory().openSession();
		
		Query consulta = session.createQuery("from Funcionario order by name");
		
		
		List<Funcionario> funcionarios = consulta.list();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getName());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("---------------------------\n");
		}
		
		session.close();
	}
}
