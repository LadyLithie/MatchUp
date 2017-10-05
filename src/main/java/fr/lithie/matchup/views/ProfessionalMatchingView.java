package fr.lithie.matchup.views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import fr.lithie.matchup.database.SkillDAO;
import fr.lithie.matchup.entities.Skill;
import fr.lithie.matchup.entities.base.BaseEntity;
import fr.lithie.matchup.views.base.BaseView;
import fr.lithie.matchup.views.panels.MatchedCandidate;
import fr.lithie.matchup.views.usercontrols.MenuBar;

public class ProfessionalMatchingView extends BaseView {
	
		private MenuBar menuBar;
		private JLabel lblPhoto;
		private JLabel lblPrenom;
		private JTextField textFieldFirstname;
		private JTextField textFieldPourcentageMatching;
		private JTextField textFieldLastname;
		private JTextField textFieldAge;
		private JTextField textFieldMail;
		private JList<String> list;
		private DefaultListModel<String> listModel ;
		

	public ProfessionalMatchingView(JFrame frame){
		
		super.pageName= "MatchingYou";
		JPanel contentPane = new JPanel();
		super.panel = contentPane;
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0,0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		menuBar = new MenuBar();
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		gbc_menuBar.gridwidth = GridBagConstraints.REMAINDER;
		contentPane.add(menuBar.getContentPane(), gbc_menuBar);
		
		lblPhoto = new JLabel("");
		lblPhoto.setIcon(new ImageIcon(MatchedCandidate.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoto.gridx = 1;
		gbc_lblPhoto.gridy = 1;
		contentPane.add(lblPhoto, gbc_lblPhoto);
		
		lblPrenom = new JLabel("Prenom");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 1;
		gbc_lblPrenom.gridy = 2;
		contentPane.add(lblPrenom, gbc_lblPrenom);
		
		textFieldFirstname = new JTextField();
		textFieldFirstname.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		contentPane.add(textFieldFirstname, gbc_textField);
		textFieldFirstname.setColumns(10);
		
		JLabel lblPourcentage = new JLabel("<html>Pourcentage<br>matching</html>");
		GridBagConstraints gbc_lblPourcentage = new GridBagConstraints();
		gbc_lblPourcentage.insets = new Insets(0, 0, 5, 5);
		gbc_lblPourcentage.gridx = 5;
		gbc_lblPourcentage.gridy = 2;
		contentPane.add(lblPourcentage, gbc_lblPourcentage);
		
		textFieldPourcentageMatching = new JTextField();
		textFieldPourcentageMatching.setEditable(false);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 6;
		gbc_textField_3.gridy = 2;
		contentPane.add(textFieldPourcentageMatching, gbc_textField_3);
		textFieldPourcentageMatching.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 3;
		contentPane.add(lblNom, gbc_lblNom);
		
		textFieldLastname = new JTextField();
		textFieldLastname.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		contentPane.add(textFieldLastname, gbc_textField_1);
		textFieldLastname.setColumns(10);
		
		JLabel lblPossessedSkills = new JLabel("<html>Compétences<br />possédées</html> ");
		GridBagConstraints gbc_lblPossessedSkills = new GridBagConstraints();
		gbc_lblPossessedSkills.gridwidth = 2;
		gbc_lblPossessedSkills.insets = new Insets(0, 0, 5, 5);
		gbc_lblPossessedSkills.gridx = 5;
		gbc_lblPossessedSkills.gridy = 3;
		contentPane.add(lblPossessedSkills, gbc_lblPossessedSkills);
		
		JLabel lblAge = new JLabel("Age");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 1;
		gbc_lblAge.gridy = 4;
		contentPane.add(lblAge, gbc_lblAge);
		
		textFieldAge = new JTextField();
		textFieldAge.setEditable(false);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 4;
		contentPane.add(textFieldAge, gbc_textField_4);
		textFieldAge.setColumns(10);
		
		list = new JList<String>();
		
		SkillDAO skillDAO = new SkillDAO();
		
		listModel = new DefaultListModel<String>();		
				
		for (BaseEntity entity : skillDAO.get()) {
			 Skill skill = (Skill) entity;
			 listModel.addElement(skill.getName()+"  ("+skill.getSkillType()+")");
		}		
		
		JScrollPane scroll = new JScrollPane(list);
		Dimension preferredSize = new Dimension(10, 100);
		scroll.setPreferredSize(preferredSize );
		
		list.setModel(listModel);
		scroll.setViewportView(list);
		
		list.setEnabled(false);
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.gridheight = 2;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 5;
		gbc_table.gridy = 4;
		contentPane.add(scroll, gbc_table);
		
		JLabel lblAdresseEmail = new JLabel("<html>Adresse<br>e-mail</html>");
		GridBagConstraints gbc_lblAdresseEmail = new GridBagConstraints();
		gbc_lblAdresseEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresseEmail.gridx = 1;
		gbc_lblAdresseEmail.gridy = 5;
		contentPane.add(lblAdresseEmail, gbc_lblAdresseEmail);
		
		textFieldMail = new JTextField();
		textFieldMail.setEditable(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 5;
		contentPane.add(textFieldMail, gbc_textField_2);
		textFieldMail.setColumns(10);

	}
	

	/**
	 * @return the menuBar
	 */
	public MenuBar getMenuBar() {
		return menuBar;
	}


	/**
	 * @return the lblPhoto
	 */
	public JLabel getLblPhoto() {
		return lblPhoto;
	}


	/**
	 * @param lblPhoto the lblPhoto to set
	 */
	public void setLblPhoto(JLabel lblPhoto) {
		this.lblPhoto = lblPhoto;
	}


	/**
	 * @return the lblPrenom
	 */
	public JLabel getLblPrenom() {
		return lblPrenom;
	}


	/**
	 * @param lblPrenom the lblPrenom to set
	 */
	public void setLblPrenom(JLabel lblPrenom) {
		this.lblPrenom = lblPrenom;
	}


	/**
	 * @return the textFieldFirstname
	 */
	public JTextField getTextFieldFirstname() {
		return textFieldFirstname;
	}


	/**
	 * @param textFieldFirstname the textFieldFirstname to set
	 */
	public void setTextFieldFirstname(JTextField textFieldFirstname) {
		this.textFieldFirstname = textFieldFirstname;
	}


	/**
	 * @return the textFieldPourcentageMatching
	 */
	public JTextField getTextFieldPourcentageMatching() {
		return textFieldPourcentageMatching;
	}


	/**
	 * @param textFieldPourcentageMatching the textFieldPourcentageMatching to set
	 */
	public void setTextFieldPourcentageMatching(JTextField textFieldPourcentageMatching) {
		this.textFieldPourcentageMatching = textFieldPourcentageMatching;
	}


	/**
	 * @return the textFieldLastname
	 */
	public JTextField getTextFieldLastname() {
		return textFieldLastname;
	}


	/**
	 * @param textFieldLastname the textFieldLastname to set
	 */
	public void setTextFieldLastname(JTextField textFieldLastname) {
		this.textFieldLastname = textFieldLastname;
	}


	/**
	 * @return the textFieldAge
	 */
	public JTextField getTextFieldAge() {
		return textFieldAge;
	}


	/**
	 * @param textFieldAge the textFieldAge to set
	 */
	public void setTextFieldAge(JTextField textFieldAge) {
		this.textFieldAge = textFieldAge;
	}


	/**
	 * @return the textFieldMail
	 */
	public JTextField getTextFieldMail() {
		return textFieldMail;
	}


	/**
	 * @param textFieldMail the textFieldMail to set
	 */
	public void setTextFieldMail(JTextField textFieldMail) {
		this.textFieldMail = textFieldMail;
	}


	/**
	 * @param menuBar the menuBar to set
	 */
	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}
	
}
