
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


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
        driver.findElement(By.xpath("//h5//a[contains(text(), 'Dresses')]")).click();

        //select orange in filter
        driver.findElement(By.id("layered_id_attribute_group_13")).click();


        //check if all items has orange


        //solution1
        //loop iekš loop - turpat loop liek assert, vai ir orange
        //1 loop - atlasītie itemi, otrais loop krāsa un tur liek klāt assert
        List<WebElement> orangeList = driver.findElements(By.xpath("//*[contains(@href, 'product#/size-s/color-orange')]"));
        for (int i = 0; i < orangeList.size(); i++) {
            String article = orangeList.get(i).getText();
//            System.out.println(orangeList);
        }

        for (int i = 0; i < orangeList.size(); i++) {
            String article = orangeList.get(i).getText();
            Assert.assertEquals(orangeList.size(), 2);
        }

        //nekompilējas
//        for (int i = 0; i < orangeList.size(); i++) {
//            String article = orangeList.get(i).getText();
//            for (int i = 0, i < orangeList.size(); i++) {
//                Assertions.assertTrue(orangeList.get(a).getText().contains("Orange"));
//            }
//        }

        //solution 2
        //oranžo kvadrātu jābūt tik daudz, cik piedāvājumu// salīdzina piedāvājumu skaitu ar oranžo kvadrātu skaitu
//        driver.findElement(By.cssSelector("@style='background: #F39C11'")).click();


        //open one and check that it has orange
        WebElement testElement = driver.findElement(By.xpath("//*[contains(@href, 'product#/size-s/color-orange')][1]"));
        driver.findElement(By.xpath(".//h5/a[@href='http://automationpractice.com/index.php?id_product=5&controller=product']")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.invisibilityOfAllElements());

        String text = driver.findElement(By.xpath(".//li/a[@title='Orange']")).getAttribute("title");

        //expected: <true> but was: <false>
        Assertions.assertTrue(text.contains("Orange"));

        //Assertions.assertEquals("background:#F39C11;", text, "Text is not equal");
        Assertions.assertEquals(text, "Orange", "Text is not equal");

        String parentWindow = driver.getWindowHandles().iterator().next();

        //add 2 items to cart
        driver.findElement(By.xpath("//li//a[@name='Orange']")).click();
        driver.findElement(By.xpath("//a//span//i[@class='icon-plus']")).click();
        driver.findElement(By.xpath("//div//p//button//span[contains(text(), 'Add to cart')]")).click();

        //switch to popup and close

        for (String childWindow : driver.getWindowHandles()) {
            driver.switchTo().window(childWindow);
            WebDriverWait wait3 = new WebDriverWait(driver, 10);
            wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@title='Close window']")));
            driver.findElement(By.xpath(".//span[@title='Close window']")).click();
        }

        driver.switchTo().window(parentWindow);
        //driver.switchTo().defaultContent(); is used to switch the control back from pop up to default content in the window.
        //driver.switchTo().parentFrame(); is generally used to switch the control back to the parent frame

        //get price for each item
        String originalPrice = driver.findElement(By.xpath("//p//span[@itemprop='price']")).getText().substring(1);
//        String originalPriceRemoveCurrencySymb = originalPrice.substring(1, originalPrice.length());
        double selectedPrice = Double.parseDouble(originalPrice);
        double doubledPrice = selectedPrice * 2;

        System.out.println(doubledPrice);

//        //click cart
        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();

        //assert that sum in cart is the same as saved
        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr//td[@id='total_product']")));
        String chartPrice = driver.findElement(By.xpath("//tr//td[@id='total_product']")).getText().substring(1);
        //String chartPriceRemoveCurrencySymb = chartPrice.substring(1, chartPrice.length());

        double chartPriceNumber = Double.parseDouble(chartPrice);
        System.out.println(chartPriceNumber);

        Assertions.assertEquals(doubledPrice, chartPriceNumber, "Chart amount differs");

        driver.quit();
    }


//    driver.quit();
}
