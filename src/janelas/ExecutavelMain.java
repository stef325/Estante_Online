package janelas;

import projeto.CentralDeInformacoes;
import projeto.Persistencia;

public class ExecutavelMain {

	public static void main(String[] args) {
		Persistencia p = new Persistencia();
		CentralDeInformacoes c = new CentralDeInformacoes();
		c = p.recuperarCentral("central.xml");
		Login login = new Login(c,p);
	}
}
