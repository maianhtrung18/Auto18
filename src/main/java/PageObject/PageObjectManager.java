package PageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public static PageObjectBusinessDetail businessDetail;
    public static PageObjectBusinessRole businessRole;
    public static PageObjectIdentityVerification identityVerification;
    public static PageObjectLoginPage loginPage;
    public static PageObjectVerificationPage mobileVerification;
    public static PageObjectOnboardingPage onboardingPage;
    public static PageObjectPersonalDetail personalDetail;
    public static PageObjectRegisterPage registerPage;


    public static PageObjectBusinessDetail getBusinessDetail(WebDriver driver){
        if (businessDetail==null) {
            businessDetail = new PageObjectBusinessDetail(driver);
        }
        return businessDetail;
    }

    public static PageObjectBusinessRole getBusinessRole(WebDriver driver){
        if (businessRole==null) {
            businessRole = new PageObjectBusinessRole(driver);
        }
        return businessRole;
    }


    public static PageObjectIdentityVerification getIdentityVerification(WebDriver driver){
        if (identityVerification==null) {
            identityVerification = new PageObjectIdentityVerification(driver);
        }
        return identityVerification;
    }

    public static PageObjectLoginPage getLoginPage(WebDriver driver){
        if (loginPage==null) {
            loginPage = new PageObjectLoginPage(driver);
        }
        return loginPage;
    }

    public static PageObjectVerificationPage getMobileVerification(WebDriver driver){
        if (mobileVerification==null) {
            mobileVerification = new PageObjectVerificationPage(driver);
        }
        return mobileVerification;
    }

    public static PageObjectOnboardingPage getObjectOnboardingPage(WebDriver driver){
        if (onboardingPage ==null) {
            onboardingPage = new PageObjectOnboardingPage(driver);
        }
        return onboardingPage;
    }

    public static PageObjectPersonalDetail getPersonalDetail(WebDriver driver){
        if (personalDetail ==null) {
            personalDetail = new PageObjectPersonalDetail(driver);
        }
        return personalDetail;
    }

    public static PageObjectRegisterPage getRegisterPage(WebDriver driver){
        if (registerPage ==null) {
            registerPage = new PageObjectRegisterPage(driver);
        }
        return registerPage;
    }
}
