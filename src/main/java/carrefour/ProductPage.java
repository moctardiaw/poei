package carrefour;

import org.openqa.selenium.WebDriver;

public class ProductPage {

    //  //*[@id="3663326022551"]/div[2]/div[1]/div[2]/div[2]/a

    private WebDriver driver;
    private final int TIMEOUT_COOKIE = 1000;

    public ProductPage (WebDriver driver){

        this.driver = driver;
    }
}
