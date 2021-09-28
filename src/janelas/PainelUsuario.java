package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Persistencia;

public class PainelUsuario extends Janelas{
	private JButton alterarDados;
	private JButton config;
	private JButton sair;
	private Conta logado;
	private CentralDeInformacoes c;
	private Persistencia p;
	private JButton voltar;
	
	public PainelUsuario(Conta logado, CentralDeInformacoes c, Persistencia p) {
		this.logado = logado;
		this.p = p;
		this.c = c;
		this.setSize(500, 300);
		criarJLabel("Painel de controle", 250, 30, 220, 50,20);
		criarJLabel(logado.getNome(), 90, 75, 150, 150,12);
		voltar = criarBotao("<- voltar", 400, 20, 100, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		alterarDados = criarBotao("Alterar dados",220,100, 220, 30,"#D7D7D7","#000000", "#D7D7D7", 30);
		config = criarBotao("Configurações de visualização",220,140, 220, 30,"#D7D7D7","#000000", "#D7D7D7", 30);
		sair = criarBotao("Sair da conta",30,170, 120, 30,"#169BD5","#FFFFFF", "#169BD5", 15);
		Ouvintes();
		visible(true);
	}
	private void Ouvintes() {
		
		alterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AlterarDados(logado, c, p);
				visible(false);
				
			}
		});
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
		
	}
}
