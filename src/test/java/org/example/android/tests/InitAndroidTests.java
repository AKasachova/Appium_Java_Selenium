package org.example.android.tests;

import org.example.android.pages.HomePage;
import org.example.android.pages.SelectLessonPage;
import org.example.android.pages.TrainingSessionPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class InitAndroidTests extends BaseTest {
    final int LESSON_NUMBER = 24;

    @Test
    public void test() {
        HomePage homepage = new HomePage();
        homepage.tabOnKochTraining();

        SelectLessonPage selectLessonPage = new SelectLessonPage();
        selectLessonPage.waitUntilSelectLessonPageIsLoaded();
        selectLessonPage.swipeDownUntilLessonWidgetIsVisibleByNumber(LESSON_NUMBER);
        selectLessonPage.tapOnLessonWidget(LESSON_NUMBER);

        TrainingSessionPage trainingSessionPage = new TrainingSessionPage();
        trainingSessionPage.waitUntilTrainingSessionPageIsLoaded();
        trainingSessionPage.tapOnNavigateUpButton();

        selectLessonPage.waitUntilSelectLessonPageIsLoaded();
        String actualFirstWidgetText =  selectLessonPage.getFirstWidgetText();
        String expectedFirstWidgetText =  String.valueOf(LESSON_NUMBER);
        assertEquals(actualFirstWidgetText, expectedFirstWidgetText);
    }
}
