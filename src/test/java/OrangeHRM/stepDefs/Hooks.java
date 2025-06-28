package OrangeHRM.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;

    @Before
    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Open Website URL and navigate to the Login pge
    }

    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(4000);
        if (driver != null) {
            driver.quit();
        }
    }
}