package br.com.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name= "FUNCIONARIOS")
public class Funcionario implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable=false,length=100)
	@NotEmpty(message="O campo nome é obrigatório")
	@Length(max=100, min=3, message="o nome do funcionario deve conter entre {max} e {min} caracteres ")
	private String nome;
	
	@Column(nullable=false,length=14,unique=true)
	@NotEmpty(message="o cpf é obrigatório")
	@Length(max=14,message="o campo CPF só pode conter {max} caracteres")
	private String cpf;
	
	@Column(nullable=false,length=50,unique=true)
	@NotEmpty(message="o email é obrigatório")
	@Length(max=50,message="o campo CPF só pode conter {max} caracteres")
	@Email(message="digite um email válido")
	private String email;
	
	@Column(columnDefinition="numeric(10,2)")
	private Double salario;
	
	
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	private Boolean ativo;
	
	@Lob
	private byte[] foto;
	
	@Column(nullable=false,length=12,unique=true)
	@NotEmpty(message="o nome do usuario é obrigatório")
	@Length(max=12,message="o campo usuario só pode conter {max} caracteres")
	@Index(name="INX_FUNCIONARIO_USUARIO")
	private String usuario;
	
	@Column(nullable=false,length=8,unique=true)
	@NotEmpty(message="o email é obrigatório")
	@Length(max=8,min=4,message="o campo senha deeve conter entre {max} e {min} caracteres")
	private String senha;
	
	@ManyToOne // muitos funcionarios para um grupo
	@JoinColumn(name="grupo", referencedColumnName = "id")
	@NotNull(message="o grupo deve ser informado")
	private Grupo grupo;
	
	@ManyToOne // muitos funcionarios para um grupo
	@JoinColumn(name="setor", referencedColumnName = "id")
	@NotNull(message="o grupo deve ser informado")
	private Setor setor;
	
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}


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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public Calendar getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}


	public byte[] getFoto() {
		return foto;
	}


	public void setFoto(byte[] foto) {
		this.foto = foto;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Grupo getGrupo() {
		return grupo;
	}


	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}


	public Setor getSetor() {
		return setor;
	}


	public void setSetor(Setor setor) {
		this.setor = setor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + "]";
	}
	
	
}
