package PageUI;

import org.openqa.selenium.By;

public class PageUIBusinessDetail {

    public static final By DROPDOWN_LIST = By.xpath("//div[@class='q-item__label']");
    public static final String INPUT_TEXTBOX = "//div[contains(text(),'%s')]/parent::div/following-sibling::label//input";
    public static final By CONTINUE_BUTTON = By.xpath("//button[@type='button']");
    public static final String RADIO_BUTTON = "//div[contains(text(),'%s')]/parent::div/following-sibling::div[1]//div[@role='radio']/div[text()='%s']/preceding-sibling::div";
    public static final By SKIP_LINK = By.xpath("//div[contains(text(),'Skip now, ask me later')]");
}
