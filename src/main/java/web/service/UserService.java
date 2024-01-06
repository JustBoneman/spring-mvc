package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.List;

@Service
public interface UserService {

    @Transactional
    void saveUser(User user);

    @Transactional
    User loadUserById(long id);

    @Transactional
    void removeUserById(long id);

    List<User> loadAllUsers();

    @Transactional
    void changeUser(User user);

}
