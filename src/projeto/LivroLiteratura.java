package projeto;

import java.util.ArrayList;

public class LivroLiteratura extends Livro{
	private String autores;
	
	public LivroLiteratura(String titulo, String resumo, String idioma, String editora, int anoDePublicacao,String capa,String genero, float avaliacao, int quantidade, float valor) {
		super(titulo, resumo, idioma, editora, anoDePublicacao, capa, genero, avaliacao, quantidade, valor);
	}
	
	public String getAutores() {
		return autores;
	}


	public void setAutores(String autores) {
		this.autores = autores;
	}
	
	public String toString() {
		return "Literatura";
	}



}
