package PageObject;

import Commons.BasePage;
import PageUI.PageUIBusinessDetail;
import org.openqa.selenium.WebDriver;

public class PageObjectBusinessDetail extends BasePage {
    public PageObjectBusinessDetail(WebDriver driver){
        super(driver);
    }

    public void inputInfoToTextBox(String textType, String businessLegalName){
        waitForElementVisible(getBy(PageUIBusinessDetail.INPUT_TEXTBOX,textType));
        waitForPageLoaded();
        sendKeyToElement(getBy(PageUIBusinessDetail.INPUT_TEXTBOX,textType),businessLegalName);
    }

    public void selectDropdownList(String dropDownType, String entityCategory){
        waitForElementClickable(getBy(PageUIBusinessDetail.INPUT_TEXTBOX,dropDownType));
        selectItemInCustomDropdown(getBy(PageUIBusinessDetail.INPUT_TEXTBOX,dropDownType),PageUIBusinessDetail.DROPDOWN_LIST,entityCategory);
    }

    public void clickToContinueButton(){
        waitForElementClickable(PageUIBusinessDetail.CONTINUE_BUTTON);
        clickToElement(PageUIBusinessDetail.CONTINUE_BUTTON);
    }

    public void checkToRadioButton(String question, String answer){
        waitForElementVisible(getBy(PageUIBusinessDetail.RADIO_BUTTON,question,answer));
        checkToCheckBoxOrRadio(getBy(PageUIBusinessDetail.RADIO_BUTTON,question,answer));
    }

    public void clickSkippedUploadingCertificateLink(){
        try {
            waitForElementVisible(PageUIBusinessDetail.SKIP_LINK);
            clickToElement(PageUIBusinessDetail.SKIP_LINK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
