package carrefour.scenario1;

import common.SetupTeardown;
import common.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class TestScenarioGlobal extends SetupTeardown {

    Wait wait;

    @Test
    public void testScenario_1(){

        carrefour.HomePage homePage = new carrefour.HomePage(driver);
        homePage.acceptCookie().goShopping();//.hoverMenuRayon().navMenuRayon().sportMenuRayon();//.bestSellerMenuRayon().seeProduct();
        Wait.sleeping(3000);
    }

}
