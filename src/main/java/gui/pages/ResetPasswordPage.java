package gui.pages;

import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

import java.util.Properties;

public class ResetPasswordPage extends BasePage {
    private static final Logger log = Logger.getLogger(ResetPasswordPage.class);
    public ResetPasswordPage(Page page, Properties prop) {
        super(page, prop);
    }

    public String getTitlePage() {
        return page.locator("//h6[contains(@class,'forgot-password-title')]").innerText();
    }

    public boolean isEditableFieldUserName() {
        return page.isEditable("//input[@name='username']");
    }

    public boolean isEnabledButtonCancel() {
        return page.isEnabled("//button[@type='button']");
    }

    public boolean isEnabledButtonSubmit() {
        return page.isEnabled("//button[@type='submit']");
    }

    public void clickSubmit() {
        log.info("Click submit");
        page.click("//button[@type='submit']");
    }

    public void setUserName() {
        log.info("Set user name");
        page.fill("//input[@name='username']", prop.getProperty("userName"));
    }
}
