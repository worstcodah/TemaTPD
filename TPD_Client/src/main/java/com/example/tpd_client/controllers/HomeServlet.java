package com.example.tpd_client.controllers;

import com.example.tpd_client.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("HOME SERVLET - GET METHOD");
//        User loggedUser = (User) req.getSession().getAttribute(ControllerUtils.loggedUser);
//        if (loggedUser == null) {
//            resp.sendRedirect(req.getContextPath() + "/");
//            return;
//        }
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

    }
}
