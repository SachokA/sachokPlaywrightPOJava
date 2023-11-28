package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResetPasswordTest extends BaseTest {
    @Test
    public void validationFormResetPasswordTest() {

        loginPage.clickForgottenPassword();

        Assertions.assertEquals("Reset Password", resetPasswordPage.getTitlePage());
        Assertions.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode",
                resetPasswordPage.getUrl());
        Assertions.assertTrue(resetPasswordPage.isEditableFieldUserName());
        Assertions.assertTrue(resetPasswordPage.isEnabledButtonSubmit());
        Assertions.assertTrue(resetPasswordPage.isEnabledButtonCancel());
    }

    @Test
    public void changedPasswordTest() {
        loginPage.clickForgottenPassword()
                .setUserName();
        resetPasswordPage.clickSubmit();
        Assertions.assertEquals("Reset Password link sent successfully", resetPasswordPage.getTitlePage());
        Assertions.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset", page.url());
    }
}
