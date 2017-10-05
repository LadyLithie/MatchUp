package fr.lithie.matchup.views;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;

import fr.lithie.matchup.views.base.BaseView;
import fr.lithie.matchup.views.panels.PanelField;

import java.awt.Insets;


public class RegisterView extends BaseView {
	private ButtonGroup typeGroup;
	private JRadioButton rdbtnCandidat;
	private JRadioButton rdbtnEntreprise;
	private JRadioButton rdbtnRecruteur;
	private PanelField login;
	private JPasswordField pwdField;
	private JPasswordField pwdVerifField;
	private PanelField email;
	private JButton btnValider;
	private JButton btnAnnuler;

	/**
	 * @return the typeGroup
	 */
	public ButtonGroup getTypeGroup() {
		return typeGroup;
	}
	/**
	 * @return the rdbtnCandidat
	 */
	public JRadioButton getRdbtnCandidat() {
		return rdbtnCandidat;
	}
	/**
	 * @return the rdbtnEntreprise
	 */
	public JRadioButton getRdbtnEntreprise() {
		return rdbtnEntreprise;
	}
	/**
	 * @return the rdbtnRecruteur
	 */
	public JRadioButton getRdbtnRecruteur() {
		return rdbtnRecruteur;
	}
	/**
	 * @return the login
	 */
	public PanelField getLogin() {
		return login;
	}
	/**
	 * @return the pwdField
	 */
	public JPasswordField getPwdField() {
		return pwdField;
	}
	/**
	 * @return the pwdVerifField
	 */
	public JPasswordField getPwdVerifField() {
		return pwdVerifField;
	}
	/**
	 * @return the email
	 */
	public PanelField getEmail() {
		return email;
	}
	/**
	 * @return the btnValider
	 */
	public JButton getBtnValider() {
		return btnValider;
	}
	/**
	 * @return the btnAnnuler
	 */
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
	
	/**
	 * Create the frame.
	 * 
	 * @param frame
	 */
	public RegisterView(JFrame frame) {
		super();
		super.pageName = "Register";
		JPanel panel = new JPanel();
		super.panel = panel;

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 5, 0, 5, 0 };
		gbl_panel.rowHeights = new int[] { 0, 5, 0, 0, 5, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);

		// Zone type of user profile
		JPanel panel_type = new JPanel();
		GridBagConstraints gbc_panel_type = new GridBagConstraints();
		gbc_panel_type.insets = new Insets(0, 0, 5, 5);
		gbc_panel_type.fill = GridBagConstraints.BOTH;
		gbc_panel_type.gridx = 1;
		gbc_panel_type.gridy = 1;
		panel.add(panel_type, gbc_panel_type);
		GridBagLayout gbl_panel_type = new GridBagLayout();
		gbl_panel_type.columnWidths = new int[] { 118, 54, 0 };
		gbl_panel_type.rowHeights = new int[] { 14, 0, 0, 0, 0 };
		gbl_panel_type.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_type.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_type.setLayout(gbl_panel_type);

		JLabel lblType = new JLabel("Vous \u00EAtes :");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 0);
		gbc_lblType.gridx = 1;
		gbc_lblType.gridy = 0;
		panel_type.add(lblType, gbc_lblType);
		
		typeGroup = new ButtonGroup();
		rdbtnCandidat = new JRadioButton("Candidat");

		GridBagConstraints gbc_rdbtnCandidat = new GridBagConstraints();
		gbc_rdbtnCandidat.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnCandidat.gridx = 1;
		gbc_rdbtnCandidat.gridy = 1;
		panel_type.add(rdbtnCandidat, gbc_rdbtnCandidat);
		typeGroup.add(rdbtnCandidat);
		rdbtnEntreprise = new JRadioButton("Entreprise");
		GridBagConstraints gbc_rdbtnEntreprise = new GridBagConstraints();
		gbc_rdbtnEntreprise.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnEntreprise.gridx = 1;
		gbc_rdbtnEntreprise.gridy = 2;
		panel_type.add(rdbtnEntreprise, gbc_rdbtnEntreprise);
		typeGroup.add(rdbtnEntreprise);
		rdbtnRecruteur = new JRadioButton("Recruteur");
		GridBagConstraints gbc_rdbtnRecruteur = new GridBagConstraints();
		gbc_rdbtnRecruteur.gridx = 1;
		gbc_rdbtnRecruteur.gridy = 3;
		panel_type.add(rdbtnRecruteur, gbc_rdbtnRecruteur);
		typeGroup.add(rdbtnRecruteur);

		// Zone Login
		login = new PanelField("Login");
		GridBagLayout gridBagLayout = (GridBagLayout) login.getLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		GridBagConstraints gbc_login = new GridBagConstraints();
		gbc_login.insets = new Insets(0, 0, 5, 5);
		gbc_login.gridx = 1;
		gbc_login.gridy = 2;
		login.getInput().setColumns(10);
		panel.add(login, gbc_login);

		// Zone Password
		JPanel panelPwd = new JPanel();
		GridBagConstraints gbc_panelPwd = new GridBagConstraints();
		gbc_panelPwd.insets = new Insets(0, 0, 5, 5);
		gbc_panelPwd.gridx = 1;
		gbc_panelPwd.gridy = 3;
		panel.add(panelPwd, gbc_panelPwd);
		GridBagLayout gbl_panelPwd = new GridBagLayout();
		gbl_panelPwd.columnWidths = new int[] { 1, 0, 1, 0, 1, 0 };
		gbl_panelPwd.rowHeights = new int[] { 0, 0 };
		gbl_panelPwd.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelPwd.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelPwd.setLayout(gbl_panelPwd);
		JLabel pwdlabel = new JLabel("Mot de passe: ");
		GridBagConstraints gbc_pwdlabel = new GridBagConstraints();
		gbc_pwdlabel.anchor = GridBagConstraints.WEST;
		gbc_pwdlabel.insets = new Insets(0, 0, 0, 1);
		gbc_pwdlabel.gridx = 1;
		gbc_pwdlabel.gridy = 0;
		panelPwd.add(pwdlabel, gbc_pwdlabel);
		pwdField = new JPasswordField();
		GridBagConstraints gbc_pwdField = new GridBagConstraints();
		gbc_pwdField.fill = GridBagConstraints.HORIZONTAL;
		pwdField.setMinimumSize(new Dimension(50, 20));
		gbc_pwdField.insets = new Insets(0, 0, 0, 1);
		gbc_pwdField.gridx = 3;
		gbc_pwdField.gridy = 0;
		panelPwd.add(pwdField, gbc_pwdField);
		pwdField.setColumns(10);

		// Zone Password Verif
		JPanel panelPwdVerif = new JPanel();
		GridBagConstraints gbc_panelPwdVerif = new GridBagConstraints();
		gbc_panelPwdVerif.insets = new Insets(0, 0, 5, 5);
		gbc_panelPwdVerif.gridx = 1;
		gbc_panelPwdVerif.gridy = 4;
		panel.add(panelPwdVerif, gbc_panelPwdVerif);
		GridBagLayout gbl_panelPwdVerif = new GridBagLayout();
		gbl_panelPwdVerif.columnWidths = new int[] { 1, 0, 1, 0, 1, 0 };
		gbl_panelPwdVerif.rowHeights = new int[] { 0, 0 };
		gbl_panelPwdVerif.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelPwdVerif.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelPwdVerif.setLayout(gbl_panelPwdVerif);
		JLabel pwdlabelVerif = new JLabel("Mot de passe: ");
		GridBagConstraints gbc_pwdVeriflabel = new GridBagConstraints();
		gbc_pwdVeriflabel.anchor = GridBagConstraints.WEST;
		gbc_pwdVeriflabel.insets = new Insets(0, 0, 0, 1);
		gbc_pwdVeriflabel.gridx = 1;
		gbc_pwdVeriflabel.gridy = 0;
		panelPwdVerif.add(pwdlabelVerif, gbc_pwdVeriflabel);
		pwdVerifField = new JPasswordField();
		GridBagConstraints gbc_pwdVerifFieldField = new GridBagConstraints();
		gbc_pwdVerifFieldField.fill = GridBagConstraints.HORIZONTAL;
		pwdVerifField.setMinimumSize(new Dimension(50, 20));
		gbc_pwdVerifFieldField.insets = new Insets(0, 0, 0, 1);
		gbc_pwdVerifFieldField.gridx = 3;
		gbc_pwdVerifFieldField.gridy = 0;
		panelPwdVerif.add(pwdVerifField, gbc_pwdVerifFieldField);
		pwdVerifField.setColumns(10);

		// Zone Email
		email = new PanelField("Email");
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.insets = new Insets(0, 0, 5, 5);
		gbc_email.gridx = 1;
		gbc_email.gridy = 5;
		email.getInput().setColumns(10);
		panel.add(email, gbc_email);

		// Validation or Cancellation sections
		JPanel panelDecision = new JPanel();
		GridBagConstraints gbc_panelDecision = new GridBagConstraints();
		gbc_panelDecision.insets = new Insets(0, 0, 1, 5);
		gbc_panelDecision.gridx = 1;
		gbc_panelDecision.gridy = 7;
		panel.add(panelDecision, gbc_panelDecision);
		panelDecision.setLayout(new GridLayout(1, 0, 0, 0));
		btnAnnuler = new JButton("Annuler");
		panelDecision.add(btnAnnuler);
		btnValider = new JButton("Valider");
		panelDecision.add(btnValider);
	}

}
