import amazon.CartPage;
import amazon.HomePage;
import amazon.ProductPage;
import amazon.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpPageObject {

    WebDriver driver;
    String URL="https://www.amazon.fr/";
    String KEYWORD = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
    Integer INDEX=1;
    String QUANTITY="2";

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }

    @Test
    public void testPO() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();
        homePage.searchWithButton(KEYWORD);

        SearchResultPage searchResultPage  = new SearchResultPage(driver);
        searchResultPage.openProduct(INDEX);
        searchResultPage.openSearchResult(INDEX);

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.refuseAppleCare();
        productPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.selectQuantity(QUANTITY);
        System.out.println(cartPage.getFirsProductName());
        System.out.println("*********************OH_bad_master_do*****************");
        System.out.println(cartPage.getInformations());
    }

    /**
     * amazon.HomePage [acceptCookie]
     *          [searchWithButton]
     *                            -> amazon.SearchResultPage [openProduct] -> amazon.ProductPage -> amazon.CartPage
     */
    @Test
    public void testPO1() {
        HomePage homePage = new HomePage(driver);

        homePage.acceptCookie()
                .searchWithButton(KEYWORD)
                .openProduct(INDEX).openSearchResult(INDEX)
                .addToCart().refuseAppleCare().openCart()
                .selectQuantity(QUANTITY);
       sleeping(3000);
    }

    @Test
    public void testPO2(){

        /**
         * Hover rm -rf : remove recursive force
         */
        HomePage homePage = new HomePage(driver);

        WebElement loginButton = driver.findElement((By.cssSelector("#nav-link-accountList")));
        Actions actions = new Actions(driver);

        actions.moveToElement(loginButton);
        actions.perform();
        sleeping(3000);

    }//action stimuler souris

    public void sleeping(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}