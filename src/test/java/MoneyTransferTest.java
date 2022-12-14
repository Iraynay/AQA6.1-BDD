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
    public String transferAmount = "100";
    public String firstCardNumber = DataHelper.getFirstCardNumber().getFirstCard();
    public String secondCardNumber = DataHelper.getSecondCardNumber().getSecondCard();


    @Test
    void shouldCheckBalanceFirstCardTransferFor01Card() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var firstCardStartBalance = page.DashboardPage.getFirstCardBalance();
        var secondCardStartBalance = page.DashboardPage.getSecondCardBalance();
        new DashboardPage().topUpForCard1();
        var moneyTransferFor01Card = new MoneyTransferPage().moneyTransferFor(transferAmount, secondCardNumber);
        var firstCardFinalBalance = page.DashboardPage.getFirstCardBalance();
        var secondCardFinalBalance = page.DashboardPage.getSecondCardBalance();
        int transferAmountInt = Integer.parseInt(transferAmount);
        assertEquals(firstCardStartBalance + transferAmountInt, firstCardFinalBalance);
        assertEquals(secondCardStartBalance - transferAmountInt, secondCardFinalBalance);
    }

    @Test
    void shouldCheckBalanceFirstCardTransferFor02Card() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var firstCardStartBalance = page.DashboardPage.getFirstCardBalance();
        var secondCardStartBalance = page.DashboardPage.getSecondCardBalance();
        new DashboardPage().topUpForCard2();
        var moneyTransferFor01Card = new MoneyTransferPage().moneyTransferFor(transferAmount, firstCardNumber);
        var firstCardFinalBalance = page.DashboardPage.getFirstCardBalance();
        var secondCardFinalBalance = page.DashboardPage.getSecondCardBalance();
        int transferAmountInt = Integer.parseInt(transferAmount);
        assertEquals(firstCardStartBalance - transferAmountInt, firstCardFinalBalance);
        assertEquals(secondCardStartBalance + transferAmountInt, secondCardFinalBalance);
    }

}
