package com.qaguru.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();

    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем, что существует Issue с номером {number}")
    public void shouldSeeIssueWithNumber(Integer number) {
        $(withText("#" + number)).shouldBe(Condition.visible);
    }

    @Step("Открываем Issue {name}")
    public void openIssue(String name) {
        $(withText(name)).click();
    }

    @Step("Проверяем, что заволовок Issue {name}")
    public void issueTitleShouldBe(String name) {
        $(".js-issue-title").shouldHave(Condition.text(name));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

}
