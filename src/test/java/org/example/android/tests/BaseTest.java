package org.example.android.tests;

import org.example.android.framework.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        Driver.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
