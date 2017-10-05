package fr.lithie.matchup.views.usercontrols;

import javax.swing.JPanel;

import fr.lithie.matchup.managers.ViewsManager;
import fr.lithie.matchup.views.ViewsTerms;
import fr.lithie.matchup.views.base.BaseView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NavigationBar extends BaseView {

	private JButton btnGoToProfil;
	private JButton btnGoToMatching;
	//For each listener
	private ActionListener backListener;
	private ActionListener nextListener;

	/**
	 * @return the btnBack
	 */
	public JButton getBtnGoToProfil() {
		return btnGoToProfil;
	}

	/**
	 * @param btnBack
	 *            the btnBack to set
	 */
	public void setBtnBack(JButton btnBack) {
		this.btnGoToProfil = btnBack;
	}

	/**
	 * @return the btnNext
	 */
	public JButton getBtnGoToMatching() {
		return btnGoToMatching;
	}

	/**
	 * @param btnNext
	 *            the btnNext to set
	 */
	public void setBtnNext(JButton btnNext) {
		this.btnGoToMatching = btnNext;
	}

	public NavigationBar() {
		super.pageName = ViewsTerms.NAVIGATIONBAR_PAGE_NAME;
		JPanel panel = new JPanel();
		super.panel = panel;
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		btnGoToProfil = new JButton("Profil");
		panel.add(btnGoToProfil);

		btnGoToMatching = new JButton("MatchUp");
		panel.add(btnGoToMatching);
	}

	public void setupEvents() {
		if (!ViewsManager.getInstance().canBack()) {
			btnGoToProfil.setEnabled(false);
		}else{
			btnGoToProfil.setEnabled(true);
		}

		if (!ViewsManager.getInstance().canNext()) {
			btnGoToMatching.setEnabled(false);
		}else{
			btnGoToMatching.setEnabled(true);
		}

		backListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewsManager.getInstance().back();
			}
		};
		this.btnGoToProfil.addActionListener(backListener);

		nextListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewsManager.getInstance().next();
			}
		};
		this.btnGoToMatching.addActionListener(nextListener);
	}

	/**
	 * To avoid redondant actions on 1 event
	 */
	public void resetEvents() {
		this.btnGoToProfil.removeActionListener(backListener);
		this.btnGoToMatching.removeActionListener(nextListener);
	}
}
