package com.vm.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vm.api.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

	@Query(value = "SELECT * FROM test WHERE user_id=?1", nativeQuery=true)
	List<Test> findAllTestByUserId(Integer user_id);

}
