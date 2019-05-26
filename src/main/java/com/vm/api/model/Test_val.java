package com.vm.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "test_val")
public class Test_val {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "q_id")
	private Integer q_id;
	
	@Column(name = "test_id")
	private Integer test_id;
	
	@Column(name = "verb_id")
	private Integer verb_id;
	
	@Column(name = "q_res")
	private Integer q_res;
	
	@Column(name = "q_question")
	private String q_question;
	
	@Column(name = "q_ok_word")
	private String q_ok_word;
	
	@Column(name = "q_ng_word1")
	private String q_ng_word1;
	
	@Column(name = "q_ng_word2")
	private String q_ng_word2;
	
	@Column(name = "q_ng_word3")
	private String q_ng_word3;

	public Integer getQ_id() {
		return q_id;
	}

	public void setQ_id(Integer q_id) {
		this.q_id = q_id;
	}

	public Integer getTest_id() {
		return test_id;
	}

	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
	}

	public Integer getVerb_id() {
		return verb_id;
	}

	public void setVerb_id(Integer verb_id) {
		this.verb_id = verb_id;
	}

	public Integer getQ_res() {
		return q_res;
	}

	public void setQ_res(Integer q_res) {
		this.q_res = q_res;
	}

	public String getQ_question() {
		return q_question;
	}

	public void setQ_question(String q_question) {
		this.q_question = q_question;
	}

	public String getQ_ok_word() {
		return q_ok_word;
	}

	public void setQ_ok_word(String q_ok_word) {
		this.q_ok_word = q_ok_word;
	}

	public String getQ_ng_word1() {
		return q_ng_word1;
	}

	public void setQ_ng_word1(String q_ng_word1) {
		this.q_ng_word1 = q_ng_word1;
	}

	public String getQ_ng_word2() {
		return q_ng_word2;
	}

	public void setQ_ng_word2(String q_ng_word2) {
		this.q_ng_word2 = q_ng_word2;
	}

	public String getQ_ng_word3() {
		return q_ng_word3;
	}

	public void setQ_ng_word3(String q_ng_word3) {
		this.q_ng_word3 = q_ng_word3;
	}
	
	

}
