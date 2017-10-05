package fr.lithie.matchup.utils.views;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import fr.lithie.matchup.entities.ContractType;
import fr.lithie.matchup.entities.Location;
import fr.lithie.matchup.entities.RegisteredUser;

/**
 * @author Audrey
 *
 */
public class ComboBoxRenderer extends DefaultListCellRenderer {
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (value instanceof ContractType) {
			ContractType item = (ContractType) value;
			setText(item.getName());
			// setIcon(ingredient.getIcon());
		}else if (value instanceof Location) {
			Location item = (Location) value;
			setText(item.getZipcode() + " " + item.getCity());
		}else if (value instanceof RegisteredUser) {
			RegisteredUser item = (RegisteredUser) value;
			setText(item.getName());
		}
		return this;
	}
}