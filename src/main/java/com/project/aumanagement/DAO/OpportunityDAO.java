package com.project.aumanagement.DAO;

import java.util.List;

public class OpportunityDAO {
	List<String> skills;
	List<Integer> minExperience;
	List<String> location;
	List<Integer> countOfFrequency;
	
	public OpportunityDAO() {
		super();
	}

	

	public OpportunityDAO(List<String> skills, List<Integer> minExperience, List<String> location,
			List<Integer> countOfFrequency) {
		super();
		this.skills = skills;
		this.minExperience = minExperience;
		this.location = location;
		this.countOfFrequency = countOfFrequency;
	}



	public List<Integer> getCountOfFrequency() {
		return countOfFrequency;
	}



	public void setCountOfFrequency(List<Integer> countOfFrequency) {
		this.countOfFrequency = countOfFrequency;
	}



	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<Integer> getMinExperience() {
		return minExperience;
	}

	public void setMinExperience(List<Integer> minExperience) {
		this.minExperience = minExperience;
	}

	public List<String> getLocation() {
		return location;
	}

	public void setLocation(List<String> location) {
		this.location = location;
	}
	
	
	
}
