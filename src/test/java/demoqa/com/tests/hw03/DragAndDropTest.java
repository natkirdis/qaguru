package demoqa.com.tests.hw03;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeEach
    void preconditions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @DisplayName("Check drag and drop works")
    @Test
    void dragAndDropCheckWithSelenideDragAndDrop() {
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }

    @Disabled("Doesn't work correctly. Should use selenide dragAndDropTo()")
    @Test
    void dragAndDropCheckWithActions() {
        actions().dragAndDrop($("#column-a"), $("#column-b"))
                .perform();
        $("#column-b").shouldHave(Condition.text("A"));
        $("#column-a").shouldHave(Condition.text("B"));
    }

    @Disabled("Doesn't work correctly. Should use selenide dragAndDropTo()")
    @Test
    void dragAndDropCheckWithActionsOffset() {
        actions().dragAndDropBy($("#column-a"), 100, 0)
                .perform();
        $("#column-b").shouldHave(Condition.text("A"));
        $("#column-a").shouldHave(Condition.text("B"));
    }
}
