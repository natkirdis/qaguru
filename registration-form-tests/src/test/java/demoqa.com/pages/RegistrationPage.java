package demoqa.com.pages;

import com.codeborne.selenide.*;
import demoqa.com.models.Student;
import demoqa.com.pages.components.CalendarComponent;

import java.io.File;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPage {

    //elements

    private static final String FORM_TITLE = "Student Registration Form";
    private final SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            submitButton = $("#submit"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckBox = $("#hobbiesWrapper"),
            fileUploadButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            StateDropdown = $("#state"),
            CityDropdown = $("#city"),
            StateBlock = $("#stateCity-wrapper");

    public CalendarComponent calendar = new CalendarComponent();

    //actions

    public RegistrationPage openPage() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(Condition.text(FORM_TITLE));
        return this;
    }

    public RegistrationPage fillFormFor(Student student) {
        typeFirstName(student.getFirstName());
        typeLastName(student.getLastName());
        typeEmail(student.getEmail());
        chooseGender(student.getGender());
        typeNumber(student.getNumber());
        calendar.withDate(student.getDay(), student.getMonth(), student.getYear());
        scrollToThePageBottom();
        typeSubjects(student.getSubjects());
        typeHobbies(student.getHobbies());
        uploadImage(new File(student.getImagePath()));
        typeAddress(student.getAddress());
        selectState(student.getState());
        selectCity(student.getCity());
        return this;
    }

    public void typeFirstName(String name) {
        firstNameInput.setValue(name);
    }

    public void typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void typeEmail(String email) {
        emailInput.setValue(email);
    }

    public void chooseGender(String gender) {
        Selenide.$(Selectors.byText(gender)).click();
    }

    public void typeNumber(String number) {
        numberInput.setValue(number);
    }

    public void scrollToThePageBottom() {
        submitButton.scrollTo();
    }

    public void typeSubjects(List<String> subjects) {
        for (String subject : subjects) {
            subjectsInput.setValue(subject).pressEnter();
        }
    }

    public void typeHobbies(List<String> hobbies) {
        for (String hobby : hobbies) {
            hobbiesCheckBox.$(Selectors.byText(hobby)).click();
        }
    }

    public void uploadImage(File file) {
        fileUploadButton.uploadFile(file);
    }

    public void typeAddress(String address) {
        addressInput.setValue(address);
    }

    public void selectCity(String city) {
        CityDropdown.click();
        StateBlock.$(Selectors.byText(city)).click();
    }

    public void selectState(String state) {
        StateDropdown.click();
        StateBlock.$(Selectors.byText(state)).click();
    }

    public void submitForm() {
        submitButton.click();
    }


    //checks

    public void checkResult(Map<String, String> expectedData) {
        ElementsCollection lines = $$(".table-responsive tbody tr").snapshot();
        for (SelenideElement line: lines) {
            String key = line.$("td").text();
            String expectedValue = expectedData.get(key);
            String actualValue = line.$("td", 1).text();
            assertEquals(expectedValue, actualValue, "any message here");
        }
    }
}
