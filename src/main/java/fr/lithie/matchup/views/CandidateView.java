package fr.lithie.matchup.views;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import fr.lithie.matchup.database.SkillDAO;
import fr.lithie.matchup.entities.Skill;
import fr.lithie.matchup.entities.base.BaseEntity;
import fr.lithie.matchup.views.base.BaseView;
import fr.lithie.matchup.views.usercontrols.MenuBar;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class CandidateView extends BaseView {
	private JTextField textFieldFirstname;
	private JTextField textFieldLastname;
	private JTextField textFieldMail;
	private JTextField textFieldPhone;
	private JLabel lblListeDeSkills;
	private JList<String> list;
	private JButton btnEdit;
	private JTextArea textArea;
	private JButton btnSelectSkill;
	private DefaultListModel<JCheckBox> listModel;
	private JTable table;
	private JButton btnAnnulerButton;
	private DefaultTableModel model ;
	private JLabel linkTwitter;
	private JLabel linkLinkedin;
	private JLabel linkViadeo;
	private String nameLinkLinkedin;
	private String nameLinkTwitter;
	private String nameLinkViadeo;
	private JButton btnEditLink;
	private MenuBar menuBar;
	

	public CandidateView(JFrame frame){
		super.pageName= "Candidate";
		JPanel contentPane = new JPanel();
		super.panel = contentPane;
		
		nameLinkLinkedin = "https://www.linkedin.com";
		nameLinkTwitter ="https://twitter.com/?lang=fr";
		nameLinkViadeo ="http://www.viadeo.com";
		
//		ViewsUtils.configureJFrame(frame,contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0,0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		menuBar = new MenuBar();
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		gbc_menuBar.gridwidth = 10;
		contentPane.add(menuBar.getContentPane(), gbc_menuBar);
		
		
		lblListeDeSkills = new JLabel("Liste de Skills");
		GridBagConstraints gbc_lblListeDeSkills = new GridBagConstraints();
		gbc_lblListeDeSkills.gridwidth = 2;
		gbc_lblListeDeSkills.anchor = GridBagConstraints.NORTH;
		gbc_lblListeDeSkills.insets = new Insets(0, 0, 5, 5);
		gbc_lblListeDeSkills.gridx = 1;
		gbc_lblListeDeSkills.gridy = 1;
		contentPane.add(lblListeDeSkills, gbc_lblListeDeSkills);
		
		
	
		model = new DefaultTableModel(null, new String [] {"CheckMe", "Compétences"}) {
            /**
			 * 
			 */
			private static final long serialVersionUID = -6608977305023118577L;

			public Class<?> getColumnClass(int c) {
              switch (c) {
                case 0: return Boolean.class;
                default: return String.class;
              }   
            } };	
		
		table = new JTable(model);
		
		SkillDAO skillDAO = new SkillDAO();
		
		for (BaseEntity entity : skillDAO.get()) {
			 Skill skill = (Skill) entity;
			 model.addRow(new Object [] {false,skill.getName()});
		}	
		
		table.setEnabled(false);
		
		JScrollPane scroll = new JScrollPane(table);
		Dimension preferredSize = new Dimension(10, 100);
		scroll.setPreferredSize(preferredSize );
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.gridheight = 14;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 2;
		contentPane.add(scroll, gbc_table);
		
		JLabel lblNewLabelFirstname = new JLabel("Prenom");
		GridBagConstraints gbc_lblNewLabelFirstname = new GridBagConstraints();
		gbc_lblNewLabelFirstname.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabelFirstname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelFirstname.gridx = 4;
		gbc_lblNewLabelFirstname.gridy = 2;
		contentPane.add(lblNewLabelFirstname, gbc_lblNewLabelFirstname);
		
		textFieldFirstname = new JTextField();
		GridBagConstraints gbc_textField_firstname = new GridBagConstraints();
		gbc_textField_firstname.gridwidth = 2;
		gbc_textField_firstname.weightx = 1.0;
		gbc_textField_firstname.fill = GridBagConstraints.BOTH;
		gbc_textField_firstname.insets = new Insets(0, 0, 5, 5);
		gbc_textField_firstname.gridx = 5;
		gbc_textField_firstname.gridy = 2;
		contentPane.add(textFieldFirstname, gbc_textField_firstname);
		textFieldFirstname.setColumns(10);
		textFieldFirstname.setEditable(false);
		
		JLabel lblNewLabelLastname = new JLabel("Nom");
		GridBagConstraints gbc_lblNewLabelLastname = new GridBagConstraints();
		gbc_lblNewLabelLastname.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabelLastname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelLastname.gridx = 4;
		gbc_lblNewLabelLastname.gridy = 3;
		contentPane.add(lblNewLabelLastname, gbc_lblNewLabelLastname);
		
		textFieldLastname = new JTextField();
		GridBagConstraints gbc_textField_Lastname = new GridBagConstraints();
		gbc_textField_Lastname.gridwidth = 2;
		gbc_textField_Lastname.weightx = 1.0;
		gbc_textField_Lastname.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Lastname.fill = GridBagConstraints.BOTH;
		gbc_textField_Lastname.gridx = 5;
		gbc_textField_Lastname.gridy = 3;
		contentPane.add(textFieldLastname, gbc_textField_Lastname);
		textFieldLastname.setColumns(10);
		textFieldLastname.setEditable(false);
		
		JLabel lblNewLabelMail = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabelMail = new GridBagConstraints();
		gbc_lblNewLabelMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabelMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelMail.gridx = 4;
		gbc_lblNewLabelMail.gridy = 4;
		contentPane.add(lblNewLabelMail, gbc_lblNewLabelMail);
		
		textFieldMail = new JTextField();
		GridBagConstraints gbc_textFieldMail = new GridBagConstraints();
		gbc_textFieldMail.gridwidth = 2;
		gbc_textFieldMail.weightx = 1.0;
		gbc_textFieldMail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMail.gridx = 5;
		gbc_textFieldMail.gridy = 4;
		contentPane.add(textFieldMail, gbc_textFieldMail);
		textFieldMail.setColumns(10);
		textFieldMail.setEditable(false);
		
		JLabel lblNewLabelPhone = new JLabel("T\u00E9l\u00E9phone\r\n");
		GridBagConstraints gbc_lblNewLabelPhone = new GridBagConstraints();
		gbc_lblNewLabelPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabelPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelPhone.gridx = 4;
		gbc_lblNewLabelPhone.gridy = 5;
		contentPane.add(lblNewLabelPhone, gbc_lblNewLabelPhone);
		
		textFieldPhone = new JTextField();
		GridBagConstraints gbc_textFieldPhone = new GridBagConstraints();
		gbc_textFieldPhone.gridwidth = 2;
		gbc_textFieldPhone.weightx = 1.0;
		gbc_textFieldPhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPhone.gridx = 5;
		gbc_textFieldPhone.gridy = 5;
		contentPane.add(textFieldPhone, gbc_textFieldPhone);
		textFieldPhone.setColumns(10);
		textFieldPhone.setEditable(false);
		
		btnEditLink = new JButton("Edit");
		GridBagConstraints gbc_btnEditLink = new GridBagConstraints();
		gbc_btnEditLink.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditLink.gridx = 12;
		gbc_btnEditLink.gridy = 5;
		contentPane.add(btnEditLink, gbc_btnEditLink);
		
		textArea = new JTextArea("Présentation du profil");
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 9;
		gbc_textArea.gridheight = 3;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 4;
		gbc_textArea.gridy = 7;
		contentPane.add(textArea, gbc_textArea);
		textArea.setEditable(false);
		
		btnEdit = new JButton("Edit");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.BOTH;
		gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnEdit.gridx = 6;
		gbc_btnEdit.gridy = 10;
		contentPane.add(btnEdit, gbc_btnEdit);
		
//		JLabel lblTitle = new JLabel("Title");
//		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
//		gbc_lblTitle.gridwidth = 7;
//		gbc_lblTitle.fill = GridBagConstraints.VERTICAL;
//		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
//		gbc_lblTitle.gridx = 4;
//		gbc_lblTitle.gridy = 12;
//		contentPane.add(lblTitle, gbc_lblTitle);
//		
//		JButton btnButton = new JButton("button");
//		GridBagConstraints gbc_btnButton = new GridBagConstraints();
//		gbc_btnButton.gridwidth = 2;
//		gbc_btnButton.fill = GridBagConstraints.BOTH;
//		gbc_btnButton.insets = new Insets(0, 0, 5, 5);
//		gbc_btnButton.gridx = 9;
//		gbc_btnButton.gridy = 13;
//		contentPane.add(btnButton, gbc_btnButton);
//		
//		JLabel lblOption_1 = new JLabel("Option 1");
//		GridBagConstraints gbc_lblOption_1 = new GridBagConstraints();
//		gbc_lblOption_1.insets = new Insets(0, 0, 5, 5);
//		gbc_lblOption_1.gridx = 4;
//		gbc_lblOption_1.gridy = 14;
//		contentPane.add(lblOption_1, gbc_lblOption_1);
//		
//		JList list_1 = new JList();
//		GridBagConstraints gbc_list_1 = new GridBagConstraints();
//		gbc_list_1.gridwidth = 2;
//		gbc_list_1.gridheight = 3;
//		gbc_list_1.insets = new Insets(0, 0, 0, 5);
//		gbc_list_1.fill = GridBagConstraints.BOTH;
//		gbc_list_1.gridx = 5;
//		gbc_list_1.gridy = 14;
//		contentPane.add(list_1, gbc_list_1);
//		
//		JList list_2 = new JList();
//		GridBagConstraints gbc_list_2 = new GridBagConstraints();
//		gbc_list_2.insets = new Insets(0, 0, 0, 5);
//		gbc_list_2.gridheight = 3;
//		gbc_list_2.gridwidth = 4;
//		gbc_list_2.fill = GridBagConstraints.BOTH;
//		gbc_list_2.gridx = 7;
//		gbc_list_2.gridy = 14;
//		contentPane.add(list_2, gbc_list_2);
//		
//		JLabel lblOption_2 = new JLabel("Option 2");
//		GridBagConstraints gbc_lblOption_2 = new GridBagConstraints();
//		gbc_lblOption_2.anchor = GridBagConstraints.NORTH;
//		gbc_lblOption_2.insets = new Insets(0, 0, 5, 5);
//		gbc_lblOption_2.gridx = 4;
//		gbc_lblOption_2.gridy = 15;
//		contentPane.add(lblOption_2, gbc_lblOption_2);
		
		btnSelectSkill = new JButton("Sélectionner Skill");
		Dimension preferredSize1 = new Dimension(180, 25);
		btnSelectSkill.setPreferredSize(preferredSize1);
		GridBagConstraints gbc_btnSelectSkill = new GridBagConstraints();
		gbc_btnSelectSkill.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelectSkill.gridx = 1;
		gbc_btnSelectSkill.gridy = 16;
		contentPane.add(btnSelectSkill, gbc_btnSelectSkill);
		
		btnAnnulerButton = new JButton("Annuler");
		btnAnnulerButton.setEnabled(false);
		GridBagConstraints gbc_btnAnnulerButton = new GridBagConstraints();
		gbc_btnAnnulerButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnulerButton.gridx = 2;
		gbc_btnAnnulerButton.gridy = 16;
		contentPane.add(btnAnnulerButton, gbc_btnAnnulerButton);
		
		ImageIcon image = new ImageIcon("image\\linkedin-icon2.png");
		linkLinkedin = new JLabel();
		linkLinkedin.setIcon(image);
		GridBagConstraints gbc_linkLinkedin = new GridBagConstraints();
		gbc_linkLinkedin.insets = new Insets(0, 0, 5, 5);
		gbc_linkLinkedin.gridx = 9;
		gbc_linkLinkedin.gridy = 5;
		contentPane.add(linkLinkedin,gbc_linkLinkedin);
		
		ImageIcon image2 = new ImageIcon("image/Twitterbird2.png");
		linkTwitter = new JLabel();
		linkTwitter.setIcon(image2);
		GridBagConstraints gbc_linkTwitter = new GridBagConstraints();
		gbc_linkTwitter.insets = new Insets(0, 0, 5, 5);
		gbc_linkTwitter.gridx = 10;
		gbc_linkTwitter.gridy = 5;
		contentPane.add(linkTwitter,gbc_linkTwitter);
		
		ImageIcon image3 = new ImageIcon("image/viadeo.png");
		linkViadeo = new JLabel();
		linkViadeo.setIcon(image3);
		GridBagConstraints gbc_linkViadeo = new GridBagConstraints();
		gbc_linkViadeo.insets = new Insets(0, 0, 5, 5);
		gbc_linkViadeo.gridx = 11;
		gbc_linkViadeo.gridy = 5;
		contentPane.add(linkViadeo,gbc_linkViadeo);
		
		
	}


	/**
	 * @return the linkTwitter
	 */
	public JLabel getLinkTwitter() {
		return linkTwitter;
	}


	/**
	 * @param linkTwitter the linkTwitter to set
	 */
	public void setLinkTwitter(JLabel linkTwitter) {
		this.linkTwitter = linkTwitter;
	}


	/**
	 * @return the linkLinkedin
	 */
	public JLabel getLinkLinkedin() {
		return linkLinkedin;
	}


	/**
	 * @param linkLinkedin the linkLinkedin to set
	 */
	public void setLinkLinkedin(JLabel linkLinkedin) {
		this.linkLinkedin = linkLinkedin;
	}


	/**
	 * @return the linkViadeo
	 */
	public JLabel getLinkViadeo() {
		return linkViadeo;
	}


	/**
	 * @param linkViadeo the linkViadeo to set
	 */
	public void setLinkViadeo(JLabel linkViadeo) {
		this.linkViadeo = linkViadeo;
	}


	/**
	 * @return the textFieldFirstname
	 */
	public JTextField getTextFieldFirstname() {
		return textFieldFirstname;
	}


	/**
	 * @return the textFieldLastname
	 */
	public JTextField getTextFieldLastname() {
		return textFieldLastname;
	}


	/**
	 * @return the textFieldMail
	 */
	public JTextField getTextFieldMail() {
		return textFieldMail;
	}


	/**
	 * @return the textFieldPhone
	 */
	public JTextField getTextFieldPhone() {
		return textFieldPhone;
	}


	/**
	 * @return the lblListeDeSkills
	 */
	public JLabel getLblListeDeSkills() {
		return lblListeDeSkills;
	}


	/**
	 * @return the list
	 */
	public JList<String> getList() {
		return list;
	}


	/**
	 * @return the btnEdit
	 */
	public JButton getBtnEdit() {
		return btnEdit;
	}


	/**
	 * @return the textArea
	 */
	public JTextArea getTextArea() {
		return textArea;
	}


	/**
	 * @return the btnSelectSkill
	 */
	public JButton getBtnSelectSkill() {
		return btnSelectSkill;
	}


	/**
	 * @return the listModel
	 */
	public DefaultListModel<JCheckBox> getListModel() {
		return listModel;
	}


	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}


	/**
	 * @return the btnAnnulerButton
	 */
	public JButton getBtnAnnulerButton() {
		return btnAnnulerButton;
	}


	/**
	 * @return the model
	 */
	public DefaultTableModel getModel() {
		return model;
	}


	/**
	 * @return the nameLinkLinkedin
	 */
	public String getNameLinkLinkedin() {
		return nameLinkLinkedin;
	}


	/**
	 * @return the nameLinkTwitter
	 */
	public String getNameLinkTwitter() {
		return nameLinkTwitter;
	}


	/**
	 * @return the nameLinkViadeo
	 */
	public String getNameLinkViadeo() {
		return nameLinkViadeo;
	}


	/**
	 * @return the btnEditLink
	 */
	public JButton getBtnEditLink() {
		return btnEditLink;
	}


	/**
	 * @return the menuBar
	 */
	public MenuBar getMenuBar() {
		return menuBar;
	}


	/**
	 * @param nameLinkLinkedin the nameLinkLinkedin to set
	 */
	public void setNameLinkLinkedin(String nameLinkLinkedin) {
		this.nameLinkLinkedin = nameLinkLinkedin;
	}


	/**
	 * @param nameLinkTwitter the nameLinkTwitter to set
	 */
	public void setNameLinkTwitter(String nameLinkTwitter) {
		this.nameLinkTwitter = nameLinkTwitter;
	}


	/**
	 * @param nameLinkViadeo the nameLinkViadeo to set
	 */
	public void setNameLinkViadeo(String nameLinkViadeo) {
		this.nameLinkViadeo = nameLinkViadeo;
	}
	
	

}
