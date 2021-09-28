package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class OuvinteBox implements ActionListener{
	private ManipularLivro x;
	public OuvinteBox(ManipularLivro x) {
		this.x = x;
	}

	public void actionPerformed(ActionEvent e) {
		JComboBox e2 = (JComboBox) e.getSource();
		if(e2.getSelectedIndex() == 0) {
			if(x.getSubClasses() != null) {
				x.getSubClasses().setVisible(false);
			}
			x.getAssunto().setEnabled(false);
			x.getAutores().setEnabled(false);
			x.getNumeroDaEdicao().setEnabled(false);
			x.getMes().setEnabled(false);
		}
		if(e2.getSelectedIndex() == 1) {
			if(x.getSubClasses() != null) {
				x.getSubClasses().setVisible(false);
			}
			x.setSubClasses(x.criarComboBox(100, 170, 231, 30, x.getSubL()));
			x.getAutores().setEnabled(true);
			x.getMes().setEnabled(false);
			x.getNumeroDaEdicao().setEnabled(false);
			x.getAssunto().setEnabled(false);
		}
		else if(e2.getSelectedIndex() == 2) {
			if(x.getSubClasses() != null) {
				x.getSubClasses().setVisible(false);
			}
			x.setSubClasses(x.criarComboBox(100, 170, 231, 30, x.getSubT()));
			x.getAssunto().setEnabled(true);
			x.getAutores().setEnabled(false);
			x.getNumeroDaEdicao().setEnabled(false);
			x.getMes().setEnabled(false);
		}
		
		else if(e2.getSelectedIndex() == 3) {
			if(x.getSubClasses() != null) {
				x.getSubClasses().setVisible(false);
			}
			x.setSubClasses(x.criarComboBox(100, 170, 231, 30, x.getSubP()));
			x.getMes().setEnabled(true);
			x.getNumeroDaEdicao().setEnabled(true);
			x.getAutores().setEnabled(false);
			x.getAssunto().setEnabled(false);
		}

		else if(e2.getSelectedIndex() == 4) {
			if(x.getSubClasses() != null) {
				x.getSubClasses().setVisible(false);
			}
			x.setSubClasses(x.criarComboBox(100, 170, 231, 30, x.getSubD()));
			x.getAutores().setEnabled(true);
			x.getMes().setEnabled(false);
			x.getNumeroDaEdicao().setEnabled(false);
			x.getAssunto().setEnabled(false);
		}

	}

}
