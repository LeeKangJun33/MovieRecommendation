package com.example.movierecommendation.service;

import com.example.movierecommendation.entity.User;
import com.example.movierecommendation.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("서비스-사용자이메일")
    public void testGetUserByEmail() {
        // Given
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("12345");

        given(userRepository.findByEmail(anyString())).willReturn(Optional.of(user));

        // When
        Optional<User> foundUser = userService.getUserByEmail("test@example.com");

        // Then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUsername()).isEqualTo("testuser");
    }

    @Test
    @DisplayName("서비스-사용자 이름찾기")
    public void testGetUserByUsername() {
        // Given
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("12345");

        given(userRepository.findByUsername(anyString())).willReturn(Optional.of(user));

        // When
        Optional<User> foundUser = userService.getUserByUsername("testuser");

        // Then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo("test@example.com");
    }

    @Test
    @DisplayName("사용자생성 테스트")
    public void testCreateUser() {
        // Given
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("12345");

        given(userRepository.save(any(User.class))).willReturn(user);

        // When
        User createdUser = userService.createUser(user);

        // Then
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getEmail()).isEqualTo("test@example.com");
        assertThat(createdUser.getUsername()).isEqualTo("testuser");
    }

    @Test
    @DisplayName("서비스 수정 테스트")
    public void testUpdateUser() {
        // Given
        User existingUser = new User();
        existingUser.setId(1L);
        existingUser.setEmail("old@example.com");
        existingUser.setUsername("olduser");
        existingUser.setPassword("oldpassword");

        User updatedUser = new User();
        updatedUser.setId(1L);
        updatedUser.setEmail("new@example.com");
        updatedUser.setUsername("newuser");
        updatedUser.setPassword("newpassword");

        given(userRepository.findById(anyLong())).willReturn(Optional.of(existingUser));
        given(userRepository.save(any(User.class))).willReturn(updatedUser);

        // When
        User result = userService.updateUser(1L, updatedUser);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getEmail()).isEqualTo("new@example.com");
        assertThat(result.getUsername()).isEqualTo("newuser");
    }

    @Test
    @DisplayName("서비스-삭제 테스트")
    public void testDeleteUser() {
        // Given
        doNothing().when(userRepository).deleteById(anyLong());

        // When
        userService.deleteUser(1L);

        // Then
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("모든 사용자 테스트")
    public void testGetAllUsers() {
        // Given
        User user1 = new User();
        user1.setId(1L);
        user1.setEmail("test1@example.com");
        user1.setUsername("testuser1");
        user1.setPassword("1234");

        User user2 = new User();
        user2.setId(2L);
        user2.setEmail("test2@example.com");
        user2.setUsername("testuser2");
        user2.setPassword("12345");

        given(userRepository.findAll()).willReturn(Arrays.asList(user1, user2));

        // When
        List<User> users = userService.getAllUsers();

        // Then
        assertThat(users).hasSize(2);
        assertThat(users).extracting(User::getEmail).containsExactlyInAnyOrder("test1@example.com", "test2@example.com");
    }

    @Test
    @DisplayName("사용자 아이디 테스트")
    public void testGetUserById() {
        // Given
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("12345");

        given(userRepository.findById(anyLong())).willReturn(Optional.of(user));

        // When
        User foundUser = userService.getUserById(1L);

        // Then
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getEmail()).isEqualTo("test@example.com");
        assertThat(foundUser.getUsername()).isEqualTo("testuser");
    }


}