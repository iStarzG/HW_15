package test.java.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxRegistrationPage {

    private SelenideElement
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAdressName = $("#currentAddress"),
            permanentAdressName = $("#permanentAddress"),

    submitClick = $("#submit");


    public TextBoxRegistrationPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxRegistrationPage setFirstName(String value) {
        userName.setValue(value);
        return this;
    }

    public TextBoxRegistrationPage setEmailName(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxRegistrationPage setCurrentAdress(String value) {
        currentAdressName.setValue(value);
        return this;
    }

    public TextBoxRegistrationPage setPermanentAdress(String value) {
        permanentAdressName.setValue(value);
        return this;
    }

    public TextBoxRegistrationPage submitClick() {
        submitClick.click();
        return this;
    }
}