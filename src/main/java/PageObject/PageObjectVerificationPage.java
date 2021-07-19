package PageObject;

import Commons.BasePage;
import PageUI.PageUIVerificationPage;
import org.openqa.selenium.WebDriver;

public class PageObjectVerificationPage extends BasePage {
    protected PageObjectVerificationPage(WebDriver driver) {
        super(driver);
    }

    public void inputOTPNumber(String OTPNumber){
        waitForElementVisible(PageUIVerificationPage.RESEND_OTP_LINK);
        waitForPageLoaded();
        clickToElementByJS(PageUIVerificationPage.OTP_TEXTBOX);
        sendKeys(OTPNumber);
    }

    public boolean isCompletedRegisterPageDisplayed(){
        return isElementDisplayed(PageUIVerificationPage.REGISTER_COMPLETED_MESSAGE);
    }

    public void clickToContinueButton(){
        waitForElementClickable(PageUIVerificationPage.CONTINUE_BUTTON);
        clickToElement(PageUIVerificationPage.CONTINUE_BUTTON);
    }
}
