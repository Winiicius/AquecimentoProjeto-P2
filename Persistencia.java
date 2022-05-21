package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import classes.CentralDeInformacoes;

public class Persistencia {
	private XStream xStream = new XStream(new DomDriver("UTF-8"));
	public void salvarCentral(CentralDeInformacoes cdi, String nomeDoarquivo){
		File arquivo = new File(nomeDoarquivo);
		try {
			arquivo.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw;
		try {
			pw = new PrintWriter(arquivo);
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
			xml += xStream.toXML(cdi);
			
			pw.print(xml);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public CentralDeInformacoes recuperarCentral(String nomeDoArquivo){
		File arquivo = new File(nomeDoArquivo);
		try {
			if(arquivo.exists()) {
				FileInputStream fis;
					fis = new FileInputStream(arquivo);
					return (CentralDeInformacoes) xStream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new CentralDeInformacoes();
	}
	
}
