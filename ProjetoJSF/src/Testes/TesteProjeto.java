package Testes;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Funcionario;
import br.com.modelo.Projeto;
import br.com.modelo.ProjetoFuncionario;
import br.com.modelo.Setor;

public class TesteProjeto {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		Setor setor = em.find(Setor.class, 4);
		Funcionario funcionario = em.find(Funcionario.class,13);
		
		Projeto projeto = new Projeto();
		// definindo o projeto
		projeto.setNome("SISTEMAS DE FUNCIONARIOS");
		projeto.setDescricao("SISTEMA QUE REALIZA A ALOCAÇÃO DOS FUNCIONARIOS");
		projeto.setAtivo(true);
		projeto.setData_fim(Calendar.getInstance());
		projeto.setData_inicio(Calendar.getInstance());
		projeto.setSetor(setor);

		
		//definindo quem vai fazer parte do projeto
		ProjetoFuncionario projetoFuncionario = new ProjetoFuncionario();
		projetoFuncionario.setCargaHorario(100);
		projetoFuncionario.setGestor(true);
		projetoFuncionario.setFimParticipacao(Calendar.getInstance());
		projetoFuncionario.setInicioParticipacao(Calendar.getInstance());
		projetoFuncionario.setFuncionario(funcionario);
		
		projeto.adicionarFuncionarioProjeto(projetoFuncionario);
		
		em.getTransaction().begin();
		em.persist(projeto);
		em.getTransaction().commit();
		
	}

}
