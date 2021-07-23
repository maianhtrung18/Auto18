package PageObject;

import Commons.BasePage;
import PageUI.PageUILoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectLoginPage extends BasePage {
    public PageObjectLoginPage(WebDriver driver){
        super(driver);
    }



    public void clickToRegisterLink(){
        waitForElementClickable(PageUILoginPage.REGISTER_LINK);
        clickToElementByJS(PageUILoginPage.REGISTER_LINK);
    }

    public void waitElement(){
    waitForElement(PageUILoginPage.REGISTER_LINK);
    }
}
