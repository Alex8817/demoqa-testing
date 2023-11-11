package demoqa;

import com.codeborne.selenide.Configuration;
import demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
     RegistrationPage registrationPage = new RegistrationPage(); // для хранения в памяти быстро

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
}
