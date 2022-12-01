import com.codeborne.selenide.Condition;
import data.DataHelper;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPageV1;
import page.MoneyTransferPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {
    public String transferAmount = "25000";


    @Test
    void shouldTransferFundsEnoughMoney() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
       var moneyTransferFor01Card = new MoneyTransferPage().moneyTransferFor01Card(transferAmount);
       $x("//h1[contains(text(),'Ваши карты')]").shouldBe(visible);

    }
    @Test
    void shouldCheckBalanceFirstCard() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var firstCardStartBalance = page.DashboardPage.getFirstCardBalance();
        var secondCardStartBalance = page.DashboardPage.getSecondCardBalance();
        var moneyTransferFor01Card = new MoneyTransferPage().moneyTransferFor01Card(transferAmount);
        var firstCardFinalBalance = page.DashboardPage.getFirstCardBalance();
        var secondCardFinalBalance = page.DashboardPage.getSecondCardBalance();
        int transferAmountInt = Integer.parseInt(transferAmount);
        assertEquals(firstCardStartBalance + transferAmountInt, firstCardFinalBalance);
    }
    @Test
    void shouldCheckBalanceSecondCard() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var firstCardStartBalance = page.DashboardPage.getFirstCardBalance();
        var secondCardStartBalance = page.DashboardPage.getSecondCardBalance();
        var moneyTransferFor01Card = new MoneyTransferPage().moneyTransferFor01Card(transferAmount);
        var firstCardFinalBalance = page.DashboardPage.getFirstCardBalance();
        var secondCardFinalBalance = page.DashboardPage.getSecondCardBalance();
        int transferAmountInt = Integer.parseInt(transferAmount);
        assertEquals(secondCardStartBalance - transferAmountInt, secondCardFinalBalance);
    }


}
