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
import sun.reflect.misc.FieldUtil;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

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

    @Test
    public  void TakeScreenshottoFile ()throws IOException {
        takeScreenShort(driver, "C:\\selenium\\intelij-idea-practice-master\\image.pnj");

    }

    @Test(description = "Test I created for ")
    public void firstTestNG() {
        driver.get("https://vnexpress.net/");
        // Assert
        Assert.assertTrue(driver.getTitle().contains("VnExpress"));
    }

    @Test(description = "Test I created for ")
    public void takeScreenShort(WebDriver webdriver,String fileWithPath) throws IOException {
        driver.get("https://vnexpress.net/");

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);




    }


}
