package janelas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import projeto.CentralDeInformacoes;
import projeto.Conta;
import projeto.Persistencia;

public class MinhaEstante extends ClasseMenu{
	private DefaultTableModel modeloEstante;
	public MinhaEstante(Conta logado, CentralDeInformacoes c, Persistencia p) {
		super(logado, c, p);
		setTitle("Minha Estante");
		criarJLabel("MINHA ESTANTE", 350, 50, 250, 50,20);
		modeloEstante = geradorDeTableModel();
		if(logado.getLivrosUsuario() != null) {
			geradorDeTabela(logado.getLivrosUsuario(), 200,110,550,440);
		}
		setVisible(true);
	}
	
}
