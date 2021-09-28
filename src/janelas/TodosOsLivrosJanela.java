package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Livro;
import projeto.Persistencia;

public class TodosOsLivrosJanela extends ClasseMenu{
	private ArrayList<Livro> livrosEmOrdem1 = new ArrayList<Livro>();
	private ArrayList<Livro> livrosEmOrdem2 = new ArrayList<Livro>();
	private DefaultTableModel modeloEstante;
	private String alf = "Alfabetica";
	private String avali = "Avaliação";
	private boolean f = true;
	private JButton filtrar;
	public TodosOsLivrosJanela(Conta logado, CentralDeInformacoes c, Persistencia p) {
		super(logado, c, p);
		setTitle("Todos os livros");
		livrosEmOrdem1.addAll(c.getTodosOsLivros());
		livrosEmOrdem2.addAll(c.getTodosOsLivros());
		criarJLabel("TODOS OS LIVROS", 330, 30, 250, 100,20);
		criarJLabel("Filtragem:", 520, 85, 150, 20,12);
		filtrar = criarBotao("Filtrar:Alfabetica, Avaliação",580, 85, 200, 20,"#169BD5","#FFFFFF", "#169BD5", 5);
		modeloEstante = geradorDeTableModel();
		geradorDeTabela(getC().getTodosOsLivros(), 200,110,550,440);
		ouvinteFiltro();
		setVisible(true);
	}
	public void ouvinteFiltro() {
		filtrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getRoda().setBounds(0,0,0,0);
				if(f == true) {
					f = false;
					filtrar.setText(alf);
				}
				else {
					f = true;
					filtrar.setText(avali);
				}
				chamarTabela();
			}
		});
	}
	public void chamarTabela() {
		if(filtrar.getText().equals(alf)) {
			getRoda().setBounds(0, 0, 0, 0);
			Collections.sort(livrosEmOrdem1, new Comparator<Livro>() {
				public int compare(Livro o1, Livro o2) {
					 return o1.comparar().compareTo(o2.comparar());
				}
			});
			geradorDeTabela(livrosEmOrdem1, 200,110,550,440);
		}
		
		else if(filtrar.getText().equals(avali)) {
			getRoda().setBounds(0, 0, 0, 0);
			Collections.sort(livrosEmOrdem2, new Comparador2());
			geradorDeTabela(livrosEmOrdem2, 200,110,550,440);
		}
		else {
			geradorDeTabela(getC().getTodosOsLivros(), 200,110,550,440);
		}
	}

}
class Comparador2 implements Comparator<Livro>{
	public int compare(Livro o1, Livro o2) {
		Livro c1 = (Livro)o1;
		Livro c2 = (Livro)o2;

		if (o1.getAvaliacao() > o2.getAvaliacao()) return -1;
		else if (o1.getAvaliacao() < o2.getAvaliacao()) return +1;
		else return 0;
	}
}

