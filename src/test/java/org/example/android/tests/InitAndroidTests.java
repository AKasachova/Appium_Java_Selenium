package org.example.android.tests;

import org.example.android.pages.HomePage;
import org.example.android.pages.SelectLessonPage;
import org.example.android.pages.TrainingSessionPage;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import static org.testng.Assert.assertEquals;

public class InitAndroidTests extends BaseTest {
    @Test
    public void test() throws MalformedURLException, URISyntaxException {
        HomePage homepage = new HomePage();
        homepage.tabOnKochTraining();

        SelectLessonPage selectLessonPage = new SelectLessonPage();
        int lessonWidgetNumberToTest = 24;
        selectLessonPage.waitUntilSelectLessonPageIsLoaded();
        selectLessonPage.swipeDownUntilLessonWidgetIsVisibleByNumber(lessonWidgetNumberToTest);
        selectLessonPage.tapOnLessonWidget(lessonWidgetNumberToTest);

        TrainingSessionPage trainingSessionPage = new TrainingSessionPage();
        trainingSessionPage.waitUntilTrainingSessionPageIsLoaded();
        trainingSessionPage.tapOnNavigateUpButton();

        selectLessonPage.waitUntilSelectLessonPageIsLoaded();
        String actualFirstWidgetText =  selectLessonPage.getFirstWidgetText();
        String expectedFirstWidgetText =  String.valueOf(lessonWidgetNumberToTest);
        assertEquals(actualFirstWidgetText, expectedFirstWidgetText);
    }
}
