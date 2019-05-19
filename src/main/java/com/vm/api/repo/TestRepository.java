package com.vm.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vm.api.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

}
