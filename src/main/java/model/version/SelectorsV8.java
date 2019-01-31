package model.version;

class SelectorsV8 implements Selectors {

	@Override
	public String getPackageSelector() {
		return "body > div.header > div.subTitle:nth-last-child(2)";
	}

	@Override
	public String getClassSelector() {
		return "body > div.contentContainer > div.description > ul > li";
	}

	@Override
	public String getNestedLinkSelector() {
		return "body > div.contentContainer > div.summary  a[name=\"nested.class.summary\"] ~ table > tbody > tr:nth-child(n+1) > td.colLast a:nth-child(1)";
	}

	@Override
	public String getFieldsSelector() {
		return "body > div.contentContainer > div.details  a[name=\"field.detail\"] ~ ul > li";
	}

	@Override
	public String getConstructorsSelector() {
		return "body > div.contentContainer > div.details  a[name=\"constructor.detail\"] ~ ul > li";
	}

	@Override
	public String getMethodsSelector() {
		return "body > div.contentContainer > div.details  a[name=\"method.detail\"] ~ ul > li";
	}

	@Override
	public String getDeclarationSelector() {
		return "pre";
	}

	@Override
	public String getDescriptionSelector() {
		return "div.block";
	}

	@Override
	public String getTagsSelector() {
		return "dl:nth-last-child(1) > dt";
	}

	@Override
	public String getFileAllClassFrameName() {
		return "allclasses-frame.html";
	}

	@Override
	public String getFileAllClassName() {
		return "allclasses-noframe.html";
	}

	@Override
	public String getAllClassSelector() {
		return "body > div > ul > li > a";
	}

}
