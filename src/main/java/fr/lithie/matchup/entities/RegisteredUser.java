/**
 * 
 */
package fr.lithie.matchup.entities;

import java.sql.Blob;

import fr.lithie.matchup.entities.base.BaseEntity;

/**
 * @author Audrey
 *
 */
public abstract class RegisteredUser extends BaseEntity {
	private String login;
	private String name;
	private Role role;
	private String phone;
	private String email;
	private String presentation;
	private Blob avatar;
	private String created_at;
	private String updated_at;
	//Temporary
	private String password;
	private Validity valid;
	
	/**
	 * @return the valid
	 */
	public Validity getValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(Validity valid) {
		this.valid = valid;
	}		
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the presentation
	 */
	public String getPresentation() {
		return presentation;
	}

	/**
	 * @param presentation the presentation to set
	 */
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	/**
	 * @return the avatar
	 */
	public Blob getAvatar() {
		return avatar;
	}

	/**
	 * @param blob the avatar to set
	 */
	public void setAvatar(Blob blob) {
		this.avatar = blob;
	}

	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return the updated_at
	 */
	public String getUpdated_at() {
		return updated_at;
	}

	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	/**
	 * Void constructor
	 */
	public RegisteredUser() {
		super();
	}

	/**
	 * Full constructor
	 * @param login
	 * @param name
	 * @param phone
	 * @param email
	 * @param presentation
	 * @param avatar
	 * @param created_at
	 * @param updated_at
	 */
	public RegisteredUser(String login, String name, String phone, String email,
			String presentation, Blob avatar, String created_at, String updated_at) {
		super();
		this.login = login;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.presentation = presentation;
		this.avatar = avatar;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	
	public RegisteredUser(Role role){
		this.role = role;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegisteredUser [login=" + login + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", presentation=" + presentation + ", avatar=" + avatar + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", password=" + password + "]";
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	

}
