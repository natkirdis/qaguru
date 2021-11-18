package demoqa.com.models;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String number;
    private String gender;
    private String year;
    private String month;
    private String day;
    private List<String> subjects;
    private List<String > hobbies;
    private String imageName;
    private String state;
    private String city;
    private String address;

    public String getFirstName() {
        return firstName;
    }

    public Student withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Student withNumber(String number) {
        this.number = number;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Student withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public String getFormattedSubjects() {
        return formatList(subjects);
    }

    public Student withSubjects(List<String> subjects) {
        this.subjects = subjects;
        return this;
    }

    public Student withRandomSubject() {
        List<String> allSubjects = Arrays.asList("Maths", "Arts", "Chemistry", "Computer Science", "Physics");
        this.subjects = List.of(allSubjects.get(new SecureRandom().nextInt(allSubjects.size())));
        return this;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Student withRandomHobby() {
        List<String> allHobbies = Arrays.asList("Sports", "Reading", "Music");
        this.hobbies = List.of(allHobbies.get(new SecureRandom().nextInt(allHobbies.size())));
        return this;
    }

    public String getFormattedHobbies() {
        return formatList(hobbies);
    }

    public Student withHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public String getImageName() {
        return imageName;
    }

    public Student withImageName(String image) {
        this.imageName = image;
        return this;
    }

    public String getImagePath() {
        return String.format("src/test/resources/%s", imageName);
    }


    public String getState() {
        return state;
    }

    public Student withState(String state) {
        this.state = state;
        return this;
    }

    public Student withRandomState() {
        List<String> allStates = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        this.state = allStates.get(new SecureRandom().nextInt(allStates.size()));
        return this;
    }

    public String getCity() {
        return city;
    }

    public Student withCity(String city) {
        this.city = city;
        return this;
    }
    public Student withRandomCity() {
        Map<String, List<String>> allCities = new HashMap<>();
        allCities.put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
        allCities.put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));
        allCities.put("Haryana", Arrays.asList("Karnal", "Panipat"));
        allCities.put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
        this.city = allCities.get(state).get(new SecureRandom().nextInt(allCities.size()));
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Student withAddress(String address) {
        this.address = address;
        return this;
    }

    public Student withRandomBirthday() {
        LocalDate birthday = LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(-80 * 365, 0));
        String dateFormated = birthday.format(DateTimeFormatter
                .ofLocalizedDate(FormatStyle.LONG).localizedBy(Locale.UK));

        List<String> separatedDay = List.of(dateFormated.split(" "));

        String dayNotFormatted = separatedDay.get(0);
        day = (dayNotFormatted.length() == 1) ? "0" + dayNotFormatted : dayNotFormatted;
        month = separatedDay.get(1);
        year = separatedDay.get(2);

        return this;
    }


    public String getYear() {
        return year;
    }

    public Student withYear(String year) {
        this.year = year;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public Student withMonth(String month) {
        this.month = month;
        return this;
    }

    public String getDay() {
        return day;
    }

    public Student withDay(String day) {
        this.day = day;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return firstName.equals(that.firstName) && lastName.equals(that.lastName) && email.equals(that.email) && number.equals(that.number) && gender.equals(that.gender) && year.equals(that.year) && month.equals(that.month) && day.equals(that.day) && subjects.equals(that.subjects) && hobbies.equals(that.hobbies) && imageName.equals(that.imageName) && state.equals(that.state) && city.equals(that.city) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, number, gender, year, month, day, subjects, hobbies, imageName, state, city, address);
    }

    private String formatList(List<String> list) {
        return list.toString().replace("[", "")
                .replace("'", "")
                .replace("]", "");
    }
}
