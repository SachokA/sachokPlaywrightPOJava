package base;

import com.microsoft.playwright.Page;
import gui.core.PlaywrightFactory;
import gui.pages.ContactDetailsPage;
import gui.pages.DashboardPage;
import gui.pages.LoginPage;
import gui.pages.ResetPasswordPage;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    private static final Logger log = Logger.getLogger(BaseTest.class);
    PlaywrightFactory pf;
    protected Page page;
    Properties prop;
    protected LoginPage loginPage;
    protected ResetPasswordPage resetPasswordPage;
    protected DashboardPage dashboardPage;
    protected ContactDetailsPage contactDetailsPage;

    @BeforeEach
    public void setup() throws IOException {
        log.info("Initialized browser");
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        loginPage = new LoginPage(page, prop);
        resetPasswordPage = new ResetPasswordPage(page, prop);
        dashboardPage = new DashboardPage(page, prop);
        contactDetailsPage = new ContactDetailsPage(page, prop);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tearing down browser");
        page.context().browser().close();
    }
}