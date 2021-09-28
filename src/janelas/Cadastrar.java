package janelas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Persistencia;

public class Cadastrar extends EntradaDeInformacoes{
	private JTextField email;
	private JButton cadastrar;
	private CentralDeInformacoes c;
	private Persistencia p;
	private JButton voltar;
	public Cadastrar(CentralDeInformacoes c, Persistencia p) {
		this.p = p;
		this.c = c;
		this.setTitle("Cadastrar");
		email = criarTextFields("E-mail",290, 353, 231, 36,"#D7D7D7","#D7D7D7",JLabel.CENTER,40);
		cadastrar = this.criarBotao("Cadastrar",330, 400, 150, 36,"#169BD5","#FFFFFF", "#169BD5", 15);
		voltar = criarBotao("<- voltar", 700, 35, 100, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		ouvinteCadastrar();
		visible(true);
	}

	private void ouvinteCadastrar() {
		
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( getNome().getText().equals("") || String.valueOf(getSenha().getPassword()).equals("") || email.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos o campos!", "Erro", JOptionPane.ERROR_MESSAGE, null);
				}
				
				else if(email.getText().contains("@") == false) {
					JOptionPane.showMessageDialog(null, "Não parece ser um Email!", "Erro", JOptionPane.ERROR_MESSAGE, null);
				}
				
				else if(c.recuperarConta(getNome().getText(), String.valueOf(getSenha().getPassword())) != null) {
					JOptionPane.showMessageDialog(null, "Conta ja Cadastrada!", "Erro", JOptionPane.ERROR_MESSAGE, null);
				}
				else {
					Conta conta = new Conta();
					conta.setNome(getNome().getText());
					conta.setSenha(String.valueOf(getSenha().getPassword()));
					conta.setEmail(email.getText());
					c.adicionarConta(conta);
					p.salvarCentral(c);
					new MinhaEstante(conta, c, p);
					visible(false);
				}
			}
		});
		
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login(c, p);
				visible(false);
			}
		});
	}
	public String toString() {
		return "pode";
	}
}
