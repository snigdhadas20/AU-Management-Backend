package com.project.aumanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aumanagement.model.opportunity;
import com.project.aumanagement.repository.OpportunityRepo;

@Service
public class OpportunityService {
	
	@Autowired
	OpportunityRepo opRepo;
	
	public List<opportunity> findAllOpportunity(){
		return opRepo.findAll();
	}
	
	public void updateOppor(opportunity op) {
		opportunity object = opRepo.findById(op.getId());
		object.setDesc(op.getDesc());
		object.setHiringManager(op.getHiringManager());
		object.setLocation(op.getLocation());
		object.setMinExperience(op.getMinExperience());
		object.setPost(op.getPost());
		object.setSkill(op.getSkill());
		opRepo.save(object);
	}
	
	public opportunity addOppor(opportunity op) {
		return opRepo.save(op);
	}
	
	public void deleteOppor(int id) {
		opRepo.deleteById(id);
	}
	public List<String> findAllResource(String resource){
		List<opportunity> allItems = new ArrayList<opportunity>();
		allItems = opRepo.findAll();
		if(resource.equals("skills")) {
			List<String> resultsOfSkills = new ArrayList<String>();
			for(opportunity item : allItems) {
				resultsOfSkills.add(item.getSkill());
			}
			return resultsOfSkills;
		}
		else {
			List<String> resultsOfLocation = new ArrayList<String>();
			for(opportunity item : allItems) {
				resultsOfLocation.add(item.getLocation());
			}
			return resultsOfLocation;
		}
	}
	public List<Integer> findAllMinExp(){
		List<opportunity> allItems = new ArrayList<opportunity>();
		allItems = opRepo.findAll();
		List<Integer> resultsOfMinEx = new ArrayList<Integer>();
		for(opportunity item : allItems) {
			resultsOfMinEx.add(item.getMinExperience());
		}
		return resultsOfMinEx;
	}


}
