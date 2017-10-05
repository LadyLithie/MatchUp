package fr.lithie.matchup.views.panels;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import fr.lithie.matchup.entities.Enterprise;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Color;

public class PanelLinkedEnterprises extends JPanel {

	private ArrayList<Enterprise> enterprises;
	private Enterprise company;
	
	private PanelNewEnterprise newEnterprise;
	private JScrollPane scrollPaneListEnterprise;
	private JPanel panelContentListEnterprise;
	
	private JButton btnEditer;
	private JButton btnAnnuler;
	
	/**
	 * @return the scrollPaneListEnterprise
	 */
	public JScrollPane getScrollPaneListEnterprise() {
		return scrollPaneListEnterprise;
	}

	/**
	 * @return the panelContentListEnterprise
	 */
	public JPanel getPanelContentListEnterprise() {
		return panelContentListEnterprise;
	}

	/**
	 * @return the companies
	 */
	public ArrayList<Enterprise> getCompanies() {
		return enterprises;
	}

	/**
	 * @return the newEnterprise
	 */
	public PanelNewEnterprise getNewEnterprise() {
		return newEnterprise;
	}

	/**
	 * @return the btnEditer
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
	 * Create the panel.
	 */
	public PanelLinkedEnterprises(ArrayList<Enterprise> companies) {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{300};
		gridBagLayout.rowHeights = new int[]{30, 30, 65};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_Title = new GridBagConstraints();
		gbc_panel_Title.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Title.gridwidth = 3;
		gbc_panel_Title.fill = GridBagConstraints.BOTH;
		gbc_panel_Title.gridx = 0;
		gbc_panel_Title.gridy = 0;
		add(panel_Title, gbc_panel_Title);
		GridBagLayout gbl_panel_Title = new GridBagLayout();
		gbl_panel_Title.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_Title.rowHeights = new int[]{0, 0};
		gbl_panel_Title.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Title.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_Title.setLayout(gbl_panel_Title);
		
		JLabel lblEnterprisesPartenaires = new JLabel("Enterprises partenaires");
		GridBagConstraints gbc_lblEnterprisesPartenaires = new GridBagConstraints();
		gbc_lblEnterprisesPartenaires.insets = new Insets(0, 0, 0, 5);
		gbc_lblEnterprisesPartenaires.gridx = 0;
		gbc_lblEnterprisesPartenaires.gridy = 0;
		panel_Title.add(lblEnterprisesPartenaires, gbc_lblEnterprisesPartenaires);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setVisible(false);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnuler.gridx = 1;
		gbc_btnAnnuler.gridy = 0;
		panel_Title.add(btnAnnuler, gbc_btnAnnuler);
		
		btnEditer = new JButton("Editer");
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.gridx = 2;
		gbc_btnEditer.gridy = 0;
		panel_Title.add(btnEditer, gbc_btnEditer);
		
		newEnterprise = new PanelNewEnterprise();
		newEnterprise.setBackground(Color.WHITE);
		GridBagConstraints gbc_newEnterprise = new GridBagConstraints();
		gbc_newEnterprise.fill = GridBagConstraints.BOTH;
		gbc_newEnterprise.insets = new Insets(0, 0, 5, 5);
		gbc_newEnterprise.gridx = 0;
		gbc_newEnterprise.gridy = 1;
		add(newEnterprise, gbc_newEnterprise);
		
		scrollPaneListEnterprise = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPaneListEnterprise, gbc_scrollPane);
		
//		panelContentListEnterprise = new PanelEnterpriseAssociated(company);
//		panelContentListEnterprise.setBackground(Color.WHITE);
//		scrollPaneListEnterprise.setViewportView(panelContentListEnterprise);
//		GridBagLayout gbl_panelContent = new GridBagLayout();
//		gbl_panelContent.columnWidths = new int[] {0, 0};
//		gbl_panelContent.rowHeights = new int[] {30, 30};
//		gbl_panelContent.columnWeights = new double[]{1.0};
//		gbl_panelContent.rowWeights = new double[]{0.0, 0.0};
//		panelContentListEnterprise.setLayout(gbl_panelContent);
//		


	}

}
