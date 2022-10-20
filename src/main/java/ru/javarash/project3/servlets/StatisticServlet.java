package ru.javarash.project3.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarash.project3.model.Model;
import ru.javarash.project3.util.Go;
import ru.javarash.project3.util.Jsp;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "statListServlet", value = Go.STATISTIC)
public class StatisticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = Model.getInstance();
        List<String> statistics = model.list();
        request.setAttribute("title", Go.statisticTitle);
        request.setAttribute("statistics", statistics);
        Jsp.show(request, response, Go.STATISTIC);
    }
}
