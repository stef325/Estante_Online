package projeto;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;

import janelas.ModeloTabelaEstante;

public class ThreadLivro implements Runnable{
	private Livro livro;
	private ModeloTabelaEstante modelo;
	private int indice;
	private JTable tabela;
	private int largura;
	private int altura;
	private JLabel capa;
	public ThreadLivro(Livro livro, ModeloTabelaEstante modelo, int indice, JTable tabela, int largura, int altura) {
		this.livro = livro;
		this.modelo = modelo;
		this.indice = indice;
		this.tabela = tabela;
		this.largura = largura;
		this.altura = altura;
	}

	public ThreadLivro(Livro livro, JLabel label, int largura, int altura) {
		this.livro = livro;
		this.largura = largura;
		this.altura = altura;
		this.capa = label;
	}


	public void run() {
		try {
			ImageIcon content = new ImageIcon(new URL(livro.getUrlcapa()));
			Image image = content.getImage();
			Image newimg = image.getScaledInstance(largura, altura,  java.awt.Image.SCALE_SMOOTH);
			content = new ImageIcon(newimg);
			modelo.setIcons(content, indice);
			tabela.repaint();

		} catch (IOException e) {
			e.printStackTrace();
		}catch (NullPointerException a) {
			try {
				ImageIcon content = new ImageIcon(new URL(livro.getUrlcapa()));
				Image image = content.getImage();
				Image newimg = image.getScaledInstance(largura, altura,  java.awt.Image.SCALE_SMOOTH);
				content = new ImageIcon(newimg);
				capa.setIcon(content);
				capa.repaint();

			} catch (MalformedURLException e) {

				e.printStackTrace();
			}



		}
	}



}