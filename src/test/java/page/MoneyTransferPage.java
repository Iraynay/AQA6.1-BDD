package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

//import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement.*;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    private SelenideElement initiateTopUp = $("[data-test-id='action-deposit']");
    private SelenideElement amount = $("[data-test-id='amount'] .input__control");
    private SelenideElement debitAccount = $("[data-test-id='from'] .input__control");
    private SelenideElement topUp = $("[data-test-id='action-transfer']");



    public DashboardPage moneyTransferFor01Card(String transferAmount) {
        String secondCardNumber = String.valueOf(DataHelper.getSecondCardNumber());
        initiateTopUp.click();
        amount.setValue(transferAmount);
        debitAccount.setValue(secondCardNumber);
        topUp.click();
        return new DashboardPage();

    }

}
