package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private static ElementsCollection card1 = $$("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private static ElementsCollection card2 = $$("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    private static final String balanceStart = ", баланс: ";
    private static final String balanceFinish = "р.";

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public static int getFirstCardBalance() {
        val text = card1.first().text();
        return extractBalance(text);
    }

    public static int getSecondCardBalance() {
        val text = card2.first().text();
        return extractBalance(text);
    }

    private static int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish - 1);
        return Integer.parseInt(value);
    }
}
