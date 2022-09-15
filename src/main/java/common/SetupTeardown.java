package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class SetupTeardown {

    protected WebDriver driver;
    ChromeOptions options;
    protected String carrefourURL = "https://www.carrefour.fr/";


    @BeforeMethod
    public void setup() throws MalformedURLException {

        options = new ChromeOptions();
        options.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(carrefourURL);


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
