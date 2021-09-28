package projeto;
public class LivroTecnico extends Livro{
	private String assunto;
	
	public LivroTecnico(String titulo, String resumo, String idioma, String editora, int anoDePublicacao, String capa,String genero, float avaliacao,int quantidade, float valor) {
		super(titulo, resumo, idioma, editora, anoDePublicacao, capa, genero, avaliacao, quantidade, valor);
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	public String toString() {
		return "Técnico";
	}

}
