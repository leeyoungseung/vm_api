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
import com.vm.api.model.Verb;
import com.vm.api.service.VerbService;

@RestController
@RequestMapping(path = "/api")
public class VerbController {
	
	private static final Logger log = LogManager.getLogger(VerbController.class.getName());
	
	@Autowired
	VerbService verbService;
	
	/**
	 * 유저가 등록한 동사단어 리스트
	 * @param user_id
	 */
	@GetMapping("/verb/{user_id}")
	public VerbResponseBean findAllVerb(@PathVariable("user_id") Integer user_id){
		log.info("findAllVerb");	
		VerbResponseBean response = new VerbResponseBean();
		List<Verb> list = verbService.findAllVerbByUserId(user_id);
		
		if(list == null) {
			response.setMessage("Failed List Verb");
			response.setRes(false);
		}else {
			response.setMessage("Success List Verb");
			response.setData(list);
			response.setRes(true);
		}
		
		return response;
	}
	
	
	/**
	 * 유저가 등록한 동사단어 하나의 정보
	 * @param user_id
	 * @param verb_id
	 */
	@GetMapping("/verb/{user_id}/{verb_id}")
	public VerbResponseBean findOneVerb(@PathVariable("user_id") Integer user_id
			, @PathVariable("verb_id") Integer verb_id) {
		log.debug("findOneVerb");
		VerbResponseBean response = new VerbResponseBean();
		Verb verb = verbService.findOneVerb(verb_id);
		List<Verb> resData = new ArrayList<Verb>();
		
		if(verb == null) {
			response.setMessage("Failed Get Verb");
			response.setRes(false);
		}else {
			response.setMessage("Success Get Verb");
			resData.add(0, verb);
			response.setData(resData);
			response.setRes(true);
		}
		
		return response;
	}
	
	
	/**
	 * 동사정보 등록
	 * @param request
	 */
	@PostMapping("/verb")
	public VerbResponseBean createVerb(@RequestBody VerbRequestBean request){
		log.info("createVerb");
		Verb verb = request.getData().get(0);
		Integer user_id = request.getData().get(0).getUser_id();
		
		VerbResponseBean response = new VerbResponseBean();
		Verb createdVerb = verbService.createVerb(verb);
		List<Verb> resData = new ArrayList<Verb>();
		
		if(createdVerb == null) {
			response.setMessage("Failed Create Verb");
			response.setData(verbService.findAllVerbByUserId(user_id));
			response.setRes(false);
		}else {
			response.setMessage("Success Create Verb");
			resData.add(0, createdVerb);
			response.setData(resData);
			response.setRes(true);
		}
		
		return response;
	}
	
	/**
	 * 동사정보 수정
	 * @param request
	 * @return
	 */
	@PutMapping("/verb")
	public VerbResponseBean updateVerb(@RequestBody VerbRequestBean request) {
		log.info("updateVerb");
		Verb verb = request.getData().get(0);
		Integer verb_id = verb.getVerb_id();
		
		
		VerbResponseBean response = new VerbResponseBean();
		Verb updatedVerb = verbService.updateVerb(verb);
		List<Verb> resData = new ArrayList<Verb>();
		
		
		if(updatedVerb == null) {
			response.setMessage("Failed Update Verb");
			resData.add(0, verbService.findOneVerb(verb_id));
			response.setData(resData);
			response.setRes(false);
		}else {
			response.setMessage("Success Update Verb");
			resData.add(0, updatedVerb);
			response.setData(resData);
			response.setRes(true);
		}
		
		return response;
	}
	
	/**
	 * 동사정보 삭제
	 * @param verb_id
	 */
	@DeleteMapping("/verb/{verb_id}")
	public VerbResponseBean deleteVerb(@PathVariable("verb_id") Integer verb_id) {
		log.info("deleteVerb");
		
		VerbResponseBean response = new VerbResponseBean();
		
		boolean res = verbService.deleteVerb(verb_id);
		if(!res) {
			response.setMessage("Failed Delete Verb");
			response.setRes(false);
		}else {
			response.setMessage("Success Delete Verb");
			response.setRes(true);
		}
			
		return response;
		
	}
	
	

}
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
class VerbRequestBean extends RequestBean implements Serializable{

	private static final long serialVersionUID = -1700757480588648185L;
	
	private List<Verb> data;
	
	public List<Verb> getData() {
		return data;
	}
	public void setData(List<Verb> data) {
		this.data = data;
	}
	
	
}


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
class VerbResponseBean extends ResponseBean implements Serializable{
	
	private static final long serialVersionUID = 2462960532603595150L;
	
	private List<Verb> data;
	

	public List<Verb> getData() {
		return data;
	}
	public void setData(List<Verb> data) {
		this.data = data;
	}

}
