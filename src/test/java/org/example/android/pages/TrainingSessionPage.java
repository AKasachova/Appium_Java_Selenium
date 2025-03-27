package org.example.android.pages;

import org.example.android.framework.BaseForm;
import org.example.android.framework.elements.Button;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class TrainingSessionPage extends BaseForm {
    private final Button navigateUpButton = new Button(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"), "Navigate Up");

    public TrainingSessionPage() {
        super(By.xpath("//android.widget.TextView[@text=\"Training Session\"]"), "Training Session Page");
    }

    public void waitUntilTrainingSessionPageIsLoaded() throws MalformedURLException, URISyntaxException {
        waitUntilPageIsDisplayed(5);
    }

    public void tapOnNavigateUpButton() {
        navigateUpButton.tapOnElement();
    }
}
