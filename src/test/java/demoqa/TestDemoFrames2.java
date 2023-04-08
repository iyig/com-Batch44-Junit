package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestDemoFrames2 {


    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/nestedframes");
Thread.sleep(5);

        WebElement adFrame=driver.findElement(By.cssSelector("iframe[title='3rd party ad content"));
        driver.switchTo().frame(adFrame);

        WebElement closeButton=driver.findElement(By.id("cbb"));
        driver.switchTo().frame(closeButton);
        closeButton.click();
    }


}
