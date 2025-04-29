package com.example.userservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.UUID;

@Data
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RabbitTemplate rabbitTemplate;

    @Cacheable(value = "users", key = "#id")
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @CachePut(value = "users", key = "#result.id")
    public User createUser(User user) {
        // Kodowanie hasła
        user.setPassword(passwordEncoder.encode("cokolwiek"));
        User savedUser = userRepository.save(user);
        // Przesyłanie obiektu User do RabbitMQ. Dzięki konfiguracji RabbitConfig, obiekt jest automatycznie konwertowany do JSON.
        rabbitTemplate.convertAndSend("user.exchange", "user.created", savedUser);
        return savedUser;
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
        rabbitTemplate.convertAndSend("user.exchange", "user.deleted", id);
    }
}