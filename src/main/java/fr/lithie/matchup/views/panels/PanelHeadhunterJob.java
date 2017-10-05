package fr.lithie.matchup.views.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.lithie.matchup.entities.Proposal;

public class PanelHeadhunterJob extends JPanel {

	private JTextArea textArea_JobTitle;
	private JTextField textField_EnterpriseName;
	private JButton btnEditJob;
	private Proposal job;
	
	
	/**
	 * @return the job
	 */
	public Proposal getJob() {
		return job;
	}


	/**
	 * @return the textArea_JobTitle
	 */
	public JTextArea getTextArea_JobTitle() {
		return textArea_JobTitle;
	}


	/**
	 * @return the textField_EnterpriseName
	 */
	public JTextField getTextField_EnterpriseName() {
		return textField_EnterpriseName;
	}


	/**
	 * @return the btnEditJob
	 */
	public JButton getBtnEditJob() {
		return btnEditJob;
	}


	public PanelHeadhunterJob (Proposal job) {
		super();
		this.job = job;
		
		
		
		GridBagLayout gbl_panel_Job = new GridBagLayout();
		gbl_panel_Job.columnWidths = new int[]{0, 0};
		gbl_panel_Job.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_Job.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_Job.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_panel_Job);
		
		JLabel lblJobTitle = new JLabel("Titre du poste");
		GridBagConstraints gbc_lblJobTitle = new GridBagConstraints();
		gbc_lblJobTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblJobTitle.gridx = 0;
		gbc_lblJobTitle.gridy = 0;
		add(lblJobTitle, gbc_lblJobTitle);
		
		textArea_JobTitle = new JTextArea();
		textArea_JobTitle.setEditable(false);
		textArea_JobTitle.setText(job.getName());
		GridBagConstraints gbc_textArea_JobTitle = new GridBagConstraints();
		gbc_textArea_JobTitle.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_JobTitle.fill = GridBagConstraints.BOTH;
		gbc_textArea_JobTitle.gridx = 0;
		gbc_textArea_JobTitle.gridy = 1;
		add(textArea_JobTitle, gbc_textArea_JobTitle);
		
		JLabel lblEnterprise = new JLabel("Enterprise");
		GridBagConstraints gbc_lblEnterprise = new GridBagConstraints();
		gbc_lblEnterprise.insets = new Insets(0, 0, 5, 0);
		gbc_lblEnterprise.gridx = 0;
		gbc_lblEnterprise.gridy = 2;
		add(lblEnterprise, gbc_lblEnterprise);
		
		textField_EnterpriseName = new JTextField();
		textField_EnterpriseName.setEditable(false);
		textField_EnterpriseName.setBackground(Color.white);
		textField_EnterpriseName.setText(job.getCompany().getName());
		GridBagConstraints gbc_textField_EnterpriseName = new GridBagConstraints();
		gbc_textField_EnterpriseName.insets = new Insets(0, 0, 5, 0);
		gbc_textField_EnterpriseName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_EnterpriseName.gridx = 0;
		gbc_textField_EnterpriseName.gridy = 3;
		add(textField_EnterpriseName, gbc_textField_EnterpriseName);
		textField_EnterpriseName.setColumns(10);
		
		btnEditJob = new JButton("Editer");
		btnEditJob.setEnabled(true);
		GridBagConstraints gbc_btnEditJob = new GridBagConstraints();
		gbc_btnEditJob.gridx = 0;
		gbc_btnEditJob.gridy = 4;
		add(btnEditJob, gbc_btnEditJob);
	}
}
