package carrefour;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPageObjet {

    WebDriver driver;
    String URL = "https://www.carrefour.fr/";

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @Test
    public void testScenario_1(){

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
