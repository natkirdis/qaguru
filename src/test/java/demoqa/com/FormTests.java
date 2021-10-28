package demoqa.com;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import demoqa.com.models.StudentData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith({SoftAssertsExtension.class})
public class FormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.assertionMode = SOFT;
    }

    @Test
    void positiveFillFormTest() {
        StudentData student = new StudentData()
                .withFirstName("Name")
                .withLastName("LastName")
                .withEmail("test@email.ru")
                .withNumber("8888888888")
                .withGender("Male")
                .withYear("1990")
                .withMonth("March")
                .withDay("09")
                .withSubjects(List.of("Maths", "Arts"))
                .withHobbies(List.of("Sports", "Music"))
                .withImageName("img.png")
                .withState("NCR")
                .withCity("Delhi")
                .withAddress("Some address");

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(student.getFirstName());
        $("#lastName").setValue(student.getLastName());
        $("#userEmail").setValue(student.getEmail());
        $(byText(student.getGender())).click();
        $("#userNumber").setValue(student.getNumber());
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(student.getMonth());
        $(".react-datepicker__year-select").selectOption(student.getYear());
        $(".react-datepicker__day--009").click();
        $("#submit").scrollTo();
        for (String subject : student.getSubjects()) {
            $("#subjectsInput").setValue(subject).pressEnter();}
        for (String hobby : student.getHobbies()) {
            $("#hobbiesWrapper").$(byText(hobby)).click();}
        $("#uploadPicture").uploadFile(new File(student.getImagePath()));
        $("#currentAddress").setValue(student.getAddress());
        $("#state").click();
        $("#stateCity-wrapper").$(byText(student.getState())).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(student.getCity())).click();
        $("#submit").click();

        getValue("Student Name")
                .shouldHave(text(student.getFirstName()
                        + " " +student.getLastName()));
        getValue("Student Email")
                .shouldHave((text(student.getEmail())));
        getValue("Gender")
                .shouldHave((text(student.getGender())));
        getValue("Mobile")
                .shouldHave((text(student.getNumber())));
        getValue("Date of Birth")
                .shouldHave((text(student.getDay() + " " +
                        student.getMonth() + "," +
                        student.getYear())));
        getValue("Subjects")
                .shouldHave((text(formatList(student.getSubjects()))));
        getValue("Hobbies")
                .shouldHave((text(formatList(student.getHobbies()))));
        getValue("Picture")
                .shouldHave((text(student.getImageName())));
        getValue("Address")
                .shouldHave((text(student.getAddress())));
        getValue("State and City")
                .shouldHave((text(student.getState()
                        + " " + student.getCity())));
    }


    private SelenideElement getValue(String fieldName) {
        return $(".modal-content")
                .$(byText(fieldName))
                .sibling(0);
    }

    private String formatList(List<String> list) {
        return list.toString().replace("[", "")
                .replace("'", "")
                .replace("]", "");
    }
}
