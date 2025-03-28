package org.example.android.framework;

import org.example.android.framework.driver.DriverWaiters;
import org.openqa.selenium.By;

public abstract class BaseForm {
    protected By by;
    protected String name;

    public BaseForm(By by, String name) {
        this.by = by;
        this.name = name;
    }

    public void waitUntilPageIsDisplayed(int timeoutInSeconds) {
        DriverWaiters.getWebDriverWait(by, timeoutInSeconds);
    }
}