package PageObject;

import Commons.BasePage;
import PageUI.PageUIBusinessRole;
import org.openqa.selenium.WebDriver;

public class PageObjectBusinessRole extends BasePage {
    protected PageObjectBusinessRole(WebDriver driver) {
        super(driver);
    }

    public void selectTheBusinessRole(String role){
        waitForElementClickable(getBy(PageUIBusinessRole.ROLE_SELECTION,role));
        waitForPageLoaded();
        clickToElementByJS(getBy(PageUIBusinessRole.ROLE_SELECTION,role));
    }
}
