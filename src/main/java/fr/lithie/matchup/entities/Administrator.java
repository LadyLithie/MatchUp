/**
 * 
 */
package fr.lithie.matchup.entities;

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
	 * 
	 */
	public Administrator() {
		super(Role.ADMIN);
	}


}
