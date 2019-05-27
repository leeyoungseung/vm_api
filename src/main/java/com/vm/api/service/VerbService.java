package com.vm.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.api.model.User;
import com.vm.api.model.Verb;
import com.vm.api.repo.VerbRepository;

@Service
public class VerbService {

	private static final Logger log = LogManager.getLogger(VerbService.class.getName());
	
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
	
	
	public Verb updateVerb(Verb verb) {
		Integer verb_id = verb.getVerb_id();
		Verb ex = verbRepository.getOne(verb_id);
		String mean1 = ex.getVerb_mean1();
		String mean2 = ex.getVerb_mean2();
		String mean3 = ex.getVerb_mean3();
		String mean4 = ex.getVerb_mean4();
		String mean5 = ex.getVerb_mean5();
		Integer v_sort = ex.getVerb_sort();
		
		
		verbRepository.findById(verb_id)
		.map(update_verb -> {
			log.info("update map (1)");
			update_verb.setVerb_mean1(verb.getVerb_mean1());
			update_verb.setVerb_mean2(verb.getVerb_mean2());
			update_verb.setVerb_mean3(verb.getVerb_mean3());
			update_verb.setVerb_mean4(verb.getVerb_mean4());
			update_verb.setVerb_mean5(verb.getVerb_mean5());
			update_verb.setVerb_update_day(verb.getVerb_update_day());
			update_verb.setVerb_sort(verb.getVerb_sort());
			
			return verbRepository.save(update_verb);
		}).orElseGet(()->{
			verb.setVerb_id(verb_id);
			return verbRepository.save(verb);
		});
		
		if(!verb.getVerb_mean1().equals(mean1) || 
			!verb.getVerb_mean2().equals(mean2) ||
			!verb.getVerb_mean3().equals(mean3) ||
			!verb.getVerb_mean4().equals(mean4) ||
			!verb.getVerb_mean5().equals(mean5) ||
			verb.getVerb_sort() != v_sort) 
		{
			return verbRepository.getOne(verb_id);
		} else {
			log.info("Failed Update");
			return null;
		}

	}
	
	public boolean deleteVerb(Integer verb_id) {
		boolean res = true;
		verbRepository.deleteById(verb_id);
		try {
			verbRepository.getOne(verb_id);
		}catch (EntityNotFoundException e) {res = false;}
		return res;
	}
}
