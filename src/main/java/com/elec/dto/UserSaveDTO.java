package com.elec.dto;

import lombok.Data;

@Data
public class UserSaveDTO {
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
}
