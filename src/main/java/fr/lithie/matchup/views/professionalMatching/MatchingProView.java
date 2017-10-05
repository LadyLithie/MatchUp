package fr.lithie.matchup.views.professionalMatching;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

import fr.lithie.matchup.views.base.BaseView;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MatchingProView extends BaseView {

	private JButton btnSeeMore1;

	/**
	 * @return the btnSeeMore1
	 */
	public JButton getBtnSeeMore1() {
		return btnSeeMore1;
	}
	
	/**
	 * Create the frame.
	 */
	public MatchingProView(JFrame frame) {
		super.pageName = ("Matching");
		JPanel panelMatching = new JPanel();
		panelMatching.setBounds(100, 100, 900, 600);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		panelMatching.setLayout(gbl_contentPane);
		
		JPanel panelMatch1 = new JPanel();
		panelMatch1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 5, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panelMatching.add(panelMatch1, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 30, 30, 30, 0, 0};
		gbl_panel.rowHeights = new int[] {0, 0, 30};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{1.0, 1.0};
		panelMatch1.setLayout(gbl_panel);
		
		JLabel lblJobProposal = new JLabel("Job proposal 1");
		GridBagConstraints gbc_lblJobProposal = new GridBagConstraints();
		gbc_lblJobProposal.anchor = GridBagConstraints.WEST;
		gbc_lblJobProposal.insets = new Insets(5, 5, 5, 5);
		gbc_lblJobProposal.gridx = 0;
		gbc_lblJobProposal.gridy = 0;
		panelMatch1.add(lblJobProposal, gbc_lblJobProposal);
		
		JTextField textField_JobTitle = new JTextField();
		textField_JobTitle.setEditable(false);
		GridBagConstraints gbc_textField_JobTitle = new GridBagConstraints();
		gbc_textField_JobTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_JobTitle.gridwidth = 4;
		gbc_textField_JobTitle.insets = new Insets(5, 5, 5, 5);
		gbc_textField_JobTitle.gridx = 0;
		gbc_textField_JobTitle.gridy = 1;
		panelMatch1.add(textField_JobTitle, gbc_textField_JobTitle);
		textField_JobTitle.setColumns(10);
		
		JButton btnSeeMore1 = new JButton("See more");
		GridBagConstraints gbc_btnSeeMore1 = new GridBagConstraints();
		gbc_btnSeeMore1.gridx = 4;
		gbc_btnSeeMore1.gridy = 1;
		gbc_btnSeeMore1.insets = new Insets(5, 5, 5, 5);
		panelMatch1.add(btnSeeMore1, gbc_btnSeeMore1);
		
		JScrollBar scrollBar = new JScrollBar();
		GridBagConstraints gbc_scrollBar = new GridBagConstraints();
		gbc_scrollBar.insets = new Insets(0, 0, 5, 0);
		gbc_scrollBar.fill = GridBagConstraints.VERTICAL;
		gbc_scrollBar.gridheight = 6;
		gbc_scrollBar.gridx = 1;
		gbc_scrollBar.gridy = 0;
		panelMatching.add(scrollBar, gbc_scrollBar);
		
		JPanel panelMatch2 = new JPanel();
		panelMatch2.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(5, 5, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panelMatching.add(panelMatch2, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[] {0, 0, 10};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0};
		panelMatch2.setLayout(gbl_panel_1);
		
		JLabel lblJobProposal_1 = new JLabel("Job proposal 2");
		GridBagConstraints gbc_lblJobProposal_1 = new GridBagConstraints();
		gbc_lblJobProposal_1.anchor = GridBagConstraints.WEST;
		gbc_lblJobProposal_1.gridx = 0;
		gbc_lblJobProposal_1.gridy = 0;
		gbc_lblJobProposal_1.insets = new Insets(5, 5, 5, 5);
		panelMatch2.add(lblJobProposal_1, gbc_lblJobProposal_1);
		
		JTextField textField_JobTitle2 = new JTextField();
		textField_JobTitle2.setEditable(false);
		GridBagConstraints gbc_textField_JobTitle2 = new GridBagConstraints();
		gbc_textField_JobTitle2.gridwidth = 4;
		gbc_textField_JobTitle2.insets = new Insets(5, 5, 5, 5);
		gbc_textField_JobTitle2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_JobTitle2.gridx = 0;
		gbc_textField_JobTitle2.gridy = 1;
		panelMatch2.add(textField_JobTitle2, gbc_textField_JobTitle2);
		textField_JobTitle2.setColumns(10);
		
		JButton btnSeeMore2 = new JButton("See more");
		GridBagConstraints gbc_btnSeeMore2 = new GridBagConstraints();
		gbc_btnSeeMore2.gridx = 4;
		gbc_btnSeeMore2.gridy = 1;
		gbc_btnSeeMore2.insets = new Insets(5, 5, 5, 5);
		panelMatch2.add(btnSeeMore2, gbc_btnSeeMore2);
		
		JPanel panelMatch3 = new JPanel();
		panelMatch3.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(5, 5, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panelMatching.add(panelMatch3, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {0, 30, 30, 30, 0, 0};
		gbl_panel_2.rowHeights = new int[] {0, 0, 30};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panelMatch3.setLayout(gbl_panel_2);
		
		JLabel lblJobProposal_2 = new JLabel("Job proposal 3");
		GridBagConstraints gbc_lblJobProposal_2 = new GridBagConstraints();
		gbc_lblJobProposal_2.anchor = GridBagConstraints.WEST;
		gbc_lblJobProposal_2.insets = new Insets(5, 5, 5, 5);
		gbc_lblJobProposal_2.gridx = 0;
		gbc_lblJobProposal_2.gridy = 0;
		panelMatch3.add(lblJobProposal_2, gbc_lblJobProposal_2);
		
		JTextField textField_JobTitle3 = new JTextField();
		textField_JobTitle3.setEditable(false);
		textField_JobTitle3.setColumns(10);
		GridBagConstraints gbc_textField_JobTitle3 = new GridBagConstraints();
		gbc_textField_JobTitle3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_JobTitle3.gridwidth = 4;
		gbc_textField_JobTitle3.insets = new Insets(5, 5, 0, 5);
		gbc_textField_JobTitle3.gridx = 0;
		gbc_textField_JobTitle3.gridy = 1;
		panelMatch3.add(textField_JobTitle3, gbc_textField_JobTitle3);
		
		JButton btnSeeMore3 = new JButton("See more");
		GridBagConstraints gbc_btnSeeMore3 = new GridBagConstraints();
		gbc_btnSeeMore3.insets = new Insets(5, 5, 5, 5);
		gbc_btnSeeMore3.gridx = 4;
		gbc_btnSeeMore3.gridy = 1;
		panelMatch3.add(btnSeeMore3, gbc_btnSeeMore3);
		
		
		
		
	}

}
