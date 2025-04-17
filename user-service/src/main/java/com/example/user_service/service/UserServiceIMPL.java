package com.example.user_service.service;

import com.example.user_service.DTO.UserResponseDTO;
import com.example.user_service.entity.User;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserResponseDTO createUser(UserResponseDTO userResponseDTO) {
        User user = new User();
        user.setFirstName(userResponseDTO.getFirstName());
        user.setLastName(userResponseDTO.getLastName());
        user.setEmail(userResponseDTO.getEmail());
        user.setPhoneNumber(userResponseDTO.getPhoneNumber());
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserResponseDTO(savedUser);
    }
}
