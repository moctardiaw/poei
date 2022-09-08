import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TP2 {

    WebDriver driver;
    WebDriverWait wait;
    final String URL="https://www.amazon.fr";
    final Integer DURATION_WAIT=5;
    final String BUTTON_COOK="sp-cc-accept";
    final String BUTTON_TOUTES="nav-hamburger-menu";
    final String MENU_MEILLEURS_VENTES="ul.hmenu-visible > li > a.hmenu-item";
    final String LIST_PRODUCT="div.zg-carousel-general-faceout > div > a.a-link-normal";
    final String NAV_LOGO ="nav-logo";
    final String BARRE_RECHERCHE ="twotabsearchtextbox";
    final String TOUTES_MENU ="nav-hamburger-menu";
    final String MEILLEURS_VENTES ="[data-csa-c-content-id=nav_cs_bestsellers]";
    final String AMAZON_BASICS ="[data-csa-c-slot-id=desktop-5] h2.as-title-block-left";

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        wait   = new WebDriverWait(driver, Duration.ofSeconds(DURATION_WAIT));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testFlow(){
        /*Click Cookie Button*/
        WebElement buttonCookie   = wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_COOK)));
        buttonCookie.click();
        sleeping(1000);
        /*Click Toutes Button*/
        WebElement buttonToutes   = wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_TOUTES)));
        buttonToutes.click();
        sleeping(1000);
        /*Click MeilleursVentes Menu*/
        List<WebElement> menuList    = driver.findElements(By.cssSelector(MENU_MEILLEURS_VENTES));//list li
        menuList.get(0).click();
        sleeping(1000);
        /*Click 3th product in Products List*/
        List<WebElement> productLists = driver.findElements(By.cssSelector(LIST_PRODUCT));//list a
        sleeping(3000);
        productLists.get(3).click();
        sleeping(1000);
    }
    @Test
    public void testAssert(){
        //ARRANGE :
        final String expectedToutes              = "Toutes";
        final String expectedAmazonBasics        = "Amazon Basics";

        final String expectedMessageToutes       = "Le menu n'est pas trouvé";
        final String expectedMessageAmazonBasics = "Le texte Amazon basic  n'est  pas trouvé";
        //ACT :
        WebElement logo            = driver.findElement(By.id(NAV_LOGO));
        WebElement barreRecherche  = driver.findElement(By.id(BARRE_RECHERCHE));
        WebElement toutesMenu      = driver.findElement(By.id(TOUTES_MENU));
        WebElement meilleursVentes = driver.findElement(By.cssSelector(MEILLEURS_VENTES));
        WebElement amazonBasics    = driver.findElement(By.cssSelector(AMAZON_BASICS));
        //ASSERT :
        Assert.assertTrue(logo.isDisplayed());//for bool
        Assert.assertTrue(barreRecherche.isDisplayed());//for bool
        Assert.assertEquals(toutesMenu.getText(),expectedToutes,expectedMessageToutes);//for string
        Assert.assertTrue(meilleursVentes.isDisplayed());//for bool
        //Assert.assertEquals(amazonBasics.getText(),expectedAmazonBasics,expectedMessageAmazonBasics);//for string
    }
    @Test
    public void testSelect() {
        WebElement dropdown = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select categoriesSelect = new Select(dropdown);

        categoriesSelect.selectByIndex(4);
        sleeping(1000);
        categoriesSelect.selectByValue("search-alias=baby");
        sleeping(1000);
        categoriesSelect.selectByVisibleText("Informatique");
        sleeping(1000);
    }

    public void sleeping(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
