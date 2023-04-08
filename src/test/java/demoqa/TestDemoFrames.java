package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.time.Duration;
import java.util.List;

public class TestDemoFrames {


@Test
    public void test() throws InterruptedException {

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://demoqa.com/frames");

    driver.switchTo().frame(0);

   // driver.switchTo().frame("iframe1");
    WebElement heading=driver.findElement(By.id("sampleHeading"));
    String text=heading.getText();
    System.out.println(text);
    Thread.sleep(5);
    driver.switchTo().parentFrame();
    List<WebElement> elementList=driver.findElements(By.cssSelector("div[id='framesWrapper'] div"));
    String paragraph=elementList.get(0).getText();
    System.out.println(paragraph);

    driver.switchTo().frame("frame2");
    WebElement heading2=driver.findElement(By.id("sampleHeading"));
    String text2=heading.getText();
    System.out.println(text2);
}



}
