package janelas;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Livro;
import projeto.Persistencia;

public class CategoriaLivros extends ClasseMenu{
	private DefaultTableModel modeloEstante;
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	private String categoria;
	public CategoriaLivros(Conta logado, CentralDeInformacoes c, Persistencia p, String categoria) {
		super(logado, c, p);
		setTitle(categoria);
		this.categoria = categoria;
		criarJLabel(categoria, 370, 50, 250, 50,20);
		modeloEstante = geradorDeTableModel();
		preencherLivros();
		geradorDeTabela(livros, 200,110,550,440);
		visible(true);
	}
	
	public void preencherLivros() {
		ArrayList<Livro> passar = getC().getTodosOsLivros();
		for(int i = 0; i < passar.size(); i++) {
			if(categoria.equals("Literatura")) {
				if(passar.get(i).toString().equals(categoria)) {
					livros.add(passar.get(i));
				}
			}
			else if(categoria.equals("Desenvolvimento Pessoal")) {
				if(passar.get(i).toString().equals(categoria)) {
					livros.add(passar.get(i));
				}
			}
			else if(categoria.equals("Periódico")) {
				if(passar.get(i).toString().equals(categoria)) {
					livros.add(passar.get(i));
				}
			}
			else if(categoria.equals("Técnico")) {
				if(passar.get(i).toString().equals(categoria)) {
					livros.add(passar.get(i));
				}
			}
		}
	}
}
