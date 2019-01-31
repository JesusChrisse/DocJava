package model.version;

public interface Selectors {
	/**
	 * Selector CSS to select the node where the <code>Node.text()</code> give the package.
	 */
	public String getPackageSelector();
	
	/**
	 * Selector CSS to select the node where the description block of the class is.
	 */
	public String getClassSelector();
	
	/**
	 * Selector CSS to select all the links (the balise A) of the different nested
	 * class
	 */
	public String getNestedLinkSelector();
	
	/**
	 * Selector CSS to select all the nodes where all the description block of each
	 * field is.
	 */
	public String getFieldsSelector();
	
	/**
	 * Selector CSS to select all the nodes where all the description block of each
	 * constructor is.
	 */
	public String getConstructorsSelector();
	
	/**
	 * Selector CSS to select all the nodes where all the description block of each
	 * method is.
	 */
	public String getMethodsSelector();
	
	/**
	 * Selector CSS to select the node of the declaration within a description block.
	 */
	public String getDeclarationSelector();
	
	/**
	 * Selector CSS to select the node of the description within a description block.
	 */
	public String getDescriptionSelector();
	
	/**
	 * Selector CSS to select the nodes of the tags (the balise DT) title within a
	 * description block.
	 */
	public String getTagsSelector();
	
	/**
	 * Name of the frame file that have all the name of types.
	 */
	public String getFileAllClassFrameName();
	
	/**
	 * Name of the frame file that have all the name of types.
	 */
	public String getFileAllClassName();
	
	/**
	 * Selector CSS to select all the nodes of types and their path.
	 */
	public String getAllClassSelector();
}
