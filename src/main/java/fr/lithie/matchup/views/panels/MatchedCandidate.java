package fr.lithie.matchup.views.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class MatchedCandidate extends JPanel {

	private JTextField textFieldPrenom;
	private JTextField textFieldNom;
	private JTextField textFieldEmail;
	private JTextField textFieldMatching;
	private JTextField textFieldPhone;
	private JButton btnRetour;
	private JList<String> list;

	/**
	 * @return the list
	 */
	public JList<String> getList() {
		return list;
	}

	/**
	 * @return the textFieldPrenom
	 */
	public JTextField getTextFieldPrenom() {
		return textFieldPrenom;
	}

	/**
	 * @return the textFieldNom
	 */
	public JTextField getTextFieldNom() {
		return textFieldNom;
	}

	/**
	 * @return the textFieldEmail
	 */
	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	/**
	 * @return the textFieldMatching
	 */
	public JTextField getTextFieldMatching() {
		return textFieldMatching;
	}

	/**
	 * @return the textFieldPhone
	 */
	public JTextField getTextFieldPhone() {
		return textFieldPhone;
	}

	/**
	 * @return the btnRetour
	 */
	public JButton getBtnRetour() {
		return btnRetour;
	}

	/**
	 * Create the frame.
	 */
	public MatchedCandidate() {
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {75, 80, 100, 120, 75};
		gbl_contentPane.rowHeights = new int[] {50, 50, 50, 50, 50};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
//		JPanel contentPane = new JPanel() ;
		setLayout(gbl_contentPane);
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setIcon(new ImageIcon(MatchedCandidate.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoto.gridx = 0;
		gbc_lblPhoto.gridy = 0;
		add(lblPhoto, gbc_lblPhoto);
		
		JLabel lblPrenom = new JLabel("Prenom");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 1;
		gbc_lblPrenom.gridy = 0;
		add(lblPrenom, gbc_lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setEditable(false);
		GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
		gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenom.gridx = 2;
		gbc_textFieldPrenom.gridy = 0;
		add(textFieldPrenom, gbc_textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		JLabel lblPourcentage = new JLabel("<html>Pourcentage<br>matching</html>");
		GridBagConstraints gbc_lblPourcentage = new GridBagConstraints();
		gbc_lblPourcentage.insets = new Insets(0, 0, 5, 5);
		gbc_lblPourcentage.gridx = 3;
		gbc_lblPourcentage.gridy = 0;
		add(lblPourcentage, gbc_lblPourcentage);
		
		textFieldMatching = new JTextField();
		textFieldMatching.setEditable(false);
		GridBagConstraints gbc_textFieldMatching = new GridBagConstraints();
		gbc_textFieldMatching.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMatching.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldMatching.gridx = 4;
		gbc_textFieldMatching.gridy = 0;
		add(textFieldMatching, gbc_textFieldMatching);
		textFieldMatching.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 1;
		add(lblNom, gbc_lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setEditable(false);
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.gridx = 2;
		gbc_textFieldNom.gridy = 1;
		add(textFieldNom, gbc_textFieldNom);
		textFieldNom.setColumns(10);
				
		JLabel lblPhone = new JLabel("Téléphone");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 1;
		gbc_lblPhone.gridy = 2;
		add(lblPhone, gbc_lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setEditable(false);
		GridBagConstraints gbc_textFieldPhone = new GridBagConstraints();
		gbc_textFieldPhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPhone.gridx = 2;
		gbc_textFieldPhone.gridy = 2;
		add(textFieldPhone, gbc_textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JLabel lblCompetencePossdes = new JLabel("<html>Compétences<br />possédées</html> ");
		GridBagConstraints gbc_lblCompetencePossdes = new GridBagConstraints();
		gbc_lblCompetencePossdes.gridwidth = 2;
		gbc_lblCompetencePossdes.insets = new Insets(0, 0, 5, 0);
		gbc_lblCompetencePossdes.gridx = 3;
		gbc_lblCompetencePossdes.gridy = 1;
		add(lblCompetencePossdes, gbc_lblCompetencePossdes);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		list = new JList<>();

		scrollPane.setViewportView(list);
		
		JLabel lblAdresseEmail = new JLabel("<html>Adresse<br>e-mail</html>");
		GridBagConstraints gbc_lblAdresseEmail = new GridBagConstraints();
		gbc_lblAdresseEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresseEmail.gridx = 1;
		gbc_lblAdresseEmail.gridy = 3;
		add(lblAdresseEmail, gbc_lblAdresseEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 3;
		add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
//		btnRetour = new JButton("Retour");
//		GridBagConstraints gbc_btnRetour = new GridBagConstraints();
//		gbc_btnRetour.gridwidth = 5;
//		gbc_btnRetour.gridx = 0;
//		gbc_btnRetour.gridy = 4;
//		add(btnRetour, gbc_btnRetour);
	}

}
