package ru.javarash.project3.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarash.project3.util.Go;
import ru.javarash.project3.util.Jsp;

import java.io.IOException;

@WebServlet(name = "MainServlet", value = {Go.ROOT, Go.MAIN})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", Go.mainTitle);
        Jsp.show(request, response, Go.MAIN);
    }
}
