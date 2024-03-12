package com.herokuappqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksPage extends BasePage{
    public BrokenLinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[href='/redirector']")
    WebElement redirectorPageLink;
    public BrokenLinksPage openRedirectionPage() {
        clickWithJS(redirectorPageLink, 0, 400);
        return this;
    }

    @FindBy(id="redirect")
    WebElement redirect;
    public BrokenLinksPage openBrokenLinksPage() {
        click(redirect);
        return this;
    }

    @FindBy(css="a")
    List<WebElement> links;
    public BrokenLinksPage checkBrokenLinks() {
        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            verifyLink(url);
        }
        return this;
    }
    public void verifyLink (String url) {
        try {
            URL linkUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) linkUrl.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(url + " - return code: " + httpURLConnection.getResponseCode() + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(url + " - " + e.getMessage() +  " - Link with exception");
        }
    }


}
