package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.SortedSet;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.format.FileFormat;
import model.version.Selectors;
import model.version.SelectorsVersions;

public class DocJava {
	
	private Selectors selectors;
	private File source;
	private File destination;
	private SortedSet<File> filesSet;
	private SortedSet<FileFormat> filesFormatSet;

	public DocJava(File pSource, File pDestination, int version) throws IOException {
		switch (version) {
			case 7:
				selectors = SelectorsVersions.V7;
				break;
			case 8:
				selectors = SelectorsVersions.V8;
				break;
			case 9:
				selectors = SelectorsVersions.V9;
				break;
			case 10:
				selectors = SelectorsVersions.V10;
				break;
			default:
				throw new IOException("This version of JavaDoc is not supported by DocJava.");
		}
		
		if (validationSource(pSource) && validationDestination(pDestination)) {
			source = pSource;
			destination = pDestination;
			filesSet = new TreeSet<>();
			filesFormatSet = new TreeSet<>();
			
			init();
		}
	}
	
	private boolean validationSource(File pSource) throws IOException {
		if (!pSource.exists())
			throw new IOException("The source must exist.");
		if (!pSource.canRead())
			throw new IOException("You do not have sufficient permissions to read the specified source. Check your file permissions.");
		return true;
	}
	
	private boolean validationDestination(File pDestination) throws IOException {
		if (!pDestination.exists())
			throw new IOException("The destination must exist.");
		if (!pDestination.isDirectory())
			throw new IOException("The destination must be a directory.");
		if (!pDestination.canWrite())
			throw new IOException("You do not have sufficient permissions to write in the specified destination. Check your file permissions.");
		return true;
	}
	
	private void init() throws IOException {
		if (source.isDirectory())
			convertAllFiles();
		else
			convertSingleFile(source);
	}
	
	private void convertAllFiles() throws IOException {
		File allClass = new File(source, selectors.getFileAllClassName());
		if (!allClass.exists()) {
			allClass = new File(source, selectors.getFileAllClassFrameName());
			if (!allClass.exists()) {
				throw new IOException("Can't convert this JavaDoc folder. File missing: \"" + selectors.getFileAllClassName() + "\" or \"" + selectors.getFileAllClassFrameName() + "\"");
			}
		}
		
		Document doc = Jsoup.parse(allClass, "UTF-8", Paths.get(allClass.getParent()).toUri().toString());
		Elements eles = doc.select(selectors.getAllClassSelector());
		for (Element element : eles) {
//			element. attribut href
		}
			
	}
	
	private void convertSingleFile(File file) {
		
	}
	
	public static void main(String[] args) {
//		try {
//			System.out.println(new FileFormat(new File(new URI("file:///E:/workspace/DocJava/docTest/String.html")), new VersionOld(8)));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		File a = new File("E:\\workspace\\DocJava\\src\\main\\resources\\docTest");
		File b = new File(a, "allclasses-frame.html");
		
		System.out.println(a.getName());
	}
}
