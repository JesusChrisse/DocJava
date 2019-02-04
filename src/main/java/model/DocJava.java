package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

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
	private List<FileFormat> filesFormatSet;

	public DocJava(File pSource, File pDestination, int version) throws IOException {
		selectors = new SelectorsVersions(version);
		
		if (validationSource(pSource) && validationDestination(pDestination)) {
			source = pSource;
			destination = pDestination;
			filesFormatSet = new LinkedList<>();
			
			init();
		}
	}
	
	private boolean validationSource(File pSource) throws IOException {
		if (!pSource.exists())
			throw new IOException("The source must exist.");
		if (!pSource.isDirectory() && !pSource.isFile())
			throw new IOException("The source must be a file or a directory.");
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
			formatAllFiles();
		else
			formatSingleFile();
		
		writeFiles();
	}
	
	private void formatAllFiles() throws IOException {
		File allClass = new File(source, selectors.getFileAllClassName());
		if (!allClass.exists()) {
			allClass = new File(source, selectors.getFileAllClassFrameName());
			if (!allClass.exists()) {
				throw new IOException("Can't convert this JavaDoc folder. File missing: \"" + selectors.getFileAllClassName() + "\" or \"" + selectors.getFileAllClassFrameName() + "\"");
			}
		}
		
		for (String fileName : getAllFilesName(allClass)) {
			filesFormatSet.add(new FileFormat(new File(source, fileName), selectors));
		}
		
	}
	
	private List<String> getAllFilesName(File allClassFile) throws IOException {
		List<String> list = new LinkedList<>();
		Document doc = Jsoup.parse(allClassFile, "UTF-8", Paths.get(allClassFile.getParent()).toUri().toString());
		Elements eles = doc.select(selectors.getAllClassSelector());
		for (Element element : eles) {
			list.add(element.attr("href"));
		}
		return list;
	}
	
	private void formatSingleFile() throws IOException {
		filesFormatSet.add(new FileFormat(source, selectors));
	}
	
	private void writeFiles() throws IOException {
		for (FileFormat fileFormat : filesFormatSet) {
			File file = new File(destination, fileFormat.getPackagePath() + "/" + fileFormat.getFileName());
			
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs(); //TODO: add check if doesn't work
			}
			
			file.createNewFile(); //TODO: add check if doesn't work
			
			FileWriter writer = new FileWriter(file);
			writer.write(fileFormat.toString());
			writer.flush();
			writer.close();
		}
	}
	
	public static void main(String[] args) {
//		try {
//			System.out.println(new FileFormat(new File(new URI("file:///E:/workspace/DocJava/docTest/String.html")), new VersionOld(8)));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		File sc = new File("E:\\workspace\\DocJava\\src\\main\\resources\\docTest");
		File dt = new File("E:\\workspace\\DocJava\\src\\main\\resources\\destinationTest");
//		
//		System.out.println(a.getName());
		
		try {
			DocJava dj = new DocJava(sc, dt, 8);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
