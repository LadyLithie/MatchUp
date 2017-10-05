package fr.lithie.matchup.views.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

import fr.lithie.matchup.views.base.IVisibility;

import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class PanelPresentation extends JPanel implements IVisibility {
	private GridBagLayout gridBagLayout;

	private PanelField namePanel;
	private PanelField siretPanel;
	private PanelField emailPanel;
	private PanelField websitePanel;
	private PanelField addressPanel;
	private PanelField phonePanel;

	private JLabel lblLogo;
	private JButton btnModifier;

	private JLabel lblIcon;
	private JButton btnAjout;
	private JTextField textFieldNetwork;

	private JButton btnAnnuler;
	private JButton btnEditer;

	private JTextArea textAreaPresentation;
	private JPanel panelInfos;
	private JPanel panelSocio;


	/**
	 * @return the btnEditer
	 */
	public JButton getBtnEdit() {
		return btnEditer;
	}

	/**
	 * @return the textAreaPresentation
	 */
	public JTextArea getTextAreaPresentation() {
		return textAreaPresentation;
	}

	/**
	 * @return the namePanel
	 */
	public PanelField getNamePanel() {
		return namePanel;
	}

	/**
	 * @return the siretPanel
	 */
	public PanelField getSiretPanel() {
		return siretPanel;
	}

	/**
	 * @return the emailPanel
	 */
	public PanelField getEmailPanel() {
		return emailPanel;
	}

	/**
	 * @return the websitePanel
	 */
	public PanelField getWebsitePanel() {
		return websitePanel;
	}

	/**
	 * @return the lblLogo
	 */
	public JLabel getLblLogo() {
		return lblLogo;
	}

	/**
	 * @return the btnModifier
	 */
	public JButton getBtnModifier() {
		return btnModifier;
	}

	/**
	 * @return the lblIcon
	 */
	public JLabel getLblIcon() {
		return lblIcon;
	}

	/**
	 * @return the btnAjout
	 */
	public JButton getBtnAjout() {
		return btnAjout;
	}

	/**
	 * @return the textFieldNetwork
	 */
	public JTextField getTextFieldNetwork() {
		return textFieldNetwork;
	}

	/**
	 * @return the btnAnnuler
	 */
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	/**
	 * @return the addressPanel
	 */
	public PanelField getAddressPanel() {
		return addressPanel;
	}

	/**
	 * @return the phonePanel
	 */
	public PanelField getPhonePanel() {
		return phonePanel;
	}

	/**
	 * @return the btnEditer
	 */
	public JButton getBtnEditer() {
		return btnEditer;
	}

	/**
	 * @return the panelSocio
	 */
	public JPanel getPanelSocio() {
		return panelSocio;
	}

	/**
	 * Create the panel.
	 */
	public PanelPresentation() {
		super();
		gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[]{2, 0, 2, 0, 0, 2, 0};
		gridBagLayout.columnWidths = new int[]{5, 0, 10, 0, 5};
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 2.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.1, 0.0, 1.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		panelInfos = new JPanel();
		GridBagConstraints gbc_panelInfos = new GridBagConstraints();
		gbc_panelInfos.insets = new Insets(5, 5, 5, 5);
		gbc_panelInfos.fill = GridBagConstraints.BOTH;
		gbc_panelInfos.gridx = 1;
		gbc_panelInfos.gridy = 1;
		add(panelInfos, gbc_panelInfos);
		GridBagLayout gbl_panelInfos = new GridBagLayout();
		gbl_panelInfos.columnWeights = new double[] { 0.0 };
		gbl_panelInfos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panelInfos.setLayout(gbl_panelInfos);

		// A field Panel with label and its associate textField
		namePanel = new PanelField("Nom");
		GridBagConstraints gbc_namePanel = new GridBagConstraints();
		gbc_namePanel.gridy = 0;
		gbc_namePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_namePanel.insets = new Insets(0, 0, 5, 0);
		gbc_namePanel.gridx = 0;
		panelInfos.add(namePanel, gbc_namePanel);
		namePanel.getInput().setBorder(new LineBorder(null, 0));
		namePanel.getInput().setEditable(false);

		// A field Panel with label and its associate textField
		siretPanel = new PanelField("SIRET");
		GridBagConstraints gbc_siretPanel = new GridBagConstraints();
		gbc_siretPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_siretPanel.insets = new Insets(0, 0, 5, 0);
		gbc_siretPanel.gridx = 0;
		panelInfos.add(siretPanel, gbc_siretPanel);
		siretPanel.getInput().setToolTipText("Chiffres uniquement");
		siretPanel.getInput().setBorder(new EmptyBorder(0, 0, 0, 0));
		siretPanel.getInput().setEditable(false);

		// A field Panel with label and its associate textField
		addressPanel = new PanelField("Adresse");
		GridBagConstraints gbc_addressPanel = new GridBagConstraints();
		gbc_addressPanel.insets = new Insets(0, 0, 5, 0);
		gbc_addressPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressPanel.gridx = 0;
		panelInfos.add(addressPanel, gbc_addressPanel);
		addressPanel.getInput().setBorder(new EmptyBorder(0, 0, 0, 0));
		addressPanel.getInput().setEditable(false);

		// A field Panel with label and its associate textField
		phonePanel = new PanelField("Téléphone");
		GridBagConstraints gbc_phonePanel = new GridBagConstraints();
		gbc_phonePanel.insets = new Insets(0, 0, 5, 0);
		gbc_phonePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_phonePanel.gridx = 0;
		panelInfos.add(phonePanel, gbc_phonePanel);
		phonePanel.getInput().setBorder(new EmptyBorder(0, 0, 0, 0));
		phonePanel.getInput().setEditable(false);

		// A field Panel with label and its associate textField
		emailPanel = new PanelField("Email");
		GridBagConstraints gbc_emailPanel = new GridBagConstraints();
		gbc_emailPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailPanel.insets = new Insets(0, 0, 5, 0);
		gbc_emailPanel.gridx = 0;
		panelInfos.add(emailPanel, gbc_emailPanel);
		emailPanel.getInput().setBorder(new EmptyBorder(0, 0, 0, 0));
		emailPanel.getInput().setEditable(false);

		// A field Panel with label and its associate textField
		websitePanel = new PanelField("Site web");
		GridBagConstraints gbc_websitePanel = new GridBagConstraints();
		gbc_websitePanel.insets = new Insets(0, 0, 5, 0);
		gbc_websitePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_websitePanel.gridx = 0;
		panelInfos.add(websitePanel, gbc_websitePanel);
		websitePanel.getInput().setBorder(new EmptyBorder(0, 0, 0, 0));
		websitePanel.getInput().setEditable(false);
		
		

		panelSocio = new JPanel();
		GridBagConstraints gbc_panelSocio = new GridBagConstraints();
		gbc_panelSocio.insets = new Insets(5, 5, 5, 5);
		gbc_panelSocio.fill = GridBagConstraints.BOTH;
		gbc_panelSocio.gridx = 3;
		gbc_panelSocio.gridy = 1;
		add(panelSocio, gbc_panelSocio);
		GridBagLayout gbl_panelSocio = new GridBagLayout();
		gbl_panelSocio.columnWeights = new double[] { 0.0 };
		gbl_panelSocio.rowWeights = new double[] { 0.0, 0.0 };
		panelSocio.setLayout(gbl_panelSocio);

		// Zone logo
		JPanel panelLogo = new JPanel();
		GridBagConstraints gbc_panelLogo = new GridBagConstraints();
		gbc_panelLogo.fill = GridBagConstraints.BOTH;
		gbc_panelLogo.insets = new Insets(0, 0, 5, 0);
		gbc_panelLogo.gridx = 0;
		gbc_panelLogo.gridy = 0;
		panelSocio.add(panelLogo, gbc_panelLogo);
		GridBagLayout gbl_panelLogo = new GridBagLayout();
		gbl_panelLogo.columnWidths = new int[] { 2, 0, 0, 2, 0 };
		gbl_panelLogo.rowHeights = new int[] { 2, 23, 0, 2, 0 };
		gbl_panelLogo.columnWeights = new double[] { 1, 0.0, 0, 0, Double.MIN_VALUE };
		gbl_panelLogo.rowWeights = new double[] { 0, 0, 0, 0, Double.MIN_VALUE };
		panelLogo.setLayout(gbl_panelLogo);

		lblLogo = new JLabel(new ImageIcon("image/GenericAvatar.png"));
		lblLogo.setSize(100, 100);
		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.insets = new Insets(0, 0, 1, 1);
		gbc_lblLogo.gridx = 2;
		gbc_lblLogo.gridy = 1;
		panelLogo.add(lblLogo, gbc_lblLogo);

		btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.insets = new Insets(0, 0, 1, 1);
		gbc_btnModifier.gridx = 2;
		gbc_btnModifier.gridy = 2;
		panelLogo.add(btnModifier, gbc_btnModifier);

		// Panel SocialNetwork
		JPanel panelSocialNetwork = new JPanel();
		GridBagConstraints gbc_panelSocialNetwork = new GridBagConstraints();
		gbc_panelSocialNetwork.insets = new Insets(0, 0, 5, 0);
		gbc_panelSocialNetwork.fill = GridBagConstraints.BOTH;
		gbc_panelSocialNetwork.gridx = 0;
		gbc_panelSocialNetwork.gridy = 1;
		panelSocio.add(panelSocialNetwork, gbc_panelSocialNetwork);
		GridBagLayout gbl_panelSocialNetwork = new GridBagLayout();
		gbl_panelSocialNetwork.columnWidths = new int[] { 2, 0, 5, 0, 2, 0 };
		gbl_panelSocialNetwork.rowHeights = new int[] { 2, 0, 1, 0, 2, 0 };
		gbl_panelSocialNetwork.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelSocialNetwork.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelSocialNetwork.setLayout(gbl_panelSocialNetwork);
		// Icone of the network (with link?)
		lblIcon = new JLabel("icon1");
		GridBagConstraints gbc_lblI = new GridBagConstraints();
		gbc_lblI.anchor = GridBagConstraints.EAST;
		gbc_lblI.fill = GridBagConstraints.VERTICAL;
		gbc_lblI.insets = new Insets(0, 0, 1, 1);
		gbc_lblI.gridx = 1;
		gbc_lblI.gridy = 1;
		panelSocialNetwork.add(lblIcon, gbc_lblI);
		btnAjout = new JButton("Ajout");
		btnAjout.setVisible(false);
		GridBagConstraints gbc_btnAjout = new GridBagConstraints();
		gbc_btnAjout.fill = GridBagConstraints.BOTH;
		gbc_btnAjout.insets = new Insets(0, 0, 1, 1);
		gbc_btnAjout.gridx = 3;
		gbc_btnAjout.gridy = 1;
		panelSocialNetwork.add(btnAjout, gbc_btnAjout);
		textFieldNetwork = new JTextField();
		textFieldNetwork.setBorder(null);
		textFieldNetwork.setColumns(10);
		textFieldNetwork.setEditable(false);
		GridBagConstraints gbc_textFieldNetwork = new GridBagConstraints();
		gbc_textFieldNetwork.anchor = GridBagConstraints.EAST;
		gbc_textFieldNetwork.insets = new Insets(0, 0, 1, 1);
		gbc_textFieldNetwork.gridwidth = 3;
		gbc_textFieldNetwork.gridx = 1;
		gbc_textFieldNetwork.gridy = 3;
		panelSocialNetwork.add(textFieldNetwork, gbc_textFieldNetwork);

		// Panel for the user presentation
		JLabel lblPrsentation = new JLabel("Pr\u00E9sentation :");
		GridBagConstraints gbc_lblPrsentation = new GridBagConstraints();
		gbc_lblPrsentation.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPrsentation.insets = new Insets(1, 1, 5, 5);
		gbc_lblPrsentation.gridx = 1;
		gbc_lblPrsentation.gridy = 3;
		add(lblPrsentation, gbc_lblPrsentation);
		textAreaPresentation = new JTextArea();
		textAreaPresentation.setWrapStyleWord(true);
		textAreaPresentation.setLineWrap(true);
		textAreaPresentation.setBackground(UIManager.getColor("Panel.background"));
		textAreaPresentation.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 3;
		gbc_textArea.insets = new Insets(1, 1, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 4;
		add(textAreaPresentation, gbc_textArea);

		// Validation or Cancellation sections
		JPanel panelDecision = new JPanel();
		GridBagConstraints gbc_panelDecision = new GridBagConstraints();
		gbc_panelDecision.anchor = GridBagConstraints.EAST;
		gbc_panelDecision.gridwidth = 6;
		gbc_panelDecision.gridx = 0;
		gbc_panelDecision.gridy = 6;
		add(panelDecision, gbc_panelDecision);
		GridBagLayout gbl_panelDecision = new GridBagLayout();
		gbl_panelDecision.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panelDecision.rowWeights = new double[]{0.0};
		panelDecision.setLayout(gbl_panelDecision);
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setVisible(false);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
//		gbc_btnAnnuler.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAnnuler.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnuler.gridx = 1;
		gbc_btnAnnuler.gridy = 0;
		panelDecision.add(btnAnnuler, gbc_btnAnnuler);
		btnEditer = new JButton("Editer");
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
//		gbc_btnEditer.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEditer.gridx = 2;
		gbc_btnEditer.gridy = 0;
		panelDecision.add(btnEditer, gbc_btnEditer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.yas.matchup.views.IVisibility#setMode(boolean)
	 */
	@Override
	public void setMode(boolean b) {
		// this.getBtnEdit().setVisible(!b);
		if (b) {
			this.getBtnEdit().setText("Valider");
		} else {
			this.getBtnEdit().setText("Editer");
		}
		this.getBtnAjout().setVisible(b);
		this.getBtnAnnuler().setVisible(b);
		this.getBtnModifier().setVisible(b);

		this.getNamePanel().setMode(b);
		this.getSiretPanel().setMode(b);
		this.getEmailPanel().setMode(b);
		this.getWebsitePanel().setMode(b);
		this.getTextAreaPresentation().setEditable(b);

		if (b) {
			this.getTextAreaPresentation().setBackground(UIManager.getColor("TextArea.background"));
			this.getTextAreaPresentation().setBorder(new TextFieldBorder());
		} else {
			this.getTextAreaPresentation().setBackground(UIManager.getColor("Panel.background"));
			this.getTextAreaPresentation().setBorder(new EmptyBorder(0, 0, 0, 0));
		}
	}

}
