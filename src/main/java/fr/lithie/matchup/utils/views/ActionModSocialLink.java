/**
 * 
 */
package fr.lithie.matchup.utils.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.lithie.matchup.views.CandidateView;
import fr.lithie.matchup.views.base.BaseView;

/**
 * @author Audrey
 *
 */
public class ActionModSocialLink implements ActionListener {
	public static final String VIADEO = "Viadeo";
	public static final String TWITTER = "Twitter";
	public static final String LINKEDIN = "LinkedIn";
	private BaseView view;
	private HashMap<String, String> links;

	/**
	 * @return the links
	 */
	public HashMap<String, String> getLinks() {
		return links;
	}
	
	public ActionModSocialLink() {
		links = new HashMap<>();
	}

	public ActionModSocialLink(BaseView view) {
		this.view = view;
		links = new HashMap<>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		if (e.getSource() == view.getBtnEditLink()) {

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

			JTextField tFieldTwitter = new JTextField();
			GridBagConstraints gbc_4 = new GridBagConstraints();
			gbc_4.fill = GridBagConstraints.BOTH;
			gbc_4.gridx = 2;
			gbc_4.gridy = 2;
			contentPanel.add(tFieldTwitter, gbc_4);

			ImageIcon image3 = new ImageIcon("image/viadeo.png");
			JLabel imageJlabel3 = new JLabel();
			imageJlabel3.setIcon(image3);
			GridBagConstraints gbc_5 = new GridBagConstraints();
			gbc_5.fill = GridBagConstraints.CENTER;
			gbc_5.gridx = 1;
			gbc_5.gridy = 3;
			contentPanel.add(imageJlabel3, gbc_5);

			JTextField tFieldViadeo = new JTextField();
			GridBagConstraints gbc_6 = new GridBagConstraints();
			gbc_6.fill = GridBagConstraints.BOTH;
			gbc_6.gridx = 2;
			gbc_6.gridy = 3;
			contentPanel.add(tFieldViadeo, gbc_6);

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
						if(view instanceof CandidateView) {
							((CandidateView) view).setNameLinkLinkedin(newlink.getText());
							((CandidateView) view).setNameLinkTwitter(newlink.getText());
							
						}else {
							links.put(LINKEDIN, newlink.getText());
							links.put(TWITTER, tFieldTwitter.getText());
							links.put(VIADEO, tFieldViadeo.getText());
						}
						
						edition.setVisible(false);
					}
				}
			});

		}
//	}

}
