package org.example.android.framework.elements;

import org.example.android.framework.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Button extends BaseElement {
    public Button(By locator, String name) {
        super(locator, name);
    }

    public  List<Button> findElements() throws MalformedURLException, URISyntaxException {
        List<WebElement> webElements = Driver.getDriver().findElements(by);
        List<Button> buttons = new ArrayList<>();
        for (WebElement webElement : webElements) {
            buttons.add(new Button(by, null));
        }
        return buttons;
    }
}