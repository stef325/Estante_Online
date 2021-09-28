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

public class AlterarDados extends Janelas{
	private JButton alterar;
	private JButton voltar;
	private Conta logado;
	private CentralDeInformacoes c;
	private Persistencia p;
	private JTextField nome;
	private JTextField senha;
	public AlterarDados(Conta logado, CentralDeInformacoes c, Persistencia p) {
		this.setSize(300, 300);
		setTitle("Alterar Dados");
		this.logado = logado;
		this.c = c;
		this.p = p;
		criarJLabel("Nome:", 30, 50, 100, 36, 12);
		criarJLabel("Senha:", 30, 100, 100, 36, 12);
		nome = criarTextFields(logado.getNome(),100, 50, 100, 36,"#D7D7D7","#D7D7D7",JLabel.CENTER,40);
		senha = criarTextFields(logado.getSenha(),100, 100, 100, 36,"#D7D7D7","#D7D7D7",JLabel.CENTER,40);
		alterar = criarBotao("Alterar", 150, 200, 100, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		voltar = criarBotao("<- voltar", 45, 200, 100, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		ouvintesAlterar();
		visible(true);
	}
	public void ouvintesAlterar() {
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logado.setNome(nome.getText());
				logado.setSenha(senha.getText());
				p.salvarCentral(c);
				JOptionPane.showMessageDialog(null, "Cadastro atualizado", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
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
