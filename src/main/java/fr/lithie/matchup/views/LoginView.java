package fr.lithie.matchup.views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import fr.lithie.matchup.views.base.BaseView;

public class LoginView extends BaseView {
	private JPasswordField textFieldPwd;
	private JTextField textFieldLogin;
	private JButton btnRegister;
	private JButton btnLogin;

	/**
	 * @return the btnRegister
	 */
	public JButton getBtnRegister() {
		return btnRegister;
	}

	/**
	 * @return the btnLogin
	 */
	public JButton getBtnLogin() {
		return btnLogin;
	}

	/**
	 * @return the textFieldPwd
	 */
	public JTextField getTextFieldPwd() {
		return textFieldPwd;
	}

	/**
	 * @param textFieldPwd the textFieldPwd to set
	 */
	public void setTextFieldPwd(JPasswordField textFieldPwd) {
		this.textFieldPwd = textFieldPwd;
	}

	/**
	 * @return the textFieldLogin
	 */
	public JTextField getTextFieldLogin() {
		return textFieldLogin;
	}

	/**
	 * @param textFieldLogin the textFieldLogin to set
	 */
	public void setTextFieldLogin(JTextField textFieldLogin) {
		this.textFieldLogin = textFieldLogin;
	}

	/**
	 * Create the frame.
	 */
	public LoginView(JFrame frame) {
		super();
		super.pageName = "Login";
		JPanel panel = new JPanel();
		super.panel = panel;
		panel.setLayout(new GridLayout(1, 2, 5, 0));
		
		JPanel panelLogin = new JPanel();
		GridBagConstraints gbc_panelLogin = new GridBagConstraints();
		gbc_panelLogin.insets = new Insets(10, 10, 10, 10);
		gbc_panelLogin.fill = GridBagConstraints.BOTH;
		gbc_panelLogin.gridx = 0;
		gbc_panelLogin.gridy = 0;
		panel.add(panelLogin,gbc_panelLogin);
		GridBagLayout gbl_panelLogin = new GridBagLayout();
		gbl_panelLogin.rowHeights = new int[]{0, 20, 0, 0, 0, 0};
		gbl_panelLogin.columnWidths = new int[]{0, 0, 0, 0};
//		gbl_panelLogin.columnWidths = new int[] {95, 93, 80, 48};
//		gbl_panelLogin.rowHeights = new int[] {60, 60, 60, 60, 60, 60, 60};
		gbl_panelLogin.columnWeights = new double[]{0.0, 0.0};
		gbl_panelLogin.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 1.0};
		panelLogin.setLayout(gbl_panelLogin);
		
		JLabel lblIdentification = new JLabel("Identification");
		lblIdentification.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIdentification.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblIdentification = new GridBagConstraints();
		gbc_lblIdentification.fill = GridBagConstraints.VERTICAL;
		gbc_lblIdentification.gridwidth = 4;
		gbc_lblIdentification.insets = new Insets(0, 0, 5, 0);
		gbc_lblIdentification.gridx = 0;
		gbc_lblIdentification.gridy = 0;
		panelLogin.add(lblIdentification, gbc_lblIdentification);
		
		JLabel lblLogin = new JLabel("Login");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 2;
		panelLogin.add(lblLogin, gbc_lblLogin);
		
		textFieldLogin = new JTextField();
		GridBagConstraints gbc_textFieldLogin = new GridBagConstraints();
		gbc_textFieldLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLogin.gridwidth = 2;
		gbc_textFieldLogin.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLogin.gridx = 1;
		gbc_textFieldLogin.gridy = 2;
		panelLogin.add(textFieldLogin, gbc_textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.VERTICAL;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 3;
		panelLogin.add(lblPassword, gbc_lblPassword);
		
		textFieldPwd = new JPasswordField();
		GridBagConstraints gbc_textFieldPwd = new GridBagConstraints();
		gbc_textFieldPwd.gridwidth = 2;
		gbc_textFieldPwd.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPwd.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPwd.gridx = 1;
		gbc_textFieldPwd.gridy = 3;
		panelLogin.add(textFieldPwd, gbc_textFieldPwd);
		textFieldPwd.setColumns(10);
		
		JButton btnForgottenPassword = new JButton("<html>Forgotten<br />Password</html>");
		//For now : inactive (no associated action)
		btnForgottenPassword.setEnabled(false);
		GridBagConstraints gbc_btnForgottenPassword = new GridBagConstraints();
		gbc_btnForgottenPassword.gridheight = 2;
		gbc_btnForgottenPassword.insets = new Insets(0, 0, 5, 0);
		gbc_btnForgottenPassword.gridx = 3;
		gbc_btnForgottenPassword.gridy = 2;
		panelLogin.add(btnForgottenPassword, gbc_btnForgottenPassword);
		
		JPanel panelButtons = new JPanel();
		GridBagConstraints gbc_panelButtons = new GridBagConstraints();
		gbc_panelButtons.gridwidth = 4;
		gbc_panelButtons.fill = GridBagConstraints.BOTH;
		gbc_panelButtons.gridx = 0;
		gbc_panelButtons.gridy = 5;
		panelLogin.add(panelButtons, gbc_panelButtons);
		
		btnRegister = new JButton("Register");
		panelButtons.add(btnRegister);
		
		btnLogin = new JButton("Login");
		panelButtons.add(btnLogin);
		
		//Right panel
		JPanel panelAbout = new JPanel();
		GridBagConstraints gbc_panelAbout = new GridBagConstraints();
		gbc_panelAbout.insets = new Insets(10, 10, 10, 10);
		gbc_panelAbout.gridx = 1;
		gbc_panelAbout.gridy = 1;
		gbc_panelAbout.fill = GridBagConstraints.BOTH;
		panel.add(panelAbout, gbc_panelAbout);
		
		JLabel image = new JLabel(new ImageIcon("image/MatchUp 1v3l.png"));
		panelAbout.setLayout(new BorderLayout());
		panelAbout.add(image, BorderLayout.CENTER);
		
		JLabel lblTitle = new JLabel("Match Up");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelAbout.add(lblTitle, BorderLayout.SOUTH);
	}

}
