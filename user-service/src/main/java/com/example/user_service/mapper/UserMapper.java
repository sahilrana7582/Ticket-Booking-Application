package com.example.user_service.mapper;

import com.example.user_service.DTO.UserResponseDTO;
import com.example.user_service.entity.User;

public class UserMapper {

    public static UserResponseDTO mapToUserResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhoneNumber(user.getPhoneNumber());
        return userResponseDTO;
    }
}
