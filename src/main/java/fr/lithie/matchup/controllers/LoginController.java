/**
 * 
 */
package fr.lithie.matchup.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.lithie.matchup.database.ProposalDAO;
import fr.lithie.matchup.database.RegisteredUserDAO;
import fr.lithie.matchup.entities.Administrator;
import fr.lithie.matchup.entities.Candidate;
import fr.lithie.matchup.entities.Company;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.User;
import fr.lithie.matchup.managers.ViewsManager;
import fr.lithie.matchup.views.LoginView;

/**
 * @author Audrey
 *
 */
public class LoginController extends BaseController {
	private User user;

	/**
	 * Basic constructor
	 * 
	 * @param frame
	 */
	public LoginController(JFrame frame) {
		super();
		super.frame = frame;
		super.view = new LoginView(this.frame);
	}

	/**
	 * Constructor with data transfer
	 * 
	 * @param frame
	 * @param newUser
	 */
	public LoginController(JFrame frame, User newUser) {
		super();
		this.user = newUser;
		super.frame = frame;
		super.view = new LoginView(this.frame);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.controllers.BaseController#initView()
	 */
	@Override
	public void initView() {
		if (getViewDatas().get("newUser") != null) {
			this.user = (User) getViewDatas().get("newUser");
		} else if (getViewDatas().get("currentUser") != null) {
			this.user = (User) getViewDatas().get("currentUser");
		}

		if (user != null) {
			((LoginView) getView()).getTextFieldLogin().setText(this.user.getLogin());
			((LoginView) getView()).getTextFieldPwd().setText(this.user.getPassword());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.controllers.BaseController#initEvent()
	 */
	@Override
	public void initEvent() {
		LoginView view = (LoginView) super.view;
		super.frame.getRootPane().setDefaultButton(view.getBtnLogin());

		// Connect and go to Profile
		view.getBtnLogin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getTextFieldLogin().getText().isEmpty() || view.getTextFieldPwd().getText().isEmpty()) {
					if (view.getTextFieldPwd().getText().isEmpty()) {
						view.getTextFieldPwd().setBackground(Color.PINK);
					} else {
						view.getTextFieldPwd().setBackground(Color.WHITE);
					}
					if (view.getTextFieldLogin().getText().isEmpty()) {
						view.getTextFieldLogin().setBackground(Color.PINK);
					} else {
						view.getTextFieldLogin().setBackground(Color.WHITE);
					}
				} else {
					// normal version must consult the database for a user with those datas
					RegisteredUserDAO userDAO = new RegisteredUserDAO();
					user = userDAO.connection(view.getTextFieldLogin().getText(),
							view.getTextFieldPwd().getText());

					if (user != null) {
						setupDatas();
						if (user instanceof Company) {
							((Company) user).setJobs(new ProposalDAO().getByCompany(user.getId()));
							ViewsManager.getInstance().next(new CompanyController(frame));
						}else if (user instanceof Headhunter) {
							((Headhunter) user).setJobs(new ProposalDAO().getByHeadhunter(user.getId()));
							ViewsManager.getInstance().next(new HeadhunterController(frame));
						}else if (user instanceof Candidate) {
							ViewsManager.getInstance().next(new CandidateController(frame));
						}else if (user instanceof Administrator) {
							ViewsManager.getInstance().next(new AdminController(frame));
						}
					}
				}
			}
		});

		// Go to Register
		view.getBtnRegister().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewsManager.getInstance().next(new RegisterController(frame));
			}
		});

	}

	@Override
	public void setupDatas() {
		this.viewDatas.put(ViewsDatasTerms.CURRENT_USER, user);
	}
}
