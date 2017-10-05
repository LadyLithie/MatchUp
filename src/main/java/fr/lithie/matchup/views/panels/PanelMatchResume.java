package fr.lithie.matchup.views.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import fr.lithie.matchup.entities.base.BaseEntity;

public class PanelMatchResume extends JPanel {
	private BaseEntity matched;
	private JLabel MatchResult;
	private JButton btnSeeNewMatch;
	private JLabel lblName;

	/**
	 * @return the matched
	 */
	public BaseEntity getMatched() {
		return matched;
	}

	/**
	 * @return the matchResult
	 */
	public JLabel getMatchResult() {
		return MatchResult;
	}

	/**
	 * @return the btnSeeNewMatch
	 */
	public JButton getBtnSeeNewMatch() {
		return btnSeeNewMatch;
	}

	/**
	 * @return the lblName
	 */
	public JLabel getLblName() {
		return lblName;
	}

	/**
	 * Create the panel.
	 */
	public PanelMatchResume(BaseEntity matched) {
		this.matched = matched;
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gbl_panel_NewMatch1 = new GridBagLayout();
		gbl_panel_NewMatch1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_NewMatch1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_NewMatch1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_NewMatch1.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gbl_panel_NewMatch1);
		
		JLabel lblPhotoNewMatch = new JLabel("");
//		lblPhotoNewMatch.setIcon(new ImageIcon(MatchingResultView.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		lblPhotoNewMatch.setIcon(new ImageIcon("image/GenericAvatar.png"));
		GridBagConstraints gbc_lblPhotoNewMatch = new GridBagConstraints();
		gbc_lblPhotoNewMatch.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhotoNewMatch.gridx = 0;
		gbc_lblPhotoNewMatch.gridy = 0;
		add(lblPhotoNewMatch, gbc_lblPhotoNewMatch);
		 
		 lblName = new JLabel("Name");
		 GridBagConstraints gbc_lblName = new GridBagConstraints();
		 gbc_lblName.insets = new Insets(0, 0, 5, 0);
		 gbc_lblName.gridx = 1;
		 gbc_lblName.gridy = 0;
		 add(lblName, gbc_lblName);
		
		 MatchResult = new JLabel("%");
		GridBagConstraints gbc_MatchResult = new GridBagConstraints();
		gbc_MatchResult.insets = new Insets(0, 0, 5, 0);
		gbc_MatchResult.gridx = 1;
		gbc_MatchResult.gridy = 1;
		add(MatchResult, gbc_MatchResult);
		
		 btnSeeNewMatch = new JButton("See");
		GridBagConstraints gbc_btnSee = new GridBagConstraints();
		gbc_btnSee.gridwidth = 2;
		gbc_btnSee.gridx = 0;
		gbc_btnSee.gridy = 2;
		add(btnSeeNewMatch, gbc_btnSee);	}

}
