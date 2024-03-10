package com.herokuappqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WindowPage extends BasePage{

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[href='/windows']")
    WebElement alertLink;
    public WindowPage openWindowPage ( ) {
        clickWithJS(alertLink, 0, 500);
        return this;
    }

    @FindBy(css="[href='/windows/new']")
    WebElement newWindowLink;
    public WindowPage openWindow ( int index ) {
        click(newWindowLink);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(css=".example h3")
    WebElement result;
    public WindowPage verifyWindow ( String text ) {
        Assert.assertTrue(result.getText().contains(text));
        return this;
    }

}
