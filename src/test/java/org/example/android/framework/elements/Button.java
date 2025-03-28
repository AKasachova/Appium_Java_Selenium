package org.example.android.framework.elements;

import org.example.android.framework.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class Button extends BaseElement {
    public Button(By locator, String name) {
        super(locator, name);
    }

    public  List<WebElement> findElements() {
        return Driver.getDriver().findElements(by);
    }
}
