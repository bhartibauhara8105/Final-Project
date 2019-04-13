package com.niit.jobmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AppliedJobs extends AbstractEntity {

	@OneToOne
	@JoinColumn(name = "userid")
	private User user;

	@OneToOne
	@JoinColumn(name = "resumeid")
	private Resume resume;

	@OneToOne
	@JoinColumn(name = "jobid")
	private Jobs jobs;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

}
