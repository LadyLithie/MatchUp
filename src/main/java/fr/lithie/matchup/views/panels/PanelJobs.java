package fr.lithie.matchup.views.panels;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class PanelJobs extends JPanel {
	private List<PanelResumeJob> resumeJobs;

	/**
	 * @return the resumeJobs
	 */
	public List<PanelResumeJob> getResumeJobs() {
		return resumeJobs;
	}

	/**
	 * Create the panel.
	 */
	public PanelJobs() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		
		//Dynamically added jobs
		resumeJobs = new ArrayList<PanelResumeJob>();

	}
}
