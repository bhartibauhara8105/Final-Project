package com.niit.jobmanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.jobmanagement.entities.AppliedJobs;

public interface AppliedJobsRepository extends JpaRepository<AppliedJobs, Long> {

}
