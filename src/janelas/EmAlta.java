package janelas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.table.DefaultTableModel;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Livro;
import projeto.Persistencia;

public class EmAlta extends ClasseMenu{
	private DefaultTableModel modeloEstante;
	private ArrayList<Livro> livrosEmOrdemC = new ArrayList<Livro>();
	public EmAlta(Conta logado, CentralDeInformacoes c, Persistencia p) {
		super(logado, c, p);
		setTitle("Em Alta");
		criarJLabel("EM ALTA", 400, 50, 100, 50,20);
		modeloEstante = geradorDeTableModel();
		livrosEmOrdemC.addAll(getC().getTodosOsLivros());
		Collections.sort(livrosEmOrdemC, new Comparador());
		geradorDeTabela(livrosEmOrdemC, 200,110,550,440);
		visible(true);
	}

}
class Comparador implements Comparator<Livro>{
	public int compare(Livro o1, Livro o2) {
		Livro c1 = (Livro)o1;
		Livro c2 = (Livro)o2;

		if (o1.getContador() > o2.getContador()) return -1;
		else if (o1.getContador() < o2.getContador()) return +1;
		else return 0;
	}
}
