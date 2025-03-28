package org.example.android.framework.elements;

import org.example.android.framework.driver.Driver;
import org.example.android.framework.driver.DriverWaiters;
import org.openqa.selenium.*;
import java.util.List;


public abstract class BaseElement {
    protected By by;
    protected String name;

    public BaseElement(By by, String name) {
        this.by = by;
        this.name = name;
    }

    protected WebElement getElement() {
        return Driver.getDriver().findElement(by);
    }

    protected void waitForVisibility(int timeoutInSeconds) {
        DriverWaiters.getWebDriverWait(by, timeoutInSeconds);
    }

    protected List<WebElement> getElements() {
        List<WebElement> webElementList = Driver.getDriver().findElements(by);
        if (webElementList.isEmpty()) {
            return null;
        } else {
            return webElementList;
        }
    }

    public void tapOnElement() {
            getElement().click();
    }

    public String getText() {
        return getElement().getText();
    }

    public boolean isElementDisplayed() {
        return getElement().isDisplayed();
    }
}
