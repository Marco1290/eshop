package ch.eshop;

import ch.eshop.dao.Bag;
import ch.eshop.dao.BagDAO;
import ch.eshop.services.BagService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CheckoutServlet extends HttpServlet {
    private BagService bagService;

    @Inject
    public CheckoutServlet(BagService bagService){
        this.bagService = bagService;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bagService.setProdQtyAttribute(req);
        List<Bag> bags = bagService.findBySessionID(req.getSession().getId());
        req.setAttribute("total",bags.stream().mapToDouble(b-> b.getProduct().getPrice()*b.getQuantity()).sum());
        req.setAttribute("bags",bags);
        req.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
