package com.agpf.recrutamento.repository;

import com.agpf.recrutamento.model.User;

import com.agpf.recrutamento.model.profile.Profile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Teste responsável por buscar um usuário pelo login")
    void findByLogin() {
        User user = new User(1L, "gpf", "Andrew GPF", "********", new Profile());
        userRepository.save(user);

        UserDetails userFound = userRepository.findByLogin("gpf");
        assertNotNull(userFound);
        assertEquals("Andrew GPF", userFound.getUsername());
        assertEquals("********", userFound.getPassword());
    }
}