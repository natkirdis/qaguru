package demoqa.com.tests;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import demoqa.com.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.assertionMode = AssertionMode.SOFT;
    }
}
