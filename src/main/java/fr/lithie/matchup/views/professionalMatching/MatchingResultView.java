package fr.lithie.matchup.views.professionalMatching;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

import fr.lithie.matchup.views.base.BaseView;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class MatchingResultView extends BaseView {

	private JButton btnSeeOldMatch;
	private JButton btnSeeNewMatch;
	private JList list_SkillRequired;
	/**
	 * @return the list_SkillRequired
	 */
	public JList getList_SkillRequired() {
		return list_SkillRequired;
	}
	/**
	 * @return the btnSeeOldMatch
	 */
	public JButton getBtnSeeOldMatch() {
		return btnSeeOldMatch;
	}
	/**
	 * @return the btnSeeNewMatch
	 */
	public JButton getBtnSeeNewMatch() {
		return btnSeeNewMatch;
	}
	/**
	 * Create the frame.
	 */
	public MatchingResultView(JFrame frame) {
		
		JPanel panelMatchingResult = new JPanel();
		panelMatchingResult.setName("Matching Result");
		panelMatchingResult.setBounds(100, 100, 900, 600);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelMatchingResult.setLayout(gbl_contentPane);
		
		JPanel panel_MatchedCandidate = new JPanel();
		GridBagConstraints gbc_panel_MatchedCandidate = new GridBagConstraints();
		gbc_panel_MatchedCandidate.insets = new Insets(0, 0, 0, 5);
		gbc_panel_MatchedCandidate.fill = GridBagConstraints.BOTH;
		gbc_panel_MatchedCandidate.gridx = 0;
		gbc_panel_MatchedCandidate.gridy = 0;
		panelMatchingResult.add(panel_MatchedCandidate, gbc_panel_MatchedCandidate);
		GridBagLayout gbl_panel_MatchedCandidate = new GridBagLayout();
		gbl_panel_MatchedCandidate.columnWidths = new int[]{0, 0};
		gbl_panel_MatchedCandidate.rowHeights = new int[]{0, 0, 0};
		gbl_panel_MatchedCandidate.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_MatchedCandidate.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_MatchedCandidate.setLayout(gbl_panel_MatchedCandidate);
		
		JPanel panel_NewMatchs = new JPanel();
		panel_NewMatchs.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_NewMatchs = new GridBagConstraints();
		gbc_panel_NewMatchs.insets = new Insets(0, 0, 5, 0);
		gbc_panel_NewMatchs.fill = GridBagConstraints.BOTH;
		gbc_panel_NewMatchs.gridx = 0;
		gbc_panel_NewMatchs.gridy = 0;
		panel_MatchedCandidate.add(panel_NewMatchs, gbc_panel_NewMatchs);
		GridBagLayout gbl_panel_NewMatchs = new GridBagLayout();
		gbl_panel_NewMatchs.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_NewMatchs.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_NewMatchs.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_NewMatchs.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_NewMatchs.setLayout(gbl_panel_NewMatchs);
		
		JPanel panel_NewMatch1 = new JPanel();
		panel_NewMatch1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_NewMatch1 = new GridBagConstraints();
		gbc_panel_NewMatch1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_NewMatch1.fill = GridBagConstraints.BOTH;
		gbc_panel_NewMatch1.gridx = 0;
		gbc_panel_NewMatch1.gridy = 0;
		panel_NewMatchs.add(panel_NewMatch1, gbc_panel_NewMatch1);
		GridBagLayout gbl_panel_NewMatch1 = new GridBagLayout();
		gbl_panel_NewMatch1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_NewMatch1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_NewMatch1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_NewMatch1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_NewMatch1.setLayout(gbl_panel_NewMatch1);
		
		JLabel lblPhotoNewMatch = new JLabel("");
		lblPhotoNewMatch.setIcon(new ImageIcon(MatchingResultView.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		GridBagConstraints gbc_lblPhotoNewMatch = new GridBagConstraints();
		gbc_lblPhotoNewMatch.gridheight = 2;
		gbc_lblPhotoNewMatch.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhotoNewMatch.gridx = 0;
		gbc_lblPhotoNewMatch.gridy = 0;
		panel_NewMatch1.add(lblPhotoNewMatch, gbc_lblPhotoNewMatch);
		
		JLabel lblPrenomNewMatch = new JLabel("Prenom");
		GridBagConstraints gbc_lblPrenomNewMatch = new GridBagConstraints();
		gbc_lblPrenomNewMatch.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrenomNewMatch.gridx = 1;
		gbc_lblPrenomNewMatch.gridy = 0;
		panel_NewMatch1.add(lblPrenomNewMatch, gbc_lblPrenomNewMatch);
		
		JLabel lblNomNewMatch = new JLabel("Nom");
		GridBagConstraints gbc_lblNomNewMatch = new GridBagConstraints();
		gbc_lblNomNewMatch.insets = new Insets(0, 0, 5, 0);
		gbc_lblNomNewMatch.gridx = 1;
		gbc_lblNomNewMatch.gridy = 1;
		panel_NewMatch1.add(lblNomNewMatch, gbc_lblNomNewMatch);
		
		JLabel labelPourcentageNewMatch = new JLabel("%");
		GridBagConstraints gbc_labelPourcentageNewMatch = new GridBagConstraints();
		gbc_labelPourcentageNewMatch.insets = new Insets(0, 0, 5, 0);
		gbc_labelPourcentageNewMatch.gridx = 1;
		gbc_labelPourcentageNewMatch.gridy = 2;
		panel_NewMatch1.add(labelPourcentageNewMatch, gbc_labelPourcentageNewMatch);
		
		JButton btnSeeNewMatch = new JButton("See");
		GridBagConstraints gbc_btnSee = new GridBagConstraints();
		gbc_btnSee.gridwidth = 2;
		gbc_btnSee.insets = new Insets(0, 0, 0, 5);
		gbc_btnSee.gridx = 0;
		gbc_btnSee.gridy = 3;
		panel_NewMatch1.add(btnSeeNewMatch, gbc_btnSee);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 0;
		panel_NewMatchs.add(panel_6, gbc_panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 1;
		panel_NewMatchs.add(panel_7, gbc_panel_7);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		panel_NewMatchs.add(panel_4, gbc_panel_4);
		
		JScrollBar scrollBar = new JScrollBar();
		GridBagConstraints gbc_scrollBar = new GridBagConstraints();
		gbc_scrollBar.fill = GridBagConstraints.VERTICAL;
		gbc_scrollBar.gridheight = 2;
		gbc_scrollBar.insets = new Insets(5, 5, 5, 5);
		gbc_scrollBar.gridx = 2;
		gbc_scrollBar.gridy = 0;
		panel_NewMatchs.add(scrollBar, gbc_scrollBar);
		
		JPanel panel_OldMatch = new JPanel();
		panel_OldMatch.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_OldMatch = new GridBagConstraints();
		gbc_panel_OldMatch.fill = GridBagConstraints.BOTH;
		gbc_panel_OldMatch.gridx = 0;
		gbc_panel_OldMatch.gridy = 1;
		panel_MatchedCandidate.add(panel_OldMatch, gbc_panel_OldMatch);
		GridBagLayout gbl_panel_OldMatch = new GridBagLayout();
		gbl_panel_OldMatch.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_OldMatch.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_OldMatch.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_OldMatch.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_OldMatch.setLayout(gbl_panel_OldMatch);
		
		JPanel panel_OldMatch1 = new JPanel();
		panel_OldMatch1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_OldMatch1 = new GridBagConstraints();
		gbc_panel_OldMatch1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_OldMatch1.fill = GridBagConstraints.BOTH;
		gbc_panel_OldMatch1.gridx = 0;
		gbc_panel_OldMatch1.gridy = 0;
		panel_OldMatch.add(panel_OldMatch1, gbc_panel_OldMatch1);
		GridBagLayout gbl_panel_OldMatch1 = new GridBagLayout();
		gbl_panel_OldMatch1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_OldMatch1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_OldMatch1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_OldMatch1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_OldMatch1.setLayout(gbl_panel_OldMatch1);
		
		JLabel label_PhotoOldMatch = new JLabel("");
		label_PhotoOldMatch.setIcon(new ImageIcon(MatchingResultView.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		GridBagConstraints gbc_label_PhotoOldMatch = new GridBagConstraints();
		gbc_label_PhotoOldMatch.gridheight = 2;
		gbc_label_PhotoOldMatch.insets = new Insets(0, 0, 5, 5);
		gbc_label_PhotoOldMatch.gridx = 0;
		gbc_label_PhotoOldMatch.gridy = 0;
		panel_OldMatch1.add(label_PhotoOldMatch, gbc_label_PhotoOldMatch);
		
		JLabel label_PrenomOldMatch = new JLabel("Prenom");
		GridBagConstraints gbc_label_PrenomOldMatch = new GridBagConstraints();
		gbc_label_PrenomOldMatch.insets = new Insets(0, 0, 5, 0);
		gbc_label_PrenomOldMatch.gridx = 1;
		gbc_label_PrenomOldMatch.gridy = 0;
		panel_OldMatch1.add(label_PrenomOldMatch, gbc_label_PrenomOldMatch);
		
		JLabel label_NameOldMatch = new JLabel("Nom");
		GridBagConstraints gbc_label_NameOldMatch = new GridBagConstraints();
		gbc_label_NameOldMatch.insets = new Insets(0, 0, 5, 0);
		gbc_label_NameOldMatch.gridx = 1;
		gbc_label_NameOldMatch.gridy = 1;
		panel_OldMatch1.add(label_NameOldMatch, gbc_label_NameOldMatch);
		
		JLabel label_PourcentageOldMatch = new JLabel("%");
		GridBagConstraints gbc_label_PourcentageOldMatch = new GridBagConstraints();
		gbc_label_PourcentageOldMatch.insets = new Insets(0, 0, 5, 0);
		gbc_label_PourcentageOldMatch.gridx = 1;
		gbc_label_PourcentageOldMatch.gridy = 2;
		panel_OldMatch1.add(label_PourcentageOldMatch, gbc_label_PourcentageOldMatch);
		
		JButton btnSeeOldMatch = new JButton("See");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 2;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 3;
		panel_OldMatch1.add(btnSeeOldMatch, gbc_button);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 1;
		gbc_panel_10.gridy = 0;
		panel_OldMatch.add(panel_10, gbc_panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 1;
		panel_OldMatch.add(panel_11, gbc_panel_11);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 1;
		panel_OldMatch.add(panel_8, gbc_panel_8);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		GridBagConstraints gbc_scrollBar_1 = new GridBagConstraints();
		gbc_scrollBar_1.fill = GridBagConstraints.VERTICAL;
		gbc_scrollBar_1.gridheight = 2;
		gbc_scrollBar_1.insets = new Insets(5, 5, 5, 5);
		gbc_scrollBar_1.gridx = 2;
		gbc_scrollBar_1.gridy = 0;
		panel_OldMatch.add(scrollBar_1, gbc_scrollBar_1);
		
		JPanel panel_JobDescription = new JPanel();
		panel_JobDescription.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_JobDescription = new GridBagConstraints();
		gbc_panel_JobDescription.fill = GridBagConstraints.BOTH;
		gbc_panel_JobDescription.gridx = 1;
		gbc_panel_JobDescription.gridy = 0;
		panelMatchingResult.add(panel_JobDescription, gbc_panel_JobDescription);
		GridBagLayout gbl_panel_JobDescription = new GridBagLayout();
		gbl_panel_JobDescription.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_JobDescription.rowHeights = new int[] {25, 25, 25, 190, 25, 190};
		gbl_panel_JobDescription.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_JobDescription.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0};
		panel_JobDescription.setLayout(gbl_panel_JobDescription);
		
		JLabel lblJobTitle = new JLabel("Job title");
		GridBagConstraints gbc_lblJobTitle = new GridBagConstraints();
		gbc_lblJobTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblJobTitle.gridx = 0;
		gbc_lblJobTitle.gridy = 0;
		panel_JobDescription.add(lblJobTitle, gbc_lblJobTitle);
		
		JTextField textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_JobDescription.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblCity = new JLabel("Ville");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 4;
		gbc_lblCity.gridy = 0;
		panel_JobDescription.add(lblCity, gbc_lblCity);
		
		JTextField textField_1 = new JTextField();
		textField_1.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 0;
		panel_JobDescription.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblContractType = new JLabel("Contract type");
		GridBagConstraints gbc_lblContractType = new GridBagConstraints();
		gbc_lblContractType.insets = new Insets(0, 0, 5, 5);
		gbc_lblContractType.gridx = 0;
		gbc_lblContractType.gridy = 1;
		panel_JobDescription.add(lblContractType, gbc_lblContractType);
		
		JTextField textField_2 = new JTextField();
		textField_2.setEditable(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 1;
		panel_JobDescription.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblJobDescription = new JLabel("Description du poste");
		GridBagConstraints gbc_lblJobDescription = new GridBagConstraints();
		gbc_lblJobDescription.gridwidth = 6;
		gbc_lblJobDescription.insets = new Insets(0, 0, 5, 0);
		gbc_lblJobDescription.gridx = 0;
		gbc_lblJobDescription.gridy = 2;
		panel_JobDescription.add(lblJobDescription, gbc_lblJobDescription);
		
		JTextArea textArea_JobDescription = new JTextArea();
		textArea_JobDescription.setEditable(false);
		GridBagConstraints gbc_textArea_JobDescription = new GridBagConstraints();
		gbc_textArea_JobDescription.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_JobDescription.gridwidth = 6;
		gbc_textArea_JobDescription.fill = GridBagConstraints.BOTH;
		gbc_textArea_JobDescription.gridx = 0;
		gbc_textArea_JobDescription.gridy = 3;
		panel_JobDescription.add(textArea_JobDescription, gbc_textArea_JobDescription);
		
		JLabel lblCompetencesRequises = new JLabel("Competences requises");
		GridBagConstraints gbc_lblCompetencesRequises = new GridBagConstraints();
		gbc_lblCompetencesRequises.gridwidth = 6;
		gbc_lblCompetencesRequises.insets = new Insets(0, 0, 5, 0);
		gbc_lblCompetencesRequises.gridx = 0;
		gbc_lblCompetencesRequises.gridy = 4;
		panel_JobDescription.add(lblCompetencesRequises, gbc_lblCompetencesRequises);
		
		JList list_SkillRequired = new JList();
		GridBagConstraints gbc_list_SkillRequired = new GridBagConstraints();
		gbc_list_SkillRequired.gridwidth = 6;
		gbc_list_SkillRequired.insets = new Insets(0, 0, 0, 5);
		gbc_list_SkillRequired.fill = GridBagConstraints.BOTH;
		gbc_list_SkillRequired.gridx = 0;
		gbc_list_SkillRequired.gridy = 5;
		panel_JobDescription.add(list_SkillRequired, gbc_list_SkillRequired);
	}

}
