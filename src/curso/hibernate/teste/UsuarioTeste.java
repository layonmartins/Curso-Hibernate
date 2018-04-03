package curso.hibernate.teste;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import curso.hibernate.modelo.Endereco;
import curso.hibernate.modelo.EstadoCivil;
import curso.hibernate.modelo.Usuario;
import curso.hibernate.modelo.Veiculo;

public class UsuarioTeste {

	
	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		
		usuario.setNome("Usuario Teste 1");
		usuario.setDataNascimento(new Date());
		usuario.setEstadoCivil(EstadoCivil.SOLTEIRO);
		//usuario.setIdade(25);
		
		Veiculo fusca = new Veiculo("Fusca", 1966);
		usuario.setVeiculo(fusca);
		fusca.setUsuario(usuario);
		
		/*Endereco endereco = new Endereco();
		endereco.setCidade("Cidade teste");
		endereco.setLogradouro("Rual tal");
		endereco.setNumero(123);
		usuario.getEnderecos().add(endereco);
		
		Endereco enderecoComercial = new Endereco();
		enderecoComercial.setCidade("Cidade teste C");
		enderecoComercial.setLogradouro("Rual tal C");
		enderecoComercial.setNumero(1234);
		usuario.getEnderecos().add(enderecoComercial);*/
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		
		session.save(fusca);
		//session.save(usuario);
		
		
		session.getTransaction().commit();
		
		/*
		Usuario usuarioBanco = (Usuario) session.get(Usuario.class, 6);
		System.out.println("Nome: " + usuarioBanco.getNome());
		System.out.println("Buscou no Banco");
		//List<Endereco> enderecos = usuarioBanco.getEnderecos();
		System.out.println("Ainda não buscou o banco");
		//System.out.println("Endereço " + enderecos.get(0).getLogradouro());
*/		
		session.close();
		
	}
}
