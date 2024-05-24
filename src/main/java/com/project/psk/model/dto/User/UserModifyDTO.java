package com.project.psk.model.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//this dto is used in creating
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModifyDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String imageBytes;
}
