package com.example.tpd_client.controllers;

import com.example.tpd_client.data_access.UserDAO;
import com.example.tpd_client.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LOGIN SERVLET - GET METHOD");
        User loggedUser = (User) req.getSession().getAttribute(ControllerUtils.loggedUser);
        if (loggedUser != null) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LOGIN SERVLET - POST METHOD");
        String button = request.getParameter("button");

        if (button == null) {
            return;
        }
        if (button.equals("login")) {
            String errorMessage = tryToLogin(request);

            if (errorMessage != null) {
                System.out.println(errorMessage);
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("/login").forward(request, response);
                return;
            }

//            request.getRequestDispatcher("/hello.jsp").forward(request, response);
//            response.sendRedirect(request.getContextPath() + "/hello");
            //request.getSession().setAttribute("username", );
            response.sendRedirect(request.getContextPath() + "/home");
        } else if (button.equals("register")) {
            request.getSession().removeAttribute("username");
            response.sendRedirect(request.getContextPath() + "/register");
        } else if (button.equals("forgotPassword")) {
            request.getSession().setAttribute("username", request.getParameter("username"));
            response.sendRedirect(request.getContextPath() + "/forgot-password");
        }
    }

    private String tryToLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("password", password);

        if (username.isEmpty() || password.isEmpty()) {
            return "All fields must be filled";
        }

        User user = null;
        try {
            user = UserDAO.get(username, password);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (user == null) {
            return "No user with given username or password";
        }

        request.getSession().setAttribute("userId", user.getId());
        return null;
    }
}
