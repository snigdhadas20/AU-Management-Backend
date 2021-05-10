package com.project.aumanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class opportunity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String post;
	
	private String skill;
	private String location;
	private int minExperience;
	private String description;
	private String hiringManager;
	private String date;
	
	public opportunity() {
		super();
	}
	
	

	public opportunity(int id, String post, String skill, String location, int minExperience, String description,
			String hiringManager, String date) {
		super();
		this.id = id;
		this.post = post;
		this.skill = skill;
		this.location = location;
		this.minExperience = minExperience;
		this.description = description;
		this.hiringManager = hiringManager;
		this.date = date;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMinExperience() {
		return minExperience;
	}
	public void setMinExperience(int minExperience) {
		this.minExperience = minExperience;
	}
	public String getDesc() {
		return description;
	}
	public void setDesc(String description) {
		this.description = description;
	}
	public String getHiringManager() {
		return hiringManager;
	}
	public void setHiringManager(String hiringManager) {
		this.hiringManager = hiringManager;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "opportunity [post=" + post + ", skill=" + skill + ", location=" + location
				+ ", minExperience=" + minExperience + ", description=" + description + ", hiringManager="
				+ hiringManager + ", date=" + date + "]";
	}


}
