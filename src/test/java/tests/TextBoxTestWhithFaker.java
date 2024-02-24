package test.java.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.java.pages.TextBoxRegistrationPage;
import test.java.pages.TextBoxSelectPage;
import test.java.pages.components.TestRandomData;

public class TextBoxTestWhithFaker extends test.java.pages.components.TestBase {

    test.java.pages.TextBoxRegistrationPage textBoxPage = new TextBoxRegistrationPage();
    test.java.pages.TextBoxSelectPage textBoxSelect = new TextBoxSelectPage();
    test.java.pages.components.TestRandomData testRandomData = new TestRandomData();


    @Test
    @Tag("RegistrationTextBox")
    @Owner("iStarzG")
    @DisplayName("Заполнение формы регистрации с проверкой введеных данных")
    void textBoxWithPages() {
        textBoxPage.openPage()
                .setFirstName(testRandomData.firstName)
                .setEmailName(testRandomData.inputEmail)
                .setCurrentAdress(testRandomData.inputAddress)
                .setPermanentAdress(testRandomData.inputAddress2)
                .submitClick();
        textBoxSelect.nameCheck(testRandomData.firstName)
                .emailCheck(testRandomData.inputEmail)
                .currentAdressCheck(testRandomData.inputAddress)
                .permanentAdressCheck(testRandomData.inputAddress2);

    }
}
