package curso.hibernate.teste;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import curso.hibernate.modelo.Funcionario;

public class TesteHQLManipulacaoDatas {

	public static void main(String[] args) {
		
		Session session = GeradorSessionFactory.obterSessionFactory().openSession();
		
		//Query consulta = session.createQuery("select f from Funcionario f where date(f.dataAdmissao) = "
		//		+ "CURRENT_date order by f.name");

		Query consulta = session.createQuery("select f from Funcionario f where "
				+ "day(f.dataAdmissao) = day(current_date) and "
				+ "month(f.dataAdmissao) = month(current_date) order by f.name");
		//consulta.setParameter("ano", 2018);
				
		
		List<Funcionario> funcionarios = consulta.list();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getName());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("Data Admissão: " + formatarData(funcionario.getDataAdmissao()));
			System.out.println("---------------------------\n");
		}
		
		session.close();
	}
	
	public static String formatarData(Date data){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}
}
