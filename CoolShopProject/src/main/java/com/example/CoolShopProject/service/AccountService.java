package com.example.CoolShopProject.service;

import com.example.CoolShopProject.model.dto.accountDTO;
import com.example.CoolShopProject.model.entity.account;
import com.example.CoolShopProject.repository.accountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final accountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountService(accountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(accountDTO dto) {
        if (accountRepository.existsByAccountName(dto.getAccountName())) {
            throw new IllegalArgumentException("Tên tài khoản đã tồn tại");
        }
        if (accountRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email đã được sử dụng");
        }

        account acc = account.builder()
                .accountName(dto.getAccountName())
                .email(dto.getEmail())
                .phonenumber(dto.getPhonenumber())
                .accountPassword(passwordEncoder.encode(dto.getAccountPassword()))
                .gender(dto.getGender())
                .build();

        accountRepository.save(acc);
    }
}
