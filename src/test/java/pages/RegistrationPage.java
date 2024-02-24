package test.java.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import test.java.pages.components.InputCalendarComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            uploadPictureName = $("#uploadPicture"),
            genderWrapper = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            dialogClose = $(".fc-consent-root .fc-cta-consent");


    test.java.pages.components.InputCalendarComponent inputCalendarComponent = new InputCalendarComponent();

    @Step("Открытие страницы и удаление футера и банера")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    @Step("Закрытие диалогового окна при его наличии ")
    public RegistrationPage checkDialogModal() {
        int counter = 0;
        while (counter < 3) {

            if (dialogClose.isDisplayed()) {
                dialogClose.click();
                break;
            }
            sleep(1000);
            counter++;
        }
        return this;
    }

    @Step("Ввод имени: {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    @Step("Ввод фамилии: {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    @Step("Ввод Email: {value}")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }
    @Step("Выбор гендера: {value}")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Ввод номера телефона: {value}")
    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }
    @Step("Установка даты: {day},{month},{year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        inputCalendarComponent.setDate(day, month, year);

        return this;
    }
    @Step("Установка Subjects: {value}")
    public RegistrationPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }
    @Step("Выбор хобби: {value}")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Загрузка картинки: 1.jpeg")
    public RegistrationPage uploadPicture(String... strings) {
        uploadPictureName.uploadFromClasspath("img/1.jpeg");
        return this;

    }
    @Step("Выбор адреса: {value}")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    @Step("Выбор штата: {value}")
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Выбор города: {value}")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Проверка красного цвета в незаполненных полях")
    public RegistrationPage colorCheck(String findColor, String color) {
        firstNameInput.shouldHave(cssValue(findColor, color));
        lastNameInput.shouldHave(cssValue(findColor, color));
        phoneNumberInput.shouldHave(cssValue(findColor, color));
        genderWrapper.$("label[for='gender-radio-1']").shouldHave(cssValue(findColor, color));
        genderWrapper.$("label[for='gender-radio-2']").shouldHave(cssValue(findColor, color));
        genderWrapper.$("label[for='gender-radio-3']").shouldHave(cssValue(findColor, color));
        return this;
    }
    @Step("Нажатие кнопки submit")
    public RegistrationPage submitButton() {
        submitButton.click();

        return this;
    }
}
