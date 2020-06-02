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

public class PaymentServlet extends HttpServlet {

    private BagService bagService;

    @Inject
    public PaymentServlet(BagService bagService){
        this.bagService = bagService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Bag> bags = bagService.findBySessionID(req.getSession().getId());
        req.setAttribute("total",bags.stream().mapToDouble(b-> b.getProduct().getPrice()*b.getQuantity()).sum());
        req.getRequestDispatcher("/WEB-INF/payment.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("name"));
        bagService.deleteBag(req.getSession().getId());
        resp.sendRedirect("./products?ordered=true");
    }
}
