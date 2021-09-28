package janelas;

import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public abstract class EntradaDeInformacoes extends Janelas{
	//Cadastro e Login
	
	private JTextField nome;
	private JPasswordField senha;
	public EntradaDeInformacoes() {
		LogoTipo();
		setNome(criarTextFields("Nome de usuário",  290, 257, 231, 36, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setSenha(criarPasswordField("Senha", 290, 305, 231, 36, "#D7D7D7", "#D7D7D7", JLabel.CENTER,40));
	}
	
	private void LogoTipo() {
		JLabel logotipo = new JLabel(new ImageIcon(getClass().getResource("logotipo.jpg")));
		logotipo.setBounds(155,49,500,180);
		this.add(logotipo);
	}

	
	public JPasswordField criarPasswordField(String nome, int x, int y, int largura, int altura, String hexCorDoBackground,String hexCorDaBorda,int alinhamento,int arredondamentoDasBordas ) {
		JPasswordField senha = new RoundJPasswordField(nome,arredondamentoDasBordas,hexCorDaBorda);
		senha.addMouseListener(new OuvinteTextPass());
		senha.setBounds(x, y, largura, altura);
		senha.setBackground(Color.decode(hexCorDoBackground));
		senha.setHorizontalAlignment(alinhamento);
		this.add(senha);
		return senha;
	}

	public JTextField getNome() {
		return nome;
	}

	public void setNome(JTextField nome) {
		this.nome = nome;
	}

	public JPasswordField getSenha() {
		return senha;
	}

	public void setSenha(JPasswordField senha) {
		this.senha = senha;
	}
}
