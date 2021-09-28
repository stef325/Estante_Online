package janelas;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

public class JTableRenderer extends DefaultTableCellRenderer {
	 
    protected void setValue(Object value) {
        if (value instanceof ImageIcon) {
            ImageIcon d = (ImageIcon) value;
			setIcon(d);
        } else {
            super.setValue(value);
        }
    }
}


