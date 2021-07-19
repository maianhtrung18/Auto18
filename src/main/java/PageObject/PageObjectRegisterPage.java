package PageObject;

import Commons.BasePage;
import PageUI.PageUIRegisterPage;
import org.openqa.selenium.WebDriver;

public class PageObjectRegisterPage extends BasePage {
    protected PageObjectRegisterPage(WebDriver driver) {
        super(driver);
    }

    public void inputText(String textType ,String fullName){
        waitForElementVisible(getBy(PageUIRegisterPage.TEXT_INPUT,textType));
        waitForPageLoaded();
        sendKeyToElement(getBy(PageUIRegisterPage.TEXT_INPUT,textType),fullName);
    }

    public void selectInformationChannel(String channel){
        waitForElementClickable(PageUIRegisterPage.INFORMATION_CHANNEL_DROPDOWN_PARENT);
        selectItemInCustomDropdown(PageUIRegisterPage.INFORMATION_CHANNEL_DROPDOWN_PARENT,PageUIRegisterPage.INFORMATION_CHANNEL_DROPDOWN_CHILD, channel);
    }

    public void checkToTermCheckbox(){
        waitForElementClickable(PageUIRegisterPage.TERM_CHECKBOX);
        checkToCheckBoxOrRadio(PageUIRegisterPage.TERM_CHECKBOX);
    }

    public void clickToContinueButton(){
        waitForElementClickable(PageUIRegisterPage.CONTINUE_BUTTON);
        clickToElement(PageUIRegisterPage.CONTINUE_BUTTON);
    }



}
