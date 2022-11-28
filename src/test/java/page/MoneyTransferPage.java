package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    private static SelenideElement heading = $("[data-test-id='action-deposit']");
    private static SelenideElement amount = $("[data-test-id='amount'] .input__control");
    private static SelenideElement debitAccount = $("[data-test-id='from'] .input__control");
    private static SelenideElement topUp = $("[data-test-id='action-transfer']");


    public static DashboardPage moneyTransferFor01Card(String transferAmount) {
        heading.click();
        amount.setValue(transferAmount);
        debitAccount.setValue("5559 0000 0000 0002");
        topUp.click();
        return new DashboardPage();

    }

}
