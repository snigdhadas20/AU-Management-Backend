package com.project.aumanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.aumanagement.model.opportunity;

@Repository
public interface OpportunityRepo extends JpaRepository<opportunity, Integer> {
	public opportunity findById(int id);
}
