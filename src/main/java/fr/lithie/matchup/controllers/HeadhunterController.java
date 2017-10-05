package fr.lithie.matchup.controllers;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.lithie.matchup.database.HeadhunterDAO;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.Proposal;
import fr.lithie.matchup.entities.base.BaseEntity;
import fr.lithie.matchup.managers.ViewsManager;
import fr.lithie.matchup.views.headhunter.HeadhunterView;
import fr.lithie.matchup.views.panels.PanelHeadhunterPresentation;
import fr.lithie.matchup.views.panels.PanelLinkedEnterprises;
import fr.lithie.matchup.views.panels.PanelListJobs;
import fr.lithie.matchup.views.panels.PanelResumeJob;




public class HeadhunterController extends BaseController {

	private Headhunter user;
//	private Proposal job;
	private PanelListJobs panel_JobList;
	private PanelHeadhunterPresentation panel_HeadhunterPresentation;
	private PanelLinkedEnterprises panel_LinkedEnterprises;
	private ArrayList<Proposal> jobs;
	private ArrayList<PanelResumeJob> pJobs = new ArrayList<>();
	
	
	
	public HeadhunterController (JFrame frame) {
		super.frame = frame;
		super.view = new HeadhunterView(this.frame);
		user = (Headhunter) getViewDatas().get(ViewsDatasTerms.CURRENT_USER);
	}
	
	/* (non-Javadoc)
	 * @see fr.yas.matchup.controllers.BaseController#initView()
	 */
	
	@Override
	public void initView() {
		
		
		user = (Headhunter) getViewDatas().get(ViewsDatasTerms.CURRENT_USER);
		HeadhunterView view = ((HeadhunterView) getView());
		
		panel_HeadhunterPresentation = (PanelHeadhunterPresentation) view.getPanel_HeadhunterPresentation();
		
		view.getPanel_HeadhunterPresentation().getTextField_Firstname().setText(user.getFirstname());
		view.getPanel_HeadhunterPresentation().getTextField_Lastname().setText(user.getLastname());
		view.getPanel_HeadhunterPresentation().getTextField_Email().setText(user.getEmail());
		view.getPanel_HeadhunterPresentation().getTextField_Phone().setText(user.getPhone());
		view.getPanel_HeadhunterPresentation().getTextField_Linkedin().setText(user.getLinkedin());
		view.getPanel_HeadhunterPresentation().getTextField_Twitter().setText(user.getTwitter());
		view.getPanel_HeadhunterPresentation().getTextArea_Presentation().setText(user.getPresentation());
		
		
		panel_JobList = (PanelListJobs) view.getPanel_JobList();
		
		if (user.getJobs() != null) {
			
			pJobs = new ArrayList<>();
			
			for (Proposal job : user.getJobs()) {
				
				PanelResumeJob unJob = new PanelResumeJob(job);
				
				unJob.setPreferredSize(new Dimension(150, 150));
				unJob.getLblLink().setText("Entreprise");
				unJob.getTextField().setText(job.getName());
				GridBagConstraints gbc_UnJob = new GridBagConstraints();
				gbc_UnJob.anchor = GridBagConstraints.NORTHWEST;
				panel_JobList.getPanelJobs().add(unJob, gbc_UnJob);
				panel_JobList.getPanelJobs().getResumeJobs().add(unJob);
				pJobs.add(unJob);
				
			}
			
		}
		
//		panel_LinkedEnterprises = (JPanel) view.getPanel_LinkedEnterprises();
//		
//		List<BaseEntity> associates = new List<BaseEntity> get();
//		if (user.getAssociates() != null) {
//			
//			for (Enterprise enterprise : associates) {
//				
//				PanelEnterpriseAssociated uneEntreprise = new PanelEnterpriseAssociated(enterprise);
//				uneEntreprise.getLblEnterpriseName().setText(enterprise.getName());
//			}
//			
//		}
		
		

		
		
		//view.getPanel_LinkedEnterprises().getPanelContentListEnterprise().;
		
	
	
	/* (non-Javadoc)
	 * @see fr.yas.matchup.controllers.BaseController#initEvent()
	 */
	}
		
	@Override
	public void initEvent() {
		
		HeadhunterView view = (HeadhunterView) super.view;
		
		
		view.getPanel_HeadhunterPresentation().getBtnEditPresentation().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.getPanel_HeadhunterPresentation().getBtnAnnuler().setVisible(true);
				view.getPanel_HeadhunterPresentation().getBtnValider().setVisible(true);
				view.getPanel_HeadhunterPresentation().getBtnEditPresentation().setVisible(false);
				view.getPanel_HeadhunterPresentation().getTextField_Firstname().setEditable(true);
				view.getPanel_HeadhunterPresentation().getTextField_Lastname().setEditable(true);
				view.getPanel_HeadhunterPresentation().getTextField_Email().setEditable(true);
				view.getPanel_HeadhunterPresentation().getTextField_Phone().setEditable(true);
				view.getPanel_HeadhunterPresentation().getTextField_Linkedin().setEditable(true);
				view.getPanel_HeadhunterPresentation().getTextField_Twitter().setEditable(true);
				view.getPanel_HeadhunterPresentation().getTextArea_Presentation().setEditable(true);
			}
		});
		
		view.getPanel_HeadhunterPresentation().getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				initView();
				
				view.getPanel_HeadhunterPresentation().getBtnAnnuler().setVisible(false);
				view.getPanel_HeadhunterPresentation().getBtnValider().setVisible(false);
				view.getPanel_HeadhunterPresentation().getBtnEditPresentation().setVisible(true);
				view.getPanel_HeadhunterPresentation().getTextField_Firstname().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextField_Lastname().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextField_Email().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextField_Phone().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextField_Linkedin().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextField_Twitter().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextArea_Presentation().setEditable(false);
				
			}
		});
		
		view.getPanel_HeadhunterPresentation().getBtnValider().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				user.setFirstname(view.getPanel_HeadhunterPresentation().getTextField_Firstname().getText());
				user.setLastname(view.getPanel_HeadhunterPresentation().getTextField_Lastname().getText());
				user.setEmail(view.getPanel_HeadhunterPresentation().getTextField_Email().getText());
				user.setPhone(view.getPanel_HeadhunterPresentation().getTextField_Phone().getText());
				user.setLinkedin(view.getPanel_HeadhunterPresentation().getTextField_Linkedin().getText());
				user.setTwitter(view.getPanel_HeadhunterPresentation().getTextField_Twitter().getText());
				user.setPresentation(view.getPanel_HeadhunterPresentation().getTextArea_Presentation().getText());
				
				HeadhunterDAO dao = new HeadhunterDAO();
				List<BaseEntity> hunters = dao.get();
				
				for (BaseEntity baseEntity : hunters) {
					Headhunter user = ((Headhunter) baseEntity);
					user.setFirstname(view.getPanel_HeadhunterPresentation().getTextField_Firstname().getText());
					user.setLastname(view.getPanel_HeadhunterPresentation().getTextField_Lastname().getText());
					user.setEmail(view.getPanel_HeadhunterPresentation().getTextField_Email().getText());
					user.setPhone(view.getPanel_HeadhunterPresentation().getTextField_Phone().getText());
					user.setLinkedin(view.getPanel_HeadhunterPresentation().getTextField_Linkedin().getText());
					user.setTwitter(view.getPanel_HeadhunterPresentation().getTextField_Twitter().getText());
					user.setPresentation(view.getPanel_HeadhunterPresentation().getTextArea_Presentation().getText());
					dao.update(user);
				}
				
				view.getPanel_HeadhunterPresentation().getBtnAnnuler().setVisible(false);
				view.getPanel_HeadhunterPresentation().getBtnValider().setVisible(false);
				view.getPanel_HeadhunterPresentation().getBtnEditPresentation().setVisible(true);
				view.getPanel_HeadhunterPresentation().getTextField_Firstname().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextField_Lastname().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextField_Email().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextField_Phone().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextField_Linkedin().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextField_Twitter().setEditable(false);
				view.getPanel_HeadhunterPresentation().getTextArea_Presentation().setEditable(false);
				
				initView();
				
			}
		});
		
		view.getPanel_LinkedEnterprises().getBtnEditer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.getPanel_LinkedEnterprises().getBtnAnnuler().setVisible(true);
				
			}
		});
		
		view.getPanel_LinkedEnterprises().getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.getPanel_LinkedEnterprises().getBtnAnnuler().setVisible(false);
				initView();
				
			}
		});
		
		
		view.getPanel_JobList().getBtnAdd().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewsManager.getInstance().next(new ProposalController(frame));
			}
		});
	}
	
	
}
