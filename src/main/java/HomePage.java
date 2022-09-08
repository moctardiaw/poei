import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private By acceptCookieSelector = By.cssSelector("[data-cel-widget=sp-cc-accept]");
    private By searchBarSelector = By.cssSelector("[aria-label=Rechercher]");

    private final int TIMEOUT_COOKIE = 1000;
    private final int TIMEOUT_SEARCH_BAR = 1000;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage acceptCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
        return this;
    }

    public SearchResultPage searchWithButton(String keyword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SEARCH_BAR));
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBarSelector));
        searchBar.sendKeys(keyword);
        return new SearchResultPage(driver);
    }


}