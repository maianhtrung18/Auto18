package PageUI;

import org.openqa.selenium.By;

public class PageUIPersonalDetail {

    public static final By COMPANY_DROPDOWN_SELECTION_PARENT = By.xpath("//div[@placeholder='Select any of the following']");
    public static final By COMPANY_DROPDOWN_SELECTION_LIST = By.xpath("//div[@class='q-item__label']");
    public static final By OPTION_SELECTION_PARENT = By.xpath("//div[@placeholder='Select applicable options']");
    public static final By OPTION_SELECTION_LIST = By.xpath("//div[@class='q-item__label ellipsis']");
    public static final By CONTINUE_BUTTON = By.xpath("//span[text()='Continue']");
    public static final String REGISTRATION_METHOD_SELECTION = "//div[contains(text(),'%s')]/parent::div/parent::*/button";
    public static final By DATE_OF_BIRTH_TEXTBOX = By.xpath("//input[@placeholder='Set your date of birth']");
    public static final By NATIONALITY_DROPDOWN_PARENT = By.xpath("//div[@placeholder='Type to Search or Select Nationality']");
    public static final By NATIONALITY_DROPDOWN_LIST = By.xpath("//div[@class='q-item__label']");
    public static final By GENDER_DROPDOWN_PARENT = By.xpath("//input[@placeholder='Set your gender']");
    public static final By GENDER_DROPDOWN_LIST = By.xpath("//div[@class='q-item__label']");
    public static final By SUBMIT_BUTTON = By.xpath("//button[@type='button']");

    public static final By MONTH_SELECT_BUTTON = By.cssSelector("div.q-date__main>div div.col button");
    public static final By MONTH_VIEW = By.cssSelector("div.q-date__view");
    public static final By MONTH_SELECTION = By.cssSelector("span.block");

    public static final By YEAR_SELECT_BUTTON = By.cssSelector("div.q-date__main>div.col div.q-date__navigation div:nth-child(5) button");

    public static final By YEAR_PREVIOUS_ARROW = By.cssSelector("i.fa-chevron-left");
    public static final By YEAR_SELECTION = By.cssSelector("span.block");

    public static final By DATE_SELECTION = By.cssSelector("span.block");
    public static final By DATE_VIEW = By.cssSelector("div.q-date__calendar-days");
}
