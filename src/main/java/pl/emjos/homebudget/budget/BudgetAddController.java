package pl.emjos.homebudget.budget;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/add")
public class BudgetAddController extends HttpServlet
{

    BudgeteItemDao budgeteItemDao = new BudgeteItemDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addform.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        BigDecimal value = new BigDecimal(req.getParameter("value"));
        BudgetItemType type = BudgetItemType.valueOf(req.getParameter("type"));
        BudgetItem budgetItem = new BudgetItem(description,value,type);
        budgeteItemDao.save(budgetItem);
        resp.sendRedirect(req.getContextPath() + "/");

    }
}
