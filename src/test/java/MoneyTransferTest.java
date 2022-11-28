import data.DataHelper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.LoginPageV1;
import page.MoneyTransferPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {
    public String transferAmount = "50";


    @Test
    void shouldTransferMoney() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var moneyTransferFor01Card = page.MoneyTransferPage.moneyTransferFor01Card(transferAmount);

    }

    @Test
    void shouldCheckBalance() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var firstCardStartBalance = page.DashboardPage.getFirstCardBalance();
        var secondCardStartBalance = page.DashboardPage.getSecondCardBalance();

        var moneyTransferFor01Card = page.MoneyTransferPage.moneyTransferFor01Card(transferAmount);
        var firstCardFinalBalance = page.DashboardPage.getFirstCardBalance();
        var secondCardFinalBalance = page.DashboardPage.getSecondCardBalance();
        int transferAmountInt = Integer.parseInt(transferAmount);
        assertEquals(firstCardStartBalance + transferAmountInt, firstCardFinalBalance);
        assertEquals(secondCardStartBalance - transferAmountInt, secondCardFinalBalance);
    }
}
