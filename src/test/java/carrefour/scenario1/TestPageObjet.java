package test.java.carrefour.scenario1;

import main.java.carrefour.HomePage;
import main.java.common.SetupTeardown;
import org.testng.annotations.Test;

public class TestPageObjet extends SetupTeardown {

    //Wait wait;

    @Test
    public void testScenario_1(){

        HomePage homePage = new HomePage(drivers);
        homePage.acceptCookie().goShopping();//.hoverMenuRayon().navMenuRayon().sportMenuRayon();//.bestSellerMenuRayon().seeProduct();
        //wait.sleeping(3000);
    }


}
