package com.beautysalon.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        try {
            writer.println("<h2>Welcome to beautysalon</h2>");
        } finally {
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.print("email: ");
//        out.print(req.getParameter("email"));
//        out.print("<br>");
//        out.print("password: ");
//        out.print(req.getParameter("password"));
        req.setAttribute("email", req.getParameter("email"));
        req.setAttribute("password", req.getParameter("password"));

        getServletContext().getRequestDispatcher("/answer.jsp").forward(req, resp);
    }
}
