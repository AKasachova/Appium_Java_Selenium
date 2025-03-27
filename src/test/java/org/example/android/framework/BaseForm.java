package org.example.android.framework;

import org.example.android.framework.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

public abstract class BaseForm {
    protected By by;
    protected String name;

    public BaseForm(By by, String name) {
        this.by = by;
        this.name = name;
    }

    public void waitUntilPageIsDisplayed(int timeoutInSeconds) {
        WebDriverWait wait = null;
        try {
            wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}