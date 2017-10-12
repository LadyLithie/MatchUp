/**
 * 
 */
package fr.lithie.matchup.managers;

import java.util.ArrayList;
import java.util.List;

import fr.lithie.matchup.entities.Candidate;
import fr.lithie.matchup.entities.Job;
import fr.lithie.matchup.entities.base.BaseEntity;

/**
 * @author Audrey
 *
 */
public class MatchManager {
	private List<BaseEntity> cList;
	private List<Job> jList;
	private boolean modePro;

	/**
	 * Basic constructor
	 */
	protected MatchManager() {
		cList = new ArrayList<>();
		jList = new ArrayList<>();
	}
	
	/**
	 * Constructor for professional matching
	 * @param candidates
	 * @param job
	 */
	public MatchManager(List<BaseEntity> candidates, Job job) {
		this();
		this.cList = candidates;
		jList.add(job);
		modePro = true;
	}
	
	/**
	 * Constructor for candidate matching
	 * @param candidate
	 * @param jList
	 */
	public MatchManager(Candidate candidate, List<Job> jList) {
		this();
		this.jList = jList;
		cList.add(candidate);
		modePro = false;
	}
	
	public List<Matching> basic() {
		List<Matching> result = new ArrayList<>();
		
		if (modePro) {
			if (cList.size()<20) {
				for (BaseEntity user : cList) {
					result.add(new Matching(jList.get(0), (Candidate) user));
				}
			}
		} else {

		}
		
		return result;
	}
	
}
