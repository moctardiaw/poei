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

/**
 * - Ouvrir https://amazon.fr/
 * - Fermer cookies
 * - Chercher: Apple iPhone 13 Pro Max (256 Go) - Vert Alpin
 * - Ouvrir premier resultat
 * - Ajouter au panier
 * - Selectionner Non, Merci pour l'apple care
 * - Ouvrir le panier
 * - Changer quantite a 2
 * - Verifier titre du produit: Apple iPhone 13 Pro Max (256 Go) - Vert Alpin
 * - Verifier sous total (2 articles)
 * - Verifier taille 256Go
 * - Verifier Couleur vert alpin
 * - Verifier configuration sans appleCare+
 *
 * Conditions:
 * - Utiliser Select
 * - AAA: Act, Arrange, Assert
 * Achat et vente en ligne parmi des millions de produits en stock. Livraison gratuite à partir de 25€. Vos articles à petits prix : culture, high-tech, mode, jouets, sport, maison et bien plus !
 */

public class TP3 {

    WebDriver driver;
    WebDriverWait wait;
    final String URL="https://www.amazon.fr";
    final Integer DURATION_WAIT=5;
    final String BUTTON_COOK   ="sp-cc-accept";
    final String SEARCH_BAR    ="[aria-label=Rechercher]";
    final String BUTTON_LOUPE  ="[type=submit]";
    final String FIRST_RESULT  ="[data-cel-widget=MAIN-SEARCH_RESULTS-2]";
    final String PANIER_BUTTON ="#add-to-cart-button";
    final String MERCI_BUTTON  ="span#attachSiNoCoverage";
    final String SEARCH_PRODUCT="Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";

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
    public void testScenario1(){
        //SELECTOR********************************************************************************************

        //1*****ARRANGE***************************************************************************************
        final String expectedTaille         = "256Go";
        final String expectedCouleur        = "Vert alpin";
        final String expectedConfiguration  = "Sans AppleCare+";

        //2******ACT******************************************************************************************
        sleeping(1000);
        /*Click Cookie Button*/
        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_COOK)));
        buttonCookie.click();
        sleeping(1000);
        /*Search product*/
        WebElement searchBar   = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys(SEARCH_PRODUCT);
        sleeping(1000);
        /*Click loupe button*/
        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();
        sleeping(1000);
        /*Click premier resultat*/
        WebElement premierResultat = driver.findElement(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]"));
        premierResultat.click();
        sleeping(1000);
        /*Click panier*/
        WebElement panierButton = driver.findElement(By.cssSelector("#add-to-cart-button"));
        panierButton.click();
        sleeping(5000);
        /*Click Nomerci*/
        WebElement nomerciButton = driver.findElement(By.cssSelector("span#attachSiNoCoverage"));
        nomerciButton.click();
        sleeping(5000);
        /*Open Panier*/
        WebElement ouvrirPanierButton = driver.findElement(By.cssSelector("span#attach-sidesheet-view-cart-button"));
        ouvrirPanierButton.click();
        sleeping(5000);
        /*Change quantite*/
        WebElement dropdown = driver.findElement(By.cssSelector("#quantity"));
        Select categoriesSelect = new Select(dropdown);
        categoriesSelect.selectByValue("2");
        sleeping(1000);
        /*Check sous-total*/
        WebElement sousTotal = driver.findElement(By.cssSelector("span#sc-subtotal-label-activecart"));
        /*Check information*/
        List<WebElement> informations = driver.findElements(By.cssSelector(".sc-product-variation .a-text-bold + span"));//list li
        WebElement taille        = informations.get(0);
        WebElement couleur       = informations.get(1);
        WebElement configuration = informations.get(2);
        //WebElement soustotale = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sc-subtotal-label-activecart")));
        //3****ASSERT******************************************************************************************************
        Assert.assertEquals(sousTotal.getText(),"Sous-total (2 articles):","Pas trouvé");//for string
        Assert.assertEquals(taille.getText(),expectedTaille,"La taille n'est pas correcte");
        Assert.assertEquals(couleur.getText(),expectedCouleur ,"La couleur n'est pas correcte");
        Assert.assertEquals(configuration.getText(),expectedConfiguration ,"La configuration n'est pas correcte");
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


