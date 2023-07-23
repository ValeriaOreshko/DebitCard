package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DebitCardTest {
    @Test
    void shouldPositiveTest() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Мария Иванова");
        $("[data-test-id=phone] input").setValue("+79110000000");
        $(".checkbox").click();
        $(".button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
    @Test
    void shouldNegativeTestName() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Maria Ivanova");
        $("[data-test-id=phone] input").setValue("+79110000000");
        $(".checkbox").click();
        $(".button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldNegativeTestPhone() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Мария Иванова");
        $("[data-test-id=phone] input").setValue("+7911000000");
        $(".checkbox").click();
        $(".button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldNegativeTestEmptyName() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("+79110000000");
        $(".checkbox").click();
        $(".button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldNegativeTestEmptyPhone() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Мария Иванова");
        $("[data-test-id=phone] input").setValue("");
        $(".checkbox").click();
        $(".button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldNegativeTestCheckbox() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Мария Иванова");
        $("[data-test-id=phone] input").setValue("+79110000000");
        $(".button").click();
        $("[data-test-id='agreement'].input_invalid").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }

}
