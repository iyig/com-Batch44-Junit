package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarTest {

@Test
    public void test(){

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://demoqa.com/progress-bar");

    WebElement startStopButton= driver.findElement(By.id("startStopButton"));
    startStopButton.click();

    WebElement progressBar= driver.findElement(By.cssSelector("div[role='progressbar']"));
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.pollingEvery(Duration.ofMillis(100));

    wait.until(ExpectedConditions.attributeToBe(By.cssSelector("button[class='mt-3 btn btn-primary']"),"id","resetButton"));






    //  wait.until(ExpectedConditions.attributeToBe(progressBar,"aria-valuenow","50"));
   // startStopButton.click();
}


}
