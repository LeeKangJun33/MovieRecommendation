package com.example.movierecommendation.repository;

import com.example.movierecommendation.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("사용자 이메일 찾기")
    public void testFindByEmail(){
        // Given
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("1234");
        userRepository.save(user);

        // When
        Optional<User> foundUser = userRepository.findByEmail("test@example.com");

        // Then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUsername()).isEqualTo("testuser");
    }

    @Test
    @DisplayName("사용자 이름으로 찾기")
    public void testFindByUsername() {
        // Given
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("1234");
        userRepository.save(user);

        // When
        Optional<User> foundUser = userRepository.findByUsername("testuser");

        // Then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo("test@example.com");
    }

}