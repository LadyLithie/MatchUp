/**
 * 
 */
package fr.lithie.matchup.controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.lithie.matchup.database.EnterpriseDAO;
import fr.lithie.matchup.entities.Enterprise;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.Proposal;
import fr.lithie.matchup.managers.ViewsManager;
import fr.lithie.matchup.utils.views.ActionModSocialLink;
import fr.lithie.matchup.utils.views.ViewsUtils;
import fr.lithie.matchup.views.CompanyView;
import fr.lithie.matchup.views.panels.PanelFieldsButton;
import fr.lithie.matchup.views.panels.PanelHeadhunters;
import fr.lithie.matchup.views.panels.PanelListJobs;
import fr.lithie.matchup.views.panels.PanelPresentation;
import fr.lithie.matchup.views.panels.PanelResumeJob;

/**
 * @author Audrey
 *
 */
public class CompanyController extends BaseController {
	private Enterprise user;
	private ArrayList<Headhunter> headhunters = new ArrayList<>();
	private ArrayList<PanelFieldsButton> pHeadhunters = new ArrayList<>();
	private ArrayList<PanelResumeJob> pJobs = new ArrayList<>();

	/**
	 * Nested class for shared ActionListener
	 * 
	 * @author Audrey
	 *
	 */
	class deleteHHListener implements ActionListener {
		private PanelHeadhunters view;
		private Component headhunter;

		public deleteHHListener(PanelHeadhunters view, Component headhunter) {
			this.view = view;
			this.headhunter = headhunter;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// identify the headhunter and remove it from the user list

			// remove it graphically
			view.getPanelContent().remove(headhunter);
			view.getPanelContent().revalidate();
			pHeadhunters.remove(headhunter);
		};
	}

	/**
	 * 
	 * @param frame
	 */
	public CompanyController(JFrame frame) {
		super();
		super.frame = frame;
//		user = (Enterprise) getViewDatas().get(ViewsDatasTerms.CURRENT_USER);
		super.view = new CompanyView(this.frame);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.controllers.BaseController#initView()
	 */
	@Override
	public void initView() {
		user = (Enterprise) getViewDatas().get(ViewsDatasTerms.CURRENT_USER);
		CompanyView v = (CompanyView) getView();

		// MenuBar
		v.getMenuBar().getLblWelcome().setVisible(false);

		
		/*
		 * Panel presentation Add user's informations
		 */
		PanelPresentation vP = ((PanelPresentation) v.getPanel_TopRight());
		vP.getNamePanel().getInput().setText(user.getName());
		vP.getPhonePanel().getInput().setText(user.getPhone());
		vP.getAddressPanel().getInput().setText(user.getAddress());
		vP.getEmailPanel().getInput().setText(user.getEmail());
		vP.getWebsitePanel().getInput().setText(user.getWebsite());
		vP.getSiretPanel().getInput().setText(user.getSiretNumber());
		vP.getTextAreaPresentation().setText(user.getPresentation());

		/*
		 * Panel headhunters Create the list of headhunter working for the company
		 */
		PanelHeadhunters vH = (PanelHeadhunters) v.getPanel_bottomRight();
		if (user.getAssociates() != null) {
			pHeadhunters = new ArrayList<>();
			for (Headhunter headhunter : user.getAssociates()) {
				// posX = posX + 2;
				PanelFieldsButton test = new PanelFieldsButton("Headhunter: ", "Supprimer");
				test.getTextField1().setText(headhunter.getFirstname());
				test.getTextField2().setText(headhunter.getLastname());
				GridBagConstraints gbc_test = new GridBagConstraints();
				gbc_test.fill = GridBagConstraints.NONE;
				gbc_test.anchor = GridBagConstraints.CENTER;
				gbc_test.gridx = 1;
				gbc_test.gridy = GridBagConstraints.RELATIVE;
				vH.getPanelContent().add(test, gbc_test);
				//add all to sub-panel
				vH.getAssociates().add(test);
				pHeadhunters.add(test);
			}
		}
		vH.setMode(false);

		/*
		 * Panel jobs Create the list of jobs
		 */
		PanelListJobs vListJobs = (PanelListJobs) v.getPanel_left();
		if (user.getJobs() != null) {
			pJobs = new ArrayList<>();
			for (Proposal Ujob : user.getJobs()) {
				PanelResumeJob job = new PanelResumeJob(Ujob);
				job.setPreferredSize(new Dimension(130, 170));
				job.getLblLink().setText("Contact");
				GridBagConstraints gbc_job = new GridBagConstraints();
				gbc_job.anchor = GridBagConstraints.NORTHEAST;
				vListJobs.getPanelJobs().add(job, gbc_job);
				vListJobs.getPanelJobs().getResumeJobs().add(job);
				pJobs.add(job);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.controllers.BaseController#initEvent()
	 */
	@Override
	public void initEvent() {
		CompanyView v = (CompanyView) super.view;
		/*
		 * MenuBar
		 */
		v.getMenuBar().getNavigationBar().getBtnGoToMatching().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ViewsManager.getInstance().next(new ProMatchingHomeController(frame));
			}
		});

		
		/*
		 * Panel Presentation 
		 * 					Define the action on the buttons
		 */
		PanelPresentation vPresentation = (PanelPresentation) v.getPanel_TopRight();
		// mode view
		vPresentation.getBtnEdit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vPresentation.getBtnEdit().getText().equals("Editer")) {
					vPresentation.setMode(true);
					//remove listener?
				} else {
					// Mode modification : valid change
					vPresentation.setMode(false);
					user.setName(vPresentation.getNamePanel().getInput().getText());
					if (!user.setSiretNumber(vPresentation.getSiretPanel().getInput().getText())) {
						vPresentation.getSiretPanel().getInput().setText(user.getSiretNumber());
					}
					user.setAddress(vPresentation.getAddressPanel().getInput().getText());
					//Will need testing for numeric string
					user.setPhone(vPresentation.getPhonePanel().getInput().getText());
					user.setWebsite(vPresentation.getWebsitePanel().getInput().getText());
					user.setPresentation(vPresentation.getTextAreaPresentation().getText());
					
					EnterpriseDAO eDao = new EnterpriseDAO();
					eDao.update(user);
				}
			}
		});

		vPresentation.getBtnAnnuler().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vPresentation.setMode(false);
				vPresentation.getNamePanel().getInput().setText(user.getName());
				vPresentation.getSiretPanel().getInput().setText(user.getSiretNumber());
				vPresentation.getWebsitePanel().getInput().setText(user.getWebsite());
				vPresentation.getTextAreaPresentation().setText(user.getPresentation());
			}
		});
		//Modif avatar
		vPresentation.getBtnModifier().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO popup
				String chemin = popupCheminAvatar();
				vPresentation.getLblIcon().setIcon(new ImageIcon(chemin));
//				user.setAvatar(chemin);
			}
		});
		//Modif Social Networks
		ActionListener sNetworkLinks = new ActionModSocialLink();
		vPresentation.getBtnAjout().addActionListener(sNetworkLinks);
		//need to add icon with external links

		/*
		 * Panel Head-hunters Define the action on the buttons
		 */
		PanelHeadhunters vHeadhunters = (PanelHeadhunters) v.getPanel_bottomRight();
		// Switch between display and modification view
		vHeadhunters.getBtnEdit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vHeadhunters.getBtnEdit().getText().equalsIgnoreCase("Editer")) {
					vHeadhunters.setMode(true);
				} else {
					// assign to the entity the new associates
					if (user.getAssociates() == null) {
						user.setAssociates(headhunters);
					} else { // need test if already present
						user.getAssociates().addAll(headhunters);
					}
					headhunters = new ArrayList<>();
					// assign on the EnterpriseView the new associates panels
					if (vHeadhunters.getAssociates() == null) {
						vHeadhunters.setAssociates(pHeadhunters);
					} else {
						vHeadhunters.getAssociates().addAll(pHeadhunters);
					}
					for (PanelFieldsButton headhunter : pHeadhunters) {
						headhunter.setMode(false);
					}
					System.out.println(vHeadhunters.getAssociates().size());
					// //v.getContentPane().remove(vHeadhunters);
					// v.setPanel_bottomRight(vHeadhunters);
					vHeadhunters.setMode(false);
					//record in database
					/* Bug with id=0, 
					 * we must test if allready exist to add it's id
					 * if not we may want to create a new one before adding it (login=first+last & pwd = random passay or ask for mailing?)
					 */
					EnterpriseDAO eDao = new EnterpriseDAO();
					eDao.insertHeadhunter(user);
				}
			}
		});
		// Switch back to display without registering change
		vHeadhunters.getBtnAnnuler().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vHeadhunters.setMode(false);
				// need to add re-initialization of panel
				for (PanelFieldsButton hh : pHeadhunters) {
					vHeadhunters.getPanelContent().remove(hh);
				}
				pHeadhunters = vHeadhunters.getAssociates();
				for (PanelFieldsButton headhunter : pHeadhunters) {
					GridBagConstraints gbc_temp = new GridBagConstraints();
					gbc_temp.fill = GridBagConstraints.HORIZONTAL;
					gbc_temp.anchor = GridBagConstraints.CENTER;
					gbc_temp.gridx = 1;
					gbc_temp.gridy = GridBagConstraints.RELATIVE;
					vHeadhunters.getPanelContent().add(headhunter,gbc_temp);
				}
				headhunters = new ArrayList<>();
			}
		});
		// Add new one
		vHeadhunters.getNewHeadHunter().getButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Headhunter newHH = new Headhunter();
				boolean valid = true;
				// System.err.println(vHeadhunters.getNewHeadHunter().getTextField1().getText().isEmpty());
				// test submitted textfield for blank which provoke PINK background and invalid
				// object
				// firstname
				if (!vHeadhunters.getNewHeadHunter().getTextField1().getText().isEmpty()) {
					vHeadhunters.getNewHeadHunter().getTextField1().setBackground(Color.WHITE);
				} else {
					vHeadhunters.getNewHeadHunter().getTextField1().setBackground(Color.PINK);
					valid = false;
				}
				// lastname
				// System.err.println(vHeadhunters.getNewHeadHunter().getTextField2().getText().isEmpty());
				if (!vHeadhunters.getNewHeadHunter().getTextField2().getText().isEmpty()) {
					vHeadhunters.getNewHeadHunter().getTextField2().setBackground(Color.WHITE);
				} else {
					vHeadhunters.getNewHeadHunter().getTextField2().setBackground(Color.PINK);
					valid = false;
				}

				// email
				// System.err.println(vHeadhunters.getNewHeadHunter().getTextFieldMail().getText().isEmpty());
				if (!vHeadhunters.getNewHeadHunter().getTextFieldMail().getText().isEmpty()) {
					vHeadhunters.getNewHeadHunter().getTextFieldMail().setBackground(Color.WHITE);
				} else {
					vHeadhunters.getNewHeadHunter().getTextFieldMail().setBackground(Color.PINK);
					valid = false;
				}
				// If valid, we add the headhunter to the view list and reinitialize the new
				// headhunter
				if (valid) {
					newHH.setFirstname(vHeadhunters.getNewHeadHunter().getTextField1().getText());
					newHH.setLastname(vHeadhunters.getNewHeadHunter().getTextField2().getText());
					newHH.setEmail(vHeadhunters.getNewHeadHunter().getTextFieldMail().getText());
					headhunters.add(newHH);

					PanelFieldsButton test = new PanelFieldsButton("Headhunter", "Supprimer");
					test.getTextField1().setText(newHH.getFirstname());
					test.getTextField2().setText(newHH.getLastname());
					test.getTextFieldMail().setText(newHH.getEmail());
					test.getButton().addActionListener(new deleteHHListener(vHeadhunters, test));
					GridBagConstraints gbc_test = new GridBagConstraints();
					gbc_test.fill = GridBagConstraints.HORIZONTAL;
					gbc_test.anchor = GridBagConstraints.CENTER;
					gbc_test.gridx = 1;
					gbc_test.gridy = GridBagConstraints.RELATIVE;
					// System.out.println(vHeadhunters.getComponentCount());
					vHeadhunters.getPanelContent().add(test, gbc_test);
					pHeadhunters.add(test);

					vHeadhunters.getNewHeadHunter().getTextField1().setText("");
					vHeadhunters.getNewHeadHunter().getTextField2().setText("");
					vHeadhunters.getNewHeadHunter().getTextFieldMail().setText("");
					vHeadhunters.revalidate();
				}
			}
		});
		// Delete a listed one
		for (PanelFieldsButton headhunter : pHeadhunters) {
			headhunter.getButton().addActionListener(new deleteHHListener(vHeadhunters, headhunter));
		}

		/*
		 * Panel Jobs Define the action on the buttons
		 */
		PanelListJobs vListJobs = (PanelListJobs) v.getPanel_left();
		vListJobs.addComponentListener(new ComponentAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.ComponentAdapter#componentResized(java.awt.event.
			 * ComponentEvent)
			 */
			@Override
			public void componentResized(ComponentEvent e) {
				int width = vListJobs.getWidth();
				// System.out.println(vListJobs.getPanelJobs().getSize());
				// System.out.println("the listJobs width = "+width);
				vListJobs.getPanelJobs()
						.setPreferredSize(new Dimension(width - 5, vListJobs.getPanelJobs().getSize().height));
				vListJobs.validate();
				vListJobs.getPanelJobs().validate();
			}
		});
		vListJobs.getBtnAdd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewsManager.getInstance().next(new ProposalController(frame));
			}
		});
		for (PanelResumeJob resumeJob : vListJobs.getPanelJobs().getResumeJobs()) {
			resumeJob.getBtnEditer().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ViewsManager.getInstance().next(new ProposalController(frame, resumeJob.getJob()));
				}
			});
		}
	}

	private String popupCheminAvatar() {
		JFrame edition = new JFrame("Confirmation");
		// ConfirmMessage contentPanel = new ConfirmMessage("Etes-vous s�r de vouloir
		// supprimer la comp�tence "+skillManager.getSkill().getName()+" ?");
		JPanel contentPanel = new JPanel();
		ViewsUtils.popUp(edition, contentPanel);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		contentPanel.add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Oui");
		okButton.setActionCommand("Oui");
		buttonPane.add(okButton);

		JButton cancelButton = new JButton("Non");
		cancelButton.setActionCommand("Non");
		buttonPane.add(cancelButton);
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel lblMessage = new JLabel("Indiquer le chemin de votre image :");
		lblMessage.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblMessage);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		edition.setVisible(true);
		edition.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == okButton) {
//					final result = textField.getText();
					edition.setVisible(false);
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cancelButton) {
//					result = "";
					textField.setText("");
					edition.setVisible(false);
				}
			}
		});
		String result = textField.getText();
		return result;

	}

}
