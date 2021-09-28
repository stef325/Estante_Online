package projeto;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public abstract class GeradorDeRelatorios {
	public static void gerarRelatorio(ArrayList<Livro> livros, String relatorio) {
		Document doc = new Document(PageSize.A4);
		try {
			OutputStream arq = new FileOutputStream(relatorio);
			PdfWriter.getInstance(doc, arq);
			doc.open();
			for(int i = 0; i < livros.size(); i++) {
				String tipo = "";
				if(livros.get(i) instanceof LivroLiteratura) {
					tipo = "Livro de Literatura";
				}
				else if(livros.get(i) instanceof LivroDesenvolvimentoPessoal) {
					tipo = "Livro de Desenvolvimento Pessoal";
				}
				else if(livros.get(i) instanceof LivroPeriodico) {
					tipo = "Livro Peri�dico";
				}
				else if(livros.get(i) instanceof LivroTecnico) {
					tipo = "Livro T�cnico";
				}
				PdfPTable tabelaDeLivros = new PdfPTable(1);
				tabelaDeLivros.addCell(tipo);
				tabelaDeLivros.addCell("G�nero:"+livros.get(i).getGenero());
				tabelaDeLivros.addCell("ID:"+livros.get(i).getId());
				tabelaDeLivros.addCell("Titulo:"+livros.get(i).getTitulo());
				tabelaDeLivros.addCell("Resumo:"+livros.get(i).getResumo());
				tabelaDeLivros.addCell("Idioma:"+livros.get(i).getIdioma());
				tabelaDeLivros.addCell("Editora:"+livros.get(i).getEditora());
				tabelaDeLivros.addCell("Ano de publica��o: "+livros.get(i).getAnoDePublicacao());
				tabelaDeLivros.addCell("Visualiza��es: "+livros.get(i).getContador());
				if(livros.get(i).toString().equals("Literatura")) {
					LivroLiteratura livro = (LivroLiteratura) livros.get(i);
					tabelaDeLivros.addCell("Autores: "+livro.getAutores());
				}
				
				else if(livros.get(i).toString().equals("Desenvolvimento Pessoal")) {
					LivroDesenvolvimentoPessoal livro = (LivroDesenvolvimentoPessoal) livros.get(i);
					tabelaDeLivros.addCell("Autores: "+livro.getAutores());
				}
				else if(livros.get(i).toString().equals("T�cnico")) {
					LivroTecnico livro = (LivroTecnico) livros.get(i);
					tabelaDeLivros.addCell("Assunto: "+livro.getAssunto());
				}
				else if(livros.get(i).toString().equals("Peri�dico")) {
					LivroPeriodico livro = (LivroPeriodico) livros.get(i);
					tabelaDeLivros.addCell("M�s de lan�amendo: "+livro.getMes());
					tabelaDeLivros.addCell("N�mero da Edi��o: "+livro.getNumeroDaEdicao());
				}
				if(relatorio.equals("relat�rioInteresse.pdf") == true){
					tabelaDeLivros.addCell("Interesse: "+livros.get(i).getInteresse());
				}
				if(relatorio.equals("relat�rio.pdf") == true) {
					tabelaDeLivros.addCell("Quantidade: "+livros.get(i).getQuantidade());
				}
				tabelaDeLivros.addCell("Avalia��o de 0 a 5: "+livros.get(i).getAvaliacao());
				doc.add(tabelaDeLivros);
				Paragraph x = new Paragraph("\n\n");
				doc.add(x);
				}
			doc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
