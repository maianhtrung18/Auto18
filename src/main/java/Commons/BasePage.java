package Commons;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

protected WebDriver driver;
protected final Log log = LogFactory.getLog(getClass());
protected BasePage(WebDriver driver){
    this.driver = driver;

}
    protected By getBy(String locator) {
        return By.xpath(locator);
    }

    protected By getBy(String locator, String... dynamicValues){
        return By.xpath(String.format(locator, (Object[]) dynamicValues));
    }

    protected WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    protected void clickToElement(By locator) {
        getElement(locator).click();
    }

    protected void sendKeyToElement(By locator, String value) {
        getElement(locator).clear();
        getElement(locator).sendKeys(value);
    }

    protected void pressKeyToElement(By Locator, String key) {
        action = new Actions(driver);
        action.sendKeys(getElement(Locator), key).perform();
    }

    protected void sendKeys(String value) {
        action = new Actions(driver);
        action.sendKeys(value).perform();
    }

    protected void sendKeyToElementByJS(By locator, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    protected String getPageUrl(){
        return driver.getCurrentUrl();
    }

    protected void openPageUrl(String Url) {
        driver.get(Url);
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    protected void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void selectDropdownByText(By locator, String itemText) {
        select = new Select(getElement(locator));
        select.selectByVisibleText(itemText);
    }

    protected String getSelectedItemDropdown(By locator) {
        select = new Select(getElement(locator));
        return select.getFirstSelectedOption().getText();
    }

    protected void backToPreviousPage() {
        driver.navigate().back();
    }

    protected void forwardToNextPage() {
        driver.navigate().forward();
    }

    protected void refreshCurrentPage() {
        driver.navigate().refresh();
    }

    protected void selectItemInCustomDropdown(By parentLocator, By childItemLocator, String expectedItem) {
        getElement(parentLocator).click();
        sleepInSecond(1);

        explicitWait = new WebDriverWait(driver, timeOutInSecond);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childItemLocator));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    protected void selectItemsInCustomDropdown(By parentLocator, By childItemLocator, List<String> expectedItems) {
        getElement(parentLocator).click();
        sleepInSecond(1);

        explicitWait = new WebDriverWait(driver, timeOutInSecond);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childItemLocator));
        for (String expectedItem:expectedItems) {
            for (WebElement item : allItems) {
                if (item.getText().trim().equals(expectedItem)) {
                    jsExecutor = (JavascriptExecutor) driver;
                    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                    sleepInSecond(1);
                    item.click();
                    sleepInSecond(1);
                    break;
                }
            }
        }
    }

    protected void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = webDriver -> {
            assert webDriver != null;
            return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().equalsIgnoreCase("complete");
        };
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
            wait.until(expectation);
        } catch (InterruptedException e) {
            log.error("Timeout waiting for Page Load Request to complete. {}" + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    protected String getElementText(By locator) {
        return getElement(locator).getText();
    }

    protected void checkToCheckBoxOrRadio(By locator) {
        if (!getElement(locator).isSelected()) {
            getElement(locator).click();
        }
    }

    protected void uncheckToCheckBox(By locator) {
        if (isElementSelected(locator)) {
            getElement(locator).click();
        }
    }

    protected boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    protected boolean isElementDisplayed(By locator) {
        try{
            return getElement(locator).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    protected boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    protected WebDriver switchToIframeByElement(By locator) {
        return driver.switchTo().frame(getElement(locator));
    }

    protected WebDriver switchToDefaultContent() {
        return driver.switchTo().defaultContent();

    }

    protected void scrollToBottomPage() {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    protected void waitForElementVisible(By locator) {
        explicitWait = new WebDriverWait(driver, timeOutInSecond);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

     protected void waitForAllElementsVisible(By locator) {
        explicitWait = new WebDriverWait(driver, timeOutInSecond);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementClickable(By locator) {
        explicitWait = new WebDriverWait(driver, timeOutInSecond);
        explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void clickToElementByJS(By locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
    }

    protected void waitForElement(By locator){
        explicitWait = new WebDriverWait(driver, timeOutInSecond);
        explicitWait.until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver webDriver) {
            log.info("Please be patience .... Searching ...");
            return webDriver.findElement(locator) != null;
        }
    });}



    private WebDriverWait explicitWait;
    private long timeOutInSecond = GlobalConstants.LONG_TIME_OUT;
    private Select select;
    private JavascriptExecutor jsExecutor;
    private Actions action;

}
