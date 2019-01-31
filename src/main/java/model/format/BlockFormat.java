package model.format;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.version.Selectors;

/**
 * Class retrieving and formating block of data (declaration, description, and
 * tags)
 * 
 * @author Christophe Nadeau
 */
class BlockFormat {
	
	private static final String GN_DECLAR = "d";
	private static final String GN_ANNOTATION = "a";
	private Selectors selectors;
	private Set<String> importSet;
	
	private String description;
	private List<String> tags;
	private String declaration;
	
	/**
	 * Retrieve declaration formated, description and tag formated
	 * 
	 * @param pElement block of description (balise li for search optimized)
	 * @throws IOException if declaration not found
	 */
	public BlockFormat(Element pElement, Selectors pSelectors, Set<String> pImport) throws IOException {
		selectors = pSelectors;
		importSet = pImport;
		declaration = retrieveDeclaration(pElement);
		description = retrieveDescription(pElement);
		tags = retrieveTags(pElement);
	}
	
	/**
	 * Get matcher of types and add them to the sorted set
	 * 
	 * @param pMatcher matcher to iterate
	 */
	private void addImport(Matcher pMatcher) {
		pMatcher.reset();
		while (pMatcher.find()) {
			importSet.add(pMatcher.group());
		}
	}
	
	/**
	 * Retrieve declaration and format it.
	 * 
	 * @param pElement block of description (balise li for search optimized)
	 * @return the declaration formated or IOException if not found
	 * @throws IOException when the declaration is missing
	 */
	private String retrieveDeclaration(Element pElement) throws IOException {
		Element element = pElement.selectFirst(selectors.getDeclarationSelector());
		String chaine = "";
		if (element != null) {
			// preformat Declar:
			// to have all param of constructors/methods in one line
			// remove default extends object
			String declar = element.text().replaceAll(Util.LINE_BREAK_REGEX + " +", " ")
					.replaceFirst(Util.LINE_BREAK_REGEX + "extends (?:java.lang.Object)", "");
			
			// Creating matcher of declaration (with annotation)
			Matcher matcher = Pattern.compile(
					"^(?<" + GN_ANNOTATION + ">(?:@.+(?:" + Util.LINE_BREAK_REGEX + "))*)(?<" + GN_DECLAR
							+ ">(?:.+(?:" + Util.LINE_BREAK_REGEX + ")?)+)$")
					.matcher(declar);
			
			// if matcher have a match
			if (matcher.matches()) {
				// adding imports:
				addImport(Pattern.compile("\\w+\\.\\w+(?:\\.\\w+)*").matcher(matcher.group(GN_DECLAR)));
				// formating output
				chaine += matcher.group(GN_ANNOTATION) + matcher.group(GN_DECLAR)
						.replaceAll("(\\w+\\.)+", "").replaceAll(Util.LINE_BREAK_REGEX, " ");
			} else {
				throw new IOException("Declaration not corresponding to RegEx:" + Util.LINE_BREAK
						+ "Declaration:" + Util.LINE_BREAK + "\"" + declar + "\"");
			}
		} else {
			throw new IOException("Declaration not found for the element:" + Util.LINE_BREAK
					+ "CSS Selector:" + Util.LINE_BREAK + pElement.cssSelector() + Util.LINE_BREAK
					+ "OuterHtml:" + Util.LINE_BREAK + pElement.outerHtml());
		}
		return chaine;
	}
	
	/**
	 * Retrieve description but do NOT format it.
	 * 
	 * @param pElement block of description (balise li for search optimized)
	 * @return description NOT formated or null if not found
	 */
	private String retrieveDescription(Element pElement) {
		// TODO: format description
		Element element = pElement.selectFirst(selectors.getDescriptionSelector());
		if (element != null) {
			return element.text();
		}
		return null;
	}
	
	/**
	 * Get tags and create a list of formated tags
	 * 
	 * @param pElement block of description (balise li for search optimized)
	 * @return list of tags formated
	 */
	private List<String> retrieveTags(Element pElement) {
		List<String> list = new LinkedList<>();
		Elements elements = pElement.select(selectors.getTagsSelector());
		
		for (Element element : elements) {
			// Convert title to tag
			String tag = Util.CONVERT_TAGS.get(element.text());
			
			// If tag is supported
			if (tag != null) {
				Element nextElement = element.nextElementSibling();
				while (nextElement != null && nextElement.is("dd")) {
					// Adding tag and its description formated (I'm removing the " - "
					// in parameters and throws descriptions
					list.add(tag + " " + nextElement.text().replaceFirst("(?<=^\\w+) - ", " "));
					nextElement = nextElement.nextElementSibling();
				}
			}
		}
		
		return list;
	}
	
	@Override
	public String toString() {
		String javadoc = "";
		
		// adding JavaDoc only if present
		if (description != null || !tags.isEmpty()) {
			javadoc += "/**" + Util.LINE_BREAK + " * ";
			// adding description and formating it a little bit
			if (description != null) {
				javadoc += description.replaceAll(Util.LINE_BREAK_REGEX, Util.LINE_BREAK + " * ");
			}
			// adding tags
			for (String tag : tags) {
				javadoc += Util.LINE_BREAK + " * " + tag;
			}
			
			javadoc += Util.LINE_BREAK + " */" + Util.LINE_BREAK;
		}
		
		return javadoc + declaration;
	}
}
