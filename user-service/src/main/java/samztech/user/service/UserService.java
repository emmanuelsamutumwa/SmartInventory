package samztech.user.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import org.mindrot.jbcrypt.BCrypt;
import samztech.user.models.User;
import samztech.user.repository.UserRepository;

import java.util.List;

@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public void createUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.password, BCrypt.gensalt(12));
        user.password = hashedPassword;
        userRepository.addUser(user);
    }


    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}