package gui.pages;

import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

import java.util.Properties;

public class DashboardPage extends BasePage {
    private static final Logger log = Logger.getLogger(DashboardPage.class);
    public DashboardPage(Page page, Properties prop) {
        super(page, prop);
    }

    public PersonalDetailPage clickMyInfo() {
        log.info("Clicking my info");
        page.click("//span[text()='My Info']");
        return new PersonalDetailPage(page,prop);
    }
}
