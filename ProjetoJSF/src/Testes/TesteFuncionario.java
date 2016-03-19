package Testes;

import javax.persistence.EntityManager;

import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Funcionario;
import br.com.modelo.Grupo;
import br.com.modelo.Setor;

public class TesteFuncionario {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
							//class e ID
		Setor s1 = em.find(Setor.class, 4);
		Grupo g = em.find(Grupo.class,1);
		
		Funcionario f = new Funcionario();
		f.setNome("ivonildo");
		f.setCpf("031.741.803-3");
		f.setEmail("ivonildolopes@sefaz.ce.gov.br");
		//f.setDataNascimento(Calendar.getInstance());
		f.setAtivo(true);		
		
		f.setSalario(1795.55);
		f.setUsuario("ivonildo");
		f.setSenha("010203pj");
		f.setSetor(s1);
		f.setGrupo(g);
		

		
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		
		System.out.println("deu certo");
	}

}
