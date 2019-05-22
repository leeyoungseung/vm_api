package com.vm.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.api.model.Sentence;
import com.vm.api.repo.SentenceRepository;

@Service
public class SentenceService {
	
	@Autowired
	SentenceRepository sentenceRepo;

	public List<Sentence> findAllSentenceById(Integer verb_id) {
		// TODO Auto-generated method stub
		List<Sentence> list = sentenceRepo.findAllSentenceById(verb_id);
		if(list == null || list.size() == 0) {
			return null;
		}
		return list;
	}

	
	public Sentence findOneSentence(Integer s_id) {
		// TODO Auto-generated method stub
		Sentence sentence = sentenceRepo.getOne(s_id);
		return sentence;
	}


	public Sentence createSentence(Sentence sentence) {
		// TODO Auto-generated method stub
		return sentenceRepo.save(sentence);
	}


	public Sentence updateSentence(Integer s_id, Sentence sentence) {
		// TODO Auto-generated method stub
		sentenceRepo.findById(s_id)
		.map(update_sentence -> {
			return sentenceRepo.save(update_sentence);
		}).orElseGet(()->{
			sentence.setS_id(s_id);
			return sentenceRepo.save(sentence);
		});
		
		return null;
	}


	public boolean deleteSentence(Integer s_id) {
		// TODO Auto-generated method stub
		boolean res = false;
		sentenceRepo.deleteById(s_id);
		
		try {
			sentenceRepo.getOne(s_id);
		}catch (EntityNotFoundException e) {res = true;}
		
		return res;
	}
	

}
