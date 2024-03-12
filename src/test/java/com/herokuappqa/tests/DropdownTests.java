package com.herokuappqa.tests;

import com.herokuappqa.pages.AlertPage;
import com.herokuappqa.pages.DropdownPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTests extends TestBase{
    @BeforeMethod
    public void precondition () {
        new DropdownPage(driver).openDropdownPage();
    }

    @Test
    public void selectDropdownOptionTest () {

        new DropdownPage(driver).selectDropdownOption("2").verifyResult("Option 2");
    }
}
