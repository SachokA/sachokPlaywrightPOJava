package tests;


import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UpdatingFormInfoTest extends BaseTest {

    @Test
    public void updatingTestWithValidDate() {
//        page.pause();
        List<String> expectedContactInfo = List.of("street1", "street2", "city", "state", "123456789", "Albania");

        loginPage.loginWithValidCredential();
        dashboardPage
                .clickMyInfo()
                .clickContactDetailsButton()
                .cleanInputFields()
                .setInputFields()
                .setFieldCountry()
                .clickButtonSaveAndWaitMessageSuccessfully();
        contactDetailsPage.reloadPage();
        contactDetailsPage.waitForAppearedInputText();

        page.waitForTimeout(3000);

        Assertions.assertEquals(expectedContactInfo, contactDetailsPage.getInputFields());
    }
}
