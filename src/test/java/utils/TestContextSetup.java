package utils;

import pageObjects.PageObjectManager;

public class TestContextSetup {

    public TestBase testBase;

    public PageObjectManager pageObjectManager;

    public TestContextSetup() {
        this.testBase = new TestBase();
        this.pageObjectManager = new PageObjectManager(testBase.webDriverManager());
    }
}
