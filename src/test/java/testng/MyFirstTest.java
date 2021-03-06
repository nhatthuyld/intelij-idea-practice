package testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import package1.DriverFactory;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class MyFirstTest {


    private WebDriver driver;

    @BeforeClass
    public void SetUp() {
        driver = DriverFactory.getChromeDriver();

    }

    @AfterClass
    public void afterMethod() {
        driver.close();

    }

    @Test
    public  void TakeScreenshottoFile ()throws IOException {
//        takeScreenShoot(driver, "/Users/woodpecker/Documents/Misc/intelij-idea-practice//image.png");
        takeScreenShoot(driver, "C:\\selenium\\intelij-idea-practice-master\\image.png");

    }

    @Test(description = "Test I created for ")
    public void firstTestNG() {
        driver.get("https://vnexpress.net/");
        // Assert
        Assert.assertTrue(driver.getTitle().contains("VnExpress"));
    }

    public void takeScreenShoot(WebDriver webdriver, String fileWithPath) throws IOException {
        driver.get("https://vnexpress.net/");

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }


}
