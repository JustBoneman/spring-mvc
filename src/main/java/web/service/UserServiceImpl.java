package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.config.HibernateConfig;
import web.models.User;
import web.repository.UserRepository;
import web.repository.UserRepositoryImpl;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public User loadUserById(long id) {
        return userRepository.loadUserById(id);
    }

    @Override
    public void removeUserById(long id) {
        userRepository.removeUserById(id);
    }

    @Override
    public List<User> loadAllUsers() {
        return userRepository.loadAllUsers();
    }

    @Override
    public void changeUser(User user) {
        userRepository.changeUser(user);
    }
}
