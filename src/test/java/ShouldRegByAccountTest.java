import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class ShouldRegByAccountTest {
    @Test
    public void shouldRegByAccount() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999");
        $("[data-test-id='city'] .input__control").setValue("Вологда");
        $("[data-test-id='date'] .input__control").setValue("2022-01-10");
        $("[data-test-id='name'] .input__control").setValue("Евгения Солнцева");
        $x("//*[@name='phone']").setValue("+79117389427");
        $("button").click();
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='notification']").shouldHave(Condition.text("Встреча успешно забронирована на " + "date"), Duration.ofSeconds(15)).shouldBe(visible);
    }
}

