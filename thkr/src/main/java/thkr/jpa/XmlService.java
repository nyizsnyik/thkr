package thkr.jpa;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import thkr.model.*;

public class XmlService {

	public static List<Lakas> getAllLakas() {
		List<Lakas> lakasList = new ArrayList<Lakas>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder;
		try {
			dbuilder = factory.newDocumentBuilder();
			Document doc = dbuilder.parse(new File("Lakas.xml"));
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Lakas");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				Element eElement = (Element) nNode;
				String ajtoSzam = eElement.getAttribute("id");
				String nev = (eElement.getElementsByTagName("nev")).item(0).getTextContent();
				String szSzam = (eElement.getElementsByTagName("szSzam")).item(0).getTextContent();
				String tel = (eElement.getElementsByTagName("tel")).item(0).getTextContent();
				lakasList.add(new Lakas(ajtoSzam, nev, szSzam, tel));
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lakasList;
	}
	
	public static Futes getFutes(Lakas lakas){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder;
		try {
			dbuilder = factory.newDocumentBuilder();
			Document doc = dbuilder.parse(new File("Futes.xml"));
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Futes");
			for(int i=0;i<nList.getLength();i++){
				Node nNode = nList.item(i);
				Element eElement = (Element) nNode;
				System.out.println(eElement.getAttribute("id"));
				if(eElement.getAttribute("id").equals(lakas.getAjtoSzam())){
					
					String ajtoSzam = eElement.getAttribute("id");
					
					int aktualisOsszeg= Integer.parseInt( eElement.getElementsByTagName("aktualisOsszeg").item(0).getTextContent());
					
					Element e = (Element) eElement.getElementsByTagName("lejaratiDatum").item(0);
					LocalDate lejaratiDatum= LocalDate.of(Integer.parseInt(e.getElementsByTagName("ev").item(0).getTextContent()), 
														  Integer.parseInt(e.getElementsByTagName("honap").item(0).getTextContent()),
														  Integer.parseInt(e.getElementsByTagName("nap").item(0).getTextContent()));
					
					int lejartTartozas= Integer.parseInt( eElement.getElementsByTagName("lejartTartozas").item(0).getTextContent());
					
					e = (Element) eElement.getElementsByTagName("utorsoKamatozas").item(0);
					LocalDate utorsoKamatozas= LocalDate.of(Integer.parseInt(e.getElementsByTagName("ev").item(0).getTextContent()), 
														  Integer.parseInt(e.getElementsByTagName("honap").item(0).getTextContent()),
														  Integer.parseInt(e.getElementsByTagName("nap").item(0).getTextContent()));
					
					return new Futes(ajtoSzam,aktualisOsszeg,lejaratiDatum,lejartTartozas,utorsoKamatozas);
					
					
				}
			}
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
