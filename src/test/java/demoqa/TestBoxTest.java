package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTest {

        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920*1080";
        }
        @Test
        void demoqaTest() {
            open("https://demoqa.com/text-box");
            $(".main-header").shouldHave(text("Text BoX"));
            $("#userName").setValue("Alex");
            $("#userEmail").setValue("qwerty@test.ru");
            $("#currentAddress").setValue("Sparta");
            $("#permanentAddress").setValue("Babylon");
            $("#submit").click();
            $("#output").shouldBe(visible);

        }

}
