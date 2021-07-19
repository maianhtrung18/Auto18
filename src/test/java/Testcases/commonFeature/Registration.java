package Testcases.commonFeature;

import Commons.BaseTest;
import Helper.CommonFunctions;
import PageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Registration extends BaseTest {

    @Test
    public void TC_01(){
        log.info("TC_01: Register to system");

        String fullName = "Mai Anh Trung";
        String email = CommonFunctions.getCurrentTime("yymmddhhmmss")+"anh.maitrung@gmail.com";
        String phone = CommonFunctions.getRandomInteger(8,10);
        String channel = "Google";
        String OTPNumber = "1234";

        PageObjectLoginPage loginPage = PageObjectManager.getLoginPage(driver);
        PageObjectRegisterPage registerPage = PageObjectManager.getRegisterPage(driver);
        PageObjectVerificationPage verificationPage = PageObjectManager.getMobileVerification(driver);

        log.info("TC_01 Step 1: Navigate to register page");
        loginPage.clickToRegisterLink();

        log.info("TC_01 Step 2: Input full name to full name text box");
        registerPage.inputText("full_name",fullName);

        log.info("TC_01 Step 3: Input email to email text box");
        registerPage.inputText("email", email);

        log.info("TC_01 Step 4: Input phone to phone text box");
        registerPage.inputText("phone", phone);

        log.info("TC_01 Step 5: Select information channel");
        registerPage.selectInformationChannel(channel);

        log.info("TC_01 Step 6: Check to term checkbox");
        registerPage.checkToTermCheckbox();

        log.info("TC_01 Step 7: Click to continue button");
        registerPage.clickToContinueButton();

        log.info("TC_01 Step 8: Input mobile OTP number");
        verificationPage.inputOTPNumber(OTPNumber);

        log.info("TC_01 Step 9: Verify the completed register page is displayed");
        Assert.assertTrue(verificationPage.isCompletedRegisterPageDisplayed());

    }
    @Test
    public void TC_02(){
        log.info("TC_02: Input personal detail");

        String OTPNumber = "1234";
        String businessRole = "I am a registered director of the company";
        String companyRegisterPlace = "Singapore";
        List<String> solutions = Arrays.asList("iste","harum");
        String registrationMethod = "Standard Registration";
        String nationality = "Angola";
        String gender = "Male";
        String dayOfBirth = "12";
        String monthOfBirth = "Jun";
        String yearOfBirth = "1951";

        PageObjectVerificationPage verificationPage = PageObjectManager.getMobileVerification(driver);
        PageObjectBusinessRole businessRolePage = PageObjectManager.getBusinessRole(driver);
        PageObjectPersonalDetail personalDetail = PageObjectManager.getPersonalDetail(driver);
        PageObjectBusinessDetail businessDetail = PageObjectManager.getBusinessDetail(driver);

        log.info("TC_02 Step 1: Click to Continue button to navigate to Business Role page");
        verificationPage.clickToContinueButton();

        log.info("TC_02 Step 2: Select business role");
        businessRolePage.selectTheBusinessRole(businessRole);

        log.info("TC_02 Step 3: Select company register place");
        personalDetail.selectCompanyRegisterPlace(companyRegisterPlace);

        log.info("TC_02 Step 4: Select solutions");
        personalDetail.selectSolutions(solutions);

        log.info("TC_02 Step 5: Click to continue button");
        personalDetail.clickToContinueButton();

        log.info("TC_02 Step 6: Select registration method");
        personalDetail.clickToSelectionMethodRegistration(registrationMethod);

        log.info("TC_02 Step 7: Input date of birth to the textbox field");
        personalDetail.inputDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);

        log.info("TC_02 Step 8: Select nationality in dropdown list");
        personalDetail.selectNationality(nationality);

        log.info("TC_02 Step 9: Select gender in dropdown list");
        personalDetail.selectGender(gender);

        log.info("TC_02 Step 10: Click to submit button");
        personalDetail.clickToSubmitButton();

        log.info("TC_02 Step 11: Input email OTP number to text box");
        verificationPage.inputOTPNumber(OTPNumber);

        log.info("TC_02 Step 12: Verify business detail page is displayed");
        Assert.assertTrue(businessDetail.isBusinessDetailPageDisplays());

    }

    @Test
    public void TC_03(){

        log.info("TC_03: Input business detail");

        String UENNumber = CommonFunctions.getRandomInteger(8,9) + CommonFunctions.getRandomString(1);
        String businessLegalName = "Bookstore";
        String entityCategory = "Limited companies";
        String entityType = "Limited partnership";
        String industry = "Manufacturing";
        String subIndustry = "Fresh Food";
        String businessActivity = "The application provide sale service about sport ticket for organizers.";
        String serviceDetail= "The high schools in the US organize the sport tournaments and use this application as the third party to sell tickets of these events for their students.";
        String companyWebsite ="http://www.google.com";
        String numberOfEmployee = "2-10";
        String annualTurnOver = "S$0 - S$50,000";

        PageObjectBusinessDetail businessDetail = PageObjectManager.getBusinessDetail(driver);
        PageObjectIdentityVerification identityVerification = PageObjectManager.getIdentityVerification(driver);

        log.info("TC_03 Step 1: Input business legal name");
        businessDetail.inputInfoToTextBox("Business legal name",businessLegalName);

        log.info("TC_03 Step 2: Input entity category");
        businessDetail.selectDropdownList("Entity category",entityCategory);

        log.info("TC_03 Step 3: Input entity type");
        businessDetail.selectDropdownList("Entity type",entityType);

        log.info("TC_03 Step 4: Input UEN number");
        businessDetail.inputInfoToTextBox("UEN",UENNumber);

        log.info("TC_03 Step 5: Input industry");
        businessDetail.selectDropdownList("Industry", industry);

        log.info("TC_03 Step 6: Input sub-industry");
        businessDetail.selectDropdownList("Sub-Industry",subIndustry);

        log.info("TC_03 Step 7: Click to continue button");
        businessDetail.clickToContinueButton();

        log.info("TC_03 Step 8: Input business activity");
        businessDetail.inputInfoToTextBox("Business activity",businessActivity);

        log.info("TC_03 Step 9: Input service detail");
        businessDetail.inputInfoToTextBox("Tell us a detailed",serviceDetail);

        log.info("TC_03 Step 10: Input company website");
        businessDetail.inputInfoToTextBox("Live business website",companyWebsite);

        log.info("TC_03 Step 11: Input number of employees");
        businessDetail.selectDropdownList("Number of employees",numberOfEmployee);

        log.info("TC_03 Step 12: Input Annual turnover");
        businessDetail.selectDropdownList("Annual turnover",annualTurnOver);

        log.info("TC_03 Step 13: Click to continue button");
        businessDetail.clickToContinueButton();

        log.info("TC_03 Step 14: Answer the first question");
        businessDetail.checkToRadioButton("close family member or close associate of a PEP", "Yes");

        log.info("TC_03 Step 15: Answer the second question");
        businessDetail.checkToRadioButton(" have corporate shareholders with more than 10% ordinary shares","Yes");

        log.info("TC_03 Step 16: Click to continue button");
        businessDetail.clickToContinueButton();

        log.info("TC_03 Step 17: Skip uploading certificate");
        businessDetail.clickSkippedUploadingCertificateLink();

        log.info("TC_03 Step 18: Click start identity button");
        identityVerification.clickStartButton();

        log.info("TC_03 Step 19: Click begin button");
        identityVerification.clickBeginButton();

        log.info("TC_03 Step 20: Verify identity verification page is displayed");

    }
}
