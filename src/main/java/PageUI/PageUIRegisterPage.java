package PageUI;

import org.openqa.selenium.By;

public class PageUIRegisterPage {
    public static final String TEXT_INPUT = "//input[@name='%s']";
    public static final By INFORMATION_CHANNEL_DROPDOWN_PARENT = By.xpath("//input[@type='search']");
    public static final By INFORMATION_CHANNEL_DROPDOWN_CHILD = By.xpath("//div[@class='q-item__label']");
    public static final By TERM_CHECKBOX = By.xpath("//div[@role='checkbox']");
    public static final By CONTINUE_BUTTON = By.xpath("//button[@type='button']");


}
