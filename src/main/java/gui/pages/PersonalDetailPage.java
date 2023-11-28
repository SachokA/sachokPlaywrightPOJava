package gui.pages;

import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

import java.util.Properties;

public class PersonalDetailPage extends BasePage {
    private static final Logger log = Logger.getLogger(PersonalDetailPage.class);

    public PersonalDetailPage(Page page, Properties prop) {
        super(page, prop);
    }

    public ContactDetailsPage clickContactDetailsButton() {
        log.info("click Contact Details Button");
        page.click("//a[text()='Contact Details']");
        return new ContactDetailsPage(page, prop);
    }
}
