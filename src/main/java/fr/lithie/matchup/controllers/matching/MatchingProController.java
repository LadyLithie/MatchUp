package fr.lithie.matchup.controllers.matching;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import fr.lithie.matchup.controllers.BaseController;
import fr.lithie.matchup.entities.Company;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.Job;
import fr.lithie.matchup.entities.User;
import fr.lithie.matchup.managers.ViewsManager;
import fr.lithie.matchup.views.professionalMatching.MatchingProView;

public class MatchingProController extends BaseController {

	private User user;
	private Company company;
	private Headhunter headhunter;
	private ArrayList<Job> jobsListEnterprise = new ArrayList<>();
	private ArrayList<Job> jobsListHeadhunter = new ArrayList<>();
	
	public MatchingProController (JFrame frame, Company company) {
		super.frame = frame;
		super.view = new MatchingProView(this.frame);
	}
	public MatchingProController (JFrame frame, Headhunter headhunter) {
		super.frame = frame;
		super.view = new MatchingProView(this.frame);
	}
	
	
	
	/* (non-Javadoc)
	 * @see fr.yas.matchup.controllers.BaseController#initView()
	 */
	@Override
	public void initView() {
		
		super.initView();
	}
	/* (non-Javadoc)
	 * @see fr.yas.matchup.controllers.BaseController#initEvent()
	 */
	@Override
	public void initEvent() {
		
		
		MatchingProView view = (MatchingProView) super.view;
		
		view.getBtnSeeMore1().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (user.getClass().getSimpleName()) {
				case "Company":
					ViewsManager.getInstance().next(new MatchingResultController(frame, company));
					break;
				case "Headhunter":
					ViewsManager.getInstance().next(new MatchingResultController(frame, headhunter));
					break;						
				default:
					break;
				}
				
				
			}
		});
	}
	
	
}
