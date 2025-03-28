package org.example.android.pages;

import org.example.android.framework.BaseForm;
import org.example.android.framework.driver.Driver;
import org.example.android.framework.driver.DriverActions;
import org.example.android.framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;

public class SelectLessonPage extends BaseForm {
    final int MAX_SWIPES = 7;
    final int SWIPE_DURATION_MS = 500;
    final int PAGE_LOAD_DURATION_SEC = 2;
    int swipeCount = 0;

    public SelectLessonPage() {
        super(By.xpath("//android.widget.TextView[@text=\"Select Lesson\"]"), "Select Lesson Page");
    }

    public void waitUntilSelectLessonPageIsLoaded() {
        waitUntilPageIsDisplayed(PAGE_LOAD_DURATION_SEC);
    }

    public void swipeDownUntilLessonWidgetIsVisibleByNumber(int widgetNumber){
        Dimension size = Driver.getDriver().manage().window().getSize();
        int startY = size.height - 200;
        int endY = 200;
        int centerX = size.width / 2;

        By widgetLocator = By.xpath(String.format("//android.widget.TextView[@text='%s']", widgetNumber));
        Button button = new Button(widgetLocator, String.format("Lesson Widget %s",widgetNumber));

        while (swipeCount < MAX_SWIPES) {
            List<WebElement> buttons = button.findElements();
            if (!buttons.isEmpty()) {
                buttons.getFirst();
                break;
            }
            DriverActions.performSwipe(centerX, startY, endY, Duration.ofMillis(SWIPE_DURATION_MS));
            swipeCount++;
        }
    }

    public void tapOnLessonWidget(int widgetNumber) {
        String widgetText = String.valueOf(widgetNumber);
        By widgetLocator = By.xpath("//android.widget.TextView[@text='" + widgetText + "']");
        Button button = new Button(widgetLocator, "Lesson Widget " + widgetNumber);
        List<WebElement> buttons = button.findElements();
        buttons.getFirst().click();
    }

    public String getFirstWidgetText() {
        By widgetLocator = By.xpath("//android.widget.TextView[contains(@resource-id, \"es.eoinrul.ecwt:id/item_number\")]");
        Button button = new Button(widgetLocator, "First Lesson Widget Text");
        List<WebElement> buttons = button.findElements();
        if (!buttons.isEmpty()) {
            return buttons.getFirst().getText();
        }
        return null;
    }
}
