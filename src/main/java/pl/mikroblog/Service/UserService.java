package pl.mikroblog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mikroblog.model.User;
import pl.mikroblog.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by bartek on 07.02.2019.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    public Optional<User> getUserByNick(String nick) {
        return userRepository.findByNick(nick);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
