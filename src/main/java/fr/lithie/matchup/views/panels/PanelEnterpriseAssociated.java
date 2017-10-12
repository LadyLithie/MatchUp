package fr.lithie.matchup.views.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.lithie.matchup.entities.Company;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class PanelEnterpriseAssociated extends JPanel {

	private JLabel lblEnterpriseName;
	
	/**
	 * @return the lblEnterpriseName
	 */
	public JLabel getLblEnterpriseName() {
		return lblEnterpriseName;
	}

	/**
	 * Create the panel.
	 */
	public PanelEnterpriseAssociated(Company company) {
		
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		setLayout(gridBagLayout);
		
		lblEnterpriseName = new JLabel(company.getName());
		GridBagConstraints gbc_lblEnterpriseName = new GridBagConstraints();
		gbc_lblEnterpriseName.insets = new Insets(5, 5, 5, 5);
		gbc_lblEnterpriseName.gridx = 0;
		gbc_lblEnterpriseName.gridy = 0;
		add(lblEnterpriseName, gbc_lblEnterpriseName);
		
	}

}
