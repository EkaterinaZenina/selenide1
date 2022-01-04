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
        $("[data-test-id='date'] .input__control").setValue("2022-01-07");
        $("[data-test-id='name'] .input__control").setValue("Евгения Солнцева");
        $x("//*[@name='phone']").setValue("+79117389427");
        $("button").click();
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='notification']").shouldHave(Condition.text("Встреча успешно забронирована на " + "date"), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldNotRegByAccountСity() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999");
        $("[data-test-id='city'] .input__control").setValue("Париж");
        $("[data-test-id='date'] .input__control").setValue("2022-01-07");
        $("[data-test-id='name'] .input__control").setValue("Евгения Солнцева");
        $x("//*[@name='phone']").setValue("+79117389427");
        $("button").click();
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='notification']").shouldHave(Condition.text("Доставка в выбранный город недоступна"), Duration.ofSeconds(15)).shouldBe(visible);
    }
    @Test
    public void shouldNotRegByAccountData(){
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999");
        $("[data-test-id='city'] .input__control").setValue("Вологда");
        $("[data-test-id='date'] .input__control").setValue("2021-12-31");
        $("[data-test-id='name'] .input__control").setValue("Евгения Солнцева");
        $x("//*[@name='phone']").setValue("+79117389427");
        $("button").click();
        $(".checkbox__box").click();
        $(".button__text").click();
    }

    @Test
    public void shouldNotRegByAccountName() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999");
        $("[data-test-id='city'] .input__control").setValue("Вологда");
        $("[data-test-id='date'] .input__control").setValue("2022-01-07");
        $("[data-test-id='name'] .input__control").setValue("Evgenya Solntseva");
        $x("//*[@name='phone']").setValue("+79117389427");
        $("button").click();
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='notification']").shouldHave(Condition.text("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldNotRegByAccountNumber() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999");
        $("[data-test-id='city'] .input__control").setValue("Вологда");
        $("[data-test-id='date'] .input__control").setValue("2022-01-07");
        $("[data-test-id='name'] .input__control").setValue("Евгения Солнцева");
        $x("//*[@name='phone']").setValue("+79117388282829427");
        $("button").click();
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='notification']").shouldHave(Condition.text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldNotRegByAccountTip() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999");
        $("[data-test-id='city'] .input__control").setValue("Вологда");
        $("[data-test-id='date'] .input__control").setValue("2022-01-07");
        $("[data-test-id='name'] .input__control").setValue("Евгения Солнцева");
        $x("//*[@name='phone']").setValue("+79116372947");
        $("button").click();

        $(".button__text").click();
        $("[data-test-id='notification']").shouldHave(Condition.text("Я соглашаюсь с условиями обработки и использования моих персональных данных"));


    }
}
