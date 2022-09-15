package carrefour;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    private By acceptCookieSelector = By.cssSelector("#onetrust-accept-btn-handler");
    private By ShoppingSelector = By.xpath("//*[@id='data-top-bar']/div/div/div[2]/label");


    private final int TIMEOUT_COOKIE = 1000;

    private static final Logger Log= LogManager.getLogger(HomePage.class);

    public HomePage (WebDriver driver){

        this.driver = driver;
    }

    /**
     *
     * @return HomePage
     */
    public carrefour.HomePage acceptCookie() {

        Log.info(" i want to accept cookie :Methode: "+HomePage.class.getMethods()[0].getName());
        //Log.debug("toto");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
        return this;
    }

    /**
     *
     * @return ShoppingPage
     */
    public carrefour.ShoppingPage goShopping() {
        Log.info(" i want to shopping :Methode: "+HomePage.class.getMethods()[1].getName());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement linkShopping = wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingSelector));
        linkShopping.click();
        return new carrefour.ShoppingPage(driver);
    }
}
