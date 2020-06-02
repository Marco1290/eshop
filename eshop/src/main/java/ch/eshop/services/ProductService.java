package ch.eshop.services;

import ch.eshop.dao.Product;
import ch.eshop.dao.ProductDAO;

import javax.inject.Inject;
import java.util.List;

public class ProductService {

    private ProductDAO productDAO;

    @Inject
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void init(){
        List<Product> products = productDAO.findAll();
        if(products == null || products.size() <= 0 ) {

            productDAO.save(new Product("Short", "product_1.jpg","product_1.jpg", "A beautiful short ! ", Math.random() * 200 ));
            productDAO.save(new Product("Jeans", "product_2.jpg","product_2.jpg", "An awesome jeans !", Math.random() * 200 ));
            productDAO.save(new Product("Blazer", "product_3.jpg","product_3.jpg", "The best blazer ever ! ", Math.random() * 200 ));

        }
    }

    public List<Product> findAll(){
        return productDAO.findAll();
    }

    public Product findByID(int id){
        return productDAO.findByID(id);
    }
}
