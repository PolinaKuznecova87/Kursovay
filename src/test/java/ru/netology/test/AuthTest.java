package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.VarificationPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.netology.data.API.PaymentPageForm;

public class AuthTest {



    DashboardPage dashboardPage;
    VarificationPage varificationPage;





    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
    }


    @BeforeEach
    void openSetup() {

        dashboardPage = open("http://localhost:8080", DashboardPage.class);
    }

    @Test
    @DisplayName("Successfully pay for the trip")
    void shouldSuccessfulPay() {

var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
        DataHelper.getName(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyMessageSuccessful();


    }

    //Невалидные данные карты
//данные карты
    @Test
    @DisplayName("Invalid card number data")
    void shouldPayWithBigCardNumber() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getBigCardNumber(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayWithLatinLetters() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getLatinLettersCardNumber(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayWithSignsCardNumber() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getSignsCardNumber(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }
    @Test
    @DisplayName("Invalid card number data")
    void shouldPayWithEmptyValueCardNumber() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getEmptyValueCardNumber(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

//данные месяца

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayWithMore12Month() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMore12Month(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorInvalidCardData();


    }





    @Test
    @DisplayName("Invalid card number data")
    void shouldPayWithMonthWithZeros() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonthWithZeros() , DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }



    @Test
    @DisplayName("Invalid card number data")
    void shouldPayMonthWithEmptyField() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonthWithEmptyField(),
                DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    //данные года


    @Test
    @DisplayName("Invalid card number data")
    void shouldPayEmptyYear() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getEmptyYear(),
                DataHelper.getName(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayPastYear() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getPastYear(),
                DataHelper.getName(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorPeriodCard();


    }

//данные владельца

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayNameInLatinLetters() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getNameInLatinLetters(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayNameWithNumbers() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getNameWithNumbers(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayNameWithSigns() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getNameWithSigns(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayNameOneLetter() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getNameOneLetter(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayOwnerNameLong() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getOwnerNameLong(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayNameEmptyField() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getNameEmptyField(),DataHelper.getCodeCVC());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorEmptyOwnerField();


    }

    //СVV

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayCVCOneDigit() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCVCOneDigit());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayCVCTwoDigits() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCVCTwoDigits());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }
    @Test
    @DisplayName("Invalid card number data")
    void shouldPayCVCFourDigits() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCVCFourDigits());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayCVCWithSigns() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCVCWithSigns());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorFormat();


    }

    @Test
    @DisplayName("Invalid card number data")
    void shouldPayCVCEmptyField() {

        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCVCEmptyField());
        varificationPage.payPage(dataHelper);

        varificationPage.verifyErrorEmptyOwnerField();


    }

    //SQL


    @Test
    @DisplayName("Payment approved card")

    public void shouldSuccessPayIfValidApprovedCards() {
        var dataHelper = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCVCEmptyField());
        varificationPage.payPage(dataHelper);
        varificationPage.verifyMessageSuccessful();

        var expectedStatus = "APPROVED";
        var actualStatus = SQLHelper.getPaymentStatus();
        assertEquals(expectedStatus, actualStatus);
    }

    //API

    @Test
    void shouldValidStatusCardPaymentApproved() {
        var validApprovedCard = new DataHelper.UserInfo(DataHelper.getCardInfo(),DataHelper.getMonth(), DataHelper.getYears(),
                DataHelper.getName(),DataHelper.getCVCEmptyField());
        var status = PaymentPageForm(validApprovedCard);
        assertTrue(status.contains("APPROVED"));
    }

}




