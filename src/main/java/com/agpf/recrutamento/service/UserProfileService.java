package com.agpf.recrutamento.service;

import com.agpf.recrutamento.dto.user.UserProfileDTO;
import com.agpf.recrutamento.model.User;
import com.agpf.recrutamento.model.profile.Experience;
import com.agpf.recrutamento.model.profile.Profile;
import com.agpf.recrutamento.repository.ExperienceRepository;
import com.agpf.recrutamento.repository.UserProfileRepository;
import com.agpf.recrutamento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private UserRepository userRepository;

    public Profile createProfile(UserProfileDTO dto) {
        try {
            Optional<User> userOptional = userRepository.findById(dto.userId());

            if (userOptional.isEmpty()) {
                throw new RuntimeException("Usuário não encontrado");
            }

            Profile profile = getProfile(dto, userOptional);
            Profile savedProfile = userProfileRepository.save(profile);

            // Associa as experiências ao perfil criado
            List<Experience> experiences = dto.experience();
            if (experiences != null) {
                for (Experience experience : experiences) {
                    experience.setProfile(savedProfile);
                }
                experienceRepository.saveAll(experiences);
            }

            return savedProfile;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar perfil para o usuário");
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

    public Optional<Profile> getProfileByUser(Long id) {
        Optional<Profile> profileByUser = userProfileRepository.findById(id);
        if(profileByUser != null)
            return profileByUser;

        throw new RuntimeException("Usuário não encontrado");
    }
}
