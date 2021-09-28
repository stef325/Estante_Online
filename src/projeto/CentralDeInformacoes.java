package projeto;

import java.util.ArrayList;

public class CentralDeInformacoes {
	private ArrayList<Livro> todosOsLivros = new ArrayList<>();
	private ArrayList<Conta> todosAsContas = new ArrayList<>();
	
	//Livros
	


	public boolean adicionarLivro(Livro novoLivro) {

		if(recuperarLivro(novoLivro.getId()) != null) {
			return false;
		}

		todosOsLivros.add(novoLivro);
		return true;
	}
	public Livro recuperarLivro(long id) {
		int quant = this.todosOsLivros.size();
		for(int i = 0; i < quant ; i++) {
			if(this.todosOsLivros.get(i).getId() == id) {
				return todosOsLivros.get(i);
			}
		}
		return null;
	}
	public ArrayList<Livro> getTodosOsLivros() {
		return todosOsLivros;
	}
	public void setTodosOsLivros(ArrayList<Livro> todosOsLivros) {
		this.todosOsLivros = todosOsLivros;
	}
	
	//Contas
	
	public ArrayList<Conta> getTodosAsContas() {
		return todosAsContas;
	}
	public void setTodosAsContas(ArrayList<Conta> todosAsContas) {
		this.todosAsContas = todosAsContas;
	}
	
	public boolean adicionarConta(Conta novaConta) {

		if((recuperarConta(novaConta.getNome(), novaConta.getSenha())) != null) {
			return false;
		}

		todosAsContas.add(novaConta);
		return true;
	}
	public Conta recuperarConta(String nome, String senha) {
		int quant = this.todosAsContas.size();
		for(int i = 0; i < quant ; i++) {
			if((todosAsContas.get(i).getNome().equals(nome) && todosAsContas.get(i).getSenha().equals(senha))) {
				return todosAsContas.get(i);
			}
		}
		return null;
	}

}
