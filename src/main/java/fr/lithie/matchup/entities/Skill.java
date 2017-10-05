/**
 * 
 * @author Yannick
 *
 */
package fr.lithie.matchup.entities;

import fr.lithie.matchup.entities.base.BaseEntity;

public class Skill extends BaseEntity {
	public static final String SOCIAL = "Savoir-être";
	public static final String TECHNIQUE = "Savoir-faire";
	private String name;
	private String skillType;

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
	 * @return the skillType
	 */
	public String getSkillType() {
		return skillType;
	}

	/**
	 * @param skillType the skillType to set
	 */
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	
	
	public Skill (String name, String skillType) {
		super();
		this.name = name;
		this.skillType = skillType;
	}
	
	
	public Skill() {
		super();
	}

	public String toStringFull() {
		return "Skill "+super.toString()+"[name=" + name + ", skillType=" + skillType + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (name != null ?  name : "")
				+ (skillType != null ? "(" + skillType + ")" : "()");
	}

}
