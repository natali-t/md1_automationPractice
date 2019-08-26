import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.logging.LogManager;

public class MD1_AutomationPractice {
    //private final Logger LOGGER = (Logger) LogManager.getLogger(MD1_AutomationPractice.class);


    @Test
    public void md1AutomationPractice() {
        System.setProperty("webdriver.chrome.driver", "/Users/natali/Development/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath(".//a[@href='http://automationpractice.com/index.php?id_category=3&controller=category'][1]")).click();

        //select Dresses - what to use here??? search frame? module? not correct current solution
        //driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfAllElements());
        driver.findElement(By.id("layered_category_8")).click();

        //select orange in filter
        driver.findElement(By.id("layered_id_attribute_group_13")).click();
            //sleep(7000); how to implement sleep??
            //Thread.sleep(5000);

        //check if all items has orange - list?
        List<WebElement> orangeList = driver.findElements(By.xpath("//*[contains(@href, 'product#/size-s/color-orange')]"));
        for (int i = 0; i < orangeList.size(); i++) {
            String article = orangeList.get(i).getText();
            System.out.println(article);

        }


        //open one and check that it has orange
        //add 2 items to cart
        //assert that sum is correct







        driver.quit();
    }


    //driver.quit();
}
