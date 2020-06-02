package ch.eshop;

import ch.eshop.dao.Bag;
import ch.eshop.dao.BagDAO;
import ch.eshop.dao.ProductDAO;
import ch.eshop.services.BagService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BagServlet extends HttpServlet {

    private BagService bagService;

    @Inject
    public BagServlet(BagService bagService){
        this.bagService = bagService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        int bagID;
        switch (method){
            case "post":
                int productID = Integer.valueOf(req.getParameter("productID"));
                bagService.save(productID, req.getSession().getId());
                break;
            case "delete":
                bagID = Integer.valueOf(req.getParameter("bagID"));
                bagService.delete(bagID);
                break;
            case "putMinus":
                bagID = Integer.valueOf(req.getParameter("bagID"));
                bagService.putQuantity(bagID, 0);
                break;
            case "putPlus":
                bagID = Integer.valueOf(req.getParameter("bagID"));
                bagService.putQuantity(bagID, 1);
                break;

        }

        resp.sendRedirect("./checkout");


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
