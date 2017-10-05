package fr.lithie.matchup.views;


import javax.swing.JPanel;

import fr.lithie.matchup.views.base.BaseView;
import fr.lithie.matchup.views.usercontrols.MenuBar;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class ItemDetailsView extends BaseView {

	private MenuBar menuBar;

	/**
	 * @return the menuBar
	 */
	public MenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * @param menuBar the menuBar to set
	 */
	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	/**
	 * Create the frame.
	 * @param frame
	 */
	public ItemDetailsView() {
		super.pageName = ViewsTerms.ITEMDETAILSVIEW_PAGE_NAME;
		JPanel panel = new JPanel();
		super.panel = panel;

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		menuBar = new MenuBar();
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.fill = GridBagConstraints.NORTH;
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		gbc_menuBar.gridwidth = 10;
		panel.add(menuBar.getContentPane(), gbc_menuBar);
	}

}
