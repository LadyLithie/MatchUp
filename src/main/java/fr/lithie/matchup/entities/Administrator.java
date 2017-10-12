/**
 * 
 */
package fr.lithie.matchup.entities;

import java.sql.Blob;

/**
 * @author Audrey
 *
 */
public class Administrator extends User {
	private String firstname;
	private String lastname;
	
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
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
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param login
	 * @param isConnected
	 * @param name
	 * @param phone
	 * @param email
	 * @param presentation
	 * @param avatar
	 * @param created_at
	 * @param updated_at
	 * @param firstname
	 * @param lastname
	 */
	public Administrator(String login, String name, String phone, String email,
			String presentation, Blob avatar, String created_at, String updated_at, String firstname,
			String lastname) {
		super(login, name, phone, email, presentation, avatar, created_at, updated_at);
		this.firstname = firstname;
		this.lastname = lastname;
		super.setName(firstname + " " + lastname);
		super.setRole(Role.ADMIN);
	}

	/**
	 * 
	 */
	public Administrator() {
		super();
	}


}
