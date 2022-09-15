package amazon;

import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Amazon {

    public abstract HomePage acceptCookie();

    public abstract SearchResultPage searchWithButton(String keyword);

    public abstract SearchResultPage openProduct(Integer index);

    public abstract ProductPage openSearchResult();

    public abstract ProductPage addToCart();

    public abstract ProductPage refuseAppleCare();

    public abstract CartPage openCart();

    public abstract void selectQuantity(String quantity);

    public abstract WebElement getFirsProductName();

    public abstract List getInformations();


}
