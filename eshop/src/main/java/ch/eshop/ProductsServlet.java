package ch.eshop;

import ch.eshop.dao.ProductDAO;
import ch.eshop.services.BagService;
import ch.eshop.services.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductsServlet extends HttpServlet {

    private BagService bagService;
    private ProductService productService;

    @Inject
    public ProductsServlet(BagService bagService, ProductService productService){
        this.bagService = bagService;
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        bagService.setProdQtyAttribute(req);

        if(req.getParameter("ordered") != null){
            req.setAttribute("message", "Thanks for your order");
        }

        if(req.getParameter("id") == null){
            req.setAttribute("products",  productService.findAll());
            req.getRequestDispatcher("/WEB-INF/products.jsp").forward(req, resp);
            return;
        }


        if(productService.findByID(Integer.valueOf(req.getParameter("id"))) != null){
            req.setAttribute("product",  productService.findByID(Integer.valueOf(req.getParameter("id"))));
            req.getRequestDispatcher("/WEB-INF/productDetail.jsp").forward(req, resp);
            return;
        }


        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);


    }
}
