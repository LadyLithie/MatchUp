/**
 * 
 * @author Yannick
 *
 */
package fr.lithie.matchup.entities;

import fr.lithie.matchup.entities.base.BaseEntity;

public class ContractType extends BaseEntity {
	private String name;
	
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
	
	
	public ContractType (String name) {
		super();
		this.name = name;
	}

	public ContractType() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContractType [name=" + name + "]";
	}

}
