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
        log.info("Register to system");

        String fullName = "Mai Anh Trung";
        String email = CommonFunctions.getCurrentTime("yymmddhhmmss")+"anh.maitrung@gmail.com";
        String phone = CommonFunctions.getRandomInteger(8,10);
        String channel = "Google";
        String OTPNumber = "1234";
        String businessRole = "I am a registered director of the company";
        String companyRegisterPlace = "Singapore";
        List<String> solutions = Arrays.asList("iste","harum");
        String registrationMethod = "Standard Registration";
        String nationality = "Angola";
        String gender = "Male";
        String UENNumber = CommonFunctions.getRandomInteger(8,9) + CommonFunctions.getRandomString(1);
        String businessLegalName = "Bookstore";
        String entityCategory = "Limited companies";
        String entityType = "Limited partnership";
        String industry = "Manufacturing";
        String subIndustry = "Fresh Food";
        String businessActivity = "The application provide sale service about sport ticket for organizers. ";
        String serviceDetail= "The high schools in the US organize the sport tournaments and use this application as the third party to sell tickets of these events for their students.";
        String companyWebsite ="http://www.google.com";
        String numberOfEmployee = "2-10";
        String annualTurnOver = "S$0 - S$50,000";
        String dayOfBirth = "12";
        String monthOfBirth = "Jun";
        String yearOfBirth = "1951";

        PageObjectLoginPage loginPage = PageObjectManager.getLoginPage(driver);
        PageObjectRegisterPage registerPage = PageObjectManager.getRegisterPage(driver);
        PageObjectVerificationPage verificationPage = PageObjectManager.getMobileVerification(driver);
        PageObjectBusinessRole businessRolePage = PageObjectManager.getBusinessRole(driver);
        PageObjectPersonalDetail personalDetail = PageObjectManager.getPersonalDetail(driver);
        PageObjectBusinessDetail businessDetail = PageObjectManager.getBusinessDetail(driver);
        PageObjectIdentityVerification identityVerification = PageObjectManager.getIdentityVerification(driver);

        log.info("Navigate to register page");
        loginPage.clickToRegisterLink();

        log.info("Input fullname to full name textbox");
        registerPage.inputText("full_name",fullName);

        log.info("Input email to email textbox");
        registerPage.inputText("email", email);

        log.info("Input phone to phone textbox");
        registerPage.inputText("phone", phone);

        log.info("Select information channel");
        registerPage.selectInformationChannel(channel);

        log.info("Check to term checkbox");
        registerPage.checkToTermCheckbox();

        log.info("click to continue button");
        registerPage.clickToContinueButton();

        log.info("input mobile OTP number");
        verificationPage.inputOTPNumber(OTPNumber);

        log.info("Verify the completed register page is displayed");
        Assert.assertTrue(verificationPage.isCompletedRegisterPageDisplayed());

        log.info("Click to Continue button to navigate to Business Role page");
        verificationPage.clickToContinueButton();

        log.info("Select business role");
        businessRolePage.selectTheBusinessRole(businessRole);

        log.info("Select company register place");
        personalDetail.selectCompanyRegisterPlace(companyRegisterPlace);

        log.info("Select solutions");
        personalDetail.selectSolutions(solutions);

        log.info("Click to continue button");
        personalDetail.clickToContinueButton();

        log.info("Select registration method");
        personalDetail.clickToSelectionMethodRegistration(registrationMethod);

        log.info("Input date of birth to the textbox field");
        personalDetail.inputDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);

        log.info("Select nationality in dropdown list");
        personalDetail.selectNationality(nationality);

        log.info("Select gender in dropdown list");
        personalDetail.selectGender(gender);

        log.info("Click to submit button");
        personalDetail.clickToSubmitButton();

        log.info("Input email OTP number to text box");
        verificationPage.inputOTPNumber(OTPNumber);

        log.info("Input business legal name");
        businessDetail.inputInfoToTextBox("Business legal name",businessLegalName);

        log.info("Input entity category");
        businessDetail.selectDropdownList("Entity category",entityCategory);

        log.info("Input entity type");
        businessDetail.selectDropdownList("Entity type",entityType);

        log.info("Input UEN number");
        businessDetail.inputInfoToTextBox("UEN",UENNumber);

        log.info("Input industry");
        businessDetail.selectDropdownList("Industry", industry);

        log.info("Input sub-industry");
        businessDetail.selectDropdownList("Sub-Industry",subIndustry);

        log.info("Click to continue button");
        businessDetail.clickToContinueButton();

        log.info("Input business activity");
        businessDetail.inputInfoToTextBox("Business activity",businessActivity);

        log.info("Input service detail");
        businessDetail.inputInfoToTextBox("Tell us a detailed",serviceDetail);

        log.info("Input company website");
        businessDetail.inputInfoToTextBox("Live business website",companyWebsite);

        log.info("Input number of employees");
        businessDetail.selectDropdownList("Number of employees",numberOfEmployee);

        log.info("Input Annual turnover");
        businessDetail.selectDropdownList("Annual turnover",annualTurnOver);

        log.info("Click to continue button");
        businessDetail.clickToContinueButton();

        log.info("Answer the first question");
        businessDetail.checkToRadioButton("close family member or close associate of a PEP", "Yes");

        log.info("Answer the second question");
        businessDetail.checkToRadioButton(" have corporate shareholders with more than 10% ordinary shares","Yes");

        log.info("Click to continue button");
        businessDetail.clickToContinueButton();

        log.info("Skip uploading certificate");
        businessDetail.clickSkippedUploadingCertificateLink();

        log.info("Click start identity button");
        identityVerification.clickStartButton();

        log.info("Click begin button");
        identityVerification.clickBeginButton();



    }
}
