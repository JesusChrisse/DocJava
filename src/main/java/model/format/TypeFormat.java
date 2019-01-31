package model.format;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.version.Selectors;

class TypeFormat {
	
	private Selectors selectors;
	private Document doc;
	private Set<String> importSet;
	private String tabulation;
	
	private BlockFormat classDeclar;
	private List<BlockFormat> listFields;
	private List<BlockFormat> listConstructors;
	private List<BlockFormat> listMethods;
	private List<TypeFormat> listNestedClass;
	
	public TypeFormat(Document pDoc, Set<String> pImportSet, Selectors pSelectors) throws IOException, URISyntaxException {
		this(pDoc, pImportSet, pSelectors, "");
	}
	
	private TypeFormat(Document pDoc, Set<String> pImportSet, Selectors pSelectors, String pTabulation)
			throws IOException, URISyntaxException {
		
		//TODO: constant
		doc = pDoc;
		importSet = pImportSet;
		selectors = pSelectors;
		tabulation = pTabulation;
		
		classDeclar = retrieveClassDeclar();
		listFields = retrieveFields();
		listConstructors = retrieveConstructors();
		listMethods = retrieveMethods();
		listNestedClass = retrieveNestedClass();
	}
	
	private BlockFormat retrieveClassDeclar() throws IOException {
		return new BlockFormat(doc.selectFirst(selectors.getClassSelector()), selectors, importSet);
	}
	
	private List<BlockFormat> retrieveFields() throws IOException {
		List<BlockFormat> list = new LinkedList<>();
		Elements elements = doc.select(selectors.getFieldsSelector());
		for (Element element : elements) {
			list.add(new BlockFormat(element, selectors, importSet));
		}
		return list;
	}
	
	private List<BlockFormat> retrieveConstructors() throws IOException {
		List<BlockFormat> list = new LinkedList<>();
		Elements elements = doc.select(selectors.getConstructorsSelector());
		for (Element element : elements) {
			list.add(new BlockFormat(element, selectors, importSet));
		}
		return list;
	}
	
	private List<BlockFormat> retrieveMethods() throws IOException {
		List<BlockFormat> list = new LinkedList<>();
		Elements elements = doc.select(selectors.getMethodsSelector());
		for (Element element : elements) {
			list.add(new BlockFormat(element, selectors, importSet));
		}
		return list;
	}
	
	private List<TypeFormat> retrieveNestedClass() throws IOException, URISyntaxException {
		List<TypeFormat> list = new LinkedList<>();
		// get list of link (balise <a>) to the file of the nested class
		Elements links = doc.select(selectors.getNestedLinkSelector());
		for (Element link : links) {
			// NOTE: the File class must take a URI if not it won't work
			// and Jsoup must have a baseUri to be able to have a absolute Path
			list.add(new TypeFormat(Jsoup.parse(new File(new URI(link.absUrl("href"))), "UTF-8", doc.baseUri()), importSet, selectors, tabulation + "\t"));
		}
		
		return list;
	}
	
	@Override
	public String toString() {
		String chaine = tabulation
				+ classDeclar.toString().replaceAll(Util.LINE_BREAK_REGEX, Util.LINE_BREAK + tabulation) + " {"
				+ Util.LINE_BREAK;
		
		for (BlockFormat block : listFields) {
			// TODO: the adding of the values of the constant could be here
			chaine += Util.LINE_BREAK + "\t" + tabulation
					+ block.toString().replaceAll(Util.LINE_BREAK_REGEX, Util.LINE_BREAK + "\t" + tabulation) + ";"
					+ Util.LINE_BREAK;
		}
		
		for (BlockFormat block : listConstructors) {
			chaine += Util.LINE_BREAK + "\t" + tabulation
					+ block.toString().replaceAll(Util.LINE_BREAK_REGEX, Util.LINE_BREAK + "\t" + tabulation) + " {"
					+ Util.LINE_BREAK + "\t\t" + tabulation + Util.LINE_BREAK + "\t" + tabulation + "}"
					+ Util.LINE_BREAK;
		}
		
		for (BlockFormat block : listMethods) {
			chaine += Util.LINE_BREAK + "\t" + tabulation
					+ block.toString().replaceAll(Util.LINE_BREAK_REGEX, Util.LINE_BREAK + "\t" + tabulation) + " {"
					+ Util.LINE_BREAK + "\t\t" + tabulation + Util.LINE_BREAK + "\t" + tabulation + "}"
					+ Util.LINE_BREAK;
		}
		
		for (TypeFormat nested : listNestedClass) {
			chaine += Util.LINE_BREAK + nested.toString() + Util.LINE_BREAK;
		}
		
		return chaine + tabulation + "}";
	}
}
