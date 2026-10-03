package com.example.CoolShopProject.repository;

import com.example.CoolShopProject.model.entity.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface accountRepository extends JpaRepository<account, Long> {

    Optional<account> findByAccountName(String accountName);

    boolean existsByAccountName(String accountName);

    boolean existsByEmail(String email);
}
