package demoqa.com.models;

import java.util.List;
import java.util.Objects;

public class StudentData {
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

    public StudentData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public StudentData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public StudentData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public StudentData withNumber(String number) {
        this.number = number;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public StudentData withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public StudentData withSubjects(List<String> subjects) {
        this.subjects = subjects;
        return this;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public StudentData withHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public String getImageName() {
        return imageName;
    }

    public StudentData withImageName(String image) {
        this.imageName = image;
        return this;
    }

    public String getImagePath() {
        return String.format("src/test/resources/%s", imageName);
    }


    public String getState() {
        return state;
    }

    public StudentData withState(String state) {
        this.state = state;
        return this;
    }

    public String getCity() {
        return city;
    }

    public StudentData withCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public StudentData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getYear() {
        return year;
    }

    public StudentData withYear(String year) {
        this.year = year;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public StudentData withMonth(String month) {
        this.month = month;
        return this;
    }

    public String getDay() {
        return day;
    }

    public StudentData withDay(String day) {
        this.day = day;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentData that = (StudentData) o;
        return firstName.equals(that.firstName) && lastName.equals(that.lastName) && email.equals(that.email) && number.equals(that.number) && gender.equals(that.gender) && year.equals(that.year) && month.equals(that.month) && day.equals(that.day) && subjects.equals(that.subjects) && hobbies.equals(that.hobbies) && imageName.equals(that.imageName) && state.equals(that.state) && city.equals(that.city) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, number, gender, year, month, day, subjects, hobbies, imageName, state, city, address);
    }
}
