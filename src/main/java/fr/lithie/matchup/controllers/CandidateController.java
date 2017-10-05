package fr.lithie.matchup.controllers;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.lithie.matchup.entities.Candidate;
import fr.lithie.matchup.entities.Skill;
import fr.lithie.matchup.managers.ViewsManager;
import fr.lithie.matchup.utils.views.ViewsUtils;
import fr.lithie.matchup.views.CandidateView;

public class CandidateController extends BaseController {

	private Candidate c;
	private ArrayList<Skill> skills = new ArrayList<>();


	public CandidateController(JFrame frame) {

		super.frame = frame;
		super.view = new CandidateView(frame);
		c = (Candidate) getViewDatas().get(ViewsDatasTerms.CURRENT_USER);
		
	}
	
	/* (non-Javadoc)
	 * @see fr.yas.matchup.controllers.BaseController#initView()
	 */
	@Override
	public void initView() {
		// TODO Auto-generated method stub
		c = (Candidate) getViewDatas().get(ViewsDatasTerms.CURRENT_USER);
		CandidateView view = (CandidateView) getView();		
		
		view.getMenuBar().getLblUserName().setText(c.getFirstname());
		view.getTextFieldFirstname().setText(c.getFirstname());
		view.getTextFieldLastname().setText(c.getLastname());
		view.getTextFieldMail().setText(c.getEmail());
		view.getTextFieldPhone().setText(c.getPhone());
		view.getTextArea().setText(c.getPresentation());
	}
	

	public void initEvent() {
		CandidateView view = (CandidateView) super.view;

		// Mode Edition On/Off
		view.getBtnEdit().addActionListener(new ActionListener() {
			private boolean bool = false;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (bool == false) {
					if (e.getSource() == view.getBtnEdit()) {
						view.getTextArea().setEditable(true);
						view.getTextFieldFirstname().setEditable(true);
						view.getTextFieldLastname().setEditable(true);
						view.getTextFieldMail().setEditable(true);
						view.getTextFieldPhone().setEditable(true);

						bool = true;
					}
				} else {
					if (e.getSource() == view.getBtnEdit()) {
						view.getTextArea().setEditable(false);
						view.getTextFieldFirstname().setEditable(false);
						view.getTextFieldLastname().setEditable(false);
						view.getTextFieldMail().setEditable(false);
						view.getTextFieldPhone().setEditable(false);

						bool = false;
					}

				}
			}

		});

		view.getBtnSelectSkill().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (e.getSource() == view.getBtnSelectSkill()) {
					view.getTable().setEnabled(true);
					view.getBtnAnnulerButton().setEnabled(true);

					view.getBtnSelectSkill().setVisible(false);

					JButton btnValidateSkill = new JButton("Valider");
					Dimension preferredSize = new Dimension(180, 25);
					btnValidateSkill.setPreferredSize(preferredSize);
					GridBagConstraints gbc_btnSelectSkill = new GridBagConstraints();
					gbc_btnSelectSkill.insets = new Insets(0, 0, 0, 5);
					gbc_btnSelectSkill.gridx = 1;
					gbc_btnSelectSkill.gridy = 16;
					view.getContentPane().add(btnValidateSkill, gbc_btnSelectSkill);

					btnValidateSkill.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (e.getSource() == btnValidateSkill) {
								// TODO Auto-generated method stub
								view.getBtnAnnulerButton().setEnabled(false);
								view.getBtnSelectSkill().setVisible(true);
								view.getTable().setEnabled(false);
								view.getBtnSelectSkill().setText("Sélectionner Skill");
								btnValidateSkill.setVisible(false);

							}
						}
					});

					view.getBtnAnnulerButton().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							// TODO Auto-generated method stub
							if (e.getSource() == view.getBtnAnnulerButton()) {
								view.getBtnAnnulerButton().setEnabled(false);
								view.getBtnSelectSkill().setVisible(true);
								view.getTable().setEnabled(false);
								view.getBtnSelectSkill().setText("S�lectionner Skill");
								btnValidateSkill.setVisible(false);
							}

						}
					});

				}
			}
		});

		view.getLinkLinkedin().addMouseListener(new MouseListener() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				view.getLinkLinkedin().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				view.getLinkLinkedin().setCursor(new Cursor(Cursor.HAND_CURSOR));
				view.getLinkLinkedin()
						.setText(String.format("<HTML><FONT color = \"#000099\"><U>%s</U></FONT></HTML>", ""));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					URI uri = new URI(view.getNameLinkLinkedin());
					if (Desktop.isDesktopSupported())
						Desktop.getDesktop().browse(uri);
				} catch (Exception e2) {
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		view.getLinkLinkedin().setToolTipText(String.format("go to %s", view.getNameLinkLinkedin()));
		
		

	
		view.getLinkTwitter().addMouseListener(new MouseListener() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				view.getLinkTwitter().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				view.getLinkTwitter().setCursor(new Cursor(Cursor.HAND_CURSOR));
				view.getLinkTwitter()
						.setText(String.format("<HTML><FONT color = \"#000099\"><U>%s</U></FONT></HTML>", ""));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					URI uri = new URI(view.getNameLinkTwitter());
					if (Desktop.isDesktopSupported())
						Desktop.getDesktop().browse(uri);
				} catch (Exception e2) {
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		view.getLinkTwitter().setToolTipText(String.format("go to %s", view.getNameLinkTwitter()));
	

	
		// TODO Auto-generated method stub
		view.getLinkViadeo().addMouseListener(new MouseListener() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				view.getLinkViadeo().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				view.getLinkViadeo().setCursor(new Cursor(Cursor.HAND_CURSOR));
				view.getLinkViadeo()
						.setText(String.format("<HTML><FONT color = \"#000099\"><U>%s</U></FONT></HTML>", ""));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					URI uri = new URI(view.getNameLinkViadeo());
					if (Desktop.isDesktopSupported())
						Desktop.getDesktop().browse(uri);
				} catch (Exception e2) {
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		view.getLinkViadeo().setToolTipText(String.format("go to %s",view.getNameLinkViadeo()));
	

	
		// TODO Auto-generated method stub
		view.getBtnEditLink().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == view.getBtnEditLink()) {

					JFrame edition = new JFrame("Edition des r�seaux sociaux");
					JPanel contentPanel = new JPanel();
					ViewsUtils.popUp(edition, contentPanel);

					GridBagLayout gbl_contentPane = new GridBagLayout();
					gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
					gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
					gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
					gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
					contentPanel.setLayout(gbl_contentPane);

					ImageIcon image = new ImageIcon("image/linkedin-icon2.png");
					JLabel imageJlabel = new JLabel();
					imageJlabel.setIcon(image);
					GridBagConstraints gbc_1 = new GridBagConstraints();
					gbc_1.fill = GridBagConstraints.CENTER;
					gbc_1.gridx = 1;
					gbc_1.gridy = 1;
					contentPanel.add(imageJlabel, gbc_1);

					JTextField newlink = new JTextField();
					GridBagConstraints gbc_2 = new GridBagConstraints();
					gbc_2.fill = GridBagConstraints.BOTH;
					gbc_2.gridx = 2;
					gbc_2.gridy = 1;
					contentPanel.add(newlink, gbc_2);

					ImageIcon image2 = new ImageIcon("image/Twitterbird2.png");
					JLabel imageJlabel2 = new JLabel();
					imageJlabel2.setIcon(image2);
					GridBagConstraints gbc_3 = new GridBagConstraints();
					gbc_3.fill = GridBagConstraints.CENTER;
					gbc_3.gridx = 1;
					gbc_3.gridy = 2;
					contentPanel.add(imageJlabel2, gbc_3);

					GridBagConstraints gbc_4 = new GridBagConstraints();
					gbc_4.fill = GridBagConstraints.BOTH;
					gbc_4.gridx = 2;
					gbc_4.gridy = 2;
					contentPanel.add(new JTextField(), gbc_4);

					ImageIcon image3 = new ImageIcon("image/viadeo.png");
					JLabel imageJlabel3 = new JLabel();
					imageJlabel3.setIcon(image3);
					GridBagConstraints gbc_5 = new GridBagConstraints();
					gbc_5.fill = GridBagConstraints.CENTER;
					gbc_5.gridx = 1;
					gbc_5.gridy = 3;
					contentPanel.add(imageJlabel3, gbc_5);

					GridBagConstraints gbc_6 = new GridBagConstraints();
					gbc_6.fill = GridBagConstraints.BOTH;
					gbc_6.gridx = 2;
					gbc_6.gridy = 3;
					contentPanel.add(new JTextField(), gbc_6);

					JButton validate = new JButton("Valider");
					GridBagConstraints gbc_7 = new GridBagConstraints();
					gbc_7.fill = GridBagConstraints.CENTER;
					gbc_7.gridx = 1;
					gbc_7.gridy = 4;
					contentPanel.add(validate, gbc_7);

					JButton cancel = new JButton("Annuler");
					GridBagConstraints gbc_8 = new GridBagConstraints();
					gbc_8.fill = GridBagConstraints.BOTH;
					gbc_8.gridx = 2;
					gbc_8.gridy = 4;
					contentPanel.add(cancel, gbc_8);

					edition.setVisible(true);
					edition.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					cancel.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e1) {
							// TODO Auto-generated method stub
							if (e1.getSource() == cancel) {
								edition.setVisible(false);
							}
						}
					});

					validate.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e2) {
							// TODO Auto-generated method stub
							if (e2.getSource() == validate) {
								view.setNameLinkLinkedin(newlink.getText());
								view.setNameLinkTwitter(newlink.getText());
								view.setNameLinkViadeo(newlink.getText());
								edition.setVisible(false);
							}
						}
					});

				}
			}
		});
		
		
		view.getMenuBar().getNavigationBar().getBtnGoToMatching().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ViewsManager.getInstance().next(new ProfessionalMatchingController());
			}
		});
	}



	
}
