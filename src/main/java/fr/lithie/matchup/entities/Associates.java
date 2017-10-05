package fr.lithie.matchup.entities;

import fr.lithie.matchup.entities.base.BaseEntity;

public class Associates extends BaseEntity {

	private String headhunter;
	private String enterprise;
	
	/**
	 * @return the headhunter
	 */
	public String getHeadhunter() {
		return headhunter;
	}

	/**
	 * @param headhunter the headhunter to set
	 */
	public void setHeadhunter(String headhunter) {
		this.headhunter = headhunter;
	}

	/**
	 * @return the enterprise
	 */
	public String getEnterprise() {
		return enterprise;
	}

	/**
	 * @param enterprise the enterprise to set
	 */
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public Associates () {
		super();
	}
	
	public Associates(String headhunter, String enterprise) {
		super();
		this.headhunter = headhunter;
		this.enterprise = enterprise;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Associates [headhunter=" + headhunter + ", enterprise=" + enterprise + "]";
	}
	
	
}
