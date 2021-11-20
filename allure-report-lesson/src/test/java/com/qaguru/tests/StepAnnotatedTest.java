package com.qaguru.tests;

import com.qaguru.steps.WebSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    private final WebSteps steps = new WebSteps();

    @Owner("natkirdis")
    @Feature("Github")
    @Story("Issues")
    @DisplayName("Issue number check")
    @Test
    void testGithub() {

        steps.openMainPage();

        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();

        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);

        steps.takeScreenshot();
    }
}
