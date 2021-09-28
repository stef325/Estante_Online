package projeto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Persistencia {
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	public void salvarCentral(CentralDeInformacoes tudo) {
		File arquivo = new File("central.xml");
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(tudo);
			try {
				
				arquivo.createNewFile();
				PrintWriter gravar = new PrintWriter(arquivo);
				gravar.print(xml);
				gravar.close();
			} catch (IOException e) {
				e.printStackTrace();
				}
	}
	public CentralDeInformacoes recuperarCentral(String nomeXML) {
		File arquivo = new File(nomeXML);
			try {
				if(arquivo.exists()) {
					FileInputStream fis = new FileInputStream(arquivo);
					return (CentralDeInformacoes) xstream.fromXML(fis);
				}
				
			} catch (FileNotFoundException  e) {
				
				e.printStackTrace();
			}
			return new CentralDeInformacoes();
	}
}