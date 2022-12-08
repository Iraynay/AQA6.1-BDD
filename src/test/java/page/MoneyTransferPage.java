package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

//import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement.*;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    private SelenideElement amount = $("[data-test-id='amount'] .input__control");
    private SelenideElement debitAccount = $("[data-test-id='from'] .input__control");
    private SelenideElement topUp = $("[data-test-id='action-transfer']");


    public DashboardPage moneyTransferFor(String transferAmount, String debitCard) {
        amount.setValue(transferAmount);
        debitAccount.setValue(debitCard);
        topUp.click();
        return new DashboardPage();

    }

}
