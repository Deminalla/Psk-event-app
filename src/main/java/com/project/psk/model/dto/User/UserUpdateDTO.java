package com.project.psk.model.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//this dto is used in updating
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private byte[] imageBytes;
}
