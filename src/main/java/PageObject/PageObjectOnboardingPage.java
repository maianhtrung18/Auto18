package PageObject;

import Commons.BasePage;
import PageUI.PageUIOnboardingPage;
import org.openqa.selenium.WebDriver;

public class PageObjectOnboardingPage extends BasePage {
    protected PageObjectOnboardingPage(WebDriver driver) {
        super(driver);
    }

    public void isOnboardingPageDisplayed(){
        try {
            isElementDisplayed(PageUIOnboardingPage.ONBOARDING_MESSAGE);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
