package com.agpf.recrutamento.controller;

import com.agpf.recrutamento.dto.authentication.AuthenticationDTO;
import com.agpf.recrutamento.dto.authentication.LoginResponseDTO;
import com.agpf.recrutamento.dto.authentication.RegisterResponseDTO;
import com.agpf.recrutamento.dto.authentication.RegisterUserDTO;
import com.agpf.recrutamento.model.User;
import com.agpf.recrutamento.repository.UserRepository;
import com.agpf.recrutamento.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterUserDTO data) {
        if(userRepository.findByLogin(data.login()) != null)
            return ResponseEntity.badRequest().body("Erro ao cadastrar usuário!");;

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = User.builder().login(data.login()).username(data.username()).password(encryptedPassword).build();
        userRepository.save(newUser);

        return ResponseEntity.ok(new RegisterResponseDTO(newUser.getLogin(), newUser.getUsername(), newUser.getPassword()));
    }
}
