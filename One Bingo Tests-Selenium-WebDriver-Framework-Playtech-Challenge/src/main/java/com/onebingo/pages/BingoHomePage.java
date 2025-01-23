package com.onebingo.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class BingoHomePage extends BaseWebPage{

    public BingoHomePage(String pageSpecificUrl) {
        super(pageSpecificUrl);
    }

    @Override
    public String getBasePageUrl() { return PropertiesManager.getConfigProperties().getProperty("demoBingoBaseUrl"); }
}
