package janelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import projeto.CentralDeInformacoes;
import projeto.Persistencia;



public abstract class Janelas extends JFrame{
	
//De onde todas as janelas vão partir
/**
 * Classe responsável pelo gerenciamento e desevolvimento de toda a parte gráfica do projeto, além de funcionar como classe mãe para todas as outras.
 * 
 * @author Bruna
 */
	
	
	public Janelas() {
		this.setSize(800, 600);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Método responsável pela criação de JButtons.
	 * 
	 * @return JButton
	 * @author Bruna
	 */
	public JButton criarBotao(String nome, int x, int y, int largura, int altura, String hexCorDoBackground, String hexCorDaLetra, String hexCorDaBorda, int arredondamentoDosCantos) {
		JButton botao = new RoundJButton(nome,arredondamentoDosCantos,hexCorDaBorda);
		botao.setBounds(x, y, largura, altura);
		botao.setBackground(Color.decode(hexCorDoBackground));
		botao.setForeground(Color.decode(hexCorDaLetra));

		this.add(botao);
		return botao;
	}
	/**
	 * Método responsável pela criação de JLabels.
	 * 
	 * @return JLabel
	 * @author Bruna
	 */
	public JLabel criarJLabel(String nome, int x, int y, int largura, int altura, int tamanhoDaLetra) {
		JLabel novoJL = new JLabel(nome);
		novoJL.setBounds(x,y,largura,altura);
		novoJL.setFont(new Font("Arial", Font.BOLD,tamanhoDaLetra));
		this.add(novoJL);
		return novoJL;
	}
	/**
	 * Método responsável pela criação de JTextFields.
	 * 
	 * @return JTextField
	 * @author Bruna
	 */
	public JTextField criarTextFields(String nome, int x, int y, int largura, int altura, String hexCorDoBackground,String hexCorDaBorda, int alinhamento,int arredondamentoDasBordas) {
		JTextField novoTF = new RoundJTextField(nome,arredondamentoDasBordas,hexCorDaBorda);
		if(this.toString().equals("pode")) {
			novoTF.addMouseListener(new OuvinteTextField());
		}
		novoTF.setBounds(x, y, largura, altura);
		novoTF.setHorizontalAlignment(alinhamento);
		novoTF.setBackground(Color.decode(hexCorDoBackground));
		this.add(novoTF);
		return novoTF;
	}
	
	/**
	 * Método responsável pela criação de JTextArea.
	 * 
	 * @return JTextField
	 * @author Bruna
	 */
	public JTextArea criarTextArea(String nome, int x, int y, int largura, int altura, String hexCorDoBackground,String hexCorDaBorda, int alinhamento,int arredondamentoDasBordas) {
		JTextArea novoTF = new RoundJTextArea(nome, arredondamentoDasBordas, hexCorDaBorda);
		novoTF.setLineWrap(true);
		if(this.toString().equals("pode")) {
			novoTF.addMouseListener(new OuvinteTextArea());
		}
		novoTF.setBounds(x, y, largura, altura);
		novoTF.setBackground(Color.decode(hexCorDoBackground));
		this.add(novoTF);
		return novoTF;
	}
	


	public void visible(boolean v) {
		setVisible(v);
	}



}
