package carrefour.scenario1;

import common.SetupTeardown;
import common.Wait;
import org.testng.annotations.Test;

public class TestPageObjet extends SetupTeardown {

    Wait wait;

    @Test
    public void testScenario_1(){

        carrefour.HomePage homePage = new carrefour.HomePage(driver);
        homePage.acceptCookie().goShopping();//.hoverMenuRayon().navMenuRayon().sportMenuRayon();//.bestSellerMenuRayon().seeProduct();
        wait.sleeping(3000);  
    }


}
