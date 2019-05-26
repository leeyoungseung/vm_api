package com.vm.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.api.model.Sentence;
import com.vm.api.repo.SentenceRepository;

@Service
public class SentenceService {
	
	private static final Logger log = LogManager.getLogger(SentenceService.class.getName());
	
	@Autowired
	SentenceRepository sentenceRepo;

	public List<Sentence> findAllSentenceById(Integer verb_id) {
		List<Sentence> list = sentenceRepo.findAllSentenceById(verb_id);
		if(list == null || list.size() == 0) {
			return null;
		}
		return list;
	}

	
	public Sentence findOneSentence(Integer s_id) {
		Sentence sentence = sentenceRepo.getOne(s_id);
		return sentence;
	}


	public Sentence createSentence(Sentence sentence) {
		return sentenceRepo.save(sentence);
	}


	public Sentence updateSentence(Sentence sentence) {
		
		Integer s_id = sentence.getS_id();
		Sentence ex = sentenceRepo.getOne(s_id);
		String value = ex.getS_value();
		Integer sort = ex.getS_sort();
		
		sentenceRepo.findById(s_id)
		.map(update_sentence -> {
			log.info("update map (1)");
			update_sentence.setS_value(sentence.getS_value());
			update_sentence.setS_sort(sentence.getS_sort());
			update_sentence.setS_update_day(sentence.getS_update_day());
			
			return sentenceRepo.save(update_sentence);
		}).orElseGet(()->{
			sentence.setS_id(s_id);
			return sentenceRepo.save(sentence);
		});
		
		if(!sentence.getS_value().equals(value) ||
			sentence.getS_sort() != sort) 
		{
			return sentenceRepo.getOne(s_id);
		}else {
			log.info("Failed Update");
			return null;
		}
		
	}


	public boolean deleteSentence(Integer s_id) {
		boolean res = false;
		sentenceRepo.deleteById(s_id);
		
		try {
			sentenceRepo.getOne(s_id);
		}catch (EntityNotFoundException e) {res = true;}
		
		return res;
	}
	

}
