package org.example.android.framework.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.List;

public class DriverActions {

    public static void performSwipe(int centerX, int startY, int endY, Duration duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), centerX, endY));
        swipe.addAction(finger.createPointerUp(0));

        AndroidDriver driver = Driver.getDriver();
        driver.perform(List.of(swipe));
    }
}
