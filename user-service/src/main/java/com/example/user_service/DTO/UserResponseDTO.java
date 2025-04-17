package com.example.user_service.DTO;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
