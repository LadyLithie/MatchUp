/**
 * 
 * @author Yannick, Audrey
 *
 */
package fr.lithie.matchup.entities;

import java.sql.Blob;
import java.util.ArrayList;

public class Company extends User {
	private String address;
	// declare image as int ? chemin du fichier en String
	private String siretNumber;
	private String website;
	private String city;
	private String twitter;
	private String linkedin;
	private String activity;
	private ArrayList<Headhunter> associates;

	private ArrayList<Job> jobs;

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

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
	 * @return the associates
	 */
	public ArrayList<Headhunter> getAssociates() {
		return associates;
	}

	/**
	 * @param associates
	 *            the associates to set
	 */
	public void setAssociates(ArrayList<Headhunter> associates) {
		this.associates = associates;
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the twitter
	 */
	public String getTwitter() {
		return twitter;
	}

	/**
	 * @param twitter the twitter to set
	 */
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	/**
	 * @return the linkedin
	 */
	public String getLinkedin() {
		return linkedin;
	}

	/**
	 * @param linkedin the linkedin to set
	 */
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	/**
	 * @return the activity
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}

	/**
	 * 
	 */
	public Company() {
		super();
		associates = new ArrayList<>();
		jobs = new ArrayList<>();
	}

	/**
	 * Full constructor
	 * 
	 * @param login
	 * @param name
	 * @param phone
	 * @param email
	 * @param presentation
	 * @param avatar
	 * @param created_at
	 * @param updated_at
	 * @param address
	 * @param siretNumber
	 */
	public Company(String login, String name, String phone, String email, String presentation,
			Blob avatar, String created_at, String updated_at, String address, String siretNumber) {
		super(login, name, phone, email, presentation, avatar, created_at, updated_at);
		super.setRole(Role.COMPANY);
		this.address = address;
		this.siretNumber = siretNumber;
		associates = new ArrayList<>();
		jobs = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Company [address=" + address + ", siretNumber=" + siretNumber + ", website=" + website + "]";
	}


}
