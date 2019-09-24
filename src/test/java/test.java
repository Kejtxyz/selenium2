import com.sun.org.apache.xpath.internal.XPath;
import com.sun.org.apache.xpath.internal.objects.XNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
    @Test
    public void demoTest(){
      //  Setup
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.navigate().to("http://google.com");

        WebElement searchField = driver.findElement(By.cssSelector("[title='Szukaj']"));
        String searchEntry = "Email";
        String title = "Email";
        searchField.sendKeys(searchEntry);
        searchField.submit();

        driver.findElement(By.xpath("//*[text()='"+title+"']")).click();
        WebDriverWait wait= new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.titleIs(title));

        String entryURL = "https://wikipedia.org";
        Assertions.assertEquals(entryURL, driver.getCurrentUrl(), "url is not correct");
        driver.quit();
    }

    //TearDown
      //      driver.quit


    }


// https://www.youtube.com/watch?v=inb1BhdH_0c&list=PLZTxwbvLNhALIupUiUw5TfROPhmPXJbmP&index=2