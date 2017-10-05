package fr.lithie.matchup.views.panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelNewEnterprise extends JPanel {

	private JLabel lblNewEnterprise;
	private JTextField textField_newEnterprise;
	private JButton btnAdd;
	
	/**
	 * @return the lblNewEnterprise
	 */
	public JLabel getLblNewEnterprise() {
		return lblNewEnterprise;
	}

	/**
	 * @return the textField_newEnterprise
	 */
	public JTextField getTextField_newEnterprise() {
		return textField_newEnterprise;
	}

	/**
	 * @return the btnAdd
	 */
	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	

	/**
	 * Create the panel.
	 */
	public PanelNewEnterprise() {
		super();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 110, 100};
		gridBagLayout.rowHeights = new int[]{50};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0};
		setLayout(gridBagLayout);
		
		lblNewEnterprise = new JLabel("Nouvelle entreprise");
		GridBagConstraints gbc_lblNewEnterprise = new GridBagConstraints();
		gbc_lblNewEnterprise.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewEnterprise.gridx = 0;
		gbc_lblNewEnterprise.gridy = 0;
		add(lblNewEnterprise, gbc_lblNewEnterprise);
		
		textField_newEnterprise = new JTextField();
		GridBagConstraints gbc_textField_newEnterprise = new GridBagConstraints();
		gbc_textField_newEnterprise.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_newEnterprise.insets = new Insets(0, 0, 5, 0);
		gbc_textField_newEnterprise.gridx = 1;
		gbc_textField_newEnterprise.gridy = 0;
		add(textField_newEnterprise, gbc_textField_newEnterprise);

		btnAdd = new JButton("Ajouter");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 0;
		add(btnAdd, gbc_btnAdd);
		
		
		
		
	}

}
