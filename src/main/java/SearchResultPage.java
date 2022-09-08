import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By loupeButtonSelector = By.cssSelector("[type=submit]");
    private By premierResultatSelector = By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]");

    private final int TIMEOUT_PREMIER_RESULTAT = 3000;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_PREMIER_RESULTAT));
    }

    public SearchResultPage openProduct(Integer index) {
        WebElement loupeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loupeButtonSelector));
        loupeButton.click();
        return new SearchResultPage(driver);
    }

    public ProductPage openSearchResult(Integer index){
        WebElement premierResultat = wait.until(ExpectedConditions.visibilityOfElementLocated(premierResultatSelector));
        premierResultat.click();
        return new ProductPage(driver);
    }

}
