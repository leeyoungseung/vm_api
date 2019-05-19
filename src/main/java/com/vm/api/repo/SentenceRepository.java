package com.vm.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vm.api.model.Sentence;

public interface SentenceRepository extends JpaRepository<Sentence, Integer> {

}
