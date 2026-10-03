package com.example.CoolShopProject.service;

import com.example.CoolShopProject.model.entity.account;
import com.example.CoolShopProject.repository.accountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final accountRepository accountRepository;

    public CustomUserDetailsService(accountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        account acc = accountRepository.findByAccountName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản: " + username));

        return User.builder()
                .username(acc.getAccountName())
                .password(acc.getAccountPassword())
                .roles("USER")
                .build();
    }
}
