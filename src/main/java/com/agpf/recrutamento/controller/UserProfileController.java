package com.agpf.recrutamento.controller;

import com.agpf.recrutamento.dto.user.UserProfileDTO;
import com.agpf.recrutamento.model.User;
import com.agpf.recrutamento.model.profile.Experience;
import com.agpf.recrutamento.model.profile.Profile;
import com.agpf.recrutamento.repository.ExperienceRepository;
import com.agpf.recrutamento.repository.UserProfileRepository;
import com.agpf.recrutamento.repository.UserRepository;
import com.agpf.recrutamento.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/create")
    public ResponseEntity<?> createProfile(@RequestBody UserProfileDTO dto) {
        try {
            Profile profile = userProfileService.createProfile(dto);
            return ResponseEntity.ok().body(profile);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getProfileByUser(@PathVariable Long id) {
        try {
            Optional<Profile> profileByUser = userProfileService.getProfileByUser(id);
            return ResponseEntity.ok().body(profileByUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
