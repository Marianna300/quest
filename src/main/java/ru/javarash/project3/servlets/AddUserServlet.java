package ru.javarash.project3.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.javarash.project3.entity.User;
import ru.javarash.project3.repository.UserRepository;
import ru.javarash.project3.util.Go;
import ru.javarash.project3.util.Ids;
import ru.javarash.project3.util.Jsp;

import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = Go.ADDUSER)
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", Go.AddUserTitle);
        Jsp.show(request, response, Go.ADDUSER);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = User.builder()
                .id(++Ids.userId)
                .login(login)
                .password(password)
                .build();
        UserRepository users = UserRepository.getInstance();
        users.add(user);

        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getId());
        session.setAttribute("login", login);
        request.setAttribute("login", login);

        doGet(request, response);
    }
}
