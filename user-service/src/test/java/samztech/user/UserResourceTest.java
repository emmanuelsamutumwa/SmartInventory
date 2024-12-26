package samztech.user;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import samztech.user.models.User;
import samztech.user.repository.UserRepository;
import samztech.user.service.UserService;

import jakarta.inject.Inject; // Correct package for @Inject in Quarkus

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@QuarkusTest
class UserResourceTest {

    @InjectMock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        // Initialize the user object before each test
        user = new User();
        user.id = 1L;
        user.username = "john_doe";
        user.password = "password123";
        user.email = "john_doe@example.com";
    }

    @Test
    void testGetUserByUsername() {
        // Given
        when(userRepository.findByUsername("john_doe")).thenReturn(user);

        // When
        User foundUser = userService.getUserByUsername("john_doe");

        // Then
        assertNotNull(foundUser);
        assertEquals("john_doe", foundUser.username);
        assertEquals("john_doe@example.com", foundUser.email);
        verify(userRepository, times(1)).findByUsername("john_doe");
    }
}
