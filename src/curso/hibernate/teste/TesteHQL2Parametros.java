package curso.hibernate.teste;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import curso.hibernate.modelo.Funcionario;

public class TesteHQL2Parametros {

	public static void main(String[] args) {
		
		Session session = GeradorSessionFactory.obterSessionFactory().openSession();
		
		Integer id = 5;
		Double salario = 3000.00;
		
		
		Query consulta = session
				.createQuery("from Funcionario where id >= ? and " +
							"salario < :salario order by name");
		
		consulta.setParameter(0,  id);
		consulta.setParameter("salario",  salario);
		
		List<Funcionario> funcionarios = consulta.list();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Id: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getName());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("Salario: " + funcionario.getSalario());
			System.out.println("---------------------------\n");
		}
		
		session.close();
	}
}
