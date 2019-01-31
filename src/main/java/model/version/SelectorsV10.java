package model.version;

class SelectorsV10 implements Selectors {

	@Override
	public String getPackageSelector() {
		// TODO Auto-generated method stub
		return "body > main > div.header > div.subTitle:nth-last-child(2) > a";
	}

	@Override
	public String getClassSelector() {
		// TODO Auto-generated method stub
		return "body > main > div.contentContainer > div.description > ul > li";
	}

	@Override
	public String getNestedLinkSelector() {
		// TODO Auto-generated method stub
		return "body > main > div.contentContainer > div.summary  a[name=\"nested.class.summary\"] ~ table > tbody > tr:nth-child(n+1) > td.colSecond a:nth-child(1)";
	}

	@Override
	public String getFieldsSelector() {
		// TODO Auto-generated method stub
		return "body > main > div.contentContainer > div.details  a[name=\"field.detail\"] ~ ul > li";
	}

	@Override
	public String getConstructorsSelector() {
		// TODO Auto-generated method stub
		return "body > main > div.contentContainer > div.details  a[name=\"constructor.detail\"] ~ ul > li";
	}

	@Override
	public String getMethodsSelector() {
		// TODO Auto-generated method stub
		return "body > main > div.contentContainer > div.details  a[name=\"method.detail\"] ~ ul > li";
	}

	@Override
	public String getDeclarationSelector() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public String getDescriptionSelector() {
		// TODO Auto-generated method stub
		return "div.block";
	}

	@Override
	public String getTagsSelector() {
		// TODO Auto-generated method stub
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
