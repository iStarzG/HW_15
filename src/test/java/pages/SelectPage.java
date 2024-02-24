package test.java.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelectPage {

    private SelenideElement
            modalCheck = $(".modal-open"),
            tableName = $(".table");

    @Step("Обнаружение модального окна")
    public SelectPage modalOpenCheck(Condition... conditions) {
        modalCheck.shouldBe(conditions);
        return this;
    }
    @Step("Проверка данных в таблице")
    public SelectPage tableCheck(String key, String value) {
        tableName.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

}


