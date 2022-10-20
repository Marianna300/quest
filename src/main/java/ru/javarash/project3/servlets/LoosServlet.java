package ru.javarash.project3.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarash.project3.entity.Question;
import ru.javarash.project3.entity.Statistic;
import ru.javarash.project3.model.Model;
import ru.javarash.project3.util.Go;
import ru.javarash.project3.util.Jsp;

import java.io.IOException;

@WebServlet(name = "LoosServlet", value = Go.LOOS)
public class LoosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = Model.getInstance();

        Question question = (Question) request.getAttribute("loosMessage");

        Statistic statistic = Statistic.builder()
                .dateTime(Statistic.currentTime())
                .lastQuestion(question)
                .result("Проигрыш")
                .build();

        model.add(statistic);

        Jsp.show(request, response, Go.LOOS);
    }
}
