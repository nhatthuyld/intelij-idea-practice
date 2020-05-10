package testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import package1.DriverFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFirstTest {


    private WebDriver driver;

    @BeforeMethod
    public void SetUp() {
        driver = DriverFactory.getChromeDriver();

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();

    }

    @Test(description = "Test I created for ")
    public void firstTestNG() {
        driver.get("https://vnexpress.net/");
        // Assert
        Assert.assertTrue(driver.getTitle().contains("VnExpress"));
    }

    @Test(description = "Test I created for ")
    public void takeScreenShort() throws IOException {
        driver.get("https://vnexpress.net/");
        TakesScreenshot tkss = (TakesScreenshot) driver;
        File vnExpressHomePage = tkss.getScreenshotAs(OutputType.FILE);
        Path outputScreenshot =  Paths.get("output/vn-express" + System.currentTimeMillis() + ".png");

        //Copy file at destination
        Files.copy(Paths.get(vnExpressHomePage.getPath()),outputScreenshot);

        // ImageIO.write(screenshot.getImage(), "jpg", new File(".\\screenshot\\fullimage.jpg"));
        // Assert
        Assert.assertTrue(driver.getTitle().contains("VnExpress"));
    }

}
