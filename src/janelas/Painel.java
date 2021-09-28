package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.GeradorDeRelatorios;
import projeto.Livro;
import projeto.Mensageiro;
import projeto.Persistencia;

public class Painel extends Janelas{
	private JButton adicionar;
	private JButton sair;
	private JButton editarLivro;
	private JButton gerarRelaDeinteresse;
	private JButton gerarRelaDeLivros;
	private JButton alterarDados;
	private JButton config;
	private JButton voltar;
	private Conta logado;
	private CentralDeInformacoes c;
	private Persistencia p;
	private ArrayList<Livro> livroInteresse1 = new ArrayList<Livro>();
	private ArrayList<Livro> livroInteresse2 = new ArrayList<Livro>();

	public Painel(Conta logado, CentralDeInformacoes c, Persistencia p) {
		this.p = p;
		this.c = c;
		this.logado = logado;
		this.setTitle("Painel de controle");
		criarJLabel("Painel de Controle", 350, 20, 250, 100,20);
		criarJLabel(logado.getNome(), 100, 20, 150, 150,20);
		voltar = criarBotao("<- voltar", 700, 35, 100, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		adicionar = criarBotao("Adicionar Livro", 330, 100, 231, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		editarLivro = criarBotao("Editar Livro", 330, 135, 231, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		gerarRelaDeinteresse = criarBotao("Gerar Relátorio de Interesse", 330, 170, 231, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		gerarRelaDeLivros = criarBotao("Gerar Relatório de livros", 330, 205, 231, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		alterarDados = criarBotao("Alterar Dados", 330, 240, 231, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		config =criarBotao("Configurações de Visualisação", 330, 275, 231, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		sair = criarBotao("Sair da conta",75, 130, 150, 40,"#169BD5","#FFFFFF", "#169BD5", 15);
		ouvintes();
		visible(true);
	}

	private void ouvintes() {

		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login(c, p);
				visible(false);	
			}
		});

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MinhaEstante(logado, c, p);
				visible(false);
			}
		});

		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdicionarLivro(logado,c,p);
				visible(false);
			}
		});

		editarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarLivro(logado,c,p);
				visible(false);
			}
		});

		alterarDados.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new AlterarDados(logado, c, p);
				visible(false);

			}
		});

		gerarRelaDeLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeradorDeRelatorios.gerarRelatorio(c.getTodosOsLivros(),"relatório.pdf");
				Mensageiro.enviarListaDeLivros(logado.getEmail(),"relatório.pdf");
				JOptionPane.showMessageDialog(null, "Relatório enviado", "Confirmação", JOptionPane.INFORMATION_MESSAGE, null);
			}
		});
		gerarRelaDeinteresse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livroInteresse1.addAll(c.getTodosOsLivros());
				Collections.sort(livroInteresse1, new Comparador3());
				for(int i = 0; i <10; i++) {
					try {
						if(livroInteresse1.get(i).getQuantidade() == 0 && livroInteresse1.get(i).getInteresse() > 0)
							livroInteresse2.add(livroInteresse1.get(i));
					}catch(Exception e1){
					}
				}try {
					GeradorDeRelatorios.gerarRelatorio(livroInteresse2,"relatórioInteresse.pdf");
					Mensageiro.enviarListaDeLivros(logado.getEmail(),"relatórioInteresse.pdf");
					JOptionPane.showMessageDialog(null, "Relatório enviado", "Confirmação", JOptionPane.INFORMATION_MESSAGE, null);
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Não á nenhum livro com estoque zero e interesse", "Aviso", JOptionPane.WARNING_MESSAGE, null);
				}
			}
		});
		
	}
}
class Comparador3 implements Comparator<Livro>{
	public int compare(Livro o1, Livro o2) {
		Livro c1 = (Livro)o1;
		Livro c2 = (Livro)o2;

		if (o1.getInteresse() > o2.getInteresse()) return -1;
		else if (o1.getInteresse() < o2.getInteresse()) return +1;
		else return 0;
	}
}