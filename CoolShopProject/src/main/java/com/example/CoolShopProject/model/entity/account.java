package com.example.CoolShopProject.model.entity;

import com.example.CoolShopProject.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    @Column(unique = true, nullable = false)
    private String accountName;

    @Column(nullable = true)
    private String phonenumber;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String accountPassword;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
