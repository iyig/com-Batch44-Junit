package pratice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q1 {
static WebDriver driver;
@BeforeClass
    public static void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
@Before
public void testenonce(){
driver.get("http://www.bestbuy.com");
}



@Test
    public void titleTest(){
String title=driver.getTitle();
boolean içeriyorMu= title.contains("Best");
    Assert.assertTrue("Title Best kelimesi içermiyor", içeriyorMu);
}
@Test
    public void logoTest(){
WebElement helloHeading =driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
WebElement logo= driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));

boolean logoGorunuyorMu= logo.isDisplayed();
Assert.assertTrue(logo.isDisplayed());
}
@Test
    public void linkTest(){
WebElement uslink=driver.findElement(By.xpath("(//img[alt='United States'])[1]"));
WebElement mexicoLink= driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(uslink));
Assert.assertTrue(mexicoLink.isDisplayed());
}
@AfterClass
    public static void kapat(){
    driver.quit();
    }
}
