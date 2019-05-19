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
@Table(name = "sentence")
public class Sentence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private Integer s_id;
	
	@Column(name = "verb_id")
	private Integer verb_id;
	
	@Column(name = "s_present")
	private String s_present;
	
	@Column(name = "s_past")
	private String s_past;
	
	@Column(name = "s_future")
	private String s_future;
	
	@Column(name = "s_present_progressive")
	private String s_present_progressive;
	
	@Column(name = "s_past_progressive")
	private String s_past_progressive;
	
	@Column(name = "s_future_progressive")
	private String s_future_progressive;
	
	@Column(name = "s_present_perfect")
	private String s_present_perfect;
	
	@Column(name = "s_past_perfect")
	private String s_past_perfect;
	
	@Column(name = "s_future_perfect")
	private String s_future_perfect;
	
	@Column(name = "s_present_perfect_progressive")
	private String s_present_perfect_progressive;
	
	@Column(name = "s_on_the_past_perfect")
	private String s_on_the_past_perfect;
	
	@Column(name = "s_on_the_future_perfect")
	private String s_on_the_future_perfect;
	
	@Column(name = "s_can")
	private String s_can;
	
	@Column(name = "s_could")
	private String s_could;
	
	@Column(name = "s_shall")
	private String s_shall;
	
	@Column(name = "s_should")
	private String s_should;
	
	@Column(name = "s_may")
	private String s_may;
	
	@Column(name = "s_might")
	private String s_might;
	
	@Column(name = "s_must")
	private String s_must;
	
	@Column(name = "s_supine")
	private String s_supine;
	
	@Column(name = "s_gerund")
	private String s_gerund;
	
	@Column(name = "s_present_participle")
	private String s_present_participle;
	
	@Column(name = "s_past_participle")
	private String s_past_participle;

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

	public String getS_present() {
		return s_present;
	}

	public void setS_present(String s_present) {
		this.s_present = s_present;
	}

	public String getS_past() {
		return s_past;
	}

	public void setS_past(String s_past) {
		this.s_past = s_past;
	}

	public String getS_future() {
		return s_future;
	}

	public void setS_future(String s_future) {
		this.s_future = s_future;
	}

	public String getS_present_progressive() {
		return s_present_progressive;
	}

	public void setS_present_progressive(String s_present_progressive) {
		this.s_present_progressive = s_present_progressive;
	}

	public String getS_past_progressive() {
		return s_past_progressive;
	}

	public void setS_past_progressive(String s_past_progressive) {
		this.s_past_progressive = s_past_progressive;
	}

	public String getS_future_progressive() {
		return s_future_progressive;
	}

	public void setS_future_progressive(String s_future_progressive) {
		this.s_future_progressive = s_future_progressive;
	}

	public String getS_present_perfect() {
		return s_present_perfect;
	}

	public void setS_present_perfect(String s_present_perfect) {
		this.s_present_perfect = s_present_perfect;
	}

	public String getS_past_perfect() {
		return s_past_perfect;
	}

	public void setS_past_perfect(String s_past_perfect) {
		this.s_past_perfect = s_past_perfect;
	}

	public String getS_future_perfect() {
		return s_future_perfect;
	}

	public void setS_future_perfect(String s_future_perfect) {
		this.s_future_perfect = s_future_perfect;
	}

	public String getS_present_perfect_progressive() {
		return s_present_perfect_progressive;
	}

	public void setS_present_perfect_progressive(String s_present_perfect_progressive) {
		this.s_present_perfect_progressive = s_present_perfect_progressive;
	}

	public String getS_on_the_past_perfect() {
		return s_on_the_past_perfect;
	}

	public void setS_on_the_past_perfect(String s_on_the_past_perfect) {
		this.s_on_the_past_perfect = s_on_the_past_perfect;
	}

	public String getS_on_the_future_perfect() {
		return s_on_the_future_perfect;
	}

	public void setS_on_the_future_perfect(String s_on_the_future_perfect) {
		this.s_on_the_future_perfect = s_on_the_future_perfect;
	}

	public String getS_can() {
		return s_can;
	}

	public void setS_can(String s_can) {
		this.s_can = s_can;
	}

	public String getS_could() {
		return s_could;
	}

	public void setS_could(String s_could) {
		this.s_could = s_could;
	}

	public String getS_shall() {
		return s_shall;
	}

	public void setS_shall(String s_shall) {
		this.s_shall = s_shall;
	}

	public String getS_should() {
		return s_should;
	}

	public void setS_should(String s_should) {
		this.s_should = s_should;
	}

	public String getS_may() {
		return s_may;
	}

	public void setS_may(String s_may) {
		this.s_may = s_may;
	}

	public String getS_might() {
		return s_might;
	}

	public void setS_might(String s_might) {
		this.s_might = s_might;
	}

	public String getS_must() {
		return s_must;
	}

	public void setS_must(String s_must) {
		this.s_must = s_must;
	}

	public String getS_supine() {
		return s_supine;
	}

	public void setS_supine(String s_supine) {
		this.s_supine = s_supine;
	}

	public String getS_gerund() {
		return s_gerund;
	}

	public void setS_gerund(String s_gerund) {
		this.s_gerund = s_gerund;
	}

	public String getS_present_participle() {
		return s_present_participle;
	}

	public void setS_present_participle(String s_present_participle) {
		this.s_present_participle = s_present_participle;
	}

	public String getS_past_participle() {
		return s_past_participle;
	}

	public void setS_past_participle(String s_past_participle) {
		this.s_past_participle = s_past_participle;
	}
	
	
}
