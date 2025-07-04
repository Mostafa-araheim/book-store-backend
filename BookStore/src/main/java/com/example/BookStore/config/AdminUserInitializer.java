package com.example.BookStore.config;

import com.example.BookStore.model.Role;
import com.example.BookStore.model.User;
import com.example.BookStore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AdminUserInitializer {
    private final PasswordEncoder passwordEncoder;
    @Value("${application.security.admin.username}")
    private String adminUsername;

    @Value("${application.security.admin.password}")
    private String adminPassword;

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByEmail(adminUsername).isEmpty()) {
                User admin = User.builder()
                        .firstName("Moataz")
                        .lastName("Mostafa")
                        .email(adminUsername)
                        .password(passwordEncoder.encode(adminPassword))
                        .role(Role.ADMIN)
                        .build();
                userRepository.save(admin);
                System.out.println("Admin user created successfully!");
            }
        };
    }
}
