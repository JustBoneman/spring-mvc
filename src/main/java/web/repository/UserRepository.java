package web.repository;

import web.models.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User user);
    User loadUserById(long id);
    void removeUserById(long id);
    List<User> loadAllUsers();
}
