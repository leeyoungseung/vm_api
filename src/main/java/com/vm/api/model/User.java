package com.vm.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name = "user_mail")
	private String user_mail;
	
	@Column(name = "user_passwd")
	private String user_passwd;
	
	@Column(name = "user_name")
	private String user_name;
	
	@Column(name = "user_gender")
	private Integer user_gender;
	
	@CreationTimestamp
	@Column(name = "user_join_day")
	private LocalDateTime user_join_day;
	
	@UpdateTimestamp
	@Column(name = "user_update_day")
	private LocalDateTime user_update_day;
	
	@Column(name = "user_sort")
	private Integer user_sort;
	
	@Column(name = "user_country")
	private String user_country;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public String getUser_passwd() {
		return user_passwd;
	}

	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(Integer user_gender) {
		this.user_gender = user_gender;
	}

	public LocalDateTime getUser_join_day() {
		return user_join_day;
	}

	public void setUser_join_day(LocalDateTime user_join_day) {
		this.user_join_day = user_join_day;
	}

	public LocalDateTime getUser_update_day() {
		return user_update_day;
	}

	public void setUser_update_day(LocalDateTime user_update_day) {
		this.user_update_day = user_update_day;
	}

	public Integer getUser_sort() {
		return user_sort;
	}

	public void setUser_sort(Integer user_sort) {
		this.user_sort = user_sort;
	}

	public String getUser_country() {
		return user_country;
	}

	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}
	
}
