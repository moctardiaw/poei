package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BestSellerPage {

    private WebDriver driver;

    private final int TIMEOUT_COOKIE = 1000;

    private By hoverMenuSelector = By.xpath("//*[@id=\"3663326022551\"]/div[2]/div[1]/div[2]/div[2]/a/span");

    //*[@id="data-produit-acheter"]/button
    public BestSellerPage (WebDriver driver){

        this.driver = driver;
    }

    public carrefour.BestSellerPage seeProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement hoverMenuShopping = wait.until(ExpectedConditions.visibilityOfElementLocated(hoverMenuSelector));
        hoverMenuShopping.click();
        return this;
    }
}
