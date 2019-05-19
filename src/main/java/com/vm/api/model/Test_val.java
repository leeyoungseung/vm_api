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
	
	
	
	
	

}
