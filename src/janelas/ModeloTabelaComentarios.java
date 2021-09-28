package janelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import projeto.Livro;

public class ModeloTabelaComentarios extends AbstractTableModel{
	
	private String colunas[] = {"Nome", "Comentário","Data de publicação"};
	private ArrayList<Comentario> comentarios= new ArrayList<>();
	
	private final int colunaNome = 0;
	private final int colunaComentario = 1;
	private final int colunaDataPubli = 2;
	
	

	public ModeloTabelaComentarios(Livro livro) {
		comentarios.addAll(livro.getComentario());
		
	}


	public int getColumnCount() {
		
		return colunas.length;
	}

	public int getRowCount() {

		return comentarios.size();
	}

	public String getColumnName(int indice) {
		return colunas[indice];
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case colunaNome:
			return String.class;
		case colunaComentario:
			return String.class;
		case colunaDataPubli:
			return String.class;
		default:
			return String.class;
		}
		
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		Comentario comentario= this.comentarios.get(rowIndex);
		switch (columnIndex) {
		case colunaNome:
			return comentario.getAutor();
			
		case colunaComentario:
			return comentario.getComentario();
		case colunaDataPubli:
			return comentario.getDataPost();
		}
		return null;
	}

}