package demoqa.com.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement
            dateOfBirthdayInput = $("#dateOfBirthInput"),
            monthPickerElement = $(".react-datepicker__month-select"),
            yearPickerElement = $(".react-datepicker__year-select");

    public void withDate(String day, String month, String year) {
        dateOfBirthdayInput.click();
        monthPickerElement.selectOption(month);
        yearPickerElement.selectOption(year);
        $(String.format(".react-datepicker__day--0%s", day)).click();
    }
}
