package gerar_relatorios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import classes.Canal;
import classes.CentralDeInformacoes;
import classes.ProgramaDeTV;
import persistencia.Persistencia;

public class GeradorDeRelatorios {
	
	public static void obterProgramacaoDeUmCanal(Canal c) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes cdi = persistencia.recuperarCentral("central.xml");
		Document doc = new Document(PageSize.A4, 72, 72, 72, 72);
		
		try {
			PdfWriter.getInstance(doc, new FileOutputStream( "relatorio.pdf"));
			doc.open();
			
			Paragraph p = new Paragraph("PROGRAMAÇÃO");
			p.setSpacingAfter(20);
			p.setAlignment(Element.ALIGN_CENTER);
			doc.add(p);
			
			PdfPTable tabela = new PdfPTable(4);
			tabela.addCell("NOME DO PROGRAMA");
			tabela.addCell("TIPO");
			tabela.addCell("DIA DE TRANSMISSÃO");
			tabela.addCell("ID");
			
			for(ProgramaDeTV programa: cdi.getTodosOsProgramasDeTV()) {
				if(programa.getCanal().equals(c)) {
					tabela.addCell(programa.getNome());
					tabela.addCell(programa.getTipo().getDescricao());
					tabela.addCell(programa.getDia().toString());
					tabela.addCell(Long.toString(programa.getId()));
				}
			}
			doc.add(tabela);
			doc.close();
			
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
