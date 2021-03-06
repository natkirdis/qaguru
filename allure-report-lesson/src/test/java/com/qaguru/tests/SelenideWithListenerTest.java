package com.qaguru.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideWithListenerTest {

    private static String BASE_URL = "https://github.com/";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NAME = "69 nice";

    @Owner("natkirdis")
    @Feature("Github")
    @Story("Issues")
    @DisplayName("Issue number check")
    @Test
    void testIssueNumberGithub() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        // Открываем страницу Github
        open(BASE_URL);

        // Переходим в репозеторий
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();
        $(linkText(REPOSITORY)).click();

        // Переходим на вкладку Issues
        $(partialLinkText("Issues")).click();

        // Переходим в Issue
        $(withText(ISSUE_NAME)).click();

        // Проверяем заголовок Issue
        $(".js-issue-title").shouldHave(Condition.text(ISSUE_NAME));
    }
}
