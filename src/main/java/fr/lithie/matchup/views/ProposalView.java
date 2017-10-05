package fr.lithie.matchup.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

import fr.lithie.matchup.entities.ContractType;
import fr.lithie.matchup.entities.Location;
import fr.lithie.matchup.entities.RegisteredUser;
import fr.lithie.matchup.entities.Skill;
import fr.lithie.matchup.entities.base.BaseEntity;
import fr.lithie.matchup.views.base.BaseView;
import fr.lithie.matchup.views.base.IVisibility;

import javax.swing.JButton;
import javax.swing.JScrollPane;

/**
 * @author Audrey
 *
 */
public class ProposalView extends BaseView implements IVisibility {
	private JButton btnCancel;
	private JButton btnProposalCreation;
	// Zone options
	private JComboBox<RegisteredUser> comboBox_linkedUser;
	private JComboBox<ContractType> comboBox_contract;
	private JComboBox<Location> comboBox_location;
//	private JComboBox<City> comboBox_location;
	//Zone skills
	private ArrayList<JCheckBox> listSkills;
	// Zone description
	private JTextArea textArea;
	private JTextField textField_JobTitle;
	private JPanel panelCheckBox;
	private JLabel lblLink;

//	/**
//	 * @return the comboBox_location
//	 */
//	public JComboBox<City> getComboBox_location() {
//		return comboBox_location;
//	}

	/**
	 * @return the btnCancel
	 */
	public JButton getBtnCancel() {
		return btnCancel;
	}

	/**
	 * @return the btnProposalCreation
	 */
	public JButton getBtnProposalCreation() {
		return btnProposalCreation;
	}

	// Begin zone options
	/**
	 * @return the comboBox_linkedUser
	 */
	public JComboBox<RegisteredUser> getComboBox_linkedUser() {
		return comboBox_linkedUser;
	}

	/**
	 * @return the comboBox_contract
	 */
	public JComboBox<ContractType> getComboBox_contract() {
		return comboBox_contract;
	}

	/**
	 * @return the comboBox_location
	 */
	public JComboBox<Location> getComboBox_location() {
		return comboBox_location;
	}
	
	//Zone options end

	/**
	 * @return the listSkills
	 */
	public ArrayList<JCheckBox> getListSkills() {
		return listSkills;
	}

	// Zone description start
	/**
	 * @return the textArea
	 */
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * @return the textField_JobTitle
	 */
	public JTextField getTextField_JobTitle() {
		return textField_JobTitle;
	}
	// Zone description end

	/**
	 * @return the panelCheckBox
	 */
	public JPanel getPanelCheckBox() {
		return panelCheckBox;
	}

	/**
	 * @return the lblLink
	 */
	public JLabel getLblLink() {
		return lblLink;
	}

	/**
	 * Create the frame.
	 */
	public ProposalView(JFrame frame, List<BaseEntity> skills) {
		super();
		super.pageName = "Proposal";
		JPanel panel = new JPanel();
		super.panel = panel;
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {315, 315};
		gbl_contentPane.rowHeights = new int[] {250, 150, 20};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0};
		panel.setLayout(gbl_contentPane);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);

		/*
		 * Zone skills
		 */
		// List<Skill> possessSkills = job.getSkills();

		panelCheckBox = new JPanel();
		scrollPane.setViewportView(panelCheckBox);
		
		GridBagLayout gbl_panelCheckBox = new GridBagLayout();
		gbl_panelCheckBox.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panelCheckBox.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panelCheckBox.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelCheckBox.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelCheckBox.setLayout(gbl_panelCheckBox);

		listSkills = new ArrayList<JCheckBox>();
		int i = 0;
		for (BaseEntity skill : skills) {
			JCheckBox box = new JCheckBox(((Skill) skill).getName());
			listSkills.add(box);

			GridBagConstraints gbc_box = new GridBagConstraints();
			gbc_box.anchor = GridBagConstraints.WEST;
			gbc_box.gridx = i % 3;
			gbc_box.insets = new Insets(0, 0, 5, 5);
			panelCheckBox.add(box, gbc_box);
			i++;

		}

		/*
		 * Zone description
		 */
		JPanel panelText = new JPanel();
		GridBagConstraints gbc_panelText = new GridBagConstraints();
		gbc_panelText.gridheight = 2;
		gbc_panelText.insets = new Insets(0, 0, 5, 0);
		gbc_panelText.fill = GridBagConstraints.BOTH;
		gbc_panelText.gridx = 1;
		gbc_panelText.gridy = 0;
		panel.add(panelText, gbc_panelText);
		GridBagLayout gbl_panelText = new GridBagLayout();
		gbl_panelText.columnWidths = new int[] { 0, 0 };
		gbl_panelText.rowHeights = new int[] { 30, 0, 0, 0, 0 };
		gbl_panelText.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelText.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelText.setLayout(gbl_panelText);

		JLabel lblJobTitle = new JLabel("Titre du poste");
		GridBagConstraints gbc_lblJobTitle = new GridBagConstraints();
		gbc_lblJobTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblJobTitle.gridx = 0;
		gbc_lblJobTitle.gridy = 0;
		panelText.add(lblJobTitle, gbc_lblJobTitle);

		textField_JobTitle = new JTextField();
		GridBagConstraints gbc_textField_JobTitle = new GridBagConstraints();
		gbc_textField_JobTitle.insets = new Insets(0, 0, 5, 0);
		gbc_textField_JobTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_JobTitle.gridx = 0;
		gbc_textField_JobTitle.gridy = 1;
		panelText.add(textField_JobTitle, gbc_textField_JobTitle);
		textField_JobTitle.setColumns(10);

		JLabel lblProposalDescription = new JLabel("Description du poste");
		GridBagConstraints gbc_lblProposalDescription = new GridBagConstraints();
		gbc_lblProposalDescription.insets = new Insets(0, 0, 5, 0);
		gbc_lblProposalDescription.gridx = 0;
		gbc_lblProposalDescription.gridy = 2;
		panelText.add(lblProposalDescription, gbc_lblProposalDescription);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 3;
		panelText.add(scrollPane_1, gbc_scrollPane_1);

		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);

		/*
		 * Zone options
		 */
		JPanel panelComboBox = new JPanel();
		GridBagConstraints gbc_panelComboBox = new GridBagConstraints();
		gbc_panelComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_panelComboBox.fill = GridBagConstraints.BOTH;
		gbc_panelComboBox.gridx = 0;
		gbc_panelComboBox.gridy = 1;
		panel.add(panelComboBox, gbc_panelComboBox);
		GridBagLayout gbl_panelComboBox = new GridBagLayout();
		gbl_panelComboBox.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panelComboBox.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelComboBox.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelComboBox.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panelComboBox.setLayout(gbl_panelComboBox);

		JLabel lblGeographicLocation = new JLabel("Ville");
		GridBagConstraints gbc_lblGeographicLocation = new GridBagConstraints();
		gbc_lblGeographicLocation.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeographicLocation.gridx = 0;
		gbc_lblGeographicLocation.gridy = 0;
		panelComboBox.add(lblGeographicLocation, gbc_lblGeographicLocation);
		
		comboBox_location = new JComboBox<Location>();
//		comboBox_location = new JComboBox<City>();
		GridBagConstraints gbc_comboBox_location = new GridBagConstraints();
		gbc_comboBox_location.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_location.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_location.gridx = 2;
		gbc_comboBox_location.gridy = 0;
		panelComboBox.add(comboBox_location, gbc_comboBox_location);

		JLabel lblContractType = new JLabel("Type de contrat");
		GridBagConstraints gbc_lblContractType = new GridBagConstraints();
		gbc_lblContractType.insets = new Insets(0, 0, 5, 5);
		gbc_lblContractType.gridx = 0;
		gbc_lblContractType.gridy = 1;
		panelComboBox.add(lblContractType, gbc_lblContractType);

		comboBox_contract = new JComboBox<ContractType>();
		GridBagConstraints gbc_comboBox_contract = new GridBagConstraints();
		gbc_comboBox_contract.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_contract.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_contract.gridx = 2;
		gbc_comboBox_contract.gridy = 1;
		panelComboBox.add(comboBox_contract, gbc_comboBox_contract);

		lblLink = new JLabel("Contact");
		GridBagConstraints gbc_lblLink = new GridBagConstraints();
		gbc_lblLink.insets = new Insets(0, 0, 0, 5);
		gbc_lblLink.gridx = 0;
		gbc_lblLink.gridy = 2;
		panelComboBox.add(lblLink, gbc_lblLink);

		comboBox_linkedUser = new JComboBox<RegisteredUser>();
		GridBagConstraints gbc_comboBox_linkedUser = new GridBagConstraints();
		gbc_comboBox_linkedUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_linkedUser.gridx = 2;
		gbc_comboBox_linkedUser.gridy = 2;
		panelComboBox.add(comboBox_linkedUser, gbc_comboBox_linkedUser);

		/*
		 * Zone finalization
		 */
		btnCancel = new JButton("Annuler");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.EAST;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 2;
		panel.add(btnCancel, gbc_btnCancel);

		btnProposalCreation = new JButton("Ajouter");
		GridBagConstraints gbc_btnProposalCreation = new GridBagConstraints();
		gbc_btnProposalCreation.anchor = GridBagConstraints.WEST;
		gbc_btnProposalCreation.gridx = 1;
		gbc_btnProposalCreation.gridy = 2;
		panel.add(btnProposalCreation, gbc_btnProposalCreation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.views.IVisibility#setMode(boolean)
	 */
	@Override
	public void setMode(boolean b) {
		this.getBtnCancel().setVisible(b);
		this.btnProposalCreation.setVisible(b);
		// zone options
		this.getComboBox_contract().setEnabled(b);
		this.getComboBox_linkedUser().setEnabled(b);
		this.comboBox_location.setEnabled(b);
		// zone presentations
		this.getTextField_JobTitle().setEditable(b);
		if (b) {
			this.getTextField_JobTitle().setBorder(new TextFieldBorder());
		} else {
			this.getTextField_JobTitle().setBorder(new EmptyBorder(0, 0, 0, 0));
		}
		if (b) {
			this.getTextArea().setBackground(UIManager.getColor("TextArea.background"));
			this.getTextArea().setBorder(new TextFieldBorder());
		} else {
			this.getTextArea().setBackground(UIManager.getColor("Panel.background"));
			this.getTextArea().setBorder(new EmptyBorder(0, 0, 0, 0));
		}
		// zone skills
		for (JCheckBox jCheckBox : listSkills) {
			jCheckBox.setEnabled(b);
			if (!jCheckBox.isSelected() && !b) {
				this.panelCheckBox.remove(jCheckBox);
			}
		}
	}

}
