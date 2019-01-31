package model.format;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Some useful static values.
 * 
 * @author Christophe Nadeau
 */
final class Util {
	
	/**
	 * Value of a line break dynamic to the OS.
	 * Has the value of <code>System.lineSeparator()</code> in it,
	 * but for performance cause and to be shorter I'm using a static constant.
	 * <p>
	 * <table border="1" cellspacing="0" cellpadding="5">
	 * <tr>		<th>Operating System</th>						<th>Abbreviation</th>		<th>Escape sequence</th>		</tr>
	 * <tr>		<td>Windows</td>										<td>CR LF</td>					<td>\r\n</td>		</tr>
	 * <tr>		<td>UNIX</td>												<td>LF</td>							<td>\n</td>		</tr>
	 * <tr>		<td>MAC (older than version 9)</td>	<td>CR</td>							<td>\r</td>		</tr>
	 * <tr>		<td>MAC OS X</td>										<td>LF CR</td>					<td>\n\r</td>		</tr>
	 * </table>
	 * <p>
	 */
	public static final String LINE_BREAK = System.lineSeparator();
	
	/**
	 * Map for converting the tags titles (in the balise DT) to JavaDoc tags
	 */
	public static final Map<String, String> CONVERT_TAGS = initConverterMap();
	
	/**
	 * Value of a line break for regular expression dynamic to the OS.
	 * Has the value: {@value}
	 * <p>
	 * <table border="1" cellspacing="0" cellpadding="5">
	 * <tr>		<th>Operating System</th>						<th>Abbreviation</th>		<th>Escape sequence</th>		</tr>
	 * <tr>		<td>Windows</td>										<td>CR LF</td>					<td>\r\n</td>		</tr>
	 * <tr>		<td>UNIX</td>												<td>LF</td>							<td>\n</td>		</tr>
	 * <tr>		<td>MAC (older than version 9)</td>	<td>CR</td>							<td>\r</td>		</tr>
	 * <tr>		<td>MAC OS X</td>										<td>LF CR</td>					<td>\n\r</td>		</tr>
	 * </table>
	 * <p>
	 */
	public static final String LINE_BREAK_REGEX = "(?:\\r\\n|\\r|\\n)";
	
	/**
	 * Initialize the constant map unmodifiable for converting tags
	 * 
	 * @return Map for conversions
	 */
	private static final Map<String, String> initConverterMap() {
		Map<String, String> map = new HashMap<>();
		map.put("Parameters:", "@param");
		map.put("Returns:", "@return");
		map.put("See Also:", "@see");
		map.put("Since:", "@since");
		map.put("Throws:", "@throws");
		map.put("Version:", "@version");
		map.put("Author:", "@author");
		// TODO: Add JavaDoc tags missing
		return Collections.unmodifiableMap(map);
	}
}
