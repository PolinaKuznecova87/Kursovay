package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {


        private static final SelenideElement heading = $("#root");
        private static final SelenideElement verifyButton =  $x("//*[contains(text(), 'Купить')]");
    private static final SelenideElement formPayment = $x("//*[contains(text(), 'Оплата по карте')]");



        public void varificationPage()   {
            heading.shouldBe(visible);
            verifyButton.click();
            formPayment.shouldBe(Condition.visible, Duration.ofSeconds(15));


        }
    }

