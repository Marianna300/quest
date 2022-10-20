package ru.javarash.project3.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarash.project3.entity.Answer;
import ru.javarash.project3.entity.Question;
import ru.javarash.project3.util.Go;
import ru.javarash.project3.util.Jsp;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Question1Servlet", value = Go.QUESTION1)
public class Question1Servlet extends HttpServlet {
    Question question;
    ArrayList<Answer> answerArrayList = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        int id = 0;

        answerArrayList.add(Answer.builder()
                .id(String.valueOf(id++))
                .sectionAnswer("Принять вызов")
                .build());
        answerArrayList.add(Answer.builder()
                .id(String.valueOf(id))
                .sectionAnswer("Отклонить вызов")
                .build());

        question = Question.builder()
                .section("Вопрос1")
                .sectionStory("Ты потерял память...")
                .sectionQuestion("Принять вызов НЛО?")
                .viewAddress("WEB-INF/views/question1.jsp")
                .answers(answerArrayList)
                .answerPath(new String[]{Go.QUESTION2, Go.LOOS})
                .build();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("question", question);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(question.getViewAddress());
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String answerText = request.getParameter("answer");
        int answer = Integer.parseInt(answerText);
        question.setSubmitAnswerIndex(Integer.parseInt(answerText));

        String url = question.getAnswerPath()[answer];
        request.setAttribute("url", url);
        Jsp.redirect(request, response, url);

    }
}
