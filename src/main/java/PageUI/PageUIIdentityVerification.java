package PageUI;

import org.openqa.selenium.By;

public class PageUIIdentityVerification {

    public static final By GET_STARTED_BUTTON = By.xpath("//button[@type='button']");
    public static final By IDENTITY_METHOD_NOTIFICATION = By.xpath("//div[contains(text(),'Please be ready to provide the following documents')]");
    public static final By IDENTITY_GUIDANCE = By.xpath("//li[contains(text(),'The document must be valid & not expired')]");
    public static final By IDENTITY_VERIFICATION_HEADER = By.xpath("//span[contains(text(),'Verify your identity')]");
}
