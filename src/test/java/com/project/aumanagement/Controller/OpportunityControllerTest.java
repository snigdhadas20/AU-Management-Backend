package com.project.aumanagement.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.aumanagement.model.opportunity;
import com.project.aumanagement.service.OpportunityService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OpportunityControllerTest {
	
	@Autowired
	OpportunityService opService;
	
	@Test
	void allOpporTest() {
		opportunity newOppor = new opportunity(1, "Software Engineer", "Python", "Bangalore", 1, "Description for python",
			"Mr. XYZ", "02/03/2021");
		opService.addOppor(newOppor);
		List<opportunity> allOppor = new ArrayList<opportunity>();
		allOppor = opService.findAllOpportunity();
		String strOfEntered = newOppor.toString();
		String strOfResponse = allOppor.get(0).toString();
		assertEquals(strOfEntered, strOfResponse);
	}
	
	@Test
	void addOpporTest() {
		opportunity newOppor = new opportunity(3, "Software Tester", "Java", "Delhi", 2, "Description for Java Test",
				"Mr. DEF", "10/04/2021");
		opportunity response= opService.addOppor(newOppor);
		assertEquals(newOppor.toString(), response.toString());
	}
	
	@Test
	void findAllOppor() {
		opportunity newOppor = new opportunity(3, "Software Tester", "Java", "Delhi", 2, "Description for Java Test",
				"Mr. DEF", "10/04/2021");
		opService.addOppor(newOppor);
		List<String> listOfAllSkills = new ArrayList<String>();
		listOfAllSkills.add("Java");
		List<String> allSkillsPresent = opService.findAllResource("skills");
		assertEquals(listOfAllSkills.get(0), allSkillsPresent.get(0));
	}

}

