import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class SampleTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set path to chromedriver.exe if not already in system PATH
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Use modern headless mode
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        assertEquals("Google", title);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
