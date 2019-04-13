package com.niit.jobmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Resume extends AbstractEntity {

	@OneToOne
	@JoinColumn(name = "userid")
	private User user;
	
	 private long id1;

	private byte[] resumefile; 

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public byte[] getResumefile() {
		return resumefile;
	}

	public void setResumefile(byte[] resumefile) {
		this.resumefile = resumefile;
	}
	
	
	public Long getUserId()
	{
		id1=super.getId();
		return super.getId();
	}

	public long getId1() {
		return id1;
	}

	public void setId1(long id1) {
		this.id1 = id1;
	}
	
	

}
