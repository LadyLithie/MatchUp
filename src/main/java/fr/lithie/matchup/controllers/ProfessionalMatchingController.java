package fr.lithie.matchup.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.lithie.matchup.entities.Candidate;
import fr.lithie.matchup.managers.ViewsManager;
import fr.lithie.matchup.views.ProfessionalMatchingView;

public class ProfessionalMatchingController extends BaseController{

	public ProfessionalMatchingController(){
		
		super.frame = frame;
		super.view = new ProfessionalMatchingView(frame);
		
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.controllers.BaseController#initView()
	 */
	@Override
	public void initView() {
		// TODO Auto-generated method stub		
		Candidate c = (Candidate) getViewDatas().get(ViewsDatasTerms.CURRENT_USER);
		ProfessionalMatchingView view = (ProfessionalMatchingView) getView();		
		
		view.getMenuBar().getLblUserName().setText(c.getFirstname());
		view.getTextFieldFirstname().setText(c.getFirstname());
		view.getTextFieldLastname().setText(c.getLastname());
		view.getTextFieldMail().setText(c.getEmail());
		
		
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.controllers.BaseController#initEvent()
	 */
	@Override
	public void initEvent() {
		ProfessionalMatchingView view = (ProfessionalMatchingView) super.view;
		// TODO Auto-generated method stub
		view.getMenuBar().getNavigationBar().getBtnGoToProfil().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ViewsManager.getInstance().next(new CandidateController(frame));
			}
		});
		
		
	}
	
	
}
