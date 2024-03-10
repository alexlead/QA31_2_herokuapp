package com.herokuappqa.tests;

import com.herokuappqa.pages.AlertPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase{

    @BeforeMethod
    public void precondition () {
        new AlertPage(driver).openAlertPage();
    }

    @Test
    public void clickAlertWindowTest () {
        new AlertPage(driver).openJsAlert()
                .verifyResult("You successfully clicked an alert");
    }
    @Test
    public void acceptJsConfirmTest () {
    new AlertPage(driver).openJsConfirm("OK")
                .verifyResult("You clicked: Ok");
    }
    @Test
    public void declineJsConfirmTest () {
    new AlertPage(driver).openJsConfirm("Cancel")
                .verifyResult("You clicked: Cancel");
    }
    @Test
    public void acceptJsPromptTest () {
    new AlertPage(driver).openJsPrompt("Message")
                .verifyResult("You entered: Message");
    }
    @Test
    public void declineJsPromptTest () {
    new AlertPage(driver).openJsPrompt("")
                .verifyResult("You entered: null");
    }


}
