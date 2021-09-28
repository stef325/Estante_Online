package janelas;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Livro;
import projeto.LivroDesenvolvimentoPessoal;
import projeto.LivroLiteratura;
import projeto.LivroPeriodico;
import projeto.LivroTecnico;
import projeto.Persistencia;

public class EditarLivro extends ManipularLivro{
	private JButton confirmarAlteracao;
	private JTextField campoDoID;
	private JTextField categoria;
	private JTextField subGenero;
	private JButton voltar;
	private JButton buscar;
	private Conta logado;
	private CentralDeInformacoes c;
	private Persistencia p;
	private Livro livro;
	private LivroLiteratura ll;
	private LivroDesenvolvimentoPessoal ld;
	private LivroPeriodico lp;
	private LivroTecnico lt;
	
	public EditarLivro(Conta logado, CentralDeInformacoes c, Persistencia p) {
		this.setTitle("Editar livro");
		this.p = p;
		this.c = c;
		this.logado = logado;
		criarJLabel("EDITAR", 350, 20, 100, 30,20);
		voltar = criarBotao("<- voltar", 600, 35, 100, 30, "#D7D7D7", "#000000", "#D7D7D7", 40);
		buscar = criarBotao("Buscar", 500, 50, 80, 20, "#D7D7D7", "#000000", "#D7D7D7", 0);
		ouvinteVoltar(voltar, logado, c, p);
		campoDoID = criarTextFields("Livro a ser modificado", 250, 50, 231, 20, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 0);
		setImagem(criarTextFields("URL da capa", 250, 75, 231, 20, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setTitulo(criarTextFields("título", 100, 100, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setAutores(criarTextArea("\n                       Autores", 100, 210, 231, 60, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setNumeroDaEdicao(criarTextFields("Numero da Edição", 100, 275, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setMes(criarTextFields("Mês", 100, 310, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setAssunto(criarTextFields("Assunto", 100, 345, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setDataDeLancamento(criarTextFields("Ano de publicação", 400, 100, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setQtdEstoque(criarTextFields("Quantidade em estoque", 400, 135, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setValor(criarTextFields("Valor", 400, 170, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setIdioma(criarTextFields("Idioma", 400, 205, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setEditora(criarTextFields("Editora", 400, 240, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		setDescricao(criarTextArea("\n\n                       Descrição/Sinopse\t", 400, 275, 231, 100, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
		confirmarAlteracao = criarBotao("Confirmar alterações",300, 400, 170, 40,"#169BD5","#FFFFFF", "#169BD5", 15);
		desabilitando();
		ouvinteEditar();
		setVisible(true);
	}
	public void ouvinteEditar() {
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(campoDoID.getText().isEmpty() == false) {
					char numero = campoDoID.getText().charAt(0);
					if(Character.isDigit(numero) == true){
						long livroAchar = Long.parseLong(campoDoID.getText());
						livro = c.recuperarLivro(livroAchar);
						categoria = (criarTextFields(livro.toString(), 100, 135, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
						categoria.setEditable(false);
						subGenero = (criarTextFields(livro.getGenero(), 100, 170, 231, 30, "#D7D7D7", "#D7D7D7", JLabel.CENTER, 40));
						subGenero.setEditable(false);
						if(livro != null) {
							getTitulo().setText(livro.getTitulo());
							getDataDeLancamento().setText(livro.getAnoDePublicacao()+"");
							getDescricao().setText(livro.getResumo());
							getIdioma().setText(livro.getIdioma());
							getEditora().setText(livro.getEditora());
							getImagem().setText(livro.getUrlcapa());
							getQtdEstoque().setText(livro.getQuantidade()+"");
							getValor().setText(livro.getValor()+"");
							if(categoria.getText().equals("Literatura") || categoria.getText().equals("Desenvolvimento Pessoal")) {
								if(livro.toString().equals("Literatura")) {
									ll = (LivroLiteratura) livro;
									getAutores().setText(ll.getAutores());
									getAutores().setEnabled(true);
								}
								else if(livro.toString().equals("Desenvolvimento Pessoal")) {
									ld = (LivroDesenvolvimentoPessoal) livro;
									getAutores().setText(ld.getAutores());
									getAutores().setEnabled(true);
								}
							}
							else if(categoria.getText().equals("Periódico")) {
								lp = (LivroPeriodico) livro;
								getMes().setEnabled(true);
								getNumeroDaEdicao().setEnabled(true);
							}
							else if(categoria.getText().equals("Técnico")) {
								lt = (LivroTecnico) livro;
								getAssunto().setEnabled(true);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Esse Livro não Existe!", "Erro", JOptionPane.ERROR_MESSAGE, null);
						}

					}
					else {
						JOptionPane.showMessageDialog(null, "Preencha o Campo de busca!", "Erro", JOptionPane.ERROR_MESSAGE, null);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Preencha o Campo de busca!", "Erro", JOptionPane.ERROR_MESSAGE, null);
				}
			}});
		confirmarAlteracao.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ArrayList<Livro> livrosAlterados = c.getTodosOsLivros();
				int cont = livrosAlterados.size();
				for(int i = 0; i < cont; i++) {
					if(livrosAlterados.get(i).getId() == Long.parseLong(campoDoID.getText())) {
						livro.setTitulo(getTitulo().getText());
						livro.setAnoDePublicacao(Integer.parseInt(getDataDeLancamento().getText()));
						livro.setEditora(getEditora().getText());
						livro.setIdioma(getIdioma().getText());
						livro.setResumo(getDescricao().getText());
						livro.setUrlcapa(getImagem().getText());
						livro.setQuantidade(Integer.parseInt(getQtdEstoque().getText()));
						livro.setValor(Float.parseFloat(getValor().getText()));
						if(categoria.getText().equals("Literatura") || categoria.getText().equals("Desenvolvimento Pessoal")) {
							if(livro.toString().equals("Literatura")) {
								ll.setAutores(getAutores().getText());
								livro = ll;
							}
							else if(livro.toString().equals("Desenvolvimento Pessoal")) {
								ld.setAutores(getAutores().getText());
								livro = ld;
							}
						}
						else if(categoria.getText().equals("Periódico")) {
							lp.setMes(Integer.parseInt(getMes().getText()));
							lp.setAnoDePublicacao(Integer.parseInt(getDataDeLancamento().getText()));
							livro = lp;
						}
						else if(categoria.getText().equals("Técnico")) {
							lt.setAssunto(getAssunto().getText());
							livro = lt;
						}
						
						livrosAlterados.remove(i);
						livrosAlterados.add(livro);
						c.setTodosOsLivros(livrosAlterados);
						p.salvarCentral(c);
						new Painel(logado ,c,p);
						visible(false);
					}
				}
			}
		});
	}
}



