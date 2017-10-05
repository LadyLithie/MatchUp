/**
 * 
 */
package fr.lithie.matchup.views.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import fr.lithie.matchup.entities.Proposal;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

/**
 * @author Audrey
 *
 */
public class PanelResumeJob extends JPanel {
	
	private JTextField textField;
	private JLabel lblLink;
	private Proposal job;
	private JButton btnEditer;

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * @return the lblLink
	 */
	public JLabel getLblLink() {
		return lblLink;
	}

	/**
	 * @return the job
	 */
	public Proposal getJob() {
		return job;
	}

	/**
	 * @return the btnEditer
	 */
	public JButton getBtnEditer() {
		return btnEditer;
	}

	/**
	 * Create the panel.
	 */
	public PanelResumeJob(Proposal job) {
		super();
		this.job = job;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{2, 50, 2, 0};
		gridBagLayout.rowHeights = new int[]{0, 2, 40, 2, 0, 0, 2, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblTitreDuPoste = new JLabel(job.getName());
		GridBagConstraints gbc_lblTitreDuPoste = new GridBagConstraints();
		gbc_lblTitreDuPoste.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitreDuPoste.gridx = 1;
		gbc_lblTitreDuPoste.gridy = 0;
		add(lblTitreDuPoste, gbc_lblTitreDuPoste);
		
		JTextPane txtpnPresentation = new JTextPane();
		String shortResume;
		if (job.getPresentation().length() < 50) {
			shortResume = job.getPresentation();
		} else {
			shortResume = job.getPresentation().substring(0,50) + " ...";
		}
		txtpnPresentation.setText(shortResume);
		txtpnPresentation.setEditable(false);
		txtpnPresentation.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_txtpnPresentation = new GridBagConstraints();
		gbc_txtpnPresentation.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnPresentation.fill = GridBagConstraints.BOTH;
		gbc_txtpnPresentation.gridx = 1;
		gbc_txtpnPresentation.gridy = 2;
		add(txtpnPresentation, gbc_txtpnPresentation);
		
		lblLink = new JLabel("");
		GridBagConstraints gbc_lblLink = new GridBagConstraints();
		gbc_lblLink.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink.gridx = 1;
		gbc_lblLink.gridy = 4;
		add(lblLink, gbc_lblLink);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.WHITE);
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnEditer = new JButton("Editer");
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditer.gridx = 1;
		gbc_btnEditer.gridy = 7;
		add(btnEditer, gbc_btnEditer);

	}

}
