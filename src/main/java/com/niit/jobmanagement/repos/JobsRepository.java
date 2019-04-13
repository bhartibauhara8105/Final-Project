package com.niit.jobmanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.jobmanagement.entities.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Long> {

}
