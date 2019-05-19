package com.vm.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vm.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
