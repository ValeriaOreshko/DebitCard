package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DebitCardTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Maria Ivanova");
        $("[data-test-id=phone] input").setValue("+79110000000");
        $(".checkbox").click();
        $(".button").click();
        $("[data-test-id=name]").shouldHave(exactText("Фамилия и имя Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

}
