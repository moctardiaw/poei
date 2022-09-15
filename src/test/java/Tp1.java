
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Tp1 {

    public void sleeping(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

   // @Test
    public void test1(){
        System.out.println("Test Moctar");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Title : "+title);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        /*
        try{
        Thread.sleep(3000);
        }catch (InterruptedException e){

        }

         */

        //div id = L2AGLb

        WebElement e = driver. findElement(By.id("L2AGLb"));// //input[@id='twotabsearchtextbox']
        e.click();

        driver.quit();
    }

   // @Test
    public void test2(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        //driver.manage().window().maximize();

        //id sp-cc-accept

        WebElement e = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        e.sendKeys("moctar");

        driver.quit();
    }
/*TP amazon*/
   // @Test
    public void test3(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
        //WebElement c = driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        WebElement c = driver.findElement(By.xpath("//div[@class='sp-cc-buttons']/span/span/input")); //xpath plus lent que cssSelector
        //xpath attend que tout le DOM se charge pour executer la requete donc il arrive à trouver les élements
        //cssSelector a un problème de synchronisation (sans sleep) => ImplicitWait
        c.click();
        sleeping();

        //WebElement r = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        WebElement r = driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")); // //div[@class='nav-fill']/div/input
        r.sendKeys("coque iphone 13");
       // WebElement n = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));

        WebElement n = driver.findElement(By.xpath("//div[@class='nav-right']/div/span/input"));  // div[@class='nav-right']/div/span/input
        n.click();
        sleeping();

        WebElement f = driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']/img"));
        f.click();
        sleeping();

        //   //div[@class='nav-right']/div/span/input


        WebElement p = driver.findElement(By.xpath("//div[@class='a-button-stack']/span/span/span/input"));
        p.click();
        sleeping();

        WebElement a = driver.findElement(By.xpath("//a[@class='nav-a nav-a-2 nav-progressive-attribute']"));
        a.click();
        sleeping();

        driver.quit();
    }

   // @Test
    public void testCss() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");

        final int IMPLICIT_TIMEOUT = 10;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));

/*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
*/
        WebElement buttonCookie = driver.findElement(By.cssSelector("[data-cel-widget=sp-cc-accept]"));
        buttonCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Coque iphone 13");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement premierResultat = driver.findElement(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]"));
        premierResultat.click();

        WebElement ajouterAuPanierButton = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        ajouterAuPanierButton.click();

        WebElement panierButton = driver.findElement(By.cssSelector(".nav-cart-icon"));
        panierButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    WebDriver driver;
    //@BeforeMethod
    public void setup(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
    }
    //@AfterMethod
    public void tearDown(){
        driver.quit();
    }
    //@Test
    public void testCss2() {

/*
        final int IMPLICIT_TIMEOUT = 10;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));
*/
       // setup();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
/*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
*/
        /*
        WebElement buttonCookie = driver.findElement(By.cssSelector("[data-cel-widget=sp-cc-accept]"));
        buttonCookie.click();
        */
        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Coque iphone 13");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();
/*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
*/
        WebElement premierResultat = driver.findElement(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]"));
        premierResultat.click();

       // WebElement premierResultat = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]")));
        //premierResultat.click();

        WebElement ajouterAuPanierButton = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        ajouterAuPanierButton.click();

        WebElement panierButton = driver.findElement(By.cssSelector("#nav-cart"));//By.id("nav-cart")
        panierButton.click();
/*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
*/
        //tearDown();

    }


}
