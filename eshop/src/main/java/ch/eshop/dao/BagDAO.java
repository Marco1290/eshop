package ch.eshop.dao;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class BagDAO {

    @PersistenceContext
    private  EntityManager em;

    @Transactional
    public void save (Bag bag){
        em.persist(bag);
    }

    @Transactional
    public Bag findByID(int id){
        return em.find(Bag.class, id);
    }

    @Transactional
    public List<Bag> findAll(){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Bag> cq = cb.createQuery(Bag.class);
        Root<Bag> rootEntry = cq.from(Bag.class);
        CriteriaQuery<Bag> all = cq.select(rootEntry);

        TypedQuery<Bag> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    @Transactional
    public List<Bag> findBySessionID(String sessionID){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Bag> cq = cb.createQuery(Bag.class);
        Root<Bag> rootEntry = cq.from(Bag.class);
        cq.where(cb.equal(rootEntry.get("sessionID"),sessionID));

        TypedQuery<Bag> b = em.createQuery(cq);
        return b.getResultList();
    }

    @Transactional
    public List<Bag> findBySessionIDAndProduct(String sessionID,Product product){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Bag> cq = cb.createQuery(Bag.class);
        Root<Bag> rootEntry = cq.from(Bag.class);
        cq.where(cb.equal(rootEntry.get("sessionID"),sessionID));
        cq.where(cb.equal(rootEntry.get("product"),product));

        TypedQuery<Bag> b = em.createQuery(cq);
        return b.getResultList();
    }

    @Transactional
    public void update( Bag bag){
        em.merge(bag);
    }

    @Transactional
    public void delete ( int id){
        Bag theBag =  em.find(Bag.class, id);
        em.remove(theBag);

    }
}
