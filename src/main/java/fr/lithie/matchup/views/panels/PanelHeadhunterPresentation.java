package fr.lithie.matchup.views.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import fr.lithie.matchup.views.headhunter.HeadhunterView;

public class PanelHeadhunterPresentation extends JPanel {

	private JTextField textField_Firstname;
	private JTextField textField_Lastname;
	private JTextField textField_Linkedin;
	private JTextField textField_Email;
	private JTextField textField_Twitter;
	private JTextField textField_Phone;
	
	private JTextArea textArea_Presentation;
	
	private JButton btnEditPresentation;
	private JButton btnValider;
	private JButton btnAnnuler;
	
	
	/**
	 * @return the textField_Firstname
	 */
	public JTextField getTextField_Firstname() {
		return textField_Firstname;
	}


	/**
	 * @return the textField_Lastname
	 */
	public JTextField getTextField_Lastname() {
		return textField_Lastname;
	}


	/**
	 * @return the textField_Linkedin
	 */
	public JTextField getTextField_Linkedin() {
		return textField_Linkedin;
	}


	/**
	 * @return the textField_Email
	 */
	public JTextField getTextField_Email() {
		return textField_Email;
	}


	/**
	 * @return the textField_Twitter
	 */
	public JTextField getTextField_Twitter() {
		return textField_Twitter;
	}


	/**
	 * @return the textField_Phone
	 */
	public JTextField getTextField_Phone() {
		return textField_Phone;
	}


	/**
	 * @return the textArea_Presentation
	 */
	public JTextArea getTextArea_Presentation() {
		return textArea_Presentation;
	}


	/**
	 * @return the btnEditPresentation
	 */
	public JButton getBtnEditPresentation() {
		return btnEditPresentation;
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
	 * Create the panel.
	 */
	public PanelHeadhunterPresentation() {

		super();
		setBackground(Color.WHITE);
		
		GridBagLayout gbl_panel_HeadhunterPresentation = new GridBagLayout();
		gbl_panel_HeadhunterPresentation.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30};
		gbl_panel_HeadhunterPresentation.columnWidths = new int[] {45, 45, 45, 45, 45, 45};
		gbl_panel_HeadhunterPresentation.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_panel_HeadhunterPresentation.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		setLayout(gbl_panel_HeadhunterPresentation);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblFirstname = new JLabel("Fullname");
		GridBagConstraints gbc_lblFirstname = new GridBagConstraints();
		gbc_lblFirstname.fill = GridBagConstraints.VERTICAL;
		gbc_lblFirstname.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstname.gridx = 0;
		gbc_lblFirstname.gridy = 0;
		add(lblFirstname, gbc_lblFirstname);
		
		textField_Firstname = new JTextField();
		textField_Firstname.setEditable(false);
		textField_Firstname.setBackground(Color.white);
		GridBagConstraints gbc_textField_Firstname = new GridBagConstraints();
		gbc_textField_Firstname.fill = GridBagConstraints.BOTH;
		gbc_textField_Firstname.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Firstname.gridx = 1;
		gbc_textField_Firstname.gridy = 0;
		add(textField_Firstname, gbc_textField_Firstname);
		//textField_Firstname.setColumns(10);
		
		JLabel lblLinkedin = new JLabel("Linkedin");
		GridBagConstraints gbc_lblLinkedin = new GridBagConstraints();
		gbc_lblLinkedin.fill = GridBagConstraints.VERTICAL;
		gbc_lblLinkedin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinkedin.gridx = 2;
		gbc_lblLinkedin.gridy = 0;
		add(lblLinkedin, gbc_lblLinkedin);
		
		textField_Linkedin = new JTextField();
		textField_Linkedin.setBackground(Color.WHITE);
		textField_Linkedin.setEditable(false);
		GridBagConstraints gbc_textField_Linkedin = new GridBagConstraints();
		gbc_textField_Linkedin.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Linkedin.fill = GridBagConstraints.BOTH;
		gbc_textField_Linkedin.gridx = 3;
		gbc_textField_Linkedin.gridy = 0;
		add(textField_Linkedin, gbc_textField_Linkedin);
		//textField_Linkedin.setColumns(10);
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setIcon(new ImageIcon(HeadhunterView.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		lblPhoto.setBackground(Color.white);
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.gridheight = 3;
		gbc_lblPhoto.gridwidth = 2;
		gbc_lblPhoto.fill = GridBagConstraints.VERTICAL;
		gbc_lblPhoto.insets = new Insets(0, 0, 5, 0);
		gbc_lblPhoto.gridx = 4;
		gbc_lblPhoto.gridy = 0;
		add(lblPhoto, gbc_lblPhoto);
		
		JLabel lblLastname = new JLabel("Lastname");
		GridBagConstraints gbc_lblLastname = new GridBagConstraints();
		gbc_lblLastname.fill = GridBagConstraints.VERTICAL;
		gbc_lblLastname.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastname.gridx = 0;
		gbc_lblLastname.gridy = 1;
		add(lblLastname, gbc_lblLastname);
		
		textField_Lastname = new JTextField();
		textField_Lastname.setBackground(Color.WHITE);
		textField_Lastname.setEditable(false);
		GridBagConstraints gbc_textField_Lastname = new GridBagConstraints();
		gbc_textField_Lastname.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Lastname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Lastname.gridx = 1;
		gbc_textField_Lastname.gridy = 1;
		add(textField_Lastname, gbc_textField_Lastname);
		//textField_Lastname.setColumns(10);
		
		JLabel lblTwitter = new JLabel("Twitter");
		GridBagConstraints gbc_lblTwitter = new GridBagConstraints();
		gbc_lblTwitter.insets = new Insets(0, 0, 5, 5);
		gbc_lblTwitter.gridx = 2;
		gbc_lblTwitter.gridy = 1;
		add(lblTwitter, gbc_lblTwitter);
		
		textField_Twitter = new JTextField();
		textField_Twitter.setBackground(Color.WHITE);
		textField_Twitter.setEditable(false);
		GridBagConstraints gbc_textField_Twitter = new GridBagConstraints();
		gbc_textField_Twitter.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Twitter.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Twitter.gridx = 3;
		gbc_textField_Twitter.gridy = 1;
		add(textField_Twitter, gbc_textField_Twitter);
		textField_Twitter.setColumns(10);
		
		JLabel lblPhone = new JLabel("Telephone");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.fill = GridBagConstraints.VERTICAL;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 2;
		add(lblPhone, gbc_lblPhone);
		
		textField_Phone = new JTextField();
		textField_Phone.setEditable(false);
		textField_Phone.setBackground(Color.white);
		GridBagConstraints gbc_textField_Phone_1 = new GridBagConstraints();
		gbc_textField_Phone_1.fill = GridBagConstraints.BOTH;
		gbc_textField_Phone_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Phone_1.gridx = 1;
		gbc_textField_Phone_1.gridy = 2;
		add(textField_Phone, gbc_textField_Phone_1);
		//textField_Phone.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_Email = new JTextField();
		textField_Email.setEditable(false);
		textField_Email.setBackground(Color.white);
		GridBagConstraints gbc_textField_Email_1 = new GridBagConstraints();
		gbc_textField_Email_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Email_1.fill = GridBagConstraints.BOTH;
		gbc_textField_Email_1.gridx = 3;
		gbc_textField_Email_1.gridy = 2;
		add(textField_Email, gbc_textField_Email_1);
		//textField_Email.setColumns(10);
		
		JLabel lblPresentation = new JLabel("Presentation");
		GridBagConstraints gbc_lblPresentation = new GridBagConstraints();
		gbc_lblPresentation.gridwidth = 6;
		gbc_lblPresentation.insets = new Insets(0, 0, 5, 0);
		gbc_lblPresentation.gridx = 0;
		gbc_lblPresentation.gridy = 3;
		add(lblPresentation, gbc_lblPresentation);
		
		textArea_Presentation = new JTextArea();
		textArea_Presentation.setEditable(false);
		textArea_Presentation.setRows(4);
		textArea_Presentation.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_textArea_Presentation = new GridBagConstraints();
		gbc_textArea_Presentation.gridheight = 3;
		gbc_textArea_Presentation.gridwidth = 6;
		gbc_textArea_Presentation.insets = new Insets(5, 0, 5, 0);
		gbc_textArea_Presentation.fill = GridBagConstraints.BOTH;
		gbc_textArea_Presentation.gridx = 0;
		gbc_textArea_Presentation.gridy = 4;
		add(textArea_Presentation, gbc_textArea_Presentation);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setVisible(false);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.gridwidth = 2;
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 0;
		gbc_btnAnnuler.gridy = 7;
		add(btnAnnuler, gbc_btnAnnuler);
		
		btnEditPresentation = new JButton("Editer");
		btnEditPresentation.setVisible(true);
		btnEditPresentation.setEnabled(true);
		GridBagConstraints gbc_btnEditPresentation = new GridBagConstraints();
		gbc_btnEditPresentation.gridwidth = 2;
		gbc_btnEditPresentation.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditPresentation.gridx = 2;
		gbc_btnEditPresentation.gridy = 7;
		add(btnEditPresentation, gbc_btnEditPresentation);
		
		btnValider = new JButton("Valider");
		btnValider.setVisible(false);
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 5, 0);
		gbc_btnValider.gridwidth = 2;
		gbc_btnValider.gridx = 4;
		gbc_btnValider.gridy = 7;
		add(btnValider, gbc_btnValider);
	}

}
