package ru.javarash.project3.repository;

import ru.javarash.project3.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final UserRepository instance = new UserRepository();
    private final List<User> users;
    public static UserRepository getInstance() {
        return instance;
    }
    private UserRepository() {
        users = new ArrayList<>();
    }
    public void add(User user) {
        users.add(user);
    }
}
