package main.java.carrefour;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingPage {

    private WebDriver driver;
    private final int TIMEOUT_COOKIE = 1000;

    private By hoverMenuSelector = By.xpath("//*[@id=\"data-rayons\"]/span[1]");

    private By navMenuSelector = By.cssSelector("#data-menu-level-0");

    private By sportMenuSelector = By.xpath("//*[@id=\"data-menu-level-0\"]/li[5]/a");

    private By bestSellerMenuSelector = By.xpath("//*[@id=\"data-menu-level-1_R26\"]/li[3]/a");

    public ShoppingPage (WebDriver driver){

        this.driver = driver;
    }

    public ShoppingPage hoverMenuRayon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement hoverMenuShopping = wait.until(ExpectedConditions.visibilityOfElementLocated(hoverMenuSelector));
        hoverMenuShopping.click();
        return this;
    }
    public ShoppingPage navMenuRayon(){

        //WebElement navMenu = driver.findElement((By.cssSelector("#data-menu-level-0")));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement navMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(navMenuSelector));

        Actions actions = new Actions(driver);

        actions.moveToElement(navMenu);
        actions.perform();

        return this;
    }

    public ShoppingPage sportMenuRayon(){

        //WebElement sportMenu = driver.findElement((By.xpath("//*[@id=\"data-menu-level-0\"]/li[5]/a")));


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement sportMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(sportMenuSelector));

        Actions actions1 = new Actions(driver);

        actions1.moveToElement(sportMenu);
        actions1.perform();

        return this;
    }
    public main.java.carrefour.BestSellerPage bestSellerMenuRayon() {

        //WebElement bestSellerMenu = driver.findElement((By.xpath("//*[@id=\"data-menu-level-1_R26\"]/li[3]/a")));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement bestSellerMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(bestSellerMenuSelector));

        Actions actions1 = new Actions(driver);

        actions1.moveToElement(bestSellerMenu);
        actions1.perform();

        bestSellerMenu.click();

        return new BestSellerPage(driver);
    }
}
