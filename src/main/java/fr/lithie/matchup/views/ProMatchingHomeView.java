package fr.lithie.matchup.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JSplitPane;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import fr.lithie.matchup.utils.views.ViewsUtils;
import fr.lithie.matchup.views.base.BaseView;
import fr.lithie.matchup.views.usercontrols.MenuBar;

public class ProMatchingHomeView extends BaseView {

	private JPanel panelListJobs;
	private JLabel lblResult;
	private MenuBar menuBar;
	private JPanel panelResult;
	private JButton btnListe;
	private JButton btnMore;
	private JPanel panelPreview;

	/**
	 * @return the panelPreview
	 */
	public JPanel getPanelPreview() {
		return panelPreview;
	}

	/**
	 * @return the btnListe
	 */
	public JButton getBtnListe() {
		return btnListe;
	}

	/**
	 * @return the btnMore
	 */
	public JButton getBtnMore() {
		return btnMore;
	}

	/**
	 * @return the menuBar
	 */
	public MenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * @return the panelListJobs
	 */
	public JPanel getPanelListJobs() {
		return panelListJobs;
	}

	/**
	 * @return the lblResult
	 */
	public JLabel getLblResult() {
		return lblResult;
	}

	/**
	 * @return the panelResult
	 */
	public JPanel getPanelResult() {
		return panelResult;
	}

	/**
	 * Create the panel.
	 * 
	 * @param jFrame
	 */
	public ProMatchingHomeView(JFrame jFrame) {
		super();
		super.pageName = "Matching";
		JPanel panel = new JPanel();
		super.panel = panel;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gridBagLayout);

		menuBar = new MenuBar();
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		gbc_menuBar.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(menuBar.getContentPane(), gbc_menuBar);

		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 1;
		panel.add(splitPane, gbc_splitPane);

		// Panel for result
		panelPreview = new JPanel();
		splitPane.setRightComponent(panelPreview);
		panelPreview.setLayout(new BorderLayout(0, 0));

		JPanel panelTitle = new JPanel();
		ViewsUtils.setColorDarkOrange(panelTitle);
		panelPreview.add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new BorderLayout(0, 0));

		btnListe = new JButton("Liste");
		panelTitle.add(btnListe, BorderLayout.WEST);

		lblResult = new JLabel("result");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblResult);

		btnMore = new JButton("Détail");
		panelTitle.add(btnMore, BorderLayout.EAST);

		panelResult = new JPanel();
		panelPreview.add(panelResult);

		// Listing of user's jobs
		JPanel panelLeft = new JPanel();
		splitPane.setLeftComponent(panelLeft);
		GridBagLayout gbl_panelListJob = new GridBagLayout();
		gbl_panelListJob.columnWidths = new int[] { 93, 0 };
		gbl_panelListJob.rowHeights = new int[] { 16, 0, 0 };
		gbl_panelListJob.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelListJob.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panelLeft.setLayout(gbl_panelListJob);

		JLabel lblPostes = new JLabel("Postes proposés");
		ViewsUtils.setColorDarkOrange(lblPostes);
		GridBagConstraints gbc_lblPostesProposs = new GridBagConstraints();
		gbc_lblPostesProposs.insets = new Insets(0, 0, 5, 0);
		gbc_lblPostesProposs.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPostesProposs.gridx = 0;
		gbc_lblPostesProposs.gridy = 0;
		panelLeft.add(lblPostes, gbc_lblPostesProposs);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panelLeft.add(scrollPane, gbc_scrollPane);

		panelListJobs = new JPanel();
		scrollPane.setViewportView(panelListJobs);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelListJobs.setLayout(gbl_panel);

	}

}
