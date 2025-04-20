import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

    @Test
    public void testGoogleSearch() {
        // ✅ Update the path to the actual location of your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");

        // Start the browser
        WebDriver driver = new ChromeDriver();
        
        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // ✅ Print title for debug
            String title = driver.getTitle();
            System.out.println("Page title is: " + title);

            // ✅ Simple assertion
            assert title.contains("Google");
        } finally {
            // ✅ Ensure the browser closes even if test fails
            driver.quit();
        }
    }
}
