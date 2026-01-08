package steps;

import com.tau.Cucumber_AskOmDch.AccountPage;
import com.tau.Cucumber_AskOmDch.CartPage;
import com.tau.Cucumber_AskOmDch.HomePage;
import com.tau.Cucumber_AskOmDch.StorePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {

    public static WebDriver driver;
    public static HomePage homePage;
    public static AccountPage accountPage;
    public  static StorePage storePage;
    public  static CartPage cartPage;

    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "resources/chromedriver-win64/chromedriver.exe"
        );

        driver = new ChromeDriver();
        driver.manage().window();
        driver.get("https://askomdch.com");

        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        storePage = new StorePage(driver);
        cartPage = new CartPage(driver);

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
