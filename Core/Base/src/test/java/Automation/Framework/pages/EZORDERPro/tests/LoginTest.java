package Automation.Framework.pages.EZORDERPro.tests;

import Automation.Framework.pages.BaseTest;
import Automation.Framework.pages.EZORDERPro.pages.LoginPage;
import Automation.Framework.utilities.ExcelUtils;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;



import java.io.IOException;
import java.util.Iterator;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Iterator<Object[]> loginData() throws IOException {
        return ExcelUtils.getTestData("src/test/Resources/Excel files/Logindata.xlsx", "Sheet1").iterator();
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Add assertions to verify successful login

        String message = loginPage.ifailedmessage();
        System.out.println(message);
        boolean expected = message.contains("Failed");
        Assert.assertTrue(expected, "Message doesn't have failed credential information");
        loginPage.clickfailedLoginOK();

        boolean expecteduser = loginPage.iuserButton();
        Assert.assertEquals(expecteduser, loginPage.iuserButton());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}