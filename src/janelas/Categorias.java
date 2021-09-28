package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Persistencia;

public class Categorias extends ClasseMenu{
	private JButton literatura;
	private JButton tecnico;
	private JButton periodico;
	private JButton dp;
	public Categorias(Conta logado, CentralDeInformacoes c, Persistencia p) {
		super(logado, c, p);
		setTitle("Categorias");
		this.setSize(800, 500);
		criarJLabel("CATEGORIAS", 400, 50, 250, 50,20);
		literatura = criarBotao("Literatura",270, 100, 400, 50,"#D7D7D7","#000000", "#D7D7D7", 25);
		literatura.addActionListener(new ouvinteCategorias(logado, c, p));
		tecnico = criarBotao("Técnico",270, 160, 400, 50,"#D7D7D7","#000000", "#D7D7D7", 25);
		tecnico.addActionListener(new ouvinteCategorias(logado, c, p));
		periodico = criarBotao("Periódico",270, 220, 400, 50,"#D7D7D7","#000000", "#D7D7D7", 25);
		periodico.addActionListener(new ouvinteCategorias(logado, c, p));
		dp = criarBotao("Desenvolvimento Pessoal",270, 280, 400, 50,"#D7D7D7","#000000", "#D7D7D7", 25);
		dp.addActionListener(new ouvinteCategorias(logado, c, p));
		visible(true);
	}

	private class ouvinteCategorias implements ActionListener {
		private Conta logado;
		private CentralDeInformacoes c;
		private Persistencia p;

		public ouvinteCategorias(Conta logado, CentralDeInformacoes c, Persistencia p) {
			this.logado = logado;
			this.c = c;
			this.p = p;
		}
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			new CategoriaLivros(logado, c, p, b.getText());
			visible(false);
		}

	}
}
