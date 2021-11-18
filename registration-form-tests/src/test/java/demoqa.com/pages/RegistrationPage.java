package demoqa.com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import demoqa.com.pages.components.CalendarComponent;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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

    public void openPage() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(Condition.text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage chooseGender(String gender) {
        Selenide.$(Selectors.byText(gender)).click();
        return this;
    }

    public RegistrationPage typeNumber(String number) {
        numberInput.setValue(number);
        return this;
    }

    public RegistrationPage scrollToThePageBottom() {
        submitButton.scrollTo();
        return this;
    }

    public RegistrationPage typeSubjects(List<String> subjects) {
        for (String subject : subjects) {
            subjectsInput.setValue(subject).pressEnter();
        }
        return this;
    }

    public RegistrationPage typeHobbies(List<String> hobbies) {
        for (String hobby : hobbies) {
            hobbiesCheckBox.$(Selectors.byText(hobby)).click();
        }
        return this;
    }

    public RegistrationPage uploadImage(File file) {
        fileUploadButton.uploadFile(file);
        return this;
    }

    public RegistrationPage typeAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage selectCity(String city) {
        CityDropdown.click();
        StateBlock.$(Selectors.byText(city)).click();
        return this;
    }

    public RegistrationPage selectState(String state) {
        StateDropdown.click();
        StateBlock.$(Selectors.byText(state)).click();
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    //checks
    public RegistrationPage checkResultValues(String key, String value) {
        field(key).shouldHave(Condition.text(value));
        return this;
    }

    private SelenideElement field(String fieldName) {
        return $(".modal-content")
                .$(Selectors.byText(fieldName))
                .sibling(0);
    }
}
