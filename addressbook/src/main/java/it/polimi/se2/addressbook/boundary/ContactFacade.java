/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.se2.addressbook.boundary;

import it.polimi.se2.addressbook.entity.Contact;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author miglie
 */
@Stateless
public class ContactFacade  {
    
    @PersistenceContext(unitName = "addressbookPU")
    private EntityManager em;

    
    public void create(Contact entity) {
        em.persist(entity);
    }

    public void edit(Contact entity) {
        em.merge(entity);
    }

    public void remove(Contact entity) {
        em.remove(em.merge(entity));
    }

    public Contact find(Object id) {
        return em.find(Contact.class, id);
    }

    public List<Contact> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Contact.class));
        return em.createQuery(cq).getResultList();
    }
    
    public List<Contact> findAll2(){
        TypedQuery<Contact> query = em.createNamedQuery(Contact.findAll, Contact.class);
        return query.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Contact> rt = cq.from(Contact.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public int count2() {
        Query query = em.createNamedQuery(Contact.count);
        return ((Number)query.getSingleResult()).intValue();
    }
    
}
