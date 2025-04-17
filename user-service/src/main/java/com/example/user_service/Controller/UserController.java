package com.example.user_service.Controller;


import com.example.user_service.DTO.ResponseDTO;
import com.example.user_service.DTO.UserResponseDTO;
import com.example.user_service.entity.User;
import com.example.user_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody UserResponseDTO userResponseDTO) {
        ResponseDTO<UserResponseDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setData(userService.createUser(userResponseDTO));
        responseDTO.setMessage("User created successfully");
        responseDTO.setSuccess(true);
        responseDTO.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(responseDTO);
    }


    @GetMapping
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok("Working");
    }

}
