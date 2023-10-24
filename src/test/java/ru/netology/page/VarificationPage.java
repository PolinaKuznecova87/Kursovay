package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class VarificationPage {


    private static final SelenideElement card = $x("//*[contains(text(), 'Номер карты')]");


    private static final SelenideElement month = $x("//*[contains(text(), 'Месяц')]");

    private static final SelenideElement year = $x("//*[contains(text(), 'Год')]");

    private static final SelenideElement name = $x("//*[contains(text(), 'Владелец')]");

    private static final SelenideElement codeCVC = $x("//*[contains(text(), 'CVC/CVV')]");


    private static final SelenideElement button = $x("//*[contains(text(), 'Продолжить')]");

    private static final  SelenideElement messageSuccessful  = $x("//*[contains(text(), 'Успешно')]");
    private static final SelenideElement errorFormat = $x("//*[contains(text(), 'Неверный формат')]");
    private static final SelenideElement errorInvalidCardData = $x("//*[contains(text(), 'Неверно указан срок действия карты')]");
    private static final SelenideElement errorPeriodCard = $x("//*[contains(text(), 'Истёк срок действия карты')]");
    private static final SelenideElement   errorEmptyOwnerField   = $x("//*[contains(text(), 'Поле обязательно для заполнения')]");
    private static final SelenideElement messageError = $x("//*[contains(text(), 'Ошибка')]");


    public void verifyMessageSuccessful() {
        messageSuccessful.shouldBe(visible).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }



    public void verifyErrorFormat() {
        errorFormat.shouldBe(visible).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void verifyErrorInvalidCardData() {
        errorInvalidCardData.shouldBe(visible).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void verifyErrorPeriodCard() {
        errorPeriodCard.shouldBe(visible).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void verifyErrorEmptyOwnerField() {
        errorEmptyOwnerField.shouldBe(visible).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void verifyMessageError() {
        messageError.shouldBe(visible).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }





    public void payPage(DataHelper.UserInfo userInfo) {
        card.setValue(DataHelper.getCardInfo());
        month.setValue(DataHelper.getMonth());
        year.setValue(DataHelper.getYears());
        name.setValue(DataHelper.getName());
        codeCVC.setValue(DataHelper.getCodeCVC());
        button.click();
        messageSuccessful.shouldBe(Condition.visible, Duration.ofSeconds(15));




    }
}
