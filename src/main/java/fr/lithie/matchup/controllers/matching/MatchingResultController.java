package fr.lithie.matchup.controllers.matching;

import java.util.ArrayList;

import javax.swing.JFrame;

import fr.lithie.matchup.controllers.BaseController;
import fr.lithie.matchup.entities.Company;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.Job;
import fr.lithie.matchup.entities.User;

public class MatchingResultController extends BaseController {

	public MatchingResultController(JFrame frame, Company enterprise2) {
		super();
	}
	public MatchingResultController(JFrame frame, Headhunter headhunter2) {
		super();
	}
	private User user;
	private Company company;
	private Headhunter headhunter;
	private ArrayList<Job> jobs = new ArrayList<>();
	
}
