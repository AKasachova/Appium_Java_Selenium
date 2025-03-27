package org.example.android.tests;

import org.example.android.framework.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BaseTest {
    @BeforeMethod
    public void setUp() throws MalformedURLException, URISyntaxException {
        Driver.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
        }
}
