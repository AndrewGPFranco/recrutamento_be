package com.agpf.recrutamento.model;

import com.agpf.recrutamento.model.profile.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Table(name = "users")
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "login")
    private String login;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @JsonIgnore
    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "profile_id", unique = true)
    private Profile profile;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String username, String password) {
        this.login = login;
        this.username = username;
        this.password = password;
    }

    public User(String login, String username, String password, Profile profile) {
        this.login = login;
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
