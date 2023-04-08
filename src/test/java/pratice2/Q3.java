package pratice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.image.Kernel;
import java.time.Duration;

public class Q3 {


    public static void main(String[] args) {
     /*
     arama cubuguna oppa yazip enter deyiniz
     sonuc sayisini yazdiriniz
     çıkan ilk urune tıklayınız
     sepete ekleyiniz
     sepetime git tiklayınız
     consol da "siparis Özeti" webelemntinin text ini yazdırınız
     alışverisi tamamlayınız
     son olarak da "Teknosaya hoş geldiniz "webelementinin text ini yazdiriniz
     driver kapatınız
      */
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.teknosa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().deleteCookie();
        ChromeOptions op =new ChromeOptions();
        op.addArguments("--disable-notifications");

        driver.findElement(By.id("search-input")).sendKeys("oppo" + Keys.ENTER);
        System.out.println("sonuc yazisi: " + driver.findElement(By.className("plp-info")).getText());
        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();


        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,200)");


        driver.findElement(By.id("addToCartButton")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();
        System.out.println("siparis özeti yazisi:" + driver.findElement(By.className("cart-sum-title")).getText());
        driver.findElement(By.xpath("//a[@title= 'Alışverişi Tamamla']")).click();
        System.out.println("hosgeldiniz yazısı:" +driver.findElement(By.xpath("//div[.='Teknosa'ya hoş geldiniz']")).getText());
  driver.close();
    }
}
