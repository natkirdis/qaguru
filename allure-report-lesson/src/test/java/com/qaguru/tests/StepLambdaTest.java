package com.qaguru.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {

    private static final String BASE_URL = "https://github.com/";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NAME = "69 nice";

    @Owner("natkirdis")
    @Feature("Github")
    @Story("Issues")
    @DisplayName("Issue number check")
    @Test
    public void testGithub() {
        step("Открываем страницу " + BASE_URL, () -> {
            open(BASE_URL);
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Переходим в Issue " + ISSUE_NAME, () -> {
            $(withText(ISSUE_NAME)).click();
        });
        step("Проверяем, что заголовок " + ISSUE_NAME, () -> {
            $(".js-issue-title").shouldHave(Condition.text(ISSUE_NAME));
        });
    }
}
