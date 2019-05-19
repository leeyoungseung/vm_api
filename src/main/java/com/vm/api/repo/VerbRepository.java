package com.vm.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vm.api.model.Verb;

public interface VerbRepository extends JpaRepository<Verb, Integer> {

	@Query(value = "SELECT * FROM verb v WHERE v.user_id=?1", nativeQuery = true)
	List<Verb> findAllVerbByUserId(Integer user_id);

}
