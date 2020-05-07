package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class class1 {


    public class Basetest{

        private WebDriver driver;

        public void SetUp(){
            System.setProperty("webdriver.chrome.driver", "resource/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://vnexpress.net/");
            System.out.println(driver.getTitle());
        }

        public static void main(String args[]){
            class1 c1 = new Basetest();
            c1.SetUp();
        }
    }


}
