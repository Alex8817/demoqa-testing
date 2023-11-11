package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private String TITLE_TEXT = "Student Registration Form";
    private final String IMG_FOLDER = "images/";
    private SelenideElement
            FirstNameInput = $("#firstName"),
            LastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            userEmailInput =  $("#userEmail"),
            genderChoice = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbiesChoice = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            stateAndCityChoice = $("#stateCity-wrapper"),
            submitButton = $("#submit");



    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        FirstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        LastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderChoice.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month,  year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        userSubjectsInput.setValue("Math").pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value){
        userHobbiesChoice.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String value){
        pictureUpload.uploadFromClasspath(IMG_FOLDER + value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        stateDropdown.click();
        stateAndCityChoice.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value){
        cityDropdown.click();
        stateAndCityChoice.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }


}
