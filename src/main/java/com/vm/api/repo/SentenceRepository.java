package com.vm.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vm.api.model.Sentence;

public interface SentenceRepository extends JpaRepository<Sentence, Integer> {

	@Query(value = "SELECT * FROM sentence WHERE verb_id=?1", nativeQuery=true)
	List<Sentence> findAllSentenceById(Integer verb_id);

}
