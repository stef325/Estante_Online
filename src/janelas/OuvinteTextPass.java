package janelas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPasswordField;

public class OuvinteTextPass implements MouseListener{
	private boolean contadorUnico = true;
	public void mouseClicked(MouseEvent e) {
		JPasswordField e2 = (JPasswordField) e.getSource();
		if(contadorUnico == true && (e2.isEnabled() == true)) {
			e2.setText(null);
			contadorUnico = false;
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {	
	}
}
