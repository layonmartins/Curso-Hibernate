package curso.hibernate.teste;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import curso.hibernate.modelo.Funcionario;

public class TesteHQLUniqueResult {

	public static void main(String[] args) {

		Funcionario funcionario = obterPorId(10);
	

		if (funcionario != null) {
			System.out.println("Id: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getName());
			System.out.println("CPF: " + funcionario.getCpf());
		} else {
			System.out.println("Funcionário não encontrado");
		}

		
	}
	
	private static Funcionario obterPorId(Integer id){
		Session session = GeradorSessionFactory.obterSessionFactory().openSession();

		Query consulta = session.createQuery("select f from Funcionario f where f.id > :id order by f.name");
		consulta.setParameter("id", id);
		
		List<Funcionario> funcionarios = consulta.list();
		
		session.close();
		
		if(funcionarios.isEmpty()){
			return null;
		} else {
			return funcionarios.get(0);
		}
		
	}
}
