package janelas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Livro;
import projeto.Persistencia;

public class EncontrarLivro extends ClasseMenu{
	private DefaultTableModel modeloEstante;
	private JTextField campoDeBusca;

	private ArrayList<Livro> procurar = new ArrayList<Livro>();
	public EncontrarLivro(Conta logado, CentralDeInformacoes c, Persistencia p) {
		super(logado, c, p);
		setTitle("Encontrar Livros");
		procurar.addAll(c.getTodosOsLivros());
		campoDeBusca = criarTextFields("CAMPO DE BUSCA", 330, 40, 231, 35, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40);
		modeloEstante = geradorDeTableModel();
		campoDeBusca.addKeyListener(new OuvinteDeBusca());
		geradorDeTabela(c.getTodosOsLivros(), 200,110,550,440);
		visible(true);
	}

	public class OuvinteDeBusca implements KeyListener{

		public void keyTyped(KeyEvent e) {

			ArrayList<Livro> copia = new ArrayList<Livro>();
			String campoDeTexto = campoDeBusca.getText();
			char c = e.getKeyChar();
			if(Character.isLetterOrDigit(c) || c == ' ') {
				campoDeTexto +=c;
			}
			if(campoDeTexto.length() == 0) {
				copia.addAll(procurar);
			}
			else {
				for(Livro s: procurar) {
					if(s.getTitulo().contains(campoDeTexto)) {
						copia.add(s);
					}
				}
			}
			getRoda().setBounds(0, 0, 0, 0);
			geradorDeTabela(copia, 200,110,550,440);
			repaint();
		}
		public void keyPressed(KeyEvent e) {
		}
		public void keyReleased(KeyEvent e) {
		}

	}
	public String toString() {
		return "pode";
	}

}
