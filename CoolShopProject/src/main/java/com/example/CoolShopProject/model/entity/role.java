package com.example.CoolShopProject.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "role")
@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    @Column(nullable = false, unique = true)
    private String rolename;
}
