package fr.lithie.matchup.views.panels;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.lithie.matchup.entities.Proposal;

import java.awt.BorderLayout;

public class PanelJobToMatch extends JPanel {
	private Proposal job;
	private JButton btnSeeMore;

	/**
	 * @return the job
	 */
	public Proposal getJob() {
		return job;
	}

	/**
	 * @return the btnSeeMore
	 */
	public JButton getBtnSeeMore() {
		return btnSeeMore;
	}

	/**
	 * Create the panel.
	 */
	public PanelJobToMatch(Proposal job) {
		this.job = job;
		JPanel panelMatch = new JPanel();
		GridBagConstraints gbc_panelMatch = new GridBagConstraints();
		gbc_panelMatch.insets = new Insets(5, 5, 5, 5);
		gbc_panelMatch.anchor = GridBagConstraints.NORTHEAST;
		gbc_panelMatch.fill = GridBagConstraints.BOTH;
		gbc_panelMatch.gridx = 0;
		gbc_panelMatch.gridy = 0;
		add(panelMatch, gbc_panelMatch);
		
		JLabel lblJobProposal = new JLabel(job.getName());
		String shortResume;
		if (job.getPresentation().length() < 50) {
			shortResume = job.getPresentation();
		} else {
			shortResume = job.getPresentation().substring(0,50) + " ...";
		}
		panelMatch.setLayout(new BorderLayout(0, 0));
		lblJobProposal.setToolTipText(shortResume);
		panelMatch.add(lblJobProposal, BorderLayout.WEST);
		
		btnSeeMore = new JButton("See more");
		panelMatch.add(btnSeeMore, BorderLayout.EAST);
	}

}
