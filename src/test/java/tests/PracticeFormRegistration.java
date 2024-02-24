package test.java.tests;


import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.java.pages.RegistrationPage;
import test.java.pages.SelectPage;
import test.java.pages.components.TestRandomData;


import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;

public class PracticeFormRegistration extends test.java.pages.components.TestBase {

    test.java.pages.RegistrationPage registrationPage = new RegistrationPage();
    test.java.pages.components.TestRandomData testRandomData = new TestRandomData();
    test.java.pages.SelectPage selectPage = new SelectPage();

    @Test
    @Tag("Registration")
    @Owner("iStarzG")
    @DisplayName("Заполнение формы регистрации с проверкой введеных данных")
    void succesfulRegistrationWithAllData() {

        registrationPage.openPage()
                .checkDialogModal()
                .setFirstName(testRandomData.firstName)
                .setLastName(testRandomData.lastName)
                .setEmail(testRandomData.inputEmail)
                .setGender(testRandomData.inputGender)
                .setPhoneNumber(testRandomData.inputPhone)
                .setDateOfBirth(testRandomData.dayRandom, testRandomData.randomMonth, testRandomData.randomYear)
                .setSubjects(testRandomData.inputSubject)
                .setHobbies(testRandomData.inputHobby)
                .uploadPicture(testRandomData.pictureName)
                .setCurrentAddress(testRandomData.inputAddress)
                .setState(testRandomData.inputState)
                .setCity(testRandomData.inputCity)
                .submitButton();
        selectPage.modalOpenCheck(visible)
                .tableCheck("Student Name", testRandomData.firstName)
                .tableCheck("Student Name", testRandomData.lastName)
                .tableCheck("Student Email", testRandomData.inputEmail)
                .tableCheck("Gender", testRandomData.inputGender)
                .tableCheck("Mobile", testRandomData.inputPhone)
                .tableCheck("Date of Birth", testRandomData.setRandomDay + " " + testRandomData.randomMonth + "," + testRandomData.randomYear)
                .tableCheck("Subjects", testRandomData.inputSubject)
                .tableCheck("Hobbies", testRandomData.inputHobby)
                .tableCheck("Picture", testRandomData.pictureName)
                .tableCheck("Address", testRandomData.inputAddress)
                .tableCheck("State and City", testRandomData.inputState)
                .tableCheck("State and City", testRandomData.inputCity);
    }

    @Test
    @Tag("MinimalInfoRegistration")
    @Owner("iStarzG")
    @DisplayName("Заполнение упращенной формы регистрации с проверкой минимальных данных")
    void RegistrationWithMinimalInformation() {

        registrationPage.openPage()
                .checkDialogModal()
                .setFirstName(testRandomData.firstName)
                .setLastName(testRandomData.lastName)
                .setGender(testRandomData.inputGender)
                .setPhoneNumber(testRandomData.inputPhone)
                .setDateOfBirth(testRandomData.dayRandom, testRandomData.randomMonth, testRandomData.randomYear)
                .submitButton();
        selectPage.modalOpenCheck(visible)
                .tableCheck("Student Name", testRandomData.firstName + " " + testRandomData.lastName)
                .tableCheck("Gender", testRandomData.inputGender)
                .tableCheck("Mobile", testRandomData.inputPhone)
                .tableCheck("Date of Birth", testRandomData.setRandomDay + " " + testRandomData.randomMonth + "," + testRandomData.randomYear);


    }


    @Test
    @Tag("NegativeTest")
    @Owner("iStarzG")
    @DisplayName("Негативный тест заполнения формы с отсутствием данных")
    void RegistrationEmptyInformation() {
        registrationPage.openPage()
                .submitButton()
                .colorCheck(testRandomData.findColor, testRandomData.colorName);
        selectPage.modalOpenCheck(hidden);
    }
}