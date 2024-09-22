package com.agpf.recrutamento.controller;

import com.agpf.recrutamento.dto.user.UserProfileDTO;
import com.agpf.recrutamento.model.User;
import com.agpf.recrutamento.model.profile.Experience;
import com.agpf.recrutamento.model.profile.Profile;
import com.agpf.recrutamento.repository.ExperienceRepository;
import com.agpf.recrutamento.repository.UserProfileRepository;
import com.agpf.recrutamento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class UserProfileController {

    @Autowired
    private UserProfileRepository repository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createProfile(@RequestBody UserProfileDTO dto) {
        try {
            Optional<User> userOptional = userRepository.findById(dto.userId());

            if (userOptional.isEmpty()) {
                return ResponseEntity.badRequest().body("Usuário não encontrado");
            }

            Profile profile = getProfile(dto, userOptional);
            Profile savedProfile = repository.save(profile);

            // Associa as experiências ao perfil criado
            List<Experience> experiences = dto.experience();
            if (experiences != null) {
                for (Experience experience : experiences) {
                    experience.setProfile(savedProfile);
                }
                experienceRepository.saveAll(experiences);
            }

            return ResponseEntity.ok().body(savedProfile);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao criar perfil para o usuário");
        }
    }

    private Profile getProfile(UserProfileDTO dto, Optional<User> userOptional) {
        User user = userOptional.get();

        Profile profile = new Profile(
                user,
                dto.nickname(),
                dto.fullName(),
                dto.description(),
                dto.dateOfBirth(),
                dto.stack(),
                null,
                dto.country(),
                dto.city(),
                dto.gender(),
                dto.phoneNumber(),
                dto.languages()
        );
        return profile;
    }


}
