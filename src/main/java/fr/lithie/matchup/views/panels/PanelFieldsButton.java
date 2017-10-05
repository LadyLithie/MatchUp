/**
 * 
 */
package fr.lithie.matchup.views.panels;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

import fr.lithie.matchup.views.base.IVisibility;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;

/**
 * @author Audrey
 *
 */
public class PanelFieldsButton extends JPanel implements IVisibility {

	private JLabel label;
	private JButton button;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textFieldMail;

	/**
	 * @return the label
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * @return the textFieldMail
	 */
	public JTextField getTextFieldMail() {
		return textFieldMail;
	}

	/**
	 * @return the button
	 */
	public JButton getButton() {
		return button;
	}

	/**
	 * @return the textField1 (firstname)
	 */
	public JTextField getTextField1() {
		return textField1;
	}

	/**
	 * @return the textField2 (lastname)
	 */
	public JTextField getTextField2() {
		return textField2;
	}

	/**
	 * Create the panel with a label follow by 2 textfield and, optionally, a button
	 * 
	 * @param label
	 *            = header label
	 * @param button
	 *            with its label. Can be an empty string if we don't want one
	 */
	public PanelFieldsButton(String label, String button) {
		super();
//		if(!label.isEmpty()) {
			// layout of 1 line with surrounding padding
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[] { 1, 0, 1, 30, 30, 1, 0, 1, 0 };
			gridBagLayout.rowHeights = new int[] { 1, 0, 0, 1, 0 };
			gridBagLayout.columnWeights = new double[] { 0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
			gridBagLayout.rowWeights = new double[] { 0, 0.0, 0.0, 0, Double.MIN_VALUE };
			setLayout(gridBagLayout);

			this.label = new JLabel(label);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.WEST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 1;
			add(this.label, gbc_label);

			textField1 = new JTextField();
			textField1.setToolTipText("Pr\u00E9nom");
			textField1.setColumns(10);
			textField1.setMinimumSize(new Dimension(50, 20));
			GridBagConstraints gbc_textField1 = new GridBagConstraints();
			gbc_textField1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField1.gridy = 1;
			gbc_textField1.insets = new Insets(0, 0, 5, 5);
			gbc_textField1.gridx = 3;
			add(textField1, gbc_textField1);

			textField2 = new JTextField();
			textField2.setToolTipText("Nom");
			textField2.setColumns(10);
			textField2.setMinimumSize(new Dimension(50, 20));
			GridBagConstraints gbc_textField2 = new GridBagConstraints();
			gbc_textField2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField2.insets = new Insets(0, 0, 5, 5);
			gbc_textField2.gridx = 4;
			gbc_textField2.gridy = 1;
			add(textField2, gbc_textField2);

//			if (!button.isEmpty()) {
				this.button = new JButton(button);
				GridBagConstraints gbc_btnButton = new GridBagConstraints();
				gbc_btnButton.fill = GridBagConstraints.VERTICAL;
				gbc_btnButton.gridheight = 2;
				gbc_btnButton.anchor = GridBagConstraints.EAST;
				gbc_btnButton.insets = new Insets(0, 0, 5, 5);
				gbc_btnButton.gridx = 6;
				gbc_btnButton.gridy = 1;
				add(this.button, gbc_btnButton);
				
				textFieldMail = new JTextField();
				textFieldMail.setToolTipText("email");
				GridBagConstraints gbc_textFieldMail = new GridBagConstraints();
				gbc_textFieldMail.gridwidth = 2;
				gbc_textFieldMail.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldMail.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldMail.gridx = 3;
				gbc_textFieldMail.gridy = 2;
				add(textFieldMail, gbc_textFieldMail);
				textFieldMail.setColumns(10);
//			}			
//		}

	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.views.IVisibility#setMode(boolean)
	 */
	@Override
	public void setMode(boolean b) {
		this.getTextField2().setEditable(b);
		this.getTextField1().setEditable(b);
		this.getTextFieldMail().setEditable(b);
		this.getLabel().setVisible(b);
		if(this.getButton() != null) {
			this.getButton().setVisible(b);
		}
		
		if (b) {
			this.getTextField1().setBorder(new TextFieldBorder());
			this.getTextField2().setBorder(new TextFieldBorder());
			this.getTextFieldMail().setBorder(new TextFieldBorder());
		} else {
			this.getTextField1().setBorder(new EmptyBorder(0, 0, 0, 0));
			this.getTextField2().setBorder(new EmptyBorder(0, 0, 0, 0));
			this.getTextFieldMail().setBorder(new EmptyBorder(0, 0, 0, 0));
		}
	}

}
