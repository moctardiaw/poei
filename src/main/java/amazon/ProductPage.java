package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By panierButtonSelector = By.cssSelector("add-to-cart-button");
    private final int TIMEOUT_PANIER_BUTTON = 1000;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_PANIER_BUTTON));
    }
    public ProductPage addToCart(){
        WebElement panierButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        panierButton.click();
        return this;
    }

    public ProductPage refuseAppleCare(){
        WebElement nomerciButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span#attachSiNoCoverage")));
        nomerciButton.click();
        return this;
    }

    public CartPage openCart(){
        WebElement ouvrirPanierButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='attach-sidesheet-view-cart-button']/span/input")));
        ouvrirPanierButton.click();
        return new CartPage(driver);
    }


}
