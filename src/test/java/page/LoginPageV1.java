package page;

import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageV1 {

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        $("[name='login']").setValue(info.getLogin());
        $("[name='password']").setValue(info.getPassword());
        $("[data-test-id=action-login]").click();
        return new VerificationPage();
    }
}
