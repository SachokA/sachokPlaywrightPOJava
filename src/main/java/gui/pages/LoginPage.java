package gui.pages;

import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

import java.util.Properties;

public class LoginPage extends BasePage {
    private static final Logger log = Logger.getLogger(LoginPage.class);

    public LoginPage(Page page, Properties prop) {
        super(page, prop);
    }


    public void setUserNameInput() {
        page.fill("//input[@name='username']", prop.getProperty("userName"));
    }

    public void setUserPasswordInput() {
        page.fill("//input[@name='password']", prop.getProperty("password"));
    }

    public void clickButtonSubmit() {
        page.click("//button[@type='submit']");
    }
    public void loginWithValidCredential() {
        log.info("Login with valid credential data");
        setUserNameInput();
        setUserPasswordInput();
        clickButtonSubmit();
    }
    public void loginWithInvalidCredential(String userName, String password) {
        log.info("Login with invalid credential data");
        page.fill("//input[@name='username']",userName);
        page.fill("//input[@name='password']",password);
        clickButtonSubmit();
    }

    public ResetPasswordPage clickForgottenPassword() {
        log.info("Click button forgotten Password");
        page.click("//p[contains(@class,'login-forgot')]");
        return new ResetPasswordPage(page,prop);
    }

    public boolean isEnabledErrorMessage() {
        return page.isEnabled("//div[@role='alert']");
    }

    public String getAlertMessage() {
        log.info("Getting alert message");
        return page.innerText("//div[@role='alert']");
    }
}
