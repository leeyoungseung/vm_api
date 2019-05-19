package com.vm.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "test")
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	private Integer test_id;
	
	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name = "test_title")
	private String test_title;
	
	@CreationTimestamp
	@Column(name = "test_join_day")
	private LocalDateTime test_join_day;
	
	@UpdateTimestamp
	@Column(name = "test_submit_day")
	private LocalDateTime test_submit_day;
	
	@Column(name = "test_verb_count")
	private Integer test_verb_count;

	public Integer getTest_id() {
		return test_id;
	}

	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getTest_title() {
		return test_title;
	}

	public void setTest_title(String test_title) {
		this.test_title = test_title;
	}

	public LocalDateTime getTest_join_day() {
		return test_join_day;
	}

	public void setTest_join_day(LocalDateTime test_join_day) {
		this.test_join_day = test_join_day;
	}

	public LocalDateTime getTest_submit_day() {
		return test_submit_day;
	}

	public void setTest_submit_day(LocalDateTime test_submit_day) {
		this.test_submit_day = test_submit_day;
	}

	public Integer getTest_verb_count() {
		return test_verb_count;
	}

	public void setTest_verb_count(Integer test_verb_count) {
		this.test_verb_count = test_verb_count;
	}
	
	
	

}
