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

    final int MAX_SWIPES = 7;
    final int SWIPE_DURATION_MS = 500;
    int swipeCount = 0;

    public SelectLessonPage() {
        super(By.xpath("//android.widget.TextView[@text=\"Select Lesson\"]"), "Select Lesson Page");
    }

    public void waitUntilSelectLessonPageIsLoaded()  {
        waitUntilPageIsDisplayed(2);
    }

    public void swipeDownUntilLessonWidgetIsVisibleByNumber(int widgetNumber){
        Dimension size = null;
        try {
            size = Driver.getDriver().manage().window().getSize();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        int startY = size.height - 200;
        int endY = 200;
        int centerX = size.width / 2;

        Button foundElement = null;
        //todo
        By widgetLocator = By.xpath(String.format("//android.widget.TextView[@text='%s']", widgetNumber));
        Button button = new Button(widgetLocator, String.format("Lesson Widget %s",widgetNumber));

        while (swipeCount < MAX_SWIPES) {
            List<Button> buttons = button.findElements();
            if (!buttons.isEmpty()) {
                foundElement = buttons.getFirst();
                break;
            }

            performSwipe(centerX, centerX, endY, Duration.ofMillis(SWIPE_DURATION_MS));
            swipeCount++;
        }
    }

    private void performSwipe(int centerX, int startY, int endY, Duration duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), centerX, endY));
        swipe.addAction(finger.createPointerUp(0));
        try {
            Driver.getDriver().perform(List.of(swipe));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tapOnLessonWidget(int widgetNumber) {
        String widgetText = String.valueOf(widgetNumber);
        //todo
        By widgetLocator = By.xpath("//android.widget.TextView[@text='" + widgetText + "']");
        Button button = new Button(widgetLocator, "Lesson Widget " + widgetNumber);
        List<Button> buttons = null;
        try {
            buttons = button.findElements();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        buttons.getFirst().tapOnElement();

    }

    public String getFirstWidgetText()  {
        //todo
        By widgetLocator = By.xpath("//android.widget.TextView[contains(@resource-id, \"es.eoinrul.ecwt:id/item_number\")]");
        Button button = new Button(widgetLocator, "First Lesson Widget Text");
        List<Button> buttons = null;
        try {
            buttons = button.findElements();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        if (!buttons.isEmpty()) {
            return buttons.getFirst().getText();
        }
        return null;
    }
}
