package projeto;
public class LivroPeriodico extends Livro{
	private int mes;
	private int numeroDaEdicao;
	
	public LivroPeriodico(String titulo, String resumo, String idioma, String editora, int anoDePublicacao, String capa,String genero, float avaliacao, int quantidade, float valor) {
		super(titulo, resumo, idioma, editora, anoDePublicacao, capa, genero, avaliacao, quantidade, valor);
	}

	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getNumeroDaEdicao() {
		return numeroDaEdicao;
	}
	public void setNumeroDaEdicao(int numeroDaEdicao) {
		this.numeroDaEdicao = numeroDaEdicao;
	}
	
	public String toString() {
		return "Periódico";
	}

}
