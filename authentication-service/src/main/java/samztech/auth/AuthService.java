package samztech.auth;

import java.util.Optional;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import samztech.auth.model.User;
import samztech.auth.repository.UserRepository;

import javax.naming.AuthenticationException;

@ApplicationScoped
public class AuthService {

    @Inject
    UserRepository userRepository;

    public String authenticateUser(User loginUser) throws AuthenticationException {
        Optional<User> userOpt = userRepository.findByUsername(loginUser.getUsername());

        if (userOpt.isEmpty() || !userOpt.get().getPassword().equals(loginUser.getPassword())) {
            throw new AuthenticationException("Invalid username or password.");
        }

        return generateJwtToken(userOpt.get());
    }

    private String generateJwtToken(User user) {
        return Jwt.issuer("https://your-app.com")
                .upn(user.getUsername())
                .claim("role", user.getRole())
                .sign();
    }
}
