/**
 * 
 */
package fr.lithie.matchup.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Audrey
 *
 */
public class Candidate extends User {

	private String firstname;
	private String lastname;

	private List<Skill> skills = new ArrayList<Skill>();

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the skills
	 */
	public List<Skill> getSkills() {
		return skills;
	}

	/**
	 * @param skills
	 *            the skills to set
	 */
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}


	/**
	 * 
	 */
	public Candidate() {
		super(Role.CANDIDATE);
		// TODO Auto-generated constructor stub 
	}

	
}
