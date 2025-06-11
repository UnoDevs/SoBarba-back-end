package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.model.User;
import io.unodevs.SoBarba.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void loadUserByUsername_userExists_returnsUser() {
        // Arrange
        User mockUser = new User();
        mockUser.setUsername("projetosunodevs@gmail.com");
        mockUser.setPassword("admin123");

        when(userRepository.findByUsername("projetosunodevs@gmail.com")).thenReturn(mockUser);

        // Act
        var userDetails = userService.loadUserByUsername("projetosunodevs@gmail.com");

        // Assert
        assertNotNull(userDetails);
        assertEquals("projetosunodevs@gmail.com", userDetails.getUsername());
        assertEquals("admin123", userDetails.getPassword());
    }

    @Test
    void loadUserByUsername_userDoesNotExist_throwsException() {
        // Arrange
        when(userRepository.findByUsername("notfound")).thenReturn(null);

        // Act & Assert
        UsernameNotFoundException thrown = assertThrows(
                UsernameNotFoundException.class,
                () -> userService.loadUserByUsername("notfound")
        );

        assertTrue(thrown.getMessage().contains("notfound"));
    }
}
