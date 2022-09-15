package main.java.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class SetupTeardown {

    protected WebDriver drivers;
    protected DriverFactory driver;
    protected String browser="edge";
    final String carrefourURL = "https://www.carrefour.fr/";

    @BeforeMethod
    public void setup()  {

        DriverFactory driver = new DriverFactory();
        drivers = driver.getDriver(browser);

        drivers.manage().window().maximize();
        drivers.get(carrefourURL);
    }

    @AfterMethod
    public void teardown(){
        drivers.quit();
    }
}
