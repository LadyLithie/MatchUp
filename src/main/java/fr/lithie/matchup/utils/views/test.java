package fr.lithie.matchup.utils.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class test extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public test() {
		setLayout(new BorderLayout(0, 0));

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Oui");
		okButton.setActionCommand("Oui");
		buttonPane.add(okButton);

		JButton cancelButton = new JButton("Non");
		cancelButton.setActionCommand("Non");
		buttonPane.add(cancelButton);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel lblMessage = new JLabel("Indiquer le chemin de votre image :");
		lblMessage.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblMessage);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

	}

}
