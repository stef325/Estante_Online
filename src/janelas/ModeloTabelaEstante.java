package janelas;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import projeto.Livro;
import projeto.ThreadLivro;

public class ModeloTabelaEstante extends AbstractTableModel{

	private String colunas[] = {"Capa", "Título", "Categoria","Gênero", "Avaliação"};
	private ArrayList<Livro> livros;
	private final int colunaCapa = 0;
	private final int colunaTitulo = 1;
	private final int colunaCategoria = 2;
	private final int colunaGenero = 3;
	private final int colunaAvaliacao = 4;
	private ImageIcon[] icons;

	public ModeloTabelaEstante(ArrayList<Livro> Livros, JTable tabela, int larguraImagem, int alturaImagem) {
		this.livros = Livros;
		icons = new ImageIcon[livros.size()];
		for(int i = 0; i < livros.size(); i++) {
			new Thread(new ThreadLivro(livros.get(i), this, i, tabela, larguraImagem, alturaImagem)).start();;
		}
	}
	public void setIcons(ImageIcon icone, int indi) {
		icons[indi] = icone;
	}
	
	

	public int getColumnCount() {
		
		return colunas.length;
	}

	public int getRowCount() {

		return livros.size();
	}

	public String getColumnName(int indice) {
		return colunas[indice];
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case colunaCapa:
			return columnIndex == 1 ? ImageIcon.class : super.getColumnClass(columnIndex);
		case colunaTitulo:
			return String.class;
		case colunaCategoria:
			return String.class;
		case colunaGenero:
			return String.class;
		case colunaAvaliacao:
			return Float.class;
		default:
			return String.class;
		}
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		Livro livro= this.livros.get(rowIndex);
		switch (columnIndex) {
		case colunaCapa:
			return icons[rowIndex];
			
		case colunaTitulo:
			return livro.getTitulo();
		case colunaCategoria:
			return livro.toString();
		case colunaGenero:
			return livro.getGenero();
		case colunaAvaliacao:
			return livro.getAvaliacao() > 0? livro.getAvaliacao(): 0;
		}
		return null;
	}
	public List<Livro> getLivros() {
		   return Collections.unmodifiableList(livros);
	}
	
}
