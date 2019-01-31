package model.version;

public enum SelectorsVersions implements Selectors {
	V7(new SelectorsV7()),
	V8(new SelectorsV8()),
	V9(new SelectorsV9()),
	V10(new SelectorsV10());
	
	private Selectors selector;
	
	SelectorsVersions(Selectors pSelector) {
		selector = pSelector;
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
