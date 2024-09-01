package com.agpf.recrutamento.controller;

import com.agpf.recrutamento.dto.authentication.AuthenticationDTO;
import com.agpf.recrutamento.model.User;
import com.agpf.recrutamento.repository.UserRepository;
import com.agpf.recrutamento.service.TokenService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

    @Mock
    private TokenService tokenService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Spy
    private AuthenticationController controller;

    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve retornar um DTO contendo o token")
    public void shouldReturnLoginWithSuccess() throws Exception {
        AuthenticationDTO dto = new AuthenticationDTO("andrew@example.com", "******");
        var user = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, user);

        Mockito.when(authenticationManager.authenticate(user)).thenReturn(auth);
        controller.login(dto);
        Mockito.verify(authenticationManager, Mockito.times(1)).authenticate(user);
        Mockito.verify(tokenService, Mockito.times(1)).generateToken((User) auth.getPrincipal());
        mockMvc.perform(post("api/auth/login").queryParam("data"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}