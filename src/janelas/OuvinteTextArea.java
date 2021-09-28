package janelas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;

public class OuvinteTextArea implements MouseListener{
	private boolean contadorUnico = true;
	public void mouseClicked(MouseEvent e) {
		JTextArea e2 = (JTextArea) e.getSource();
		if(contadorUnico == true && (e2.isEnabled() == true)) {
			e2.setText("");
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

