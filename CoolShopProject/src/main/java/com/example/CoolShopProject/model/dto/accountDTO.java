package com.example.CoolShopProject.model.dto;

import com.example.CoolShopProject.model.enums.Gender;
import lombok.Data;

@Data
public class accountDTO {
    private long accountId;
    private String accountName;
    private String phonenumber;
    private String email;
    private String accountPassword;
    private Gender gender;
}
