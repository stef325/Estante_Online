package janelas;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Livro;
import projeto.Persistencia;
import projeto.TipoDoLivro;




public class AdicionarLivro extends ManipularLivro{
	private JButton adicionar;
	private JButton voltar;
	private Conta logado;
	private CentralDeInformacoes c;
	private Persistencia p;
	public AdicionarLivro(Conta logado, CentralDeInformacoes c, Persistencia p) {
		this.setTitle("Adicionar um livro");
		this.p = p;
		this.c = c;
		this.logado = logado;
		criarJLabel("NOVO LIVRO", 300, 20, 200, 30, 20);
		voltar = criarBotao("<- voltar", 600, 35, 100, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		ouvinteVoltar(voltar, logado, c, p);
		setTitulo(criarTextFields("Adicionar título", 100, 100, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setCategoria(criarComboBox(100, 135, 231, 30, getCategori()));
		setAutores(criarTextArea("Adicionar Autores", 100, 210, 231, 60, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setNumeroDaEdicao(criarTextFields("Numero da Edição", 100, 275, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setMes(criarTextFields("Mês", 100, 310, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setAssunto(criarTextFields("Assunto", 100, 345, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setImagem(criarTextFields("URL da capa", 250, 65, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setDataDeLancamento(criarTextFields("Ano de publicação", 400, 100, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setQtdEstoque(criarTextFields("Quantidade em estoque", 400, 135, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setValor(criarTextFields("Valor", 400, 170, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setIdioma(criarTextFields("Idioma", 400, 205, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setEditora(criarTextFields("Editora", 400, 240, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setDescricao(criarTextArea("\n\n                       Descrição/Sinopse\t", 400, 275, 231, 100, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		adicionar = criarBotao("Adicionar",300, 400, 150, 40,"#169BD5","#FFFFFF", "#169BD5", 15);
		getCategoria().addActionListener(new OuvinteBox(this));
		desabilitando();
		ouvinteAdicionar();
		setVisible(true);
	}

	public void ouvinteAdicionar() {
		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoDoLivro criando = new TipoDoLivro();
				String categoria = (String) getCategoria().getSelectedItem();
				char dataConfirmar = getDataDeLancamento().getText().charAt(0);
				char quaConfirmar = getQtdEstoque().getText().charAt(0);
				char valoConfirmar = getValor().getText().charAt(0);
				Livro novoLivro = null;
				if(Character.isDigit(dataConfirmar) == false){
					JOptionPane.showMessageDialog(null, "Erro no ano de Publicação! Coloque uma data valida!", "Erro", JOptionPane.ERROR_MESSAGE, null);
				}
				else if(Character.isDigit(quaConfirmar) == false){
					JOptionPane.showMessageDialog(null, "Erro na quantidade! Coloque um número", "Erro", JOptionPane.ERROR_MESSAGE, null);
				}
				else if(Character.isDigit(valoConfirmar) == false){
					JOptionPane.showMessageDialog(null, "Erro na valor! Coloque um número", "Erro", JOptionPane.ERROR_MESSAGE, null);
				}



				else if(categoria.equals("") || getTitulo().getText().equals("") || getDescricao().getText().equals("") || getIdioma().getText().equals("") || getEditora().getText().equals("") ||
						getImagem().getText().equals("") || getCategoria().getSelectedIndex() == 0 || getSubClasses().getSelectedIndex() == 0 ||getQtdEstoque().getText().equals("") || getValor().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE, null);
				}
				else {
					String genero = (String) getSubClasses().getSelectedItem();
					int data = Integer.parseInt(getDataDeLancamento().getText());

					novoLivro = criando.tipoL( categoria, getTitulo().getText(), getDescricao().getText(), getIdioma().getText(),
							getEditora().getText(),	data, getImagem().getText(), genero, 0, Integer.parseInt(getQtdEstoque().getText()), Integer.parseInt(getValor().getText()));

					if(getCategoria().getSelectedIndex() == 1 || getCategoria().getSelectedIndex() == 4) {
						criando.atributosLiteraturaDesenvolvimento(novoLivro, getAutores().getText());
					}
					else if(getCategoria().getSelectedIndex() == 2){
						criando.atributoTecnico(novoLivro, getAssunto().getText());
					}
					else if(getCategoria().getSelectedIndex() == 3){
						char mesConfirmar = getMes().getText().charAt(0);
						char edicaoConfirmar = getNumeroDaEdicao().getText().charAt(0);
						if(Character.isDigit(mesConfirmar) == false){
							JOptionPane.showMessageDialog(null, "Erro no mes! Coloque um número", "Erro", JOptionPane.ERROR_MESSAGE, null);
						}
						else if(Character.isDigit(edicaoConfirmar) == false){
							JOptionPane.showMessageDialog(null, "Erro na edição! Coloque um número", "Erro", JOptionPane.ERROR_MESSAGE, null);
						}
						else {
							criando.atributoPeriodico(novoLivro, Integer.parseInt(getMes().getText()), Integer.parseInt(getNumeroDaEdicao().getText()));
						}
					}
					c.adicionarLivro(novoLivro);
					p.salvarCentral(c);
					new Painel(logado ,c,p);
					visible(false);
				}
			}
		});
	}
	public String toString() {
		return "pode";
	}

}
