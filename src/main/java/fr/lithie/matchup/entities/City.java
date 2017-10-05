package fr.lithie.matchup.entities;

import fr.lithie.matchup.entities.base.BaseEntity;

public class City extends BaseEntity {

	private String name_city;
	private String postal_code_city;
	
	/**
	 * @return the name_city
	 */
	public String getName_city() {
		return name_city;
	}

	/**
	 * @param name_city the name_city to set
	 */
	public void setName_city(String name_city) {
		this.name_city = name_city;
	}

	/**
	 * @return the postal_code_city
	 */
	public String getPostal_code_city() {
		return postal_code_city;
	}

	/**
	 * @param postal_code_city the postal_code_city to set
	 */
	public void setPostal_code_city(String postal_code_city) {
		this.postal_code_city = postal_code_city;
	}

	public City() {
		super();
	}
	
	public City(String name_city, String postal_code_city) {
		super();
		this.name_city = name_city;
		this.postal_code_city = postal_code_city;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name_city + ", " + postal_code_city;
	}
	
	
}
