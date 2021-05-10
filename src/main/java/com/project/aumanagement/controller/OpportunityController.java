package com.project.aumanagement.controller;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.aumanagement.DAO.OpportunityDAO;
import com.project.aumanagement.model.opportunity;
import com.project.aumanagement.service.OpportunityService;

@RestController
public class OpportunityController {
	
	@Autowired
	private OpportunityService opService;
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value = "/getAllOpprtunity", produces="application/json")
	public List<opportunity> getAllOpportunity(){
		return opService.findAllOpportunity();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="/editRecord", produces="application/json")
	public ResponseEntity<String> editRecord(@RequestBody opportunity opData){
		opService.updateOppor(opData);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="/addOpportunity", produces="application/json")
	public opportunity addOpportunity(@RequestBody opportunity opData){
		return opService.addOppor(opData);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping(value="/deleteRecord/{id}", produces="application/json")
	public ResponseEntity<String> deleteRecord(@PathVariable int id){
		opService.deleteOppor(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/getAll/{resource}", produces="application/json")
	public OpportunityDAO getAllResource(@PathVariable String resource){
		OpportunityDAO domElement = new OpportunityDAO();
		String obtainedResource = resource.toLowerCase();
		List<Integer> countOfElements = new ArrayList<Integer>();
		Set<String> setOfDistinctResource = new HashSet<String>();
		Set<Integer> setOfDistinctMinExp = new HashSet<Integer>();
		
		if(obtainedResource.equals("skills")) {
			 List<String> allSkills = new ArrayList<String>();
			 allSkills = opService.findAllResource(obtainedResource);
			 Collections.sort(allSkills);
			 setOfDistinctResource.addAll(allSkills);
			 for(String skill : setOfDistinctResource) {
				 countOfElements.add(Collections.frequency(allSkills, skill));
			 }
			 allSkills.clear();
			 allSkills.addAll(setOfDistinctResource);
			 domElement.setSkills(allSkills);
			 domElement.setCountOfFrequency(countOfElements);
		}
		else if(obtainedResource.equals("locations")) {
			List<String> allLocations = new ArrayList<String>();
			allLocations = opService.findAllResource(obtainedResource);
			Collections.sort(allLocations);
			setOfDistinctResource.addAll(allLocations);
			for(String location: setOfDistinctResource) {
				 countOfElements.add(Collections.frequency(allLocations, location));
			 }
			allLocations.clear();
			allLocations.addAll(setOfDistinctResource);
			domElement.setCountOfFrequency(countOfElements);
			domElement.setLocation(allLocations);
		}
		else {
			List<Integer> allMinExp = new ArrayList<Integer>();
			allMinExp = opService.findAllMinExp();
			Collections.sort(allMinExp);
			setOfDistinctMinExp.addAll(allMinExp);
			for(int minexp: setOfDistinctMinExp) {
				 countOfElements.add(Collections.frequency(allMinExp, minexp));
			 }
			allMinExp.clear();
			allMinExp.addAll(setOfDistinctMinExp);
			domElement.setCountOfFrequency(countOfElements);
			domElement.setMinExperience(allMinExp);
		}
		return domElement;
	}



}
