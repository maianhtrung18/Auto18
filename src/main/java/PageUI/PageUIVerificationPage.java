package PageUI;

import org.openqa.selenium.By;

public class PageUIVerificationPage {

    public static final By OTP_TEXTBOX = By.xpath("//input[@inputmode='numeric']");
    public static final By RESEND_OTP_LINK = By.xpath("//span[text()='Resend OTP']");
    public static final By REGISTER_COMPLETED_MESSAGE = By.xpath("//p[contains(text(),'You have successfully verified your mobile number.')]");
    public static final By CONTINUE_BUTTON = By.xpath("//span[text()='Continue']");

}
