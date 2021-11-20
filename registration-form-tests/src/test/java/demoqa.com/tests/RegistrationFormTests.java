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

        registrationPage.openPage()
                .fillFormFor(student)
                .submitForm();

        registrationPage.checkResult(student.getResultStudentData());
    }
}
