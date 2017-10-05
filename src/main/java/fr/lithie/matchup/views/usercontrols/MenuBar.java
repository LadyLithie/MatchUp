/**
 * A graphic element integrated in a view that can possess its owns actions
 */
package fr.lithie.matchup.views.usercontrols;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JSeparator;

import fr.lithie.matchup.views.ViewsTerms;
import fr.lithie.matchup.views.base.BaseView;


public class MenuBar extends BaseView {

	private JLabel lblWelcome;
	private JLabel lblUserName;

	private JSeparator separator;
	private NavigationBar navigationBar;

	/**
	 * @return the navigationBar
	 */
	public NavigationBar getNavigationBar() {
		return navigationBar;
	}

	/**
	 * @return the lblWelcome
	 */
	public JLabel getLblWelcome() {
		return lblWelcome;
	}

	/**
	 * @param lblWelcome the lblWelcome to set
	 */
	public void setLblWelcome(JLabel lblWelcome) {
		this.lblWelcome = lblWelcome;
	}

	/**
	 * @return the lblUserlastname
	 */
	public JLabel getLblUserName() {
		return lblUserName;
	}

	/**
	 * @param lblUserlastname the lblUserlastname to set
	 */
	public void setLblUserName(JLabel lblUserlastname) {
		this.lblUserName = lblUserlastname;
	}


	/**
	 * Create the frame.
	 */
	public MenuBar() {
		super.pageName = ViewsTerms.MENUBAR_PAGE_NAME;
		JPanel panel = new JPanel();
		super.panel = panel;
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		navigationBar =  new NavigationBar();
		panel.add(navigationBar.getContentPane());

		separator = new JSeparator();
		separator.setBounds(0,40,0,0);
		panel.add(separator);

		lblWelcome = new JLabel(ViewsTerms.MENUBAR_WELCOME);
		panel.add(lblWelcome);
						
		lblUserName = new JLabel();
		panel.add(lblUserName);

		
	}
}
