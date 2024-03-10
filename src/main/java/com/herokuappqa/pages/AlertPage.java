package com.herokuappqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertPage extends BasePage{
    public AlertPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css="[href='/javascript_alerts']")
    WebElement alertLink;
    public AlertPage openAlertPage ( ) {
        clickWithJS(alertLink, 0, 500);
        return this;
    }
    @FindBy(css="ul li:nth-child(1) button")
    WebElement jsAlertButton;
    public AlertPage openJsAlert ( ) {
        click(jsAlertButton);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(css="ul li:nth-child(2) button")
    WebElement jsConfirmAlertButton;
    public AlertPage openJsConfirm ( String confirm ) {
        click(jsConfirmAlertButton);
        if(confirm!=null && confirm.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (confirm != null && confirm.equals("Cancel")) {
            driver.switchTo().alert().dismiss();

        }
        return this;
    }


    @FindBy(css="ul li:nth-child(3) button")
    WebElement jsPromptAlertButton;
    public AlertPage openJsPrompt ( String message ) {
        click(jsPromptAlertButton);

        if(message!=null && message.length() > 0 ) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        } else  {
            driver.switchTo().alert().dismiss();
        }

        return this;
    }



    @FindBy(id="result")
    WebElement result;
    public AlertPage verifyResult (String expectedResult) {
        Assert.assertTrue(result.getText().contains(expectedResult));
        return this;
    }





}
