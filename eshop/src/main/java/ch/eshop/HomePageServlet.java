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

public class HomePageServlet extends HttpServlet {

    private BagService bagService;
    private ProductService productService;

    @Inject
    public HomePageServlet(BagService bagService, ProductService productService){
        this.bagService = bagService;
        this.productService = productService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService.init();
        bagService.setProdQtyAttribute(req);
        req.setAttribute("topProducts",productService.findAll());
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req,resp);
    }
}
