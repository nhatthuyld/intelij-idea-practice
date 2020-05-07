package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTest {


    private WebDriver driver;

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver");
        driver = new ChromeDriver();

    }

    @Test(description = "Test I created for ")
    public void firstTestNG() {
        driver.get("https://vnexpress.net/");
        // Assert
        Assert.assertTrue(driver.getTitle().contains("vnexpress"));
    }

}
