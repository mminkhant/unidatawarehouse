package com.example.adswarehousesem2;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Query3Servlet", value = "/Query3Servlet")
public class Query3Servlet extends HttpServlet {
    @EJB
    DecisionMakerQueriesBean decisionMakerQueriesBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<DecisionMakerQueriesModel> data = decisionMakerQueriesBean.fetchQuery3Data();

        // Set the data as an attribute in the request object //
        request.setAttribute("data", data);

        // Forward the request to the JSP for rendering //
        request.getRequestDispatcher("Query3.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
