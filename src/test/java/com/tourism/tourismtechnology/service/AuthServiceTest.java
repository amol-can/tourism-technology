package com.tourism.tourismtechnology.service;

import static org.junit.jupiter.api.Assertions.*;

import com.tourism.tourismtechnology.model.LoginRequest;
import com.tourism.tourismtechnology.model.RegisterRequest;
import com.tourism.tourismtechnology.entity.User;
import com.tourism.tourismtechnology.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthService authService;

    @Test
    void testLoginWithValidCredentials() {
        LoginRequest loginRequest = new LoginRequest("username", "password");
        User mockUser = new User();
        mockUser.setUsername("username");
        mockUser.setPassword("password");

        when(userRepository.findByUsernameAndPassword("username", "password")).thenReturn(mockUser);

        User result = authService.login(loginRequest);

        assertNotNull(result);
        assertEquals("username", result.getUsername());
        assertEquals("password", result.getPassword());

        verify(userRepository, times(1)).findByUsernameAndPassword("username", "password");
    }

    @Test
    void testLoginWithInvalidCredentials() {
        LoginRequest loginRequest = new LoginRequest("invalidUsername", "invalidPassword");

        when(userRepository.findByUsernameAndPassword("invalidUsername", "invalidPassword")).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> authService.login(loginRequest));

        verify(userRepository, times(1)).findByUsernameAndPassword("invalidUsername", "invalidPassword");
    }

    @Test
    void testUserExists() {
        when(userRepository.existsByUsername("existingUsername")).thenReturn(true);

        assertTrue(authService.userExists("existingUsername"));

        verify(userRepository, times(1)).existsByUsername("existingUsername");
    }

    @Test
    void testUserDoesNotExist() {
        when(userRepository.existsByUsername("nonExistingUsername")).thenReturn(false);

        assertFalse(authService.userExists("nonExistingUsername"));

        verify(userRepository, times(1)).existsByUsername("nonExistingUsername");
    }

    @Test
    void testRegisterNewUser() {
        User user = new User();
        user.setUsername("newUser");
        user.setPassword("password");
        RegisterRequest registerRequest = new RegisterRequest("newUser", "password", "CUSTOMER");

        when(userRepository.existsByUsername("newUser")).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = authService.register(registerRequest);

        assertNotNull(result);
        assertEquals("newUser", result.getUsername());
        assertEquals("password", result.getPassword());

        verify(userRepository, times(1)).existsByUsername("newUser");
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testRegisterUserWithExistingUsername() {
        RegisterRequest registerRequest = new RegisterRequest("existingUser", "password", "CUSTOMER");
        when(userRepository.existsByUsername("existingUser")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> authService.register(registerRequest));

        verify(userRepository, times(1)).existsByUsername("existingUser");
        verify(userRepository, never()).save(any(User.class));
    }
}
