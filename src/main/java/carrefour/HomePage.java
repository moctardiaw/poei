package carrefour;

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

    public HomePage (WebDriver driver){

        this.driver = driver;
    }

    public carrefour.HomePage acceptCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
        return this;
    }

    public carrefour.ShoppingPage goShopping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement linkShopping = wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingSelector));
        linkShopping.click();
        return new carrefour.ShoppingPage(driver);
    }
}
