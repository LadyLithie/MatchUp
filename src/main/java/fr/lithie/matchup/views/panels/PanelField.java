/**
 * 
 */
package fr.lithie.matchup.views.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

import fr.lithie.matchup.views.base.IVisibility;

import java.awt.Insets;

/**
 * @author Audrey
 *
 */

public class PanelField extends JPanel implements IVisibility {
	private JLabel label;
	private JTextField input;

	/**
	 * @return the label
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * @return the input
	 */
	public JTextField getInput() {
		return input;
	}
	
	/**
	 * Create the panel.
	 */
	public PanelField(String label) {
		super();
//		if (!label.isEmpty()) {
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[] { 1, 0, 5, 0, 1, 0 };
			gridBagLayout.rowHeights = new int[] { 1, 0, 1, 0 };
			gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			setLayout(gridBagLayout);

			this.label = new JLabel(label);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 1, 1);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			add(this.label, gbc_lblNewLabel);

			input = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			input.setMinimumSize(new Dimension(70, 20));
			gbc_textField.insets = new Insets(0, 0, 1, 1);
			gbc_textField.gridx = 3;
			gbc_textField.gridy = 1;
			add(input, gbc_textField);
//		}
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.views.IVisibility#setMode(boolean)
	 */
	@Override
	public void setMode(boolean b) {
		this.getInput().setEditable(b);
		if(b)
			this.getInput().setBorder(new TextFieldBorder());
		else
			this.getInput().setBorder(new EmptyBorder(0, 0, 0, 0));
		
	}



}
