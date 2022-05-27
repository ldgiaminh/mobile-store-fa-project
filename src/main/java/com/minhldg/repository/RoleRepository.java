package com.minhldg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minhldg.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
