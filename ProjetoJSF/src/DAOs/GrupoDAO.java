package DAOs;

import javax.persistence.EntityManager;

import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Grupo;

public class GrupoDAO {

	private EntityManager em;
	private Grupo grupo;

	public GrupoDAO() {

		em = EntityManagerUtil.getEntityManager();

	}

	public Grupo pesquisarPorID(Integer id){
		return em.find(Grupo.class, id);
	}
	
	public Grupo pesquisarPorNome(String nome){
		String jpql = "select id,nome from Grupo";
		
		return null;
	}
	
	//crud
	public void salvar(Grupo grupo) {
		try {
			em.getTransaction().begin();
			
			if(grupo.getId() == null)
				em.persist(grupo);
			else
				em.merge(grupo);
			
			em.getTransaction().commit();
		} catch (Exception e) {

		}

	}

	public void remover(Grupo grupo) {
		em.getTransaction().begin();
		em.remove(grupo);
		em.getTransaction().commit();
	}
	
	//get and set
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
