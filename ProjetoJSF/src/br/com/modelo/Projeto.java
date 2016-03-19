package br.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
public class Projeto implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable=false,length=50)
	@Length(max=50,message="O nome não pode passar {max} caracteres")
	@NotEmpty(message="o campo nome é obrigatório")
	private String nome;
	
	@Column(nullable=false)
	@NotEmpty(message="o campo descricao é obrigatório")
	@Lob
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Calendar data_inicio;
	
	@Temporal(TemporalType.DATE)
	private Calendar data_fim;
	
	private Boolean ativo;
	
	@ManyToOne // um setor tem muitos projetos 
	@JoinColumn(name="setor",referencedColumnName="id",nullable=false)
	@NotNull(message="O setor deve ser informado")
	private Setor setor;
	
	
	/**
	 * na assinatuta @OneToMany - temos que levar em consiração qual o atributo faz a ligação na classe 
	 * Projetofuncioario - é justamente o atributo "projeto" por isso devemos mapea-lo aqui
	 */
	@OneToMany(mappedBy="projeto",cascade={CascadeType.ALL},orphanRemoval=true) // um projeto tem muitos funcionarios ou muitos funcionarios estão em um projeto
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<ProjetoFuncionario> listaFuncionariosProjeto = new ArrayList<ProjetoFuncionario>();
	
	public Projeto() {
		// TODO Auto-generated constructor stub
	}

	
	public void adicionarFuncionarioProjeto(ProjetoFuncionario obj){
		obj.setProjeto(this);
		this.listaFuncionariosProjeto.add(obj);
	}
	
	public void removerFuncionarioProjeto(ProjetoFuncionario obj){
		if(this.listaFuncionariosProjeto.contains(obj))
			this.listaFuncionariosProjeto.remove(obj);
	}
	
	//get and set
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Calendar data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Calendar getData_fim() {
		return data_fim;
	}

	public void setData_fim(Calendar data_fim) {
		this.data_fim = data_fim;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projeto [nome=" + nome + "]";
	}

	
	
}
