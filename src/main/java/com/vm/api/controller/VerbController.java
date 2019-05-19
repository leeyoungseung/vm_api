package com.vm.api.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vm.api.model.Verb;
import com.vm.api.service.VerbService;

@RestController
@RequestMapping(path = "/api")
public class VerbController {
	
	private static final Logger log = LogManager.getLogger(VerbController.class.getName());
	
	@Autowired
	VerbService verbService;
	
	@GetMapping("/verb/{user_id}")
	public List<Verb> findAllVerb(@PathVariable("user_id") Integer user_id){
		log.info("findAllVerb");
		log.debug("findAllVerb");
		log.warn("findAllVerb");
		log.error("findAllVerb");
		log.fatal("findAllVerb");
		
		List<Verb> list = verbService.findAllVerbByUserId(user_id);
		return list;
	}
	
	@GetMapping("/verb/{user_id}/{verb_id")
	public Verb findOneVerb(@PathVariable("user_id") Integer user_id
			, @PathVariable("verb_id") Integer verb_id) {
		log.debug("findOneVerb");
		Verb verb = verbService.findOneVerb(verb_id);
		return verb;
	}
	

}
