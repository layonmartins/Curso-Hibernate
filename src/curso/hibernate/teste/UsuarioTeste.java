package curso.hibernate.teste;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import curso.hibernate.modelo.EstadoCivil;
import curso.hibernate.modelo.Usuario;

public class UsuarioTeste {

	
	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		
		usuario.setNome("Usuario Teste 1");
		usuario.setDataNascimento(new Date());
		usuario.setEstadoCivil(EstadoCivil.SOLTEIRO);
		usuario.setIdade(25);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(usuario);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
