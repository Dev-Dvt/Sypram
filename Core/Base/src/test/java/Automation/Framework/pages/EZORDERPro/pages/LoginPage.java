package Automation.Framework.pages.EZORDERPro.pages;

import Automation.Framework.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement loginButton;

    @FindBy(css = ".jconfirm-box-container") // Example element for a failed message
    private WebElement failedMessage;

    @FindBy(css = ".jconfirm-buttons") // Example element for a failed message OK button
    private WebElement failedLoginOK;

    @FindBy(css = ".dropbtn.ps-2") // Example element for a logout button
    private WebElement userButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean iuserButton() {
        userButton.isDisplayed();
        return true;
    }

    public String ifailedmessage() {
        return failedMessage.getText();

    }

    public void clickfailedLoginOK() {
        failedLoginOK.click();
    }

}



