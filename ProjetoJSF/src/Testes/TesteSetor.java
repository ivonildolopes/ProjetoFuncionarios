package Testes;

import javax.persistence.EntityManager;

import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Setor;

public class TesteSetor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		Setor setor1 = new Setor();
		setor1.setNome("TESTE1");
			
		Setor setor2 = new Setor();
		setor2.setNome("TESTE2");

		em.getTransaction().begin();
		em.persist(setor1);
		em.persist(setor2);
		em.getTransaction().commit();
		
		System.out.println("Deu Certo");
	}

}
