package com.herokuappqa.tests;

import com.herokuappqa.pages.BrokenLinksPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTest extends TestBase{

    @BeforeMethod
    public void precondition () {
        new BrokenLinksPage(driver).openRedirectionPage().openBrokenLinksPage();
    }
    @Test
    public void isBrokenLinkPresentTest () {
        new BrokenLinksPage(driver).checkBrokenLinks();
    }
}
