package com.kailera.isolated.services;

import com.kailera.isolated.DTOs.MessageResponseDTO;
import com.kailera.isolated.entities.User;
import com.kailera.isolated.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public MessageResponseDTO createUser(User user){
        String generateSecurePasswordHash  = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(generateSecurePasswordHash);
        User userToSave = userRepository.save(user);
        MessageResponseDTO successMessageCreatedUser = createMessage("User created with id: ", user.getId());
        return successMessageCreatedUser;
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private MessageResponseDTO createMessage (String message, Long id){
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }


}
