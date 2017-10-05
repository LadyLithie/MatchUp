package fr.lithie.matchup.views.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.utils.views.ViewsUtils;
import fr.lithie.matchup.views.base.IVisibility;

import javax.swing.JScrollPane;

public class PanelHeadhunters extends JPanel implements IVisibility {
	private PanelFieldsButton newHeadHunter;
	private JButton btnEdit;
	private JButton btnAnnuler;
	private ArrayList<PanelFieldsButton> associates;
	private JPanel panelContent;
	private JScrollPane scrollPane;

	/**
	 * @return the newHeadHunter
	 */
	public PanelFieldsButton getNewHeadHunter() {
		return newHeadHunter;
	}

	/**
	 * @return the btnEdit
	 */
	public JButton getBtnEdit() {
		return btnEdit;
	}

	/**
	 * @return the btnAnnuler
	 */
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	/**
	 * @return the associates
	 */
	public ArrayList<PanelFieldsButton> getAssociates() {
		return associates;
	}

	/**
	 * @param associates the associates to set
	 */
	public void setAssociates(ArrayList<PanelFieldsButton> associates) {
		this.associates = associates;
	}

	/**
	 * @return the panelContent
	 */
	public JPanel getPanelContent() {
		return panelContent;
	}

	/**
	 * Create the panel.
	 */
	public PanelHeadhunters(ArrayList<Headhunter> associates) {
		super();
		this.setName("Headhunters");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0,1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Title panel
		JPanel panelTitle = new JPanel();
		ViewsUtils.setColorDarkOrange(panelTitle);
		GridBagConstraints gbc_panelTitle = new GridBagConstraints();
		gbc_panelTitle.fill = GridBagConstraints.BOTH;
		gbc_panelTitle.insets = new Insets(0, 0, 5, 0);
		gbc_panelTitle.gridx = 0;
		gbc_panelTitle.gridy = 0;
		add(panelTitle, gbc_panelTitle);
		GridBagLayout gbl_panelTitle = new GridBagLayout();
		gbl_panelTitle.columnWidths = new int[]{5, 0, 10, 0, 5};
		gbl_panelTitle.rowHeights = new int[]{0, 0};
		gbl_panelTitle.columnWeights = new double[]{0.0, 0.0, 1, 0.0, 0.0};
		gbl_panelTitle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTitle.setLayout(gbl_panelTitle);
		
		JLabel lblHeadhunters = new JLabel("Headhunters");
		GridBagConstraints gbc_lblHeadhunters = new GridBagConstraints();
		gbc_lblHeadhunters.anchor = GridBagConstraints.WEST;
		gbc_lblHeadhunters.fill = GridBagConstraints.VERTICAL;
		gbc_lblHeadhunters.insets = new Insets(0, 0, 0, 5);
		gbc_lblHeadhunters.gridx = 1;
		gbc_lblHeadhunters.gridy = 0;
		panelTitle.add(lblHeadhunters, gbc_lblHeadhunters);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setVisible(false);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.anchor = GridBagConstraints.EAST;
		gbc_btnAnnuler.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnuler.gridx = 3;
		gbc_btnAnnuler.gridy = 0;
		panelTitle.add(btnAnnuler, gbc_btnAnnuler);
		
		btnEdit = new JButton("Editer");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.anchor = GridBagConstraints.EAST;
		gbc_btnEdit.gridx = 4;
		gbc_btnEdit.gridy = 0;
		panelTitle.add(btnEdit, gbc_btnEdit);
		
		//Add new one
		newHeadHunter = new PanelFieldsButton("Nouveau recruteur", "Ajouter");
		GridBagConstraints gbc_newHeadHunter = new GridBagConstraints();
		gbc_newHeadHunter.insets = new Insets(0, 0, 5, 0);
		gbc_newHeadHunter.gridx = 0;
		gbc_newHeadHunter.gridy = 1;
		add(newHeadHunter, gbc_newHeadHunter);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		//List - Main panel
		panelContent = new JPanel();
		panelContent.setBorder(null);
		scrollPane.setViewportView(panelContent);
		GridBagLayout gbl_panelContent = new GridBagLayout();
		gbl_panelContent.columnWidths = new int[]{10, 0, 10, 0};
		gbl_panelContent.rowHeights = new int[]{10, 0, 0, 0, 0};
		gbl_panelContent.columnWeights = new double[]{1, 0.0, 1, Double.MIN_VALUE};
		gbl_panelContent.rowWeights = new double[]{0, 0.0, 0, Double.MIN_VALUE};
		panelContent.setLayout(gbl_panelContent);
		//List the present headhunters and offer possibility to delete
		if(this.associates == null) {
			this.associates = new ArrayList<PanelFieldsButton>();
		}
			
		this.setMode(false);
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.views.IVisibility#setMode(boolean)
	 */
	@Override
	public void setMode(boolean b) {
		this.getBtnAnnuler().setVisible(b);
		if (b) {
			this.getBtnEdit().setText("Valider");
		} else {
			this.getBtnEdit().setText("Editer");
		}
		for (PanelFieldsButton headhunter : associates) {
			headhunter.setMode(b);
		}
		this.getNewHeadHunter().setVisible(b);
		
	}

}
