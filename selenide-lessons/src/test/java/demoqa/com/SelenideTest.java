package demoqa.com;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @BeforeEach
    public void precondition() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
    }

    @DisplayName("Check Wiki page has article SoftAssertions")
    @Test
    void shouldFindSoftAssertionOnWikiPage() {
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").$(Selectors.byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("JUnit5"));
    }
}
