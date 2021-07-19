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
protected final Log log= LogFactory.getLog(getClass());
protected BasePage(WebDriver driver){
    this.driver = driver;
}
    public By getBy(String locator) {
        return By.xpath(locator);
    }

    public By getBy(String locator, String... dynamicValues){
        return By.xpath(String.format(locator, (Object[]) dynamicValues));
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void clickToElement(By locator) {
        getElement(locator).click();
    }

    public void sendKeyToElement(By locator, String value) {
        getElement(locator).clear();
        getElement(locator).sendKeys(value);
    }

    public void pressKeyToElement(By Locator, String key) {
        action = new Actions(driver);
        action.sendKeys(getElement(Locator), key).perform();
    }

    public void sendKeys(String value) {
        action = new Actions(driver);
        action.sendKeys(value).perform();
    }

    public void sendKeyToElementByJS(By locator, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public void openPageUrl(String Url) {
        driver.get(Url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectDropdownByText(By locator, String itemText) {
        select = new Select(getElement(locator));
        select.selectByVisibleText(itemText);
    }

    public String getSelectedItemDropdown(By locator) {
        select = new Select(getElement(locator));
        return select.getFirstSelectedOption().getText();
    }

    public void backToPreviousPage() {
        driver.navigate().back();
    }

    public void forwardToNextPage() {
        driver.navigate().forward();
    }

    public void refreshCurrentPage() {
        driver.navigate().refresh();
    }

    public void selectItemInCustomDropdown(By parentLocator, By childItemLocator, String expectedItem) {
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

    public void selectItemsInCustomDropdown(By parentLocator, By childItemLocator, List<String> expectedItems) {
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

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driverWait -> {
            assert driverWait != null;
            return ((JavascriptExecutor) driverWait).executeScript("return document.readyState").toString().equalsIgnoreCase("complete");
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

    public String getElementText(By locator) {
        return getElement(locator).getText();
    }

    public void checkToCheckBoxOrRadio(By locator) {
        if (!getElement(locator).isSelected()) {
            getElement(locator).click();
        }
    }

    public void uncheckToCheckBox(By locator) {
        if (isElementSelected(locator)) {
            getElement(locator).click();
        }
    }

    public boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    public boolean isElementDisplayed(By locator) {
        try{
            return getElement(locator).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    public WebDriver switchToIframeByElement(By locator) {
        return driver.switchTo().frame(getElement(locator));
    }

    public WebDriver switchToDefaultContent() {
        return driver.switchTo().defaultContent();

    }

    public void scrollToBottomPage() {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void waitForElementVisible(By locator) {
        explicitWait = new WebDriverWait(driver, timeOutInSecond);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

     public void waitForAllElementsVisible(By locator) {
        explicitWait = new WebDriverWait(driver, timeOutInSecond);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForElementClickable(By locator) {
        explicitWait = new WebDriverWait(driver, timeOutInSecond);
        explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickToElementByJS(By locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
    }



    private WebDriverWait explicitWait;
    private long timeOutInSecond = GlobalConstants.LONG_TIME_OUT;
    private Select select;
    private JavascriptExecutor jsExecutor;
    private Actions action;

}
