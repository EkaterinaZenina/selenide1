import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class ShouldRegByAccountTest {

    public static String generateDate(int days){
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    public void shouldRegByAccount() {
     String planningDate = generateDate(4);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Вологда");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(String.valueOf(planningDate));
        $("[data-test-id='name'] .input__control").setValue("Евгения Солнцева");
        $x("//*[@name='phone']").setValue("+79117389427");
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='notification']").shouldHave(Condition.text("Встреча успешно забронирована на "+ planningDate ), Duration.ofSeconds(15)).shouldBe(visible);
    }


}


