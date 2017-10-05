package fr.lithie.matchup.views.panels;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.lithie.matchup.entities.RegisteredUser;

import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 * @author Audrey
 *
 */
public class PanelAdminUser extends JPanel {
	private JButton btnValidateUser;
	private JButton btnDeleteUser;
	private JButton btnResetPasswordUser;
	private JLabel lblName;
	private JLabel lblEmail;
//	private JLabel lblDateCreation;
	private JLabel lblType;
	private RegisteredUser user;

	/**
	 * @return the user
	 */
	public RegisteredUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(RegisteredUser user) {
		this.user = user;
	}

	/**
	 * @return the btnValidateUser
	 */
	public JButton getBtnValidateUser() {
		return btnValidateUser;
	}

	/**
	 * @return the btnDeleteUser
	 */
	public JButton getBtnDeleteUser() {
		return btnDeleteUser;
	}

	/**
	 * @return the btnResetPasswordUser
	 */
	public JButton getBtnResetPasswordUser() {
		return btnResetPasswordUser;
	}

	/**
	 * @return the lblName
	 */
	public JLabel getLblName() {
		return lblName;
	}

	/**
	 * @return the lblEmail
	 */
	public JLabel getLblEmail() {
		return lblEmail;
	}

	/**
	 * @return the lblDateCreation
	 */
//	public JLabel getLblDateCreation() {
//		return lblDateCreation;
//	}

	/**
	 * @return the lblType
	 */
	public JLabel getLblType() {
		return lblType;
	}

	/**
	 * Create the panel.
	 */
	public PanelAdminUser() {
		super();
		setBorder(null);
		setLayout(new GridLayout(1, 0, 0, 1));
	
		lblName = new JLabel("Name");
		add(lblName);
		
		lblEmail = new JLabel("Email");
		add(lblEmail);
		
		lblType = new JLabel("Type");
		add(lblType);
		
//		lblDateCreation = new JLabel("Date de cr\u00E9ation");
//		add(lblDateCreation);
		
		btnValidateUser = new JButton("Validate");
		GridBagConstraints gbc_btnValidateUser = new GridBagConstraints();
		gbc_btnValidateUser.insets = new Insets(0, 0, 5, 5);
		add(btnValidateUser,gbc_btnValidateUser);
		
		btnDeleteUser = new JButton("Delete");
		GridBagConstraints gbc_btnDeleteUser = new GridBagConstraints();
		gbc_btnDeleteUser.insets = new Insets(0, 0, 5, 5);
		add(btnDeleteUser,gbc_btnDeleteUser);
		
		btnResetPasswordUser = new JButton("Reset password");
		btnResetPasswordUser.setEnabled(false);
		GridBagConstraints gbc_btnResetPasswordUser = new GridBagConstraints();
		gbc_btnResetPasswordUser.insets = new Insets(0, 0, 5, 5);
		add(btnResetPasswordUser,gbc_btnResetPasswordUser);
		
	}

}
