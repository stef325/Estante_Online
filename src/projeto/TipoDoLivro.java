package projeto;
public class TipoDoLivro {
	
	public Livro tipoL(String tipo, String titulo, String resumo, String idioma,  String editora, int anoDePublicacao, String capa, String genero, float avaliacao, int quantidade, float valor) {
		switch (tipo) {
		case "Literatura":
			return new LivroLiteratura(titulo, resumo, idioma, editora, anoDePublicacao, capa, genero, avaliacao, quantidade, valor);
		case "Técnico":
			return new LivroTecnico(titulo, resumo, idioma, editora, anoDePublicacao, capa, genero, avaliacao, quantidade, valor);
		case "Periódico":
			return new LivroPeriodico(titulo, resumo, idioma, editora, anoDePublicacao, capa, genero, avaliacao, quantidade, valor);
		case "Desenvolvimento pessoal":
			return new LivroDesenvolvimentoPessoal(titulo, resumo, idioma, editora, anoDePublicacao, capa, genero, avaliacao, quantidade, valor);
		default:
			return null;
		}
	}
	public void atributosLiteraturaDesenvolvimento(Livro livro, String autores) {
		if(livro instanceof LivroLiteratura) {
			((LivroLiteratura) livro).setAutores(autores);
		}
		else if(livro instanceof LivroDesenvolvimentoPessoal) {
			((LivroDesenvolvimentoPessoal) livro).setAutores(autores);
		}
	}
	public void atributoPeriodico(Livro livro,int mes, int numeroDaEdicao) {
		((LivroPeriodico) livro).setMes(mes);
		((LivroPeriodico) livro).setNumeroDaEdicao(numeroDaEdicao);
	}
	public void atributoTecnico(Livro livro, String assunto) {
		((LivroTecnico) livro).setAssunto(assunto);
	}
}
