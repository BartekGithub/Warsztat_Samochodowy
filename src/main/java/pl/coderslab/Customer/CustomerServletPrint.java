package pl.coderslab.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/printCustomers")
public class CustomerServletPrint extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = null;
        try {
            customers = CustomerDao.printAllCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/printcustomers.jsp").forward(request,response);
    }
}
