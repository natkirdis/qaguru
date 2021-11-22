package com.qaguru.tests;

import com.qaguru.steps.WebSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NAME = "69 nice";

    private final WebSteps steps = new WebSteps();

    @Owner("natkirdis")
    @Feature("Github")
    @Story("Issues")
    @DisplayName("Issue title check")
    @Test
    void testGithub() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.openIssue(ISSUE_NAME);
        steps.issueTitleShouldBe(ISSUE_NAME);

        steps.takeScreenshot();
    }
}
