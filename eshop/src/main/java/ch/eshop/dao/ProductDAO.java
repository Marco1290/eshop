package ch.eshop.dao;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ProductDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save (Product product){
        em.persist(product);
    }

    @Transactional
    public Product findByID(Integer id){
        return em.find(Product.class, id);
    }

    @Transactional
    public List<Product> findAll(){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> rootEntry = cq.from(Product.class);
        CriteriaQuery<Product> all = cq.select(rootEntry);

        TypedQuery<Product> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    @Transactional
    public void update( Product product){
        em.merge(product);
    }


    public void delete ( Product product){
        em.remove(product);
    }
}
