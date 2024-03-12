package com.herokuappqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPage extends BasePage{


    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[href='/dropdown']")
    WebElement dropdownLink;
    public DropdownPage openDropdownPage() {
        click(dropdownLink);
        return this;
    }

    @FindBy(id="dropdown")
    WebElement dropdown;
    public DropdownPage selectDropdownOption(String optionValue) {
        Select select = new Select(dropdown);
        select.selectByValue(optionValue);
        return this;
    }

    public DropdownPage verifyResult(String expectedValue) {
        Select select = new Select(dropdown);
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains(expectedValue));
        return this;
    }
}
