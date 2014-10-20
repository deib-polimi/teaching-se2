package it.polimi.se2.beans;

import it.polimi.se2.entities.WordEntity;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Dependent
public class WordBean implements Word {

	@PersistenceContext
    private EntityManager em;
    
//    @PostConstruct
//    public void postContruct(){
//    	Context ctx;
//		try {
//			ctx = new InitialContext();
//			em = (EntityManager) ctx.lookup("jndi/ChatDemoDB");
//		} catch (NamingException e) {
//			Logger.getLogger(WordBean.class.getName()).log(Level.SEVERE, null, e);
//		}  	
//    }

	@Override
	public WordEntity add(String word) {
		WordEntity newWord = new WordEntity(word);
		em.persist(newWord);
		return newWord;
	}

	@Override
	public WordEntity get(Long id) {
		return em.find(WordEntity.class, id);
	}

	@Override
	public void delete(Long id) {
		em.remove(em.find(WordEntity.class, id));
	}

	@Override
	public WordEntity update(Long id, String newContent) { 
		WordEntity w = em.find(WordEntity.class, id);
		w.setContent(newContent);
		em.merge(w);
		return w;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WordEntity> search(String filter) {
		return em.createNamedQuery("Word.search").setParameter("filter", filter).getResultList();
	}

	@Override
	public WordEntity first() {
		return em.find(WordEntity.class, 0);
	}

	@Override
	public List<WordEntity> all() {
		@SuppressWarnings("unchecked")
		List<WordEntity> resultList = em.createNamedQuery("Word.all").getResultList();
		return resultList;
	}
}
