package com.project.psk.model.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//this dto is used in retrieving information of existing users
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private byte[] imageBytes;
}
