package fr.lithie.matchup.managers;

import java.util.ArrayList;
import java.util.List;

import fr.lithie.matchup.entities.Candidate;
import fr.lithie.matchup.entities.Proposal;
import fr.lithie.matchup.entities.Skill;

public class Matching {

	private double percentage;
	private Proposal job;
	private Candidate candidate;
	// private ArrayList<Skill> jobSkills = new ArrayList<>();
	// private ArrayList<Skill> candidateSkills = new ArrayList<>();
	// private ArrayList<Skill> matchedSkills = new ArrayList<>();

	/**
	 * @param job
	 * @param candidate
	 */
	public Matching(Proposal job, Candidate candidate) {
		super();
		this.job = job;
		this.candidate = candidate;
		percentage = matching();
	}

	/**
	 * @return the percentage
	 */
	public double getPercentage() {
		return percentage;
	}

	/**
	 * @return the job
	 */
	public Proposal getJob() {
		return job;
	}

	/**
	 * @return the candidate
	 */
	public Candidate getCandidate() {
		return candidate;
	}

	private double matching() {

		// for (int i = 0 ; i < job.getSkills().size() ; i++) {
		// jobSkills.add(i, job.getSkills().get(i));
		// }
		// for (int i = 0 ; i < candidate.getSkills().size() ; i++) {
		// candidateSkills.add(i, candidate.getSkills().get(i));
		// }

		List<Skill> matchedSkills = new ArrayList<>();
		for (int i = 0; i < job.getSkills().size(); i++) {
			for (int j = 0; j < candidate.getSkills().size(); j++) {

				if (candidate.getSkills().get(j).getName().equals(job.getSkills().get(i).getName())) {
					matchedSkills.add(job.getSkills().get(i));
				}
			}
		}

		percentage = ((matchedSkills.size() / job.getSkills().size()) * 100);

		return percentage;
	}

}
