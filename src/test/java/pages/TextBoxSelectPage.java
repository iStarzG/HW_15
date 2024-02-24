package test.java.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxSelectPage {
    private SelenideElement
            nameCheck = $("#output #name"),
            emailCheck = $("#output #email"),
            currentAdressCheck = $("#output #currentAddress"),
            permanentAdressCheck = $("#output #permanentAddress");

    @Step("Проверка имени {value}")
    public TextBoxSelectPage nameCheck(String value) {
        nameCheck.shouldHave(text(value));
        return this;
    }
    @Step("Проверка майла {value}")
    public TextBoxSelectPage emailCheck(String value) {
        emailCheck.shouldHave(text(value));
        return this;
    }
    @Step("Проверка адреса №1 {value}")
    public TextBoxSelectPage currentAdressCheck(String value) {
        currentAdressCheck.shouldHave(text(value));
        return this;
    }
    @Step("Проверка адреса №2 {value}")
    public TextBoxSelectPage permanentAdressCheck(String value) {
        permanentAdressCheck.shouldHave(text(value));
        return this;
    }

}
