
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenBrowserTest {

    WebDriver browser;
    String URL = "https://mail.google.com/"; //System.getenv("URL");
    String HUB  = "http://10.67.141.213"; //System.getenv("HUB");
    String ON_GRID = "true";// System.getenv("ON_GRID");


    @BeforeTest
    public void beforeTest() throws MalformedURLException {

        System.out.println("HUB:-" + HUB);
        System.out.println("ON_GRID:-" + ON_GRID);
        System.out.println("URL:-" + URL);
        if(ON_GRID != null) {
            browser = new RemoteWebDriver(new URL( HUB+ "/wd/hub"), new ChromeOptions());
        } else {
            browser = new ChromeDriver();
            ChromeDriverManager.getInstance().setup();
        }
    }

    @Test
    public void navigateToBrowser() throws InterruptedException {
        Thread.sleep(5000);
        if(URL != null) {
            browser.get(URL);
        } else {
            System.out.println("URL is null");
            Thread.sleep(3000);
        }
    }

    @AfterTest
    public void tearDown() {
        browser.quit();
    }
}
