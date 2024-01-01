package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    User loadUserById(long id);
    void removeUserById(long id);
    List<User> loadAllUsers();
}
