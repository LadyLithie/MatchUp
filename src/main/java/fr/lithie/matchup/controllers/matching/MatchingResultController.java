package fr.lithie.matchup.controllers.matching;

import java.util.ArrayList;

import javax.swing.JFrame;

import fr.lithie.matchup.controllers.BaseController;
import fr.lithie.matchup.entities.Enterprise;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.Proposal;
import fr.lithie.matchup.entities.RegisteredUser;

public class MatchingResultController extends BaseController {

	public MatchingResultController(JFrame frame, Enterprise enterprise2) {
		super();
	}
	public MatchingResultController(JFrame frame, Headhunter headhunter2) {
		super();
	}
	private RegisteredUser user;
	private Enterprise enterprise;
	private Headhunter headhunter;
	private ArrayList<Proposal> proposals = new ArrayList<>();
	
}
