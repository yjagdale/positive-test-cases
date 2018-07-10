
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenBrowserTest {

    WebDriver browser;
    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        if(System.getenv("ON_GRID") != null) {
            browser = new RemoteWebDriver(new URL( System.getenv("HUB")+ "/wd/hub"), DesiredCapabilities.chrome());
        } else {
            browser = new ChromeDriver();
            ChromeDriverManager.getInstance().setup();
        }
    }

    @Test
    public void navigateToBrowser() throws InterruptedException {

        if(System.getenv("URL") != null) {
            browser.get(System.getenv("URL"));
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