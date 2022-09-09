package carrefour;

import amazon.HomePage;
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

        carrefour.HomePage homePage = new carrefour.HomePage(driver);
        homePage.acceptCookie().goShopping().hoverMenuRayon().navMenuRayon().sportMenuRayon().bestSellerMenuRayon().seeProduct();
        sleeping(3000);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    public void sleeping(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
