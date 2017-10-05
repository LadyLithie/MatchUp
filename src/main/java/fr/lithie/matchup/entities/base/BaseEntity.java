/**
 * 
 */
package fr.lithie.matchup.entities.base;

/**
 * @author Audrey
 *
 */
public abstract class BaseEntity {
	private double id;

	/**
	 * @return the id
	 */
	public double getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(double id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[id=" + id + "]";
	}
	
	
}
