package demoqa.com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
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
        $("#column-a").dragAndDropTo(Selenide.$("#column-b"));
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
