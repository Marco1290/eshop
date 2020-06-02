package ch.eshop.services;

import ch.eshop.dao.Bag;
import ch.eshop.dao.BagDAO;
import ch.eshop.dao.Product;
import ch.eshop.dao.ProductDAO;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BagService {

    private BagDAO bagDAO;
    private ProductDAO productDAO;

    @Inject
    public BagService(BagDAO bagDao,ProductDAO productDAO) {

        this.bagDAO = bagDao;
        this.productDAO = productDAO;
    }

    public  void setProdQtyAttribute(HttpServletRequest req){
        System.out.println(req.getSession().getId());
        List<Bag> bags = bagDAO.findBySessionID(req.getSession().getId());
        int size = bags != null  ? bags.size() : 0;
        req.setAttribute("prodQuantity", size);
    }

    public void save(int productID, String sessionID){

        Product product = productDAO.findByID(productID);
        List<Bag> bags = bagDAO.findBySessionIDAndProduct(sessionID,product);
        System.out.println(bags);
        if(bags != null && bags.size() == 1){
            putQuantity(bags.get(0).getId(),1);
            return;
        }

        Bag bag = new Bag();

        bag.setSessionID(sessionID);
        bag.setQuantity(1);
        bag.setProduct(product);

        bagDAO.save(bag);
    }

    public void delete(int bagID){

        bagDAO.delete(bagID);
    }

    public void deleteBag(String sessionID){
        List<Bag> bags = bagDAO.findBySessionID(sessionID);
        for (Bag bag : bags) {
            bagDAO.delete(bag.getId());
        }
    }

    public void putQuantity(int bagID,int operator){
        Bag bag = bagDAO.findByID(bagID);
        if(bag.getQuantity() <= 1 && operator == 0){
            return;
        }
        switch (operator){
            case 0:
                bag.setQuantity(bag.getQuantity()-1);
                break;
            case 1:
                bag.setQuantity(bag.getQuantity()+1);
                break;
        }

        bagDAO.update(bag);
    }

    public List<Bag> findBySessionID(String id) {
        return bagDAO.findBySessionID(id);
    }
}
