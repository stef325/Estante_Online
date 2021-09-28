package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Livro;
import projeto.LivroDesenvolvimentoPessoal;
import projeto.LivroLiteratura;
import projeto.LivroPeriodico;
import projeto.LivroTecnico;
import projeto.Persistencia;
import projeto.ThreadLivro;

public class ExibirLivro extends ClasseMenu{

	private JLabel capa;
	private JButton comprar;
	private JButton colocarEstante;
	private JButton interesse;
	private JButton voltar;
	private Livro livro;
	private JTextField comentario;
	private JButton botaocomentar;

	public ExibirLivro(Conta logado, CentralDeInformacoes c, Persistencia p,Livro livro) {
		super(logado, c, p);
		this.livro = livro;
		this.setTitle("Livro");
		this.setSize(800, 720);
		this.setLocationRelativeTo(null);


		capa = criarJLabel("", 240, 78, 180, 230,0);
		new Thread(new ThreadLivro(livro, capa, capa.getWidth(), capa.getHeight())).start();

		criarJLabel(livro.getTitulo(), 440, 78, 250, 40,20);

		criarJLabel("Categoria:", 440, 106, 80, 40,15);
		criarJLabel(livro.toString(), 516, 106, 250, 40,15);

		criarJLabel("Ano de lançamento:", 440, 126, 145, 40,15);
		criarJLabel(livro.getAnoDePublicacao()+"", 580, 126, 250, 40,15);

		criarJLabel("Sub-Gênero:", 440, 146,100, 40, 15);
		criarJLabel(livro.getGenero(), 540, 146,200, 40, 15);

		criarJLabel("Idioma:", 440, 166, 80, 40, 15);
		criarJLabel(livro.getIdioma(), 500, 166,100, 40, 15);

		criarJLabel("Editora:", 440, 186, 80, 40, 15);
		criarJLabel(livro.getEditora(), 500, 186,100, 40, 15);

		criarJLabel("Quantidade:", 440, 206, 87, 40,15);
		criarJLabel(livro.getQuantidade()+"", 528, 206,100, 40, 15);

		criarJLabel("Valor:", 440, 226, 68, 40,15);
		criarJLabel(livro.getValor()+"", 490, 226,100, 40, 15);




		if (livro instanceof LivroDesenvolvimentoPessoal){
			criarJLabel("Autores:", 440, 246, 70, 40,15);
			criarTextArea(((LivroDesenvolvimentoPessoal) livro).getAutores(),500, 258, 180, 40, "#FFFFFF", "#FFFFFF", JLabel.LEFT, 0).setEnabled(false);

		}
		else if (livro instanceof LivroLiteratura) {
			criarJLabel("Autores:", 440, 246, 70, 40,15);
			criarTextArea(((LivroLiteratura) livro).getAutores(),500, 258, 180, 40, "#FFFFFF", "#FFFFFF", JLabel.LEFT, 0).setEnabled(false);

		}
		else if (livro instanceof LivroTecnico) {
			criarJLabel("Assunto:", 440, 246, 70, 40,15);
			JTextField field = criarTextFields(((LivroTecnico) livro).getAssunto(), 470, 256, 180, 20, "#FFFFFF", "#FFFFFF",0, 0);
			field.setEnabled(false);
		}
		else if (livro instanceof LivroPeriodico) {
			criarJLabel("Mês de publicação:", 440, 246, 150, 40,15);
			criarJLabel(((LivroPeriodico) livro).getMes()+"", 585, 246, 70, 40,15);
		}
		criarJLabel("Avaliação (pior a melhor):", 240, 309, 180, 40,15);
		avaliacao();

		comprar = criarBotao("Comprar", 240, 348, 84, 30, "#169BD5", "#FFFFFF", "#169BD5", 20);
		colocarEstante = criarBotao("Colocar na estante", 328, 348, 145, 30, "#169BD5", "#FFFFFF", "#169BD5", 20);

		interesse = criarBotao("Tenho Interesse", 477, 348, 128, 30, "#169BD5", "#FFFFFF", "#169BD5", 20);

		voltar = criarBotao("<- voltar", 350, 30, 100, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);

		comentario = criarTextFields("Seu Comentário", 100, 388, 540, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 20);
		botaocomentar = criarBotao(">", 645, 388, 50, 30, "#169BD5","#FFFFFF","#169BD5", 20);
		geradorDeTabela(livro,logado);
		ouvintesExibir(logado);

		visible(true);


	}

	private void avaliacao() {
		JRadioButton b1 = new JRadioButton("1");
		b1.setBounds(423, 318, 35, 20);
		b1.setActionCommand("1");
		JRadioButton b2 = new JRadioButton("2");
		b2.setBounds(458, 318, 35, 20);
		b2.setActionCommand("2");
		JRadioButton b3 = new JRadioButton("3");
		b3.setBounds(493, 318,  35, 20);
		b3.setActionCommand("3");
		JRadioButton b4 = new JRadioButton("4");
		b4.setBounds(528, 318, 35, 20);
		b4.setActionCommand("4");
		JRadioButton b5 = new JRadioButton("5");
		b5.setBounds(563, 318, 35, 20);
		b5.setActionCommand("5");

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(b1);
		grupo.add(b2);
		grupo.add(b3);
		grupo.add(b4);
		grupo.add(b5);

		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		b1.addActionListener(new OuvintesRadionButton());
		b2.addActionListener(new OuvintesRadionButton());
		b3.addActionListener(new OuvintesRadionButton());
		b4.addActionListener(new OuvintesRadionButton());
		b5.addActionListener(new OuvintesRadionButton());
	}

	public class OuvintesRadionButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JRadioButton e2 = (JRadioButton) e.getSource();
			livro.setAvaliacao(Float.parseFloat(e2.getText()));
			getP().salvarCentral(getC());
		}
	}

	public void ouvintesExibir(Conta conta) {
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TodosOsLivrosJanela(getLogado(), getC(), getP());
				visible(false);
			}
		});
		interesse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livro.setInteresse();
				getP().salvarCentral(getC());
			}
		});
		colocarEstante.addActionListener(new ActionListener() {
			boolean ver = false;
			public void actionPerformed(ActionEvent e) {
				if(getLogado().getLivrosUsuario().size() >= 0) {
					for(int i = 0;i < getLogado().getLivrosUsuario().size(); i++)
						if(livro.getId() == getLogado().getLivrosUsuario().get(i).getId()) {
							ver = true;
							break;
						}
				}
				if(ver == true) {
					JOptionPane.showMessageDialog(null, "Livro ja existe na sua Estante!", "Aviso!", JOptionPane.WARNING_MESSAGE, null);
				}
				else{
					getLogado().setLivrosUsuario(livro);
					getP().salvarCentral(getC());
				}
			}
		});

		comprar.addActionListener(new ActionListener() {
			boolean ver = false;
			public void actionPerformed(ActionEvent e) {
				String[] botoes = {"Pagar", "Não pagar"};
				int escolha = JOptionPane.showOptionDialog(null, "Número do boleto: @@@@@@@", "Boleto", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botoes, botoes[0]);
				if (escolha == 0) {
					if(getLogado().getLivrosUsuario().size() >= 0) {
						for(int i = 0;i < getLogado().getLivrosUsuario().size(); i++)
							if(livro.getId() == getLogado().getLivrosUsuario().get(i).getId()) {
								ver = true;
								break;
							}
					}
					if(ver == true) {
						JOptionPane.showMessageDialog(null, "Livro ja existe na sua Estante!", "Aviso!", JOptionPane.WARNING_MESSAGE, null);
					}
					else{
						livro.livroComprado();

						getLogado().setLivrosUsuario(livro);
						getP().salvarCentral(getC());
						dispose();
						new ExibirLivro(getLogado(), getC(), getP(), livro);
					}
				}
			}
		});
		
		comentario.addMouseListener(new OuvinteTextField());

		botaocomentar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Comentario coment = new Comentario();
				coment.setAutor(conta.getNome());
				coment.setComentario(comentario.getText());
				coment.setDataPost();
				livro.setComentario(coment);
				getP().salvarCentral(getC());
				dispose();
				new ExibirLivro(conta, getC(), getP(), livro);
				
			}
		});
	}
	
	public JScrollPane geradorDeTabela(Livro livro, Conta conta) {

		JTable tabela = new JTable();
		ModeloTabelaComentarios novaTabela = new ModeloTabelaComentarios(livro);
		tabela.setModel(novaTabela);
		tabela.getTableHeader().setReorderingAllowed(false);


		tabela.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				if (conta.getEmail().equals(getC().getTodosAsContas().get(0).getEmail())) {
					if (tabela.getSelectedRow() > -1) {
						int escolha = JOptionPane.showOptionDialog(null, "Deseja excluir este comentário?", "Excluir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
						if (escolha == 0) {
							livro.getComentario().remove(tabela.getSelectedRow());
							getP().salvarCentral(getC());
						}
						
						dispose();
						new ExibirLivro(conta, getC(), getP(), livro);
					}
				}

			}
		});

		JScrollPane roda = new JScrollPane(tabela);
		roda.setBounds(100, 430, 600, 260);
		add(roda);

		return roda;

	}
}