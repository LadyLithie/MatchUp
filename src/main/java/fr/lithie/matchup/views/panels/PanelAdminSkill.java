package fr.lithie.matchup.views.panels;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.lithie.matchup.entities.Skill;

/**
 * @author Audrey
 *
 */
public class PanelAdminSkill extends JPanel {
	private Skill skill;

	private JTextField tF_SkillType;
	private JTextField tF_SkillName;
	private JButton btnModify;

	/**
	 * @return the tF_SkillType
	 */
	public JTextField gettF_SkillType() {
		return tF_SkillType;
	}

	/**
	 * @return the tF_SkillName
	 */
	public JTextField gettF_SkillName() {
		return tF_SkillName;
	}

	/**
	 * @return the btnModify
	 */
	public JButton getBtnModify() {
		return btnModify;
	}

	/**
	 * Create the panel.
	 */
	public PanelAdminSkill() {
		super();
		setLayout(new GridLayout(1, 0, 0, 0));

		tF_SkillName = new JTextField();
//		tF_SkillName.setEditable(false);
		GridBagConstraints gbc_textField_SkillName = new GridBagConstraints();
		gbc_textField_SkillName.insets = new Insets(0, 0, 5, 5);
		gbc_textField_SkillName.fill = GridBagConstraints.HORIZONTAL;
		add(tF_SkillName, gbc_textField_SkillName);
		tF_SkillName.setColumns(10);

		tF_SkillType = new JTextField();
//		tF_SkillType.setEditable(false);
		GridBagConstraints gbc_textField_SkillType = new GridBagConstraints();
		gbc_textField_SkillType.insets = new Insets(0, 0, 5, 5);
		gbc_textField_SkillType.fill = GridBagConstraints.HORIZONTAL;
		add(tF_SkillType, gbc_textField_SkillType);
		tF_SkillType.setColumns(10);

		btnModify = new JButton("Modify");
		GridBagConstraints gbc_btnModifySkill = new GridBagConstraints();
		gbc_btnModifySkill.insets = new Insets(0, 0, 5, 5);
		add(btnModify, gbc_btnModifySkill);

	}

	/**
	 * @return the skill
	 */
	public Skill getSkill() {
		return skill;
	}

	/**
	 * @param skill the skill to set
	 */
	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
