package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {


    @Test
    public void loginTestWithValidDate() {
//        final String userName = "Admin";
//        final String userPassword = "admin123";
        final String expectedTitle = "OrangeHRM";
        final String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

       loginPage.loginWithValidCredential();

        Assertions.assertEquals(expectedTitle, loginPage.getTitle());
        Assertions.assertEquals(expectedURL, loginPage.getUrl());
    }

    @Test
    public void loginTestWithInvalidData() {
        final String userName = "SomeMan";
        final String userPassword = "admin123";

       loginPage.loginWithInvalidCredential(userName,userPassword);

        Assertions.assertTrue(loginPage.isEnabledErrorMessage());
        Assertions.assertEquals("Invalid credentials", loginPage.getAlertMessage());
    }
}
