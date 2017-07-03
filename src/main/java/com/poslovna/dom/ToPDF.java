package com.poslovna.dom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.clipper.Path;
import com.itextpdf.text.pdf.parser.clipper.Paths;
import com.poslovna.model.AnalitikaIzvoda;
import com.poslovna.model.DnevnoStanjeRacuna;
import com.poslovna.model.Racun;


public class ToPDF {
	
	public ToPDF() {
		// TODO Auto-generated constructor stub
	}

	public void makeMePDF(ArrayList<AnalitikaIzvoda> arrayList) throws FileNotFoundException, DocumentException{
		 
		Document document = new Document();
		
		PdfWriter.getInstance(document, new FileOutputStream("aaaa.pdf"));
		
		AnalitikaIzvoda qwerty = arrayList.get(0);
		
		
		
		document.open();

        Paragraph p = new Paragraph();
        p.add("Uplatilac: " + qwerty.getNalogodavac());
        p.setAlignment(Element.ALIGN_LEFT);
        p.add("\nPrimalac: " + qwerty.getPrimalac());
        p.setAlignment(Element.ALIGN_LEFT);
        p.add("\nSvrha uplate: " + qwerty.getSvrhaPlacanja());
        p.setAlignment(Element.ALIGN_LEFT); 
        p.add("\nMesto: Novi Sad");
        p.setAlignment(Element.ALIGN_LEFT);
        
        p.add("\n\n\n");
        
        p.add("\nDatum prijema: " + qwerty.getDatumPrijema());
        p.setAlignment(Element.ALIGN_LEFT);
        p.add("\nDatm valute: " + qwerty.getDatumValute());
        p.setAlignment(Element.ALIGN_LEFT);

        p.add("\n\n\n");
        
        p.add("\nSifra: 14");
        p.setAlignment(Element.ALIGN_LEFT);
        p.add("\nValuta: " + qwerty.getValuta().getNazivValute());
        p.setAlignment(Element.ALIGN_LEFT);
        p.add("\nIznos: " + Double.toString(qwerty.getIznos()));
        p.setAlignment(Element.ALIGN_LEFT);
        p.add("\nBroj Racuna: " + qwerty.getRacunDuznika());
        p.setAlignment(Element.ALIGN_LEFT);
        p.add("\nModel: 99");
        p.setAlignment(Element.ALIGN_LEFT);
        p.add("\nPoziv na broj: 123456789");
        p.setAlignment(Element.ALIGN_LEFT);
        

        document.add(p);
		
		document.close();
		
		
	}
	
}
