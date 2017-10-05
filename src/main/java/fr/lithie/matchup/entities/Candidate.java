/**
 * 
 */
package fr.lithie.matchup.entities;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Audrey
 *
 */
public class Candidate extends RegisteredUser {

	private String firstname;
	private String lastname;
	private String birstdate;
	private String address;

	private ArrayList<Diploma> qualifications;
	private ArrayList<String> mobility;

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
	 * @return the birstdate
	 */
	public String getBirstdate() {
		return birstdate;
	}

	/**
	 * @param string
	 *            the birstdate to set
	 */
	public void setBirstdate(String string) {
		this.birstdate = string;
	}

	/**
	 * @return the qualifications
	 */
	public ArrayList<Diploma> getQualifications() {
		return qualifications;
	}

	/**
	 * @param qualifications
	 *            the qualifications to set
	 */
	public void setQualifications(ArrayList<Diploma> qualifications) {
		this.qualifications = qualifications;
	}

	/**
	 * @return the mobility
	 */
	public ArrayList<String> getMobility() {
		return mobility;
	}

	/**
	 * @param mobility
	 *            the mobility to set
	 */
	public void setMobility(ArrayList<String> mobility) {
		this.mobility = mobility;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 */
	public Candidate() {
		super();
	}

	/**
	 * @param login
	 * @param name
	 * @param phone
	 * @param email
	 * @param presentation
	 * @param avatar
	 * @param created_at
	 * @param updated_at
	 * @param firstname
	 * @param lastname
	 * @param birstdate
	 * @param address
	 * @param qualifications
	 * @param mobility
	 * @param skills
	 */
	public Candidate(String login, String name, String phone, String email, String presentation, Blob avatar,
			String created_at, String updated_at, String firstname, String lastname, String birstdate, String address,
			ArrayList<Diploma> qualifications, ArrayList<String> mobility, List<Skill> skills) {
		super(login, name, phone, email, presentation, avatar, created_at, updated_at);
		this.firstname = firstname;
		this.lastname = lastname;
		this.birstdate = birstdate;
		this.address = address;
		this.qualifications = qualifications;
		this.mobility = mobility;
		this.skills = skills;
		
		super.setRole(Role.CANDIDATE);
		super.setName(firstname + " " + lastname);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Candidate [" + (firstname != null ? "firstname=" + firstname + ", " : "")
				+ (lastname != null ? "lastname=" + lastname + ", " : "")
				+ (birstdate != null ? "birstdate=" + birstdate + ", " : "")
				+ (address != null ? "address=" + address + ", " : "")
				+ (qualifications != null ? "qualifications=" + qualifications + ", " : "")
				+ (mobility != null ? "mobility=" + mobility + ", " : "")
				+ (skills != null ? "skills=" + skills + ", " : "")
				+ (super.toString() != null ? "toString()=" + super.toString() : "") + "]";
	}

}
