package curso.hibernate.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "usu_usuario")
public class Usuario {
	
	
	private Integer id;
	private String nome;
	private Date dataNascimento;
	private int idade;
	private EstadoCivil estadoCivil;
	//private Endereco endereco;
	//private Endereco enderecoComercial;
	private List<Endereco> enderecos = new ArrayList<>();
	
	/*
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="logradouro", column=@Column(name="rua"))
	})
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="logradouro", column=@Column(name="log")),
		@AttributeOverride(name="cidade", column=@Column(name="cid")),
		@AttributeOverride(name="numero", column=@Column(name="num"))
	})
	public Endereco getEnderecoComercial() {
		return enderecoComercial;
	}
	public void setEnderecoComercial(Endereco enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}
	*/
	
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "usu_endereco", joinColumns = @JoinColumn(name = "id_usuario"))
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado_civil")
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Transient
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	

}
