/**
 * 
 * @author Audrey
 *
 */
package fr.lithie.matchup.entities;

import java.util.ArrayList;

public class Company extends User {
	private String siretNumber;
	private String website;
	
	private ArrayList<Job> jobs;

	/**
	 * @return the siretNumber
	 */
	public String getSiretNumber() {
		return siretNumber;
	}

	/**
	 * @param siretNumber
	 *            the siretNumber to set. 14 numbers must be present to be validate
	 * @return
	 */
	public boolean setSiretNumber(String siretNumber) {
		boolean result;
		if (siretNumber.length() == 14) {
			this.siretNumber = siretNumber;
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the jobs
	 */
	public ArrayList<Job> getJobs() {
		return jobs;
	}

	/**
	 * @param jobs
	 *            the jobs to set
	 */
	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}


	/**
	 * 
	 */
	public Company() {
		super(Role.COMPANY);
		// TODO Auto-generated constructor stub
	}

}
