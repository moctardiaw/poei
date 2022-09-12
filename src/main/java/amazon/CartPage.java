package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By quantitySelector = By.cssSelector("#quantity");
    private final int TIMEOUT_PANIER_BUTTON = 3000;
    //private final String QUANTITY = "2";

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_PANIER_BUTTON));
    }

    public void selectQuantity(String quantity){
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(quantitySelector));
        Select categoriesSelect = new Select(dropdown);
        categoriesSelect.selectByValue(quantity);
    }

    public WebElement getFirsProductName(){
        WebElement sousTotal = driver.findElement(By.cssSelector("span#sc-subtotal-label-activecart"));
        return sousTotal;
    }

    public List getInformations(){
        List<WebElement> informations = driver.findElements(By.cssSelector(".sc-product-variation .a-text-bold + span"));//list li
        WebElement taille        = informations.get(0);
        WebElement couleur       = informations.get(1);
        WebElement configuration = informations.get(2);
        return informations;
    }
}
