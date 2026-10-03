package com.example.CoolShopProject.repository;
import com.example.CoolShopProject.model.entity.role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface roleRepository extends JpaRepository<role, Long>{

}
