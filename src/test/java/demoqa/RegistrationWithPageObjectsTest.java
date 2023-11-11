package demoqa;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationWithPageObjectsTest extends TestBase {


    @Test
    void succesfullRegistratioTest() {
        String userName = "Alex",
                lastName = "Petrov",
                email = "qwerty@gmail.com",
                Gender = "Other",
                Number = "1234567890",
                birthDateYear = "2008",
                birthDateMonth = "July",
                birthDateDay = "30",
                subjects = "Math",
                hobbies = "Sports",
                img = "img.jpg",
                currentAddress = "Some adress 1",
                state = "NCR",
                city = "Delhi",
                stateAndCity = state + " " + city;



        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(Gender)
                .setNumber(Number)
                .setBirthDate(birthDateDay, birthDateMonth,
                        birthDateYear)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(img)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();;

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + "Petrov")
                .verifyResult("Student Email", "qwerty@gmail.com")
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "30 July,2008")
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", img)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", stateAndCity);


        $(".table-responsive").shouldHave(text(userName), text("Petrov"),
                text("qwerty@gmail.com"), text("1234567890"));

    }


}
