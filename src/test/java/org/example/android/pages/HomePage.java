
package org.example.android.pages;

import org.example.android.framework.elements.Button;
import org.openqa.selenium.By;

public class HomePage {
    private final Button kochTrainingButton = new Button(By.xpath("//android.widget.TextView[@text=\"Koch Training\"]"), "Koch Training");

    public void tabOnKochTraining() {
        kochTrainingButton.tapOnElement();
    }
}
