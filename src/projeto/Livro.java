package projeto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import janelas.Comentario;

public abstract class Livro {
	private long id;
	private String titulo;
	private String resumo;
	private String idioma;
	private String editora;
	private int anoDePublicacao;
	private String urlcapa;
	private float avaliacao;
	private String genero;
	private int contador;
	private int quantidade;
	private float valor;
	private int interesse;
	private int quantidadeDeVotos;
	private ArrayList<Comentario> comentarios = new ArrayList<>();
	
	public Livro(String titulo, String resumo, String idioma, String editora, int anoDePublicacao, String capa,String genero, float avaliacao,int quantidade, float valor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.idioma = idioma;
		this.editora = editora;
		this.anoDePublicacao = anoDePublicacao;
		this.urlcapa = capa;
		this.genero = genero;
		this.avaliacao = avaliacao;
		this.id = System.currentTimeMillis();
		this.setQuantidade(quantidade);
		this.setValor(valor);
	}
	
	public String comparar() {
		return titulo;
	}
	public long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getAnoDePublicacao() {
		return anoDePublicacao;
	}
	public void setAnoDePublicacao(int anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getUrlcapa() {
		return urlcapa;
	}
	public void setUrlcapa(String urlcapa) {
		this.urlcapa = urlcapa;
	}
	public float getAvaliacao() {
		return avaliacao/quantidadeDeVotos;
	}
	public void setAvaliacao(float avaliação) {
		this.avaliacao += avaliação;
		this.quantidadeDeVotos +=1;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}



	public int getContador() {
		return contador;
	}



	public void setContador() {
		this.contador += 1;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}


	public int getInteresse() {
		return interesse;
	}


	public void setInteresse() {
		this.interesse += 1;
	}
	public void livroComprado() {
		quantidade -=1;
	}
	
	public ArrayList<Comentario> getComentario() {
		return comentarios;
	}


	public void setComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}
	
}
