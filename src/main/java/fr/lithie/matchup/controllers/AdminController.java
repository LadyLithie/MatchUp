/**
 * 
 */
package fr.lithie.matchup.controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

import fr.lithie.matchup.database.AdministratorDAO;
import fr.lithie.matchup.database.CandidateDAO;
import fr.lithie.matchup.database.EnterpriseDAO;
import fr.lithie.matchup.database.HeadhunterDAO;
import fr.lithie.matchup.database.SkillDAO;
import fr.lithie.matchup.database.base.BaseDAO;
import fr.lithie.matchup.entities.Administrator;
import fr.lithie.matchup.entities.Candidate;
import fr.lithie.matchup.entities.Enterprise;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.RegisteredUser;
import fr.lithie.matchup.entities.Skill;
import fr.lithie.matchup.entities.Validity;
import fr.lithie.matchup.entities.base.BaseEntity;
import fr.lithie.matchup.utils.views.ViewsUtils;
import fr.lithie.matchup.views.AdministratorView;
import fr.lithie.matchup.views.panels.PanelAdminSkill;
import fr.lithie.matchup.views.panels.PanelAdminUser;

/**
 * @author Audrey
 *
 */
public class AdminController extends BaseController {
	private Administrator user;
//	private List<RegisteredUser> users;

	private MouseListener mouseChangeAvatar;
	protected AdministratorView v;

	public AdminController(JFrame frame) {
		super();
		super.frame = frame;
		super.view = new AdministratorView(this.frame);
//		users = new ArrayList<>();
		v = (AdministratorView) super.view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.controllers.BaseController#initView()
	 */
	@Override
	public void initView() {
//		AdministratorView v = (AdministratorView) super.view;
		user = (Administrator) getViewDatas().get(ViewsDatasTerms.CURRENT_USER);

		/*
		 * Panel presentation Add user's informations
		 */
		v.getTextField_AdminEmail().setText(user.getEmail());
		v.getTextField_adminFirstName().setText(user.getFirstname());
		v.getTextField_AdminLastName().setText(user.getLastname());
		v.getTextField_AdminPhone().setText(String.valueOf(user.getPhone()));
		// v.getLblPhoto().setIcon(new ImageIcon(user.getAvatar()));

		/*
		 * Panel skills manager Set complete list of skills
		 */
		SkillDAO sDao = new SkillDAO();
		List<BaseEntity> skills = sDao.get();
		for (BaseEntity entity : skills) {
			PanelAdminSkill skill = new PanelAdminSkill();
			skill.setSkill((Skill) entity);
			skill.gettF_SkillName().setText(((Skill) entity).getName());
			skill.gettF_SkillType().setText(((Skill) entity).getSkillType());
			GridBagConstraints gbc_skill = new GridBagConstraints();
			gbc_skill.anchor = GridBagConstraints.BASELINE_LEADING;
			gbc_skill.gridwidth = 3;
			gbc_skill.insets = new Insets(0, 0, 0, 5);
			v.getListSkills().add(skill, gbc_skill);
			v.getSkills().add(skill);
		}

		/*
		 * Panel users Set complete list of users
		 */
		createListUsers(new AdministratorDAO(), v);
		createListUsers(new HeadhunterDAO(), v);
		createListUsers(new EnterpriseDAO(), v);
		createListUsers(new CandidateDAO(), v);

	}

	/**
	 * Create all the panelAdminUser to manage the users
	 * 
	 * @param bDao
	 *            : a user DAO
	 * @param view
	 *            : the Admin view where they will be display
	 */
	private void createListUsers(BaseDAO bDao, AdministratorView view) {
		List<BaseEntity> list = bDao.get();
		for (BaseEntity entity : list) {
			if (entity.getId() != user.getId()) {
				PanelAdminUser user = new PanelAdminUser();
				user.setUser((RegisteredUser) entity);
				user.getLblName().setText(((RegisteredUser) entity).getName());
				user.getLblEmail().setText(((RegisteredUser) entity).getEmail());
				user.getLblType().setText(entity.getClass().getSimpleName());
				GridBagConstraints gbc_user = new GridBagConstraints();
				gbc_user.fill = GridBagConstraints.HORIZONTAL;
				gbc_user.anchor = GridBagConstraints.BASELINE_LEADING;
				// gbc_user.gridwidth = 3;
				gbc_user.insets = new Insets(5, 5, 5, 5);
				view.getPanelListUsers().add(user, gbc_user);
				view.getUsers().add(user);
//				users.add((RegisteredUser) entity);
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
//		v = (AdministratorView) super.view;
//		this.mouseChangeAvatar = new MouseListener() {
//			@Override
//			public void mouseReleased(MouseEvent e) {
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				v.getLblPhoto().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				v.getLblPhoto().setToolTipText("popup de confirmation avec textfield pour new link");
//				v.getLblPhoto().setCursor(new Cursor(Cursor.HAND_CURSOR));
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("popup de confirmation avec textfield pour new link");
//			}
//		};

		/*
		 * Panel presentation
		 */
		v.getBtnEditer().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (v.getBtnEditer().getText().equals("Editer")) {
					setMode(true);
					v.getLblPhoto().addMouseListener(mouseChangeAvatar);
				} else {
					setMode(false);
					// user.setAvatar(((ImageIcon) v.getLblPhoto().getIcon()).getDescription());
					user.setFirstname(v.getTextField_adminFirstName().getText());
					user.setLastname(v.getTextField_AdminLastName().getText());
					user.setEmail(v.getTextField_AdminEmail().getText());
					user.setPhone(v.getTextField_AdminPhone().getText());
					v.getLblPhoto().removeMouseListener(mouseChangeAvatar);
					AdministratorDAO aDao = new AdministratorDAO();
					aDao.update(user);
				}
			}
		});
		v.getBtnAnnuler().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setMode(false);
				v.getTextField_AdminEmail().setText(user.getEmail());
				// v.getTextField_AdminName().setText(user.getName());
				v.getTextField_adminFirstName().setText(user.getFirstname());
				v.getTextField_AdminLastName().setText(user.getLastname());
				v.getTextField_AdminPhone().setText(String.valueOf(user.getPhone()));
				// v.getLblPhoto().setIcon(new ImageIcon(user.getAvatar()));
			}
		});

		/*
		 * Panel Skills manager
		 */
		// Add a new skill
		v.getBtnAdd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == v.getBtnAdd()) {
					PanelAdminSkill pSkill = popupAddForm(v);
//					if(pSkill.getSkill() != null) {
//						v.getListSkills().add(pSkill);
//					}
					if (pSkill.getSkill() != null) {
						pSkill.getBtnModify().addActionListener(deleteSkills(pSkill));
					}
				}
			}
		});

		for (PanelAdminSkill skillManager : v.getSkills()) {
			skillManager.getBtnModify().addActionListener(deleteSkills(skillManager));
		}

		/*
		 * Panel Users manager
		 */
		for (PanelAdminUser userManager : v.getUsers()) {
			// Validation of an user account
			if (userManager.getUser().getValid().equals(Validity.TRUE)) {
				userManager.getBtnValidateUser().setEnabled(false);
			} else {
				userManager.getBtnValidateUser().setEnabled(true);
				userManager.getBtnValidateUser().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						RegisteredUser user = userManager.getUser();
						int res = JOptionPane.showConfirmDialog(null,
								"Souhaitez-vous definitivement valider " + user.getName(), "Validation",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (res == JOptionPane.YES_OPTION) {
							user.setValid(Validity.TRUE);
							// DAO with instance :(
							BaseDAO dao;
							if (user instanceof Enterprise) {
								dao = new EnterpriseDAO();
								dao.update(user);
							} else if (user instanceof Headhunter) {
								dao = new HeadhunterDAO();
								dao.update(user);
							} else if (user instanceof Candidate) {
								dao = new CandidateDAO();
								dao.update(user);
							} else if (user instanceof Administrator) {
								dao = new AdministratorDAO();
								dao.update(user);
							}
							userManager.getBtnValidateUser().setEnabled(false);
						}
					}
				});
			}

			// Suppression of an account
			userManager.getBtnDeleteUser().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Only cosmetic for now");
					JOptionPane.showMessageDialog(null, "Only cosmetic for now", "Suppression",
							JOptionPane.INFORMATION_MESSAGE);
					// Delecte this user
					v.getPanelListUsers().remove(userManager);

					v.getPanelListUsers().validate();
				}
			});

			//Reset the user password
			userManager.getBtnResetPasswordUser().setEnabled(true);
			userManager.getBtnResetPasswordUser().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Popup with random password of 6 character
					// set this new password for the user
					RegisteredUser user = userManager.getUser();
					int res = JOptionPane.showConfirmDialog(null,
							"Confirmez le reset du mot de passe de " + user.getName(), "Validation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (res == JOptionPane.YES_OPTION) {
					//	PasswordGenerator pwdGen = new PasswordGenerator();
					//	ArrayList<CharacterRule> rule = new ArrayList<>();
					//	rule.add(new CharacterRule(EnglishCharacterData.Alphabetical, 5));
					//	rule.add(new CharacterRule(EnglishCharacterData.Digit, 2));
					//	String pwd = pwdGen.generatePassword(8, rule);
					//	JOptionPane.showMessageDialog(null, "Le nouveau mot de passe est : "+pwd, "Suppression",
					//			JOptionPane.INFORMATION_MESSAGE);
						// DAO with instance :(
						BaseDAO dao;
						if (user instanceof Enterprise) {
							dao = new EnterpriseDAO();
							dao.update(user);
						} else if (user instanceof Headhunter) {
							dao = new HeadhunterDAO();
							dao.update(user);
						} else if (user instanceof Candidate) {
							dao = new CandidateDAO();
							dao.update(user);
						} else if (user instanceof Administrator) {
							dao = new AdministratorDAO();
							dao.update(user);
						}
					}
				}
			});
		}
	}

	

	private ActionListener deleteSkills(PanelAdminSkill skillManager) {
		ActionListener result = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = skillManager.gettF_SkillName().getText();
				String type = skillManager.gettF_SkillType().getText();
				if (name.isEmpty() && type.isEmpty()) { // Delete
					System.out.println(
							"Cette compétence devrait être supprimée\n mais cela aura des conséquences sur ceux qui les utilise");
					// popup de confirmation
					if (e.getSource() == skillManager.getBtnModify()) {
						popupConfirmationSupp(skillManager, v);
					}
				} else if (name.isEmpty() || type.isEmpty()) { // Error modification
					if (name.isEmpty()) {
						skillManager.gettF_SkillName().setBackground(Color.PINK);
						skillManager.gettF_SkillType().setBackground(Color.WHITE);
					} else {
						skillManager.gettF_SkillName().setBackground(Color.WHITE);
						skillManager.gettF_SkillType().setBackground(Color.PINK);
					}
				} else { // Modification valid
					// use dao to correct in the database
					System.out.println("use dao to correct in the database");
					SkillDAO sDao = new SkillDAO();
					Skill s = skillManager.getSkill();
					s.setName(name);
					s.setSkillType(type);
					sDao.update(s);
				}
			}
		};
		return result;
	}

	private void setMode(boolean b) {
		AdministratorView v = (AdministratorView) super.view;

		v.getBtnAnnuler().setVisible(b);
		if (b) {
			v.getBtnEditer().setText("Valider");
		} else {
			v.getBtnEditer().setText("Editer");
		}

		v.getTextField_adminFirstName().setEditable(b);
		if (b) {
			v.getTextField_adminFirstName().setBorder(new TextFieldBorder());
		} else {
			v.getTextField_adminFirstName().setBorder(new EmptyBorder(0, 0, 0, 0));
		}
		v.getTextField_AdminLastName().setEditable(b);
		if (b) {
			v.getTextField_AdminLastName().setBorder(new TextFieldBorder());
		} else {
			v.getTextField_AdminLastName().setBorder(new EmptyBorder(0, 0, 0, 0));
		}
		v.getTextField_AdminPhone().setEditable(b);
		if (b) {
			v.getTextField_AdminPhone().setBorder(new TextFieldBorder());
		} else {
			v.getTextField_AdminPhone().setBorder(new EmptyBorder(0, 0, 0, 0));
		}
		v.getTextField_AdminEmail().setEditable(b);
		if (b) {
			v.getTextField_AdminEmail().setBorder(new TextFieldBorder());
		} else {
			v.getTextField_AdminEmail().setBorder(new EmptyBorder(0, 0, 0, 0));
		}
	}

	private PanelAdminSkill popupAddForm(AdministratorView v) {
		JFrame edition = new JFrame("Confirmation");
		// ConfirmMessage contentPanel = new ConfirmMessage("Etes-vous sûr de vouloir
		// supprimer la compétence "+skillManager.getSkill().getName()+" ?");
		JPanel contentPanel = new JPanel();
		ViewsUtils.popUp(edition, contentPanel);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		contentPanel.add(buttonPane, BorderLayout.SOUTH);
		// getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Annuler");
		cancelButton.setActionCommand("Non");
		buttonPane.add(cancelButton);

		JButton okButton = new JButton("Valider");
		okButton.setActionCommand("Valider");
		buttonPane.add(okButton);

		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNom = new JLabel("Nom :");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 1;
		panel.add(lblNom, gbc_lblNom);

		JTextField tF_Name = new JTextField();
		GridBagConstraints gbc_tF_Name = new GridBagConstraints();
		gbc_tF_Name.insets = new Insets(0, 0, 5, 0);
		gbc_tF_Name.fill = GridBagConstraints.BOTH;
		gbc_tF_Name.gridx = 3;
		gbc_tF_Name.gridy = 1;
		panel.add(tF_Name, gbc_tF_Name);
		tF_Name.setColumns(10);

		JLabel lblType = new JLabel("Type :");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 0, 5);
		gbc_lblType.gridx = 1;
		gbc_lblType.gridy = 3;
		panel.add(lblType, gbc_lblType);

		JTextField tF_Type = new JTextField();
		GridBagConstraints gbc_tF_Type = new GridBagConstraints();
		gbc_tF_Type.fill = GridBagConstraints.HORIZONTAL;
		gbc_tF_Type.gridx = 3;
		gbc_tF_Type.gridy = 3;
		panel.add(tF_Type, gbc_tF_Type);
		tF_Type.setColumns(10);

		edition.setVisible(true);
		edition.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
		PanelAdminSkill pSkill = new PanelAdminSkill();

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == okButton) {
					Skill skill = new Skill();
					skill.setName(tF_Name.getText());
					skill.setSkillType(tF_Type.getText());
					SkillDAO sDao = new SkillDAO();
					sDao.insert(skill);
					pSkill.gettF_SkillName().setText(skill.getName());
					pSkill.gettF_SkillType().setText(skill.getSkillType());
					pSkill.setSkill(skill);
					((AdministratorView) view).getListSkills().add(pSkill);
					v.getSkills().add(pSkill);
					edition.setVisible(false);
				}
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cancelButton) {
					pSkill.setSkill(null);
					edition.setVisible(false);
				}
			}
		});
		return pSkill;
	}

	private void popupConfirmationSupp(PanelAdminSkill skillManager, AdministratorView v) {
		JFrame edition = new JFrame("Confirmation");
		// ConfirmMessage contentPanel = new ConfirmMessage("Etes-vous s�r de vouloir
		// supprimer la comp�tence "+skillManager.getSkill().getName()+" ?");
		JPanel contentPanel = new JPanel();
		ViewsUtils.popUp(edition, contentPanel);

		JLabel lblMessage = new JLabel(
				"Etes-vous sûr de vouloir supprimer \n" + "la compétence " + skillManager.getSkill().getName() + " ?");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblMessage);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		contentPanel.add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Oui");
		okButton.setActionCommand("Oui");
		buttonPane.add(okButton);

		JButton cancelButton = new JButton("Non");
		cancelButton.setActionCommand("Non");
		buttonPane.add(cancelButton);

		edition.setVisible(true);
		edition.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == okButton) {
					v.getListSkills().remove(skillManager);
					v.getSkills().remove(skillManager);
					edition.setVisible(false);
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cancelButton) {
					skillManager.gettF_SkillName().setText(skillManager.getSkill().getName());
					skillManager.gettF_SkillType().setText(skillManager.getSkill().getSkillType());
					edition.setVisible(false);
				}
			}
		});

	}
}
