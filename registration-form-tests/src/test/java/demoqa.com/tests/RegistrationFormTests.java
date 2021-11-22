package demoqa.com.tests;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static demoqa.com.tests.TestData.student;

@ExtendWith({SoftAssertsExtension.class})
public class RegistrationFormTests extends TestBase {

    @Test
    void positiveFillFormTest() {
        Map<String, String> expectedData = new HashMap<>()
        {{
            put("Student Name", student.getFirstName()
                    + " " + student.getLastName());
            put("Student Email", student.getEmail());
            put("Gender", student.getGender());
            put("Mobile", student.getNumber());
            put("Date of Birth", student.getDay() + " "
                    + student.getMonth() + "," + student.getYear());
            put("Subjects", student.getFormattedSubjects());
            put("Hobbies", student.getFormattedHobbies());
            put("Picture", student.getImageName());
            put("Address", student.getAddress());
            put("State and City", student.getState()
                    + " " + student.getCity());
        }};

        registrationPage.openPage()
                .fillFormFor(student)
                .submitForm();

        registrationPage.checkResult(expectedData);
    }
}
