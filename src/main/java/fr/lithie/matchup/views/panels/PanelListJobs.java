/**
 * 
 */
package fr.lithie.matchup.views.panels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

import fr.lithie.matchup.utils.views.ViewsUtils;

/**
 * @author Audrey
 *
 */
public class PanelListJobs extends JPanel {

	private PanelJobs panelJobs;
	private JButton btnAdd;

	/**
	 * @return the panelJobs
	 */
	public PanelJobs getPanelJobs() {
		return panelJobs;
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
	public PanelListJobs() {
		super();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setMinimumSize(new Dimension(315, 445));
		
		//Title part
		JPanel panelTitle = new JPanel();
		ViewsUtils.setColorDarkOrange(panelTitle);
		GridBagConstraints gbc_panelTitle = new GridBagConstraints();
		gbc_panelTitle.insets = new Insets(0, 0, 5, 0);
		gbc_panelTitle.fill = GridBagConstraints.BOTH;
		gbc_panelTitle.gridx = 0;
		gbc_panelTitle.gridy = 0;
		add(panelTitle, gbc_panelTitle);
		GridBagLayout gbl_panelTitle = new GridBagLayout();
		gbl_panelTitle.columnWidths = new int[]{0, 10, 0, 0};
		gbl_panelTitle.rowHeights = new int[]{0, 0};
		gbl_panelTitle.columnWeights = new double[]{0.0, 1, 0.0, Double.MIN_VALUE};
		gbl_panelTitle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTitle.setLayout(gbl_panelTitle);
		
		JLabel lbllTitle = new JLabel("Postes proposés");
		GridBagConstraints gbc_lbllTitle = new GridBagConstraints();
		gbc_lbllTitle.gridwidth = 2;
		gbc_lbllTitle.insets = new Insets(5, 5, 5, 5);
		gbc_lbllTitle.anchor = GridBagConstraints.NORTHWEST;
		gbc_lbllTitle.gridx = 0;
		gbc_lbllTitle.gridy = 0;
		panelTitle.add(lbllTitle, gbc_lbllTitle);
		
		btnAdd = new JButton("Ajouter");
		btnAdd.setToolTipText("Cr\u00E9er un nouveau poste \u00E0 proposer");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.EAST;
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 0;
		panelTitle.add(btnAdd, gbc_btnAdd);
		
		//main part
		panelJobs = new PanelJobs();
		GridBagConstraints gbc_panelJobs = new GridBagConstraints();
		gbc_panelJobs.gridx = 0;
		gbc_panelJobs.gridy = 1;
		gbc_panelJobs.fill = GridBagConstraints.BOTH;
		gbc_panelJobs.anchor = GridBagConstraints.WEST;
		JScrollPane scrollJobs = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollJobs,gbc_panelJobs);
		scrollJobs.setViewportView(panelJobs);
	}

}