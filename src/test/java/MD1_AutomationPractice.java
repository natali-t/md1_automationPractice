import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.logging.LogManager;
import java.lang.Thread;

public class MD1_AutomationPractice {
    //private final Logger LOGGER = (Logger) LogManager.getLogger(MD1_AutomationPractice.class);


    @Test
    public void md1AutomationPractice() {
        System.setProperty("webdriver.chrome.driver", "/Users/natali/Development/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //open page
        driver.get("http://automationpractice.com/index.php");
        //select "women"
        driver.findElement(By.xpath(".//a[@href='http://automationpractice.com/index.php?id_category=3&controller=category'][1]")).click();

        //select Dresses
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfAllElements());
        driver.findElement(By.id("layered_category_8")).click();
        //driver.findElement(By.xpath(".//li[@class='sfHoverForce']//a[@title='Dresses'][1]")).click();
        //driver.findElement(By.xpath(".//a[@class='sf-with-ul xh-highlight']")).click();

        //select orange in filter
        driver.findElement(By.id("layered_id_attribute_group_13")).click();

        //check if all items has orange - list?
        //loop iekš loop - turpat loop liek assert, vai ir orange
        //1 loop - atlasītie itemi, otrais loop krāsa un tur liek klāt assert
        //oranžo kvadrātu jābūt tik daudz, cik piedāvājumu// salīdzina piedāvājumu skaitu ar oranžo kvadrātu skaitu
        List<WebElement> orangeList = driver.findElements(By.xpath("//*[contains(@href, 'product#/size-s/color-orange')]"));
        for (int i = 0; i < orangeList.size(); i++) {
            String article = orangeList.get(i).getText();
            System.out.println(article);

        }


        //open one and check that it has orange - assertion not working
        driver.findElement(By.xpath("//*[contains(@href, 'product#/size-s/color-orange')][1]")).click();
        //String text = driver.findElement(By.xpath(".//span[contains(text(), 'Orange')]")).getText();
        //Assertions.assertEquals(text, "Orange", "Text is not equal");

        //Thread.sleep(5000);
        //WebDriverWait wait1 = new WebDriverWait(driver, 30); nav izsaukts wait

        //add 2 items to cart - peec 'data-id-product'?
        //kā pāriet uz pop up logu selenium, swithc to f-ja
        //driver.findElement(By.xpath(.//span[contains(text(), 'Add to cart')])).click();
        driver.findElement(By.xpath(".//a[@class='button ajax_add_to_cart_button btn btn-default'][1]")).click();
        driver.findElement(By.xpath(".//a[@class='button ajax_add_to_cart_button btn btn-default'][1]")).click();

        //get price for each item

        //click cart
        //assert that sum in cart is the same as saved







        driver.quit();
    }


    //driver.quit();
}
