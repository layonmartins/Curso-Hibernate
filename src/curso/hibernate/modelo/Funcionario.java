package curso.hibernate.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Funcionario {

	private Integer id;
	private String name;
	private Double salario;
	private String cpf;
	private Date dataAdmissao;
	private List<Projeto> projetos = new ArrayList<>();
	
	public Funcionario(){
		
	}
	
	public Funcionario(String name, Double salario, String cpf, Date dataAdmissao) {
		super();
		this.name = name;
		this.salario = salario;
		this.cpf = cpf;
		this.dataAdmissao = dataAdmissao;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="func_proj",
	joinColumns = @JoinColumn(name = "id_func"),
	inverseJoinColumns = @JoinColumn(name = "id_proj"))
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_admissao")
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	
	
}
