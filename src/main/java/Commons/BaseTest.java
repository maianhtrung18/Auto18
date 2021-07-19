package Commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected final Log log= LogFactory.getLog(getClass());
    protected BaseTest(){}

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeSuite
    public void initTest(@Optional String browser){
        openBrowser(browser,GlobalConstants.url);
    }

    public WebDriver openBrowser(String browser, String url){
        if (browser==null){
            browser = "";
        }

        if (browser.equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().arch64().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("CHROME")) {
            WebDriverManager.chromedriver().arch64().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("OPERA")) {
            WebDriverManager.operadriver().arch64().setup();
            driver = new OperaDriver();
        } else if (browser.equalsIgnoreCase("EDGE")) {
            WebDriverManager.edgedriver().arch64().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.chromedriver().arch64().setup();
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
