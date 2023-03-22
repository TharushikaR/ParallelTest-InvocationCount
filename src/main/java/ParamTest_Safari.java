import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class ParamTest {

    WebDriver driver;

    @BeforeClass
    void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1)
    void testLogo() throws InterruptedException {
        try {
            Thread.sleep(5000);
            boolean status = driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed();
            Assert.assertEquals(status,true);
        }
        catch (Exception e){
            Thread.sleep(5000);
            Assert.fail();
        }
    }

    @Test(priority = 2)
    void testHomePageTitle() throws InterruptedException {
        try {
            Thread.sleep(5000);
            Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Both Titles are matched");
        }catch (Exception e){
            Thread.sleep(5000);
            Assert.fail();
        }
    }

    @AfterClass
    void closeApp(){
        driver.quit();
    }
}
