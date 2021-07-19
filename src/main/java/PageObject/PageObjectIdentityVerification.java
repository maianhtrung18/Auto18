package PageObject;

import Commons.BasePage;
import PageUI.PageUIIdentityVerification;
import org.openqa.selenium.WebDriver;

public class PageObjectIdentityVerification extends BasePage {
    protected PageObjectIdentityVerification(WebDriver driver) {
        super(driver);
    }

    public void clickStartButton(){
          waitForElementVisible(PageUIIdentityVerification.IDENTITY_METHOD_NOTIFICATION);
          waitForElementVisible(PageUIIdentityVerification.GET_STARTED_BUTTON);
          clickToElement(PageUIIdentityVerification.GET_STARTED_BUTTON);
    }

    public void clickBeginButton(){
        waitForElementVisible(PageUIIdentityVerification.IDENTITY_GUIDANCE);
        waitForElementVisible(PageUIIdentityVerification.GET_STARTED_BUTTON);
        clickToElementByJS(PageUIIdentityVerification.GET_STARTED_BUTTON);
    }

    public boolean isIdentityVerificationDisplayed(){
        return isElementDisplayed(PageUIIdentityVerification.IDENTITY_VERIFICATION_HEADER);
    }


}
