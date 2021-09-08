package practice;

public class PayloadwithPOJOClass {

	private String name;
	private String job;
	
	private String[] skills;
	private PojoDetails details; //we are creating separate class because this object contains 2 objects.
								 //For every objects we need to create separate class
	
	//constructor to initialize the variables
	public PayloadwithPOJOClass(String name, String job, String[] skills, String companyName,String emailId)
	{
		this.name = name;
		this.job = job;
		this.skills=skills;
		this.details= new PojoDetails(companyName, emailId);
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
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public PojoDetails getDetails() {
		return details;
	}
	public void setDetails(PojoDetails details) {
		this.details = details;
	} 
	
	
}
