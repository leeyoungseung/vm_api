package com.vm.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.api.model.Verb;
import com.vm.api.repo.VerbRepository;

@Service
public class VerbService {

	@Autowired
	VerbRepository verbRepository;
	
	
	public List<Verb> findAllVerb(){
		List<Verb> verbList= verbRepository.findAll();
		return verbList;
	}
	
	
	public List<Verb> findAllVerbByUserId(Integer user_id){
		List<Verb> verbList= verbRepository.findAllVerbByUserId(user_id);
		return verbList;
	}
	
	
	public Verb findOneVerb(Integer verb_id) {
		Verb verb = verbRepository.getOne(verb_id);
		return verb;
	}
	
	
	public Verb createVerb(Verb verb) {
		Integer user_id = verb.getUser_id();
		String verb_title = verb.getVerb_title();
		
		if(isVerb(user_id, verb_title)) {
			return verbRepository.save(verb);
		}
		
		return null;
	}
	
	public boolean isVerb(final Integer user_id, final String verb_title) {
		
		Verb forCheckVerb = verbRepository.checkIsVerb(user_id, verb_title);
		if(forCheckVerb == null) {
			return true;
		}
		
		return false;
	}
	
	
	public Verb updateVerb(Integer verb_id, Verb verb) {
		verbRepository.findById(verb_id)
		.map(update_verb -> {
			return verbRepository.save(update_verb);
		}).orElseGet(()->{
			verb.setVerb_id(verb_id);
			return verbRepository.save(verb);
		});
		return null;
	}
	
	public boolean deleteVerb(Integer verb_id) {
		boolean res = false;
		verbRepository.deleteById(verb_id);
		try {
			verbRepository.getOne(verb_id);
		}catch (EntityNotFoundException e) {res = true;}
		return res;
	}
}
