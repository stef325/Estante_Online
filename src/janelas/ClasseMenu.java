package janelas;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Livro;
import projeto.Persistencia;



public abstract class ClasseMenu extends Janelas{
	private JButton minhaEstante;
	private JButton emAlta;
	private JButton categorias;
	private JButton encontreLivros;
	private JButton todosOslivros;
	private JButton usuario;
	private Conta logado;
	private CentralDeInformacoes c;
	private Persistencia p;
	private JScrollPane roda;
	
	/**
	 * atributo logado vai ser a conta que está sendo usada no momento
	 * atributo c vai ser usada para a manipulação da conta e dos livros
	 * e o atributo p para salvar a central c
	 * e esse construtor da ClasseMenu vai servir para ser herdado por todas as janelas e chamar os ouvintes de cada botao
	 * @param logado 
	 * @param c
	 * @param p
	 * @author filipe
	 */
	
	public ClasseMenu(Conta logado, CentralDeInformacoes c, Persistencia p) {
		this.logado = logado;
		this.p = p;
		this.c = c;
		minhaEstante = criarBotao("Minha estante",-10, 0, 230, 80,"#008080","#FFFFFF", "#008080", 15);
		emAlta = criarBotao("Em Alta",0, 70, 180, 70,"#169BD5","#FFFFFF", "#169BD5", 15);
		categorias = criarBotao("Categorias",0, 130, 160, 65,"#8400FF","#FFFFFF", "#8400FF", 15);
		encontreLivros = criarBotao("Encontre Livros",0, 185, 130, 60,"#420080","#FFFFFF", "#420080", 15);
		todosOslivros= criarBotao("Todos os livros",0, 235, 120, 55,"#015478","#FFFFFF", "#015478", 15);
		usuario = criarBotao(logado.getNome(),600, 10, 183, 50,"#FFFFFF","#000000", "#015478", 0);
		ouvintes(logado);
	}
	/**
	 * os ouvintes vao abrir o seu botao como evento de acordo com o botao apertado durante a execução passando como parametro
	 * os atriputos logado, c e p
	 * 
	 * @param ClasseMenu
	 * 
	 */

	private void ouvintes(Conta logado) {
		usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conta comparar = c.getTodosAsContas().get(0);
				if(comparar.equals(logado)) {
					new Painel(logado,c,p);
				}
				else {
					new PainelUsuario(logado, c, p);
				}
				visible(false);
			}	
		});

		minhaEstante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MinhaEstante(logado, c, p);
				visible(false);
			}
		});

		categorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Categorias(logado, c, p);
				visible(false);
			}
		});

		todosOslivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TodosOsLivrosJanela(logado, c, p);
				visible(false);
			}
		});

		encontreLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EncontrarLivro(logado, c, p);
				visible(false);
			}
		});

		emAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmAlta(logado, c, p);
				visible(false);
			}
		});
	}
	
	/**
	 * vai gerar um scroolpane que vai criar uma tabela dentro e receber como paramentro um array
	 * de livros e sua medida para o setbounds.
	 * 
	 * @return
	 */

	public JScrollPane geradorDeTabela(ArrayList<Livro> Livros, int x, int y, int largura, int altura) {

		JTable tabela = new JTable();
		ModeloTabelaEstante novaTabela = new ModeloTabelaEstante(Livros, tabela,100,100);
		tabela.setModel(novaTabela);
		tabela.getTableHeader().setReorderingAllowed(false);

		tabela.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				if (value instanceof ImageIcon) {
					ImageIcon icon = (ImageIcon) value;
					setIcon(icon);
					table.setRowHeight(row, icon.getIconHeight());
				}
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		});
		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).sizeWidthToFit();
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).sizeWidthToFit();
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(3).sizeWidthToFit();
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(4).setResizable(false);
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
				if (tabela.getSelectedRow() > -1) {
					dispose();
					ExibirLivro livroAberto = new ExibirLivro(logado, c, p, novaTabela.getLivros().get(tabela.getSelectedRow()));
					novaTabela.getLivros().get(tabela.getSelectedRow()).setContador();
					p.salvarCentral(c);
				}

			}
		});

		roda = new JScrollPane(tabela);
		roda.setBounds(x, y, largura, altura);
		add(roda);

		return roda;

	}
	/**
	 * gera a tabela com o as colunas inseridas no modelo
	 * @param geradorDeTableModel
	 */

	public DefaultTableModel geradorDeTableModel() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		JTable tabela = new JTable(modelo);
		tabela.setBounds(300, 300, 400, 100);
		add(tabela);

		return modelo;
	}
	/**
	 * returna a conta logada para as que seja usada nas outras java
	 * @return
	 */

	public Conta getLogado() {
		return logado;
	}
	/**
	 * seta uma nova conta quando necessario substituir
	 * @param logado
	 */
	public void setLogado(Conta logado) {
		this.logado = logado;
	}
	/**
	 * usar para pegar a mesma central ou instancia-la a outra
	 * @return
	 */
	public CentralDeInformacoes getC() {
		return c;
	}
	/**
	 * setar uma nova centra para substituila
	 * @param c
	 */
	public void setC(CentralDeInformacoes c) {
		this.c = c;
	}
	/**
	 * pegar a mesma persistencia para nao precisar criar outra 
	 * @return
	 */
	public Persistencia getP() {
		return p;
	}
	public void setP(Persistencia p) {
		this.p = p;
	}
	/**
	 * usei para alterar o tamanho do scrool pane para fazela desaparecer
	 * @return
	 */
	public JScrollPane getRoda() {
		return roda;
	}

	public void setRoda(JScrollPane roda) {
		this.roda = roda;
	}


}
