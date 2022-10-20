package ru.javarash.project3.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.javarash.project3.util.Go;
import ru.javarash.project3.util.Jsp;

import java.io.IOException;

@WebServlet(name = "QuestServlet", value = Go.QUEST)
public class QuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jsp.show(request, response, "/quest");
    }
}
