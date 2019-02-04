package model.version;

import java.io.IOException;

public class SelectorsVersions implements Selectors {
	
	private Selectors selector;
	
	public SelectorsVersions(int version) throws IOException {
		switch (version) {
		case 7:
			selector = new SelectorsV7();
			break;
		case 8:
			selector = new SelectorsV8();
			break;
		case 9:
			selector = new SelectorsV9();
			break;
		case 10:
			selector = new SelectorsV10();
			break;
		default:
			throw new IOException("This version of JavaDoc is not supported.");
		}
	}

	@Override
	public String getPackageSelector() {
		return selector.getPackageSelector();
	}

	@Override
	public String getClassSelector() {
		return selector.getClassSelector();
	}

	@Override
	public String getNestedLinkSelector() {
		return selector.getNestedLinkSelector();
	}

	@Override
	public String getFieldsSelector() {
		return selector.getFieldsSelector();
	}

	@Override
	public String getConstructorsSelector() {
		return selector.getConstructorsSelector();
	}

	@Override
	public String getMethodsSelector() {
		return selector.getMethodsSelector();
	}

	@Override
	public String getDeclarationSelector() {
		return selector.getDeclarationSelector();
	}

	@Override
	public String getDescriptionSelector() {
		return selector.getDescriptionSelector();
	}

	@Override
	public String getTagsSelector() {
		return selector.getTagsSelector();
	}

	@Override
	public String getFileAllClassFrameName() {
		return selector.getFileAllClassFrameName();
	}

	@Override
	public String getFileAllClassName() {
		return selector.getFileAllClassName();
	}

	@Override
	public String getAllClassSelector() {
		return selector.getAllClassSelector();
	}
}
