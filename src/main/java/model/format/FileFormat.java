package model.format;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.SortedSet;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import model.version.Selectors;

public class FileFormat {
	
	private Selectors selectors;
	private Document doc;
	private String classPackage;
	private String fileName;
	private SortedSet<String> importSet;
	private TypeFormat typeFormat;
	
	public FileFormat(File pFile, Selectors pSelectors) throws IOException {
		selectors = pSelectors;
		fileName = pFile.getName().replaceFirst(".html$", ".java");
		importSet = new TreeSet<>();
		doc = Jsoup.parse(pFile, "UTF-8", Paths.get(pFile.getParent()).toUri().toString());
		classPackage = retrievePackage();
		typeFormat = new TypeFormat(pFile.getParentFile(), doc, importSet, selectors);
	}
	
	private String retrievePackage() {
		Element element = doc.selectFirst(selectors.getPackageSelector());
		if (element != null) {
			return element.text();
		}
		return null;
	}
	
	@Override
	public String toString() {
		String fileInfo = "";
		if (classPackage != null) {
			fileInfo += "package " + classPackage + ";" + Util.LINE_BREAK;
		}
		fileInfo += Util.LINE_BREAK;
		
		for (String string : importSet) {
			fileInfo += "import " + string + ";" + Util.LINE_BREAK;
		}
		
		return fileInfo + Util.LINE_BREAK + typeFormat.toString();
	}
	
	public String getPackagePath() {
		return (classPackage == null)? "" : classPackage.replaceAll("\\.", "/");
	}
	
	public String getFileName() {
		return fileName;
	}
}
