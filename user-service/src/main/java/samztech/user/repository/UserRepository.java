package samztech.user.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import samztech.user.models.User;

import java.util.List;

@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
public class UserRepository implements PanacheRepository<User> {

    public List<User> findAllUsers() {
        return listAll();
    }

    public User findByUsername(String username) {
        return find("username", username).firstResult();
    }

    public void addUser(User user) {
        persist(user);
    }

    public void deleteUser(Long id) {
        deleteById(id);
    }
}