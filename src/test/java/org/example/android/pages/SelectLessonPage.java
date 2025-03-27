package org.example.android.pages;

import org.example.android.framework.BaseForm;
import org.example.android.framework.driver.Driver;
import org.example.android.framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

public class SelectLessonPage extends BaseForm {

    public SelectLessonPage() {
        super(By.xpath("//android.widget.TextView[@text=\"Select Lesson\"]"), "Select Lesson Page");
    }

    public void waitUntilSelectLessonPageIsLoaded() throws MalformedURLException, URISyntaxException {
        waitUntilPageIsDisplayed(2);
    }

    public Button swipeDownUntilLessonWidgetIsVisibleByNumber(int widgetNumber) throws MalformedURLException, URISyntaxException {
        Dimension size = Driver.getDriver().manage().window().getSize();
        int startY = size.height - 200;
        int endY = 200;
        int centerX = size.width / 2;

        int maxSwipes = 7;
        int swipeCount = 0;
        Button foundElement = null;
        String widgetText = String.valueOf(widgetNumber);
        //todo
        By widgetLocator = By.xpath("//android.widget.TextView[@text='" + widgetText + "']");
        Button button = new Button(widgetLocator, "Lesson Widget " + widgetNumber);

        while (swipeCount < maxSwipes) {
            List<Button> buttons = button.findElements();
            if (!buttons.isEmpty()) {
                foundElement = buttons.getFirst();
                break;
            }

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 0);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
            swipe.addAction(finger.createPointerDown(0));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerX, endY));
            swipe.addAction(finger.createPointerUp(0));
            Driver.getDriver().perform(List.of(swipe));

            swipeCount++;
        }
        return foundElement;
    }

    public void tapOnLessonWidget(int widgetNumber) throws MalformedURLException, URISyntaxException {
        String widgetText = String.valueOf(widgetNumber);
        //todo
        By widgetLocator = By.xpath("//android.widget.TextView[@text='" + widgetText + "']");
        Button button = new Button(widgetLocator, "Lesson Widget " + widgetNumber);
        List<Button> buttons = button.findElements();
        buttons.getFirst().tapOnElement();

    }

    public String getFirstWidgetText() throws MalformedURLException, URISyntaxException {
        //todo
        By widgetLocator = By.xpath("//android.widget.TextView[contains(@resource-id, \"es.eoinrul.ecwt:id/item_number\")]");
        Button button = new Button(widgetLocator, "First Lesson Widget Text");
        List<Button> buttons = button.findElements();
        if (!buttons.isEmpty()) {
            return buttons.getFirst().getText();
        }
        return null;
    }
}
