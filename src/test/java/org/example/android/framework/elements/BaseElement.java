package org.example.android.framework.elements;

import org.example.android.framework.driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;


public abstract class BaseElement {
    protected By by;
    protected String name;

    public BaseElement(By by, String name) {
        this.by = by;
        this.name = name;
    }

    protected WebElement getElement() throws MalformedURLException, URISyntaxException {
        return Driver.getDriver().findElement(by);
    }

    protected List<WebElement> getElements() throws MalformedURLException, URISyntaxException {
        List<WebElement> webElementList = Driver.getDriver().findElements(by);
        if (webElementList.isEmpty()) {
            return null;
        } else {
            return webElementList;
        }
    }

    public void tapOnElement() {
        try {
            getElement().click();
        } catch (ElementClickInterceptedException|MalformedURLException|URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public String getText() throws MalformedURLException, URISyntaxException {
        return getElement().getText();
    }
}