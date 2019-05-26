package com.vm.api.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vm.api.RequestBean;
import com.vm.api.ResponseBean;
import com.vm.api.model.Sentence;
import com.vm.api.service.SentenceService;


@RestController
@RequestMapping(path = "/api")
public class SentenceController {
	
	private static final Logger log = LogManager.getLogger(SentenceController.class.getName());
	
	@Autowired
	SentenceService sentenceService;
	
	@GetMapping("/sentence/{verb_id}")
	public SentenceResponseBean findAllSentence( 
			@PathVariable("verb_id") Integer verb_id ) {
		log.debug("findAllSentence");
		SentenceResponseBean response = new SentenceResponseBean();
		
		List<Sentence> list = sentenceService.findAllSentenceById(verb_id);
		if(list == null || list.size() == 0) {
			response.setMessage("Failed List Sentence");
			response.setRes(false);
		}else {
			response.setMessage("Success List Sentence");
			response.setData(list);
			response.setRes(true);
		}
		
		return response;
	}
	
	
	@GetMapping("/sentence/{verb_id}/{s_id}")
	public SentenceResponseBean findOneSentence(
			@PathVariable("s_id") Integer s_id) {
		log.debug("findOneSentence");
		SentenceResponseBean response = new SentenceResponseBean();
		Sentence sentence = sentenceService.findOneSentence(s_id);
		List<Sentence> list = new ArrayList<Sentence>();
		
		if(sentence == null) {
			response.setMessage("Failed Get Sentence");
			response.setRes(false);
		}else {
			response.setMessage("Success Get Sentence");
			list.add(0, sentence);
			response.setData(list);
			response.setRes(true);
		}
		
		return response;
		
	}
	
	
	@PostMapping("/sentence")
	public SentenceResponseBean createSentence(
			@RequestBody SentenceRequestBean request) {
		log.debug("createSentence");
		
		Sentence sentence = request.getData().get(0);
		
		SentenceResponseBean response = new SentenceResponseBean();
		List<Sentence> resData = new ArrayList<Sentence>();
		Sentence createSentence = sentenceService.createSentence(sentence);
		
		if(createSentence == null) {
			response.setMessage("Failed Create Sentence");
			response.setData(sentenceService.findAllSentenceById(sentence.getVerb_id()));
			response.setRes(false);
		}else {
			response.setMessage("Success Create Sentence");
			resData.add(0, createSentence);
			response.setData(resData);
			response.setRes(true);
		}
		
		return response;
	}
	
	
	@PutMapping("/sentence")
	public SentenceResponseBean updateSentence(@RequestBody SentenceRequestBean request) {
		log.info("updateSentence");
		Sentence sentence = request.getData().get(0);
		Integer s_id = sentence.getS_id();
		
		
		SentenceResponseBean response = new SentenceResponseBean();
		List<Sentence> resData = new ArrayList<Sentence>();
		
		Sentence updatedSentence = sentenceService.updateSentence(sentence);
		
		if(updatedSentence == null) {
			response.setMessage("Failed Update Sentence");
			resData.add(0, sentenceService.findOneSentence(s_id));
			response.setData(resData);
			response.setRes(false);
		}else {
			response.setMessage("Success Update Sentence");
			resData.add(0, updatedSentence);
			response.setData(resData);
			response.setRes(true);
		}
		
		return response;
	}
	
	/**
	 * 문장 삭제
	 */
	@DeleteMapping("/sentence/{s_id}")
	public SentenceResponseBean deleteSentence(@PathVariable("s_id") Integer s_id) {
		log.info("deleteSentence");
		
		
		
		SentenceResponseBean response = new SentenceResponseBean();
		
		boolean res = sentenceService.deleteSentence(s_id);
		if(!res) {
			response.setMessage("Failed Delete Sentence");
			response.setRes(false);
		}else {
			response.setMessage("Success Delete Sentence");
			response.setRes(true);
		}
			
		return response;
		
	}

}

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
class SentenceRequestBean extends RequestBean implements Serializable{

	private static final long serialVersionUID = -5646579874238969227L;
	
	private List<Sentence> data;

	public List<Sentence> getData() {
		return data;
	}
	public void setData(List<Sentence> data) {
		this.data = data;
	}
}


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
class SentenceResponseBean extends ResponseBean implements Serializable{

	private static final long serialVersionUID = -6944868810520812223L;
	
	private List<Sentence> data;

	public List<Sentence> getData() {
		return data;
	}
	public void setData(List<Sentence> data) {
		this.data = data;
	}
	
}

