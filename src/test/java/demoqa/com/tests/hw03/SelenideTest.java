package demoqa.com.tests.hw03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @BeforeAll
    public static void setup() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
    }

    @DisplayName("Check Wiki page has article SoftAssertions")
    @Test
    void shouldFindSoftAssertionOnWikiPage() {
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("JUnit5"));
    }
}
