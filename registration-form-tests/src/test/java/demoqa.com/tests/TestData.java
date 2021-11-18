package demoqa.com.tests;

import com.github.javafaker.Faker;
import demoqa.com.models.Student;

public class TestData {
    static Faker faker = new Faker();

    static Student student = new Student()
            .withFirstName(faker.name().firstName())
            .withLastName(faker.name().lastName())
            .withEmail(faker.internet().emailAddress())
            .withNumber(faker.phoneNumber().subscriberNumber(10))
            .withGender(faker.demographic().sex())
            .withRandomBirthday()
            .withRandomSubject()
            .withRandomHobby()
            .withImageName("img.png")
            .withRandomState()
            .withRandomCity()
            .withAddress(faker.address().streetAddress());
}
