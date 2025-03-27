/*//Это для фул рана если что-то слетит
package org.example.android.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import static org.testng.Assert.*;


public class MainPageTest  extends BaseTest {
*/
/*    AndroidDriver driver;


    @BeforeMethod
    public void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5554")
                .setApp(System.getProperty("user.dir") + "/apps/es.eoinrul.ecwt_46.apk");
        driver = new AndroidDriver(
                new URI("http://127.0.0.1:4723").toURL(), options
        );
    }

    @Test
    public void test() {
//HomePage
        WebElement sounderWidget = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Koch Training\"]"));
        sounderWidget.click();

//SelectLessonPage
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectLessonElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Select Lesson\"]"))
        );

        int lessonNumber  = 23;
        swipeDownUntilWidgetVisibleByNumber(lessonNumber).click();

//TrainingSessionPage

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement trainingSessionElement2 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Training Session\"]"))
        );

        WebElement navigateUpElement = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
        navigateUpElement.click();

//SelectLessonPage
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectLessonElement3 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Select Lesson\"]"))
        );

        String actualFirstWidgetText = getFirstWidgetText();
        String expectedFirstWidgetText = String.valueOf(lessonNumber);
        assertEquals(actualFirstWidgetText, expectedFirstWidgetText);
    }



    public WebElement swipeDownUntilWidgetVisibleByNumber(int widgetNumber) {
        Dimension size = driver.manage().window().getSize();
        int startY = size.height - 200;
        int endY = 200;
        int centerX = size.width / 2;

        int maxSwipes = 7;
        int swipeCount = 0;
        WebElement foundElement = null;
        String widgetText = String.valueOf(widgetNumber);
        By widgetLocator = By.xpath("//android.widget.TextView[@text='" + widgetText + "']");

        while (swipeCount < maxSwipes) {
            List<WebElement> elements = driver.findElements(widgetLocator);
            if (!elements.isEmpty()) {
                foundElement = elements.get(0);
                break;
            }

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 0);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
            swipe.addAction(finger.createPointerDown(0));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerX, endY));
            swipe.addAction(finger.createPointerUp(0));
            driver.perform(List.of(swipe));

            swipeCount++;
        }
        return foundElement;
    }

    public String getFirstWidgetText() {
        List<WebElement> textViews = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id, \"es.eoinrul.ecwt:id/item_number\")]"));
        if (textViews.size() > 1) {
            String lessonNumber = textViews.get(0).getText();
            return lessonNumber;
        }
        return null;
    }
}

*/
