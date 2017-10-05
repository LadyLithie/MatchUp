package fr.lithie.matchup.controllers.matching;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import fr.lithie.matchup.controllers.BaseController;
import fr.lithie.matchup.entities.Enterprise;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.Proposal;
import fr.lithie.matchup.entities.RegisteredUser;
import fr.lithie.matchup.managers.ViewsManager;
import fr.lithie.matchup.views.professionalMatching.MatchingProView;

public class MatchingProController extends BaseController {

	private RegisteredUser user;
	private Enterprise enterprise;
	private Headhunter headhunter;
	private ArrayList<Proposal> jobsListEnterprise = new ArrayList<>();
	private ArrayList<Proposal> jobsListHeadhunter = new ArrayList<>();
	
	public MatchingProController (JFrame frame, Enterprise enterprise) {
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
				case "Enterprise":
					ViewsManager.getInstance().next(new MatchingResultController(frame, enterprise));
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
