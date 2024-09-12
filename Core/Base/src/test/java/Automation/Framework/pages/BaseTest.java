package Automation.Framework.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import java.net.MalformedURLException;

public class BaseTest {
    protected WebDriver driver;

    //@Parameters({"platform", "deviceName", "browser", "url"})
    //public void setUp(String platform, String deviceName, String browser, String url) throws MalformedURLException {

    @BeforeMethod
    @Parameters({"platform", "browser", "url"})
    public void setUp(@Optional String platform, @Optional String browser, @Optional String url) throws MalformedURLException {
        if (platform.equalsIgnoreCase("desktop")) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }
            driver.manage().window().maximize();
            driver.get(url);
        } /*else if (platform.equalsIgnoreCase("android")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("browserName", "Chrome");
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.get(url);
        } else if (platform.equalsIgnoreCase("ios")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("browserName", "Safari");
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.get(url);
        }*/
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
