package janelas;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.MensageiroDaSenha;
import projeto.Persistencia;


public class Login extends EntradaDeInformacoes{
	private JButton naoCadastrado;
	private JButton recuperarSenha;
	private JButton entrar;
	private CentralDeInformacoes c;
	private Persistencia p;
	public Login(CentralDeInformacoes c, Persistencia p) {
		this.setTitle("Login");
		this.p = p;
		this.c = c;
		naoCadastrado = botaoSemFundo("Não é cadastrado? clique aqui!", 300, 350, 20, 210);
		recuperarSenha = botaoSemFundo("Recuperar senha", 300, 370, 20, 210);
		entrar = criarBotao("Entrar",330, 400, 150, 36,"#169BD5","#FFFFFF", "#169BD5", 15);
		ouvinteLogin();
		if(c.getTodosAsContas().size() == 0) {
			new Cadastrar(c, p);
		}else {
			visible(true);
		}
		

	}

	private void ouvinteLogin() {
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( getNome().getText().equals("") || String.valueOf(getSenha().getPassword()).equals("") ) {
					JOptionPane.showMessageDialog(null, "Preencha todos o campos!", "Erro", JOptionPane.ERROR_MESSAGE, null);
				}
				else if(c.recuperarConta(getNome().getText(), String.valueOf(getSenha().getPassword())) != null){
					Conta logada = (c.recuperarConta(getNome().getText(), String.valueOf(getSenha().getPassword())));
					if(String.valueOf(getSenha().getPassword()).contains("senhatemporaria")) {
						new AlterarDados(logada, c, p);
						visible(false);
					}else {
						new MinhaEstante(logada,c,p);
						visible(false);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Conta não existe!", "Erro", JOptionPane.ERROR_MESSAGE, null);
				}
			}

		});

		naoCadastrado.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				visible(false);
				new Cadastrar(c, p);

			}

		});

		recuperarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = JOptionPane.showInputDialog("Informe seu Email");
				if(email.isEmpty() == false && email != null) {
					MensageiroDaSenha.recuperarSenha(email, c, p);
				}
			}
		});
	}


	public JButton botaoSemFundo(String nome,int x, int y, int altura, int largura) {
		JButton botao = new JButton(nome);
		botao.setBounds(x, y, largura, altura);
		botao.setHorizontalAlignment(JLabel.CENTER);
		botao.setForeground(Color.decode("#169BD5"));
		botao.setOpaque(false);
		botao.setContentAreaFilled(false);
		botao.setBorderPainted(false);
		this.add(botao);
		return botao;
	}
	public String toString() {
		return "pode";
	}


}




