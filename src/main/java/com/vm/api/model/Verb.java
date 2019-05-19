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
@Table(name = "verb")
public class Verb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "verb_id")
	private Integer verb_id;
	
	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name = "verb_title")
	private String verb_title;
	
	@Column(name = "verb_mean1")
	private String verb_mean1;
	
	@Column(name = "verb_mean2")
	private String verb_mean2;
	
	@Column(name = "verb_mean3")
	private String verb_mean3;
	
	@Column(name = "verb_mean4")
	private String verb_mean4;
	
	@Column(name = "verb_mean5")
	private String verb_mean5;
	
	@CreationTimestamp
	@Column(name = "verb_join_day")
	private LocalDateTime verb_join_day;
	
	@UpdateTimestamp
	@Column(name = "verb_update_day")
	private LocalDateTime verb_update_day;
	
	@Column(name = "verb_sort")
	private Integer verb_sort;

	public Integer getVerb_id() {
		return verb_id;
	}

	public void setVerb_id(Integer verb_id) {
		this.verb_id = verb_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getVerb_title() {
		return verb_title;
	}

	public void setVerb_title(String verb_title) {
		this.verb_title = verb_title;
	}

	public String getVerb_mean1() {
		return verb_mean1;
	}

	public void setVerb_mean1(String verb_mean1) {
		this.verb_mean1 = verb_mean1;
	}

	public String getVerb_mean2() {
		return verb_mean2;
	}

	public void setVerb_mean2(String verb_mean2) {
		this.verb_mean2 = verb_mean2;
	}

	public String getVerb_mean3() {
		return verb_mean3;
	}

	public void setVerb_mean3(String verb_mean3) {
		this.verb_mean3 = verb_mean3;
	}

	public String getVerb_mean4() {
		return verb_mean4;
	}

	public void setVerb_mean4(String verb_mean4) {
		this.verb_mean4 = verb_mean4;
	}

	public String getVerb_mean5() {
		return verb_mean5;
	}

	public void setVerb_mean5(String verb_mean5) {
		this.verb_mean5 = verb_mean5;
	}

	public LocalDateTime getVerb_join_day() {
		return verb_join_day;
	}

	public void setVerb_join_day(LocalDateTime verb_join_day) {
		this.verb_join_day = verb_join_day;
	}

	public LocalDateTime getVerb_update_day() {
		return verb_update_day;
	}

	public void setVerb_update_day(LocalDateTime verb_update_day) {
		this.verb_update_day = verb_update_day;
	}

	public Integer getVerb_sort() {
		return verb_sort;
	}

	public void setVerb_sort(Integer verb_sort) {
		this.verb_sort = verb_sort;
	}
	
	
	
	
	
	
}
