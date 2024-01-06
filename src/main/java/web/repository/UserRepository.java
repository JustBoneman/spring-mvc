package web.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.User;

import java.util.List;

@Repository
public interface UserRepository {

    void saveUser(User user);

    User loadUserById(long id);

    void removeUserById(long id);

    List<User> loadAllUsers();

    void changeUser(User user);

}
