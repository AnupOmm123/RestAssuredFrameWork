package com.genericLibrary;

public class ReqresPOJOclass {
	
	String name;
	String job;

	public ReqresPOJOclass(String name, String job) {
	
		this.name = name;
		this.job = job;
	}
public ReqresPOJOclass()
{
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}

}
