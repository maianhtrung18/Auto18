package PageObject;

import Commons.BasePage;
import PageUI.PageUIPersonalDetail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectPersonalDetail extends BasePage {
    protected PageObjectPersonalDetail(WebDriver driver) {
        super(driver);
    }

    public void selectCompanyRegisterPlace(String company){
        waitForPageLoaded();
        selectItemInCustomDropdown(PageUIPersonalDetail.COMPANY_DROPDOWN_SELECTION_PARENT,PageUIPersonalDetail.COMPANY_DROPDOWN_SELECTION_LIST,company);

    }

    public void selectSolutions(List<String> solutions){
        waitForElementClickable(PageUIPersonalDetail.OPTION_SELECTION_PARENT);
        selectItemsInCustomDropdown(PageUIPersonalDetail.OPTION_SELECTION_PARENT,PageUIPersonalDetail.OPTION_SELECTION_LIST,solutions);
        clickToElementByJS(PageUIPersonalDetail.OPTION_SELECTION_PARENT);

    }

    public void clickToContinueButton(){
        waitForElementClickable(PageUIPersonalDetail.CONTINUE_BUTTON);
        clickToElementByJS(PageUIPersonalDetail.CONTINUE_BUTTON);
    }

    public void clickToSelectionMethodRegistration(String method){
        waitForElementClickable(getBy(PageUIPersonalDetail.REGISTRATION_METHOD_SELECTION,method));
        waitForPageLoaded();
        clickToElement(getBy(PageUIPersonalDetail.REGISTRATION_METHOD_SELECTION,method));
    }

    public void inputDateOfBirth(String day, String month, String year){
        waitForElementVisible(PageUIPersonalDetail.DATE_OF_BIRTH_TEXTBOX);
        clickToElement(PageUIPersonalDetail.DATE_OF_BIRTH_TEXTBOX);
        waitForElementVisible(PageUIPersonalDetail.MONTH_SELECT_BUTTON);
        selectYear(year);
        sleepInSecond(1);
        selectMonth(month);
        sleepInSecond(1);
        selectDay(day);


    }
    public void selectDay(String day){
        waitForElementVisible(PageUIPersonalDetail.DATE_VIEW);
        sleepInSecond(1);
        List<WebElement> dayElements = getElements(PageUIPersonalDetail.DATE_SELECTION);
        for(WebElement dayElement : dayElements){
            if(dayElement.getText().trim().equalsIgnoreCase(day)){
                dayElement.click();
                break;
            }

        }

    }

    public void selectMonth(String month){
        waitForElementVisible(PageUIPersonalDetail.MONTH_SELECT_BUTTON);
        clickToElement(PageUIPersonalDetail.MONTH_SELECT_BUTTON);
        waitForElementVisible(PageUIPersonalDetail.MONTH_VIEW);
        sleepInSecond(1);
        List<WebElement> monthElements = getElements(PageUIPersonalDetail.MONTH_SELECTION);
            for (WebElement monthElement : monthElements) {
                if (monthElement.getText().trim().equalsIgnoreCase(month)) {
                    monthElement.click();
                    break;
                }
            }

    }



    public void selectYear(String year){
        waitForElementVisible(PageUIPersonalDetail.YEAR_SELECT_BUTTON);
        clickToElement(PageUIPersonalDetail.YEAR_SELECT_BUTTON);
        waitForElementVisible(PageUIPersonalDetail.YEAR_PREVIOUS_ARROW);
        sleepInSecond(1);
        loop:
        for (int i=0;i<=5; i++) {
        List<WebElement> yearElements = getElements(PageUIPersonalDetail.YEAR_SELECTION);
            for(WebElement yearElement : yearElements){
                if(yearElement.getText().trim().equalsIgnoreCase(year)){
                    yearElement.click();
                    break loop;
                }
            }
            clickToElement(PageUIPersonalDetail.YEAR_PREVIOUS_ARROW);
        }
    }

    public void selectNationality(String nationality){
        waitForElementClickable(PageUIPersonalDetail.NATIONALITY_DROPDOWN_PARENT);
        waitForPageLoaded();
        selectItemInCustomDropdown(PageUIPersonalDetail.NATIONALITY_DROPDOWN_PARENT, PageUIPersonalDetail.NATIONALITY_DROPDOWN_LIST, nationality);

    }

    public void selectGender(String gender){
        waitForElementClickable(PageUIPersonalDetail.GENDER_DROPDOWN_PARENT);
        selectItemInCustomDropdown(PageUIPersonalDetail.GENDER_DROPDOWN_PARENT,PageUIPersonalDetail.GENDER_DROPDOWN_LIST, gender);
    }

    public void clickToSubmitButton(){
        waitForElementClickable(PageUIPersonalDetail.SUBMIT_BUTTON);
        clickToElement(PageUIPersonalDetail.SUBMIT_BUTTON);
    }



}
