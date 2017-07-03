package com.poslovna.dom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.poslovna.model.AnalitikaIzvoda;

/**
 * 
 * Primer demonstrira metode API-ja za potrebe programskog kreiranja DOM stabla. 
 * Pored programskog kreiranja DOM stabla, primer demonstrira i serijalizaciju
 * DOM stabla na proizvoljan stream (npr. FileOutputStream, System.out, itd.).
 *
 */
public class DOMWriter {

	private static String TARGET_NAMESPACE = "C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\xsd\\uplata2";

	private static String XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";
	
	private static DocumentBuilderFactory factory;
	
	private static TransformerFactory transformerFactory;
	
	private Document document;
	
	/*
	 * Factory initialization static-block
	 */
	static {
		factory = DocumentBuilderFactory.newInstance();
		
		transformerFactory = TransformerFactory.newInstance();
	}
	
	/**
	 * Generates document object model for a given XML file.
	 */
	public void createDocument() {

		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Kreiranje novog dokumenta 
			document = builder.newDocument(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Generates sample document object model 
	 * programmatically using DOM API methods. 
	 */
	public void generateDOM(AnalitikaIzvoda b) {
		
		// Kreiranje i postavljanje korenskog elementa
		Element rad = document.createElementNS(TARGET_NAMESPACE, "rad");
		document.appendChild(rad);
		
		//rad.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.ftn.uns.ac.rs/zavrsni_rad ../xsd/zavrsni_rad.xsd");
		//rad.setAttribute("vrsta_rada", "Diplomski rad");		
		
		//Element naslovnaStrana = document.createElementNS(TARGET_NAMESPACE, "naslovna_strana");
		//rad.appendChild(naslovnaStrana);
		
		Element podaci = document.createElementNS(TARGET_NAMESPACE, "podaci");
		rad.appendChild(podaci);
		
		Element uplatilac = document.createElementNS(TARGET_NAMESPACE, "uplatilac");
		uplatilac.appendChild(document.createTextNode(b.getNalogodavac()));
		podaci.appendChild(uplatilac);

		Element svrhaUplate = document.createElementNS(TARGET_NAMESPACE, "svrhaUplate");
		svrhaUplate.appendChild(document.createTextNode(b.getSvrhaPlacanja()));
		podaci.appendChild(svrhaUplate);
		
		Element primalac = document.createElementNS(TARGET_NAMESPACE, "primalac");
		primalac.appendChild(document.createTextNode(b.getPrimalac()));
		podaci.appendChild(primalac);

		Element mesto = document.createElementNS(TARGET_NAMESPACE, "mesto");
		mesto.appendChild(document.createTextNode("Novi Sad"));
		podaci.appendChild(mesto);
		
		Element podaci2 = document.createElementNS(TARGET_NAMESPACE, "podaci2");
		rad.appendChild(podaci2);
		
		Element potpis = document.createElementNS(TARGET_NAMESPACE, "potpis");
		potpis.appendChild(document.createTextNode("jmbg1"));
		podaci2.appendChild(potpis);
		
		Element datumPrijema = document.createElementNS(TARGET_NAMESPACE, "datumPrijema");
		datumPrijema.appendChild(document.createTextNode(b.getDatumPrijema()));
		podaci2.appendChild(datumPrijema);
		
		Element datumvalute = document.createElementNS(TARGET_NAMESPACE, "datumvalute");
		datumvalute.appendChild(document.createTextNode(b.getDatumValute()));
		podaci2.appendChild(datumvalute);
		
		Element podaci3 = document.createElementNS(TARGET_NAMESPACE, "podaci3");
		rad.appendChild(podaci3);

		Element sifra = document.createElementNS(TARGET_NAMESPACE, "sifra");
		sifra.appendChild(document.createTextNode("14"));
		podaci3.appendChild(sifra);
		
		Element valuta = document.createElementNS(TARGET_NAMESPACE, "valuta");
		valuta.appendChild(document.createTextNode("EUR"));
		podaci3.appendChild(valuta);

		Element iznos = document.createElementNS(TARGET_NAMESPACE, "iznos");
		iznos.appendChild(document.createTextNode("1000"));
		podaci3.appendChild(iznos);
		
		Element brojRacuna = document.createElementNS(TARGET_NAMESPACE, "brojRacuna");
		brojRacuna.appendChild(document.createTextNode(b.getRacunPoverioca()));
		podaci3.appendChild(brojRacuna);
		
		Element model = document.createElementNS(TARGET_NAMESPACE, "model");
		model.appendChild(document.createTextNode("99"));
		podaci3.appendChild(model);
		
		Element pozivNaBroj = document.createElementNS(TARGET_NAMESPACE, "pozivNaBroj");
		pozivNaBroj.appendChild(document.createTextNode("987654321"));
		podaci3.appendChild(pozivNaBroj);
		
	}
	
	/**
	 * Serializes DOM tree to an arbitrary OutputStream.
	 */
	public void transform(OutputStream out) {
		try {

			// Kreiranje instance objekta zaduzenog za serijalizaciju DOM modela
			Transformer transformer = transformerFactory.newTransformer();

			// Indentacija serijalizovanog izlaza
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			// Nad "source" objektom (DOM stablo) vrši se transformacija
			DOMSource source = new DOMSource(document);

			// Rezultujući stream (argument metode) 
			StreamResult result = new StreamResult(out);

			// Poziv metode koja vrši opisanu transformaciju
			transformer.transform(source, result);

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	static AnalitikaIzvoda www  = new AnalitikaIzvoda();
	
	public static void main() {

		String filePath = null;

		System.out.println("[INFO] DOM Parser");

		DOMWriter handler = new DOMWriter();

		// Kreiranje Document čvora
		handler.createDocument();

		
		www.setDatumPrijema("24-06-2017");
		www.setNalogodavac("Pera Peric");
		www.setPrimalac("Mika Mikic");
		www.setSvrhaPlacanja("Poklon");
		www.setDatumValute("24-06-2017");
		www.setRacunPoverioca("111123456789123412");
		
		/*
		www.setDatumPrijema(qwerty.getDatumPrijema());
		www.setNalogodavac(qwerty.getNalogodavac());
		www.setPrimalac(qwerty.getPrimalac());
		www.setSvrhaPlacanja(qwerty.getSvrhaPlacanja());
		www.setDatumValute(qwerty.getDatumValute());
		www.setRacunPoverioca(qwerty.getRacunPoverioca());
		//www.setIznos(qwerty.getIznos());
		*/
		
		
		// Generisanje DOM stabla
		handler.generateDOM(www);
		
		// Prikaz sadržaja (isprobati sa FileOutputStream-om)
		handler.transform(System.out);
		
		
		try {
			handler.transform(new FileOutputStream("C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\test\\aaa.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
