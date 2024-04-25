package com.example.adswarehousesem2;

import javax.ejb.EJB;
import javax.naming.AuthenticationException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {

    @EJB
    DecisionMakerQueriesBean decisionMakerQueriesBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            decisionMakerQueriesBean.getLogin(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("session", username);
            response.sendRedirect("HomePage.jsp");
        } catch (AuthenticationException e) {
            request.setAttribute("message", "Username or Password Incorrect");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
