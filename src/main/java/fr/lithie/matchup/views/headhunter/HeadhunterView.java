package fr.lithie.matchup.views.headhunter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import fr.lithie.matchup.controllers.ProfessionalMatchingController;
import fr.lithie.matchup.entities.Company;
import fr.lithie.matchup.managers.ViewsManager;
import fr.lithie.matchup.views.base.BaseView;
import fr.lithie.matchup.views.panels.PanelHeadhunterPresentation;
import fr.lithie.matchup.views.panels.PanelLinkedEnterprises;
import fr.lithie.matchup.views.panels.PanelListJobs;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class HeadhunterView extends BaseView {

	private PanelListJobs panel_JobList;
	private PanelHeadhunterPresentation panel_HeadhunterPresentation;
	private PanelLinkedEnterprises panel_LinkedEnterprises;
	
	private JMenuBar menuBar;
	
	/**
	 * @return the panel_JobList
	 */
	public PanelListJobs getPanel_JobList() {
		return panel_JobList;
	}


	/**
	 * @return the panel_HeadhunterPresentation
	 */
	public PanelHeadhunterPresentation getPanel_HeadhunterPresentation() {
		return panel_HeadhunterPresentation;
	}


	/**
	 * @return the panel_LinkedEnterprises
	 */
	public PanelLinkedEnterprises getPanel_LinkedEnterprises() {
		return panel_LinkedEnterprises;
	}


	/**
	 * @return the companies
	 */
	public ArrayList<Company> getCompanies() {
		return companies;
	}


	private ArrayList<Company> companies;
	private JMenuItem mntmProfil;
	private JMenuItem mntmMatching;


	/**
	 * Create the frame.
	 */
	public HeadhunterView(JFrame frame) {
		
		super();
		super.pageName = "Headhunter Profil";
		
		JPanel panel = new JPanel();
		super.panel = panel;
		panel.setMinimumSize(new Dimension(640, 480));
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {315, 310};
		gbl_panel.rowHeights = new int[] {30, 310, 140};
		gbl_panel.columnWeights = new double[]{1.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0};
		panel.setLayout(gbl_panel);
		
		menuBar = new JMenuBar();
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.gridwidth = 2;
		gbc_menuBar.gridheight = 1;
		gbc_menuBar.fill = GridBagConstraints.BOTH;
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		gbc_menuBar.insets = new Insets(0, 0, 5, 0);
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(menuBar, gbc_menuBar);
				
		mntmProfil = new JMenuItem("Profil");
		mntmProfil.setEnabled(false);
		menuBar.add(mntmProfil);
		mntmMatching = new JMenuItem("Matching");
		mntmMatching.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewsManager.getInstance().next(new ProfessionalMatchingController());
			}
		});
		menuBar.add(mntmMatching);
		
		
		
		
		panel_JobList = new PanelListJobs();
		GridBagLayout gridBagLayout = (GridBagLayout) panel_JobList.getLayout();
		gridBagLayout.columnWeights = new double[]{1.0};
		panel_JobList.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_JobList = new GridBagConstraints();
		gbc_panel_JobList.gridheight = 2;
		gbc_panel_JobList.fill = GridBagConstraints.BOTH;
		gbc_panel_JobList.insets = new Insets(0, 0, 0, 5);
		gbc_panel_JobList.gridx = 0;
		gbc_panel_JobList.gridy = 1;
		panel.add(panel_JobList, gbc_panel_JobList);
		
		panel_HeadhunterPresentation = new PanelHeadhunterPresentation();
		GridBagLayout gbl_panel_HeadhunterPresentation = (GridBagLayout) panel_HeadhunterPresentation.getLayout();
		GridBagConstraints gbc_panel_HeadhunterPresentation = new GridBagConstraints();
		gbc_panel_HeadhunterPresentation.gridheight = 1;
		gbc_panel_HeadhunterPresentation.fill = GridBagConstraints.BOTH;
		gbc_panel_HeadhunterPresentation.insets = new Insets(0, 0, 0, 0);
		gbc_panel_HeadhunterPresentation.gridx = 1;
		gbc_panel_HeadhunterPresentation.gridy = 1;
		panel.add(panel_HeadhunterPresentation, gbc_panel_HeadhunterPresentation);
		
		panel_LinkedEnterprises = new PanelLinkedEnterprises(companies);
		panel_LinkedEnterprises.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gbl_panel_LinkedEnterprises = (GridBagLayout) panel_LinkedEnterprises.getLayout();
		GridBagConstraints gbc_panel_LinkedEnterprises = new GridBagConstraints();
		gbc_panel_LinkedEnterprises.gridx = 1;
		gbc_panel_LinkedEnterprises.gridy = 2;
		gbc_panel_LinkedEnterprises.fill = GridBagConstraints.BOTH;
		gbc_panel_LinkedEnterprises.insets = new Insets(5, 0, 5, 0);
		panel.add(panel_LinkedEnterprises, gbc_panel_LinkedEnterprises);
		
	}

}
