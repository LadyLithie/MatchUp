package fr.lithie.matchup.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import fr.lithie.matchup.views.base.BaseView;
import fr.lithie.matchup.views.panels.PanelAdminSkill;
import fr.lithie.matchup.views.panels.PanelAdminUser;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * @author Yannick, Audrey
 *
 */
public class AdministratorView extends BaseView {
	// panel user presentation
	private JTextField textField_AdminPhone;
	private JTextField textField_AdminEmail;
	private JLabel lblPhoto;
	private JTextField textField_AdminLastName;
	private JButton btnAnnuler;
	private JButton btnEditer;
	private JTextField textField_adminFirstName;
	// panel skills
	private JButton btnAdd;
	private ArrayList<PanelAdminSkill> skills;
	// panel users
	private ArrayList<PanelAdminUser> users;
	private JPanel panelListUsers;
	private JPanel listSkills;

	// begin getters for panel user presentation
	/**
	 * @return the textField_AdminPhone
	 */
	public JTextField getTextField_AdminPhone() {
		return textField_AdminPhone;
	}

	/**
	 * @return the textField_AdminEmail
	 */
	public JTextField getTextField_AdminEmail() {
		return textField_AdminEmail;
	}

	/**
	 * @return the textField_AdminLastName
	 */
	public JTextField getTextField_AdminLastName() {
		return textField_AdminLastName;
	}

	/**
	 * @return the textField_adminFirstName
	 */
	public JTextField getTextField_adminFirstName() {
		return textField_adminFirstName;
	}

	/**
	 * @return the lblPhoto
	 */
	public JLabel getLblPhoto() {
		return lblPhoto;
	}

	/**
	 * @return the btnEdider
	 */
	public JButton getBtnEditer() {
		return btnEditer;
	}

	/**
	 * @return the btnAnnuler
	 */
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	/**
	 * @return the skills
	 */
	public ArrayList<PanelAdminSkill> getSkills() {
		return skills;
	}
	// end getters for panel user presentation

	// begin getters for Skills manager
	/**
	 * @return the btnAdd
	 */
	public JButton getBtnAdd() {
		return btnAdd;
	}

	/**
	 * @return the users
	 */
	public ArrayList<PanelAdminUser> getUsers() {
		return users;
	}
	// End getters for users manager

	/**
	 * @return the panelListUsers
	 */
	public JPanel getPanelListUsers() {
		return panelListUsers;
	}

	/**
	 * @return the listSkills
	 */
	public JPanel getListSkills() {
		return listSkills;
	}

	/**
	 * Create the panel.
	 */
	public AdministratorView(JFrame frame) {
		super();
		super.pageName = "Administrator";
		JPanel panel = new JPanel();
		super.panel = panel;

		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWidths = new int[]{261, 506};
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[] { 2, 1};
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0 };
		panel.setLayout(gbl_contentPane);

		/*
		 * Panel left : Users manager
		 */
		JPanel panelUser = new JPanel();
		panelUser.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panelUser = new GridBagConstraints();
		gbc_panelUser.anchor = GridBagConstraints.NORTH;
		gbc_panelUser.gridheight = 2;
		gbc_panelUser.insets = new Insets(0, 0, 5, 5);
		gbc_panelUser.fill = GridBagConstraints.BOTH;
		gbc_panelUser.gridx = 0;
		gbc_panelUser.gridy = 0;
		panel.add(panelUser, gbc_panelUser);
		GridBagLayout gbl_panelUser = new GridBagLayout();
		gbl_panelUser.columnWeights = new double[] { 1.0 };
		gbl_panelUser.rowWeights = new double[] { 0.0, 0.0, 1.0 };
		panelUser.setLayout(gbl_panelUser);
		// title
		JLabel lblUser = new JLabel("User");
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.insets = new Insets(0, 0, 5, 0);
		gbc_lblUser.gridx = 0;
		gbc_lblUser.gridy = 0;
		panelUser.add(lblUser, gbc_lblUser);
		// columns titles
		JPanel titleListUser = new JPanel();
//		GridBagConstraints gbc_titleListUser = new GridBagConstraints();
//		gbc_titleListUser.insets = new Insets(0, 0, 5, 5);
//		gbc_titleListUser.fill = GridBagConstraints.HORIZONTAL;
//		gbc_titleListUser.gridx = 0;
//		gbc_titleListUser.gridy = 1;
//		panelUser.add(titleListUser, gbc_titleListUser);
		titleListUser.setLayout(new GridLayout(1, 6, 0, 0));
		JLabel label = new JLabel("Name");
		titleListUser.add(label);
		JLabel lblEmail = new JLabel("E-mail");
		titleListUser.add(lblEmail);
		JLabel lblType = new JLabel("Type");
		titleListUser.add(lblType);
//		JLabel lblCreationDate = new JLabel("Creation Date");
//		titleListUser.add(lblCreationDate);
		JLabel label_1 = new JLabel("");
		titleListUser.add(label_1);
		JLabel label_2 = new JLabel("");
		titleListUser.add(label_2);
		JLabel label_3 = new JLabel("");
		titleListUser.add(label_3);
		// Scrollpane for the listing
		JScrollPane scrollPaneUser = new JScrollPane();
		GridBagConstraints gbc_scrollPaneUser = new GridBagConstraints();
		gbc_scrollPaneUser.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneUser.gridwidth = GridBagConstraints.REMAINDER;
		gbc_scrollPaneUser.gridx = 0;
		gbc_scrollPaneUser.gridy = 2;
		panelUser.add(scrollPaneUser, gbc_scrollPaneUser);
		scrollPaneUser.setColumnHeaderView(titleListUser);
		
			// Listing all users
		users = new ArrayList<PanelAdminUser>();
		panelListUsers = new JPanel();
		scrollPaneUser.setViewportView(panelListUsers);
		panelListUsers.setLayout(new GridLayout(0, 1));

		/*
		 * Panel topRight : User presentation
		 */
		JPanel panelAdminPresentation = new JPanel();
		panelAdminPresentation.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panelAdminPresentation = new GridBagConstraints();
		gbc_panelAdminPresentation.insets = new Insets(0, 0, 5, 0);
		gbc_panelAdminPresentation.fill = GridBagConstraints.BOTH;
		gbc_panelAdminPresentation.gridx = 1;
		gbc_panelAdminPresentation.gridy = 0;
		panel.add(panelAdminPresentation, gbc_panelAdminPresentation);
		GridBagLayout gbl_panelAdminPresentation = new GridBagLayout();
//		gbl_panelAdminPresentation.columnWidths = new int[] { 45, 45, 100, 77, 100 };
//		gbl_panelAdminPresentation.rowHeights = new int[] { 30, 30, 30, 30, 30 };
		gbl_panelAdminPresentation.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0 };
		gbl_panelAdminPresentation.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panelAdminPresentation.setLayout(gbl_panelAdminPresentation);

		lblPhoto = new JLabel("");
		lblPhoto.setIcon(new ImageIcon("image/GenericAvatar.png"));
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.gridheight = 3;
		gbc_lblPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoto.gridx = 1;
		gbc_lblPhoto.gridy = 0;
		panelAdminPresentation.add(lblPhoto, gbc_lblPhoto);

		JLabel lblNameAdmin = new JLabel("Name");
		GridBagConstraints gbc_lblNameAdmin = new GridBagConstraints();
		gbc_lblNameAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblNameAdmin.gridx = 2;
		gbc_lblNameAdmin.gridy = 0;
		panelAdminPresentation.add(lblNameAdmin, gbc_lblNameAdmin);

		JPanel panel_name = new JPanel();
		GridBagConstraints gbc_panel_name = new GridBagConstraints();
		gbc_panel_name.gridwidth = 2;
		gbc_panel_name.insets = new Insets(0, 0, 5, 0);
		gbc_panel_name.fill = GridBagConstraints.BOTH;
		gbc_panel_name.gridx = 3;
		gbc_panel_name.gridy = 0;
		panelAdminPresentation.add(panel_name, gbc_panel_name);
		panel_name.setLayout(new GridLayout(0, 2, 0, 0));

		textField_adminFirstName = new JTextField();
		panel_name.add(textField_adminFirstName);
		textField_adminFirstName.setEditable(false);
		textField_adminFirstName.setColumns(10);

		textField_AdminLastName = new JTextField();
		panel_name.add(textField_AdminLastName);
		textField_AdminLastName.setEditable(false);
		textField_AdminLastName.setColumns(10);

		JLabel lblEmailAdmin = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmailAdmin = new GridBagConstraints();
		gbc_lblEmailAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailAdmin.gridx = 2;
		gbc_lblEmailAdmin.gridy = 1;
		panelAdminPresentation.add(lblEmailAdmin, gbc_lblEmailAdmin);

		textField_AdminEmail = new JTextField();
		textField_AdminEmail.setEditable(false);
		GridBagConstraints gbc_textField_AdminEmail = new GridBagConstraints();
		gbc_textField_AdminEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_AdminEmail.gridwidth = 2;
		gbc_textField_AdminEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textField_AdminEmail.gridx = 3;
		gbc_textField_AdminEmail.gridy = 1;
		panelAdminPresentation.add(textField_AdminEmail, gbc_textField_AdminEmail);
		textField_AdminEmail.setColumns(10);

		JLabel lblPhoneAdmin = new JLabel("Phone");
		GridBagConstraints gbc_lblPhoneAdmin = new GridBagConstraints();
		gbc_lblPhoneAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneAdmin.gridx = 2;
		gbc_lblPhoneAdmin.gridy = 2;
		panelAdminPresentation.add(lblPhoneAdmin, gbc_lblPhoneAdmin);

		textField_AdminPhone = new JTextField();
		textField_AdminPhone.setEditable(false);
		GridBagConstraints gbc_textField_AdminPhone = new GridBagConstraints();
		gbc_textField_AdminPhone.gridwidth = 2;
		gbc_textField_AdminPhone.insets = new Insets(0, 0, 5, 0);
		gbc_textField_AdminPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_AdminPhone.gridx = 3;
		gbc_textField_AdminPhone.gridy = 2;
		panelAdminPresentation.add(textField_AdminPhone, gbc_textField_AdminPhone);
		textField_AdminPhone.setColumns(10);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setVisible(false);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnuler.gridx = 1;
		gbc_btnAnnuler.gridy = 4;
		panelAdminPresentation.add(btnAnnuler, gbc_btnAnnuler);

		btnEditer = new JButton("Editer");
		btnEditer.setVisible(true);
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 0, 5);
		gbc_btnValider.gridx = 2;
		gbc_btnValider.gridy = 4;
		panelAdminPresentation.add(btnEditer, gbc_btnValider);

		/*
		 * panel bottomRight : skills management
		 */
		JPanel panelSkill = new JPanel();
		panelSkill.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panelSkill = new GridBagConstraints();
		gbc_panelSkill.fill = GridBagConstraints.BOTH;
		gbc_panelSkill.gridx = 1;
		gbc_panelSkill.gridy = 1;
		panel.add(panelSkill, gbc_panelSkill);
		GridBagLayout gbl_panelSkill = new GridBagLayout();
		gbl_panelSkill.columnWidths = new int[] { 0 };
		gbl_panelSkill.rowHeights = new int[] { 0, 1, 0, 0 };
		gbl_panelSkill.columnWeights = new double[] { 1.0 };
		gbl_panelSkill.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelSkill.setLayout(gbl_panelSkill);
		// Title
		JLabel lblSkills = new JLabel("Skills");
		GridBagConstraints gbc_lblSkills = new GridBagConstraints();
		gbc_lblSkills.insets = new Insets(0, 0, 5, 0);
		gbc_lblSkills.gridx = 0;
		gbc_lblSkills.gridy = 0;
		panelSkill.add(lblSkills, gbc_lblSkills);

		// Scrollpane column header
		JPanel titleList = new JPanel();
		titleList.setLayout(new GridLayout(0, 3, 0, 0));
		JLabel lblSkillName = new JLabel("Nom");
		lblSkillName.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSkillName = new GridBagConstraints();
		gbc_lblSkillName.insets = new Insets(0, 0, 5, 5);
		titleList.add(lblSkillName,gbc_lblSkillName);
		JLabel lblSkillType = new JLabel("Type");
		lblSkillType.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSkillType = new GridBagConstraints();
		gbc_lblSkillType.insets = new Insets(0, 0, 5, 0);
		titleList.add(lblSkillType,gbc_lblSkillType);
		btnAdd = new JButton("Ajout");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		titleList.add(btnAdd,gbc_btnAdd);

		// Listing of available skills
		skills = new ArrayList<PanelAdminSkill>();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panelSkill.add(scrollPane, gbc_scrollPane);
		scrollPane.setColumnHeaderView(titleList);

		listSkills = new JPanel();
		scrollPane.setViewportView(listSkills);
		listSkills.setLayout(new GridLayout(0, 1, 0, 0));


	}

}
