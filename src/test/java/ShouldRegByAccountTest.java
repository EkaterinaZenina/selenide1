import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class ShouldRegByAccountTest {
    @Test
    public void shouldRegByAccount() {

        open("http://0.0.0.0:9999");
        $("[data-test-id='city'] .input__control").setValue("Вологда");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(String.valueOf(2022-01-10));
        $("[data-test-id='name'] .input__control").setValue("Евгения Солнцева");
        $x("//*[@name='phone']").setValue("+79117389427");
        $("button").click();
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='notification']").shouldHave(Condition.text("Встреча успешно забронирована на " ), Duration.ofSeconds(15)).shouldBe(visible);
    }


}


