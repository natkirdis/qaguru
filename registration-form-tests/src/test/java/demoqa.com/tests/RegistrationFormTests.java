package demoqa.com.tests;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import demoqa.com.models.StudentData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.util.List;

//TODO Добавьте в ваш код генерацию рандомных значений используя Java Faker

@ExtendWith({SoftAssertsExtension.class})
public class RegistrationFormTests extends TestBase {

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

        registrationPage.openPage();
        registrationPage
                .typeFirstName(student.getFirstName())
                .typeLastName(student.getLastName())
                .typeEmail(student.getEmail())
                .chooseGender(student.getGender())
                .typeNumber(student.getNumber());
        registrationPage
                .calendar.setDate(student.getDay(), student.getMonth(), student.getYear());

        registrationPage
                .scrollToThePageBottom()
                .typeSubjects(student.getSubjects())
                .typeHobbies(student.getHobbies())
                .uploadImage(new File(student.getImagePath()))
                .typeAddress(student.getAddress())
                .selectState(student.getState())
                .selectCity(student.getCity())
                .submitForm()

                //checks

                .checkResultValues("Student Name", student.getFirstName()
                        + " " +student.getLastName())
                .checkResultValues("Student Email", student.getEmail())
                .checkResultValues("Gender", student.getGender())
                .checkResultValues("Mobile", student.getNumber())
                .checkResultValues("Date of Birth", student.getDay() + " "
                        + student.getMonth() + "," + student.getYear())
                .checkResultValues("Subjects", student.getFormattedSubjects())
                .checkResultValues("Hobbies", student.getFormattedHobbies())
                .checkResultValues("Picture", student.getImageName())
                .checkResultValues("Address", student.getAddress())
                .checkResultValues("State and City", student.getState()
                        + " " + student.getCity());
    }
}
