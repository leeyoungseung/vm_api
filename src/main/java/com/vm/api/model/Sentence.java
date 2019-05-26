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
@Table(name = "sentence")
public class Sentence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private Integer s_id;
	
	@Column(name = "verb_id")
	private Integer verb_id;
	
	@Column(name = "s_value")
	private String s_value;
	
	@Column(name = "s_sort")
	private Integer s_sort;
	
	@CreationTimestamp
	@Column(name = "s_join_day")
	private LocalDateTime s_join_day;
	
	@UpdateTimestamp
	@Column(name = "s_update_day")
	private LocalDateTime s_update_day;

	public Integer getS_id() {
		return s_id;
	}

	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}

	public Integer getVerb_id() {
		return verb_id;
	}

	public void setVerb_id(Integer verb_id) {
		this.verb_id = verb_id;
	}

	public String getS_value() {
		return s_value;
	}

	public void setS_value(String s_value) {
		this.s_value = s_value;
	}

	public Integer getS_sort() {
		return s_sort;
	}

	public void setS_sort(Integer s_sort) {
		this.s_sort = s_sort;
	}

	public LocalDateTime getS_join_day() {
		return s_join_day;
	}

	public void setS_join_day(LocalDateTime s_join_day) {
		this.s_join_day = s_join_day;
	}

	public LocalDateTime getS_update_day() {
		return s_update_day;
	}

	public void setS_update_day(LocalDateTime s_update_day) {
		this.s_update_day = s_update_day;
	}
	
	
}
