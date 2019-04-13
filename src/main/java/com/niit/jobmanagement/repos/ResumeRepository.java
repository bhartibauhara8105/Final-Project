package com.niit.jobmanagement.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.niit.jobmanagement.entities.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

	//List<Resume>findById(Long id);
	  // @Query("SELECT id1 FROM Resume ") 
	   List<Resume> findById(@Param("id") Long id);
	
	
//	   @Query("SELECT t FROM Todo t WHERE " +
//	            "LOWER(t.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
//	            "LOWER(t.description) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
//	    List<Resume> findBySearchTerm(@Param("searchTerm") String searchTerm);
	
}
