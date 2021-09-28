package janelas;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Persistencia;

public abstract class ManipularLivro extends Janelas{
	//criar Livro e Editar Livro
	private JTextField titulo;
	private JTextArea autores;
	private JTextField numeroDaEdicao;
	private JTextField mes;
	private JTextField assunto;
	private JTextField dataDeLancamento;
	private JTextField idioma;
	private JTextField imagem;
	private JTextField editora;
	private JComboBox<String> categoria;
	private JComboBox<String> subClasses;
	private JTextField qtdEstoque;
	private JTextField valor;
	private JTextArea descricao;
	private String[] categori = {"                          Categoria:","Literatura", "Técnico","Periódico", "Desenvolvimento pessoal"};
	private String[] subL = {"                         Gênero:","literatura brasileira", "literatura estrangeira", "infanto juvenil", "artes", "biografias"," poesia"};
	private String[] subP = {"                         Gênero:","gibi", "revista de notícias"};
	private String[] subD = {"                         Gênero:","autoajuda", "religião", "saúde"};
	private String[] subT = {"                         Gênero:","paradidático", "formação profissional"};
	public ManipularLivro() {
		this.setSize(700, 550);
	}

	public JComboBox<String> criarComboBox(int x,int y, int largura,int altura, String[] vetor) {
		JComboBox<String> novoCB = new JComboBox<>(vetor);
		novoCB.setBounds(x, y, largura, altura);
		novoCB.setBorder(new RoundComboBox(40, "#D7D7D7"));
		novoCB.setBackground(Color.decode("#D7D7D7"));
		novoCB.setUI(new BasicComboBoxUI() {
			protected JButton createArrowButton() {
				JButton b = new JButton();
				b.setContentAreaFilled(false);
				b.setBorderPainted(false);
				return b; 
			}
		});
		add(novoCB);
		return novoCB;

	}
	public void ouvinteVoltar(JButton voltar,Conta logado, CentralDeInformacoes c, Persistencia p) {
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Painel(logado,c,p);
				visible(false);
			}
		});
	}
	
	public void desabilitando() {
		autores.setEnabled(false);
		numeroDaEdicao.setEnabled(false);
		mes.setEnabled(false);
		assunto.setEnabled(false);
	}
	

	public JTextField getTitulo() {
		return titulo;
	}


	public void setTitulo(JTextField titulo) {
		this.titulo = titulo;
	}


	public JTextArea getAutores() {
		return autores;
	}


	public void setAutores(JTextArea autores) {
		this.autores = autores;
	}


	public JTextField getDataDeLancamento() {
		return dataDeLancamento;
	}


	public void setDataDeLancamento(JTextField dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
	}



	public JComboBox<String> getCategoria() {
		return categoria;
	}


	public void setCategoria(JComboBox<String> categoria) {
		this.categoria = categoria;
	}


	public JTextField getQtdEstoque() {
		return qtdEstoque;
	}


	public void setQtdEstoque(JTextField qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}


	public JTextField getValor() {
		return valor;
	}


	public void setValor(JTextField valor) {
		this.valor = valor;
	}


	public String[] getCategori() {
		return categori;
	}

	public void setCategori(String[] categori) {
		this.categori = categori;
	}

	public JTextArea getDescricao() {
		return descricao;
	}

	public void setDescricao(JTextArea descricao) {
		this.descricao = descricao;
	}


	public String[] getSubL() {
		return subL;
	}

	public void setSubL(String[] subL) {
		this.subL = subL;
	}

	public String[] getSubP() {
		return subP;
	}

	public void setSubP(String[] subP) {
		this.subP = subP;
	}

	public String[] getSubD() {
		return subD;
	}

	public void setSubD(String[] subD) {
		this.subD = subD;
	}

	public String[] getSubT() {
		return subT;
	}

	public void setSubT(String[] subT) {
		this.subT = subT;
	}

	public JComboBox<String> getSubClasses() {
		return subClasses;
	}

	public void setSubClasses(JComboBox<String> subClasses) {
		this.subClasses = subClasses;
	}

	public JTextField getNumeroDaEdicao() {
		return numeroDaEdicao;
	}

	public void setNumeroDaEdicao(JTextField numeroDaEdicao) {
		this.numeroDaEdicao = numeroDaEdicao;
	}

	public JTextField getMes() {
		return mes;
	}

	public void setMes(JTextField mes) {
		this.mes = mes;
	}

	public JTextField getAssunto() {
		return assunto;
	}

	public void setAssunto(JTextField assunto) {
		this.assunto = assunto;
	}

	public JTextField getIdioma() {
		return idioma;
	}

	public void setIdioma(JTextField idioma) {
		this.idioma = idioma;
	}

	public JTextField getImagem() {
		return imagem;
	}

	public void setImagem(JTextField imagem) {
		this.imagem = imagem;
	}

	public JTextField getEditora() {
		return editora;
	}

	public void setEditora(JTextField editora) {
		this.editora = editora;
	}

}
