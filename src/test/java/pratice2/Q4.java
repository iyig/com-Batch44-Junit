package pratice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Q4 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test01() throws IOException {
        //https://www.amazon.com.tr sitesine gidelim
        driver.get("https://www.amazon.com");

        //Ana sayfanın açıldığını kontrol edin
        boolean sayfaTesti = driver.getTitle().contains("Amazon.com");
        Assert.assertTrue(sayfaTesti);


        //siteye login
        loginol(driver);
        //login işlemi kontrol edin

        mouseuSingInUsteneGit(driver);
        boolean loginOldukMu = driver.findElement(By.xpath("//span[text()='Sign Out']")).isDisplayed();
        Assert.assertTrue(loginOldukMu);
        WebElement LoginElementi = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

        webElementinScreenShotAl(LoginElementi);


        //arama butonun yanındaki kategörüler tabından bilgisayar secilir
        WebElement dropBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox'"));
        Select select = new Select(dropBox);
        select.selectByVisibleText("Computers");
        //WebElement aramaBox = driver.findElement(By.xpath("//input[@id='LoginElementi']"));

//bilgisayar kategorisi seçildiği kontrol edilir
        webElementinScreenShotAl(dropBox);

        //arama aranına msi yaz ve arama yapın

        WebElement aramaBox = driver.findElement(By.xpath("//input[@id='twoabsearchtextbox)']"));
        aramaBox.sendKeys("msi" + Keys.ENTER);
//aramanın yapıldıgını kontrol et
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-top-small"));
        boolean aramaKontrol = sonucYazisi.getText().contains("msi");
        Assert.assertTrue(aramaKontrol);


// arama sonucları sayfasından 2.sayfa açılır
        WebElement ikinciSayfa = driver.findElement(By.xpath("(//a[@class='s-pagination-item s-pagination-button'])[1]"));
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("arguments[0].scrollIntoView(true);", ikinciSayfa);
        ikinciSayfa.click();

        //2.sayfanın açıldığı kontrol edilir
        boolean ikinciSayfaKontrol = driver.getCurrentUrl().contains("page=2");
        Assert.assertTrue(ikinciSayfaKontrol);
//sayfadaki 2. ürün favorlere eklenir
        driver.findElement(By.xpath("(//img[@class='s-image])")).click();


        // 2.ürün favorilere eklendiği kontrol edilir

        WebElement addToList = driver.findElement(By.xpath("//input[@title='Add to List'"));
        jss.executeScript("arguments[0].scrollIntoView(true);", addToList);
        addToList.click();
        List<WebElement> listOlusturButonu = driver.findElements(By.xpath("(//input[@class='a-button-input a-declarative'])[3]"));
        if (!listOlusturButonu.isEmpty()) {
            driver.findElement(By.xpath("(//input[@class='a-button-input a-declarative'])[3]")).click();
            driver.findElement(By.xpath("(//button[@class='a-button-input a-declarative']")).click();
        }else {
            driver.findElement(By.xpath("(//button[@class='a-button-input a-declarative']"));
        }





    }




    private void webElementinScreenShotAl(WebElement loginOldukMu) throws IOException {
        File webElementScrenShot = new File("target/screenShot/webelement.jpg");

        File geciciResim = loginOldukMu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim, webElementScrenShot);

    }

    private void loginol(WebDriver driver) {

    mouseuSingInUsteneGit(driver);
    WebElement signIn=driver.findElement(By.xpath("(//span[text()='Sign in'])[1]"));
Actions actions=new Actions(driver);
actions.click(signIn).perform();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
        WebElement emailText=driver.findElement(By.xpath("//input[@name='email']"));
        actions.click(emailText).
                sendKeys("puturgeli1isi@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();
        WebElement pssText=driver.findElement(By.xpath("//input[@id='ap_password']"));
        actions.click(pssText).sendKeys("Aa115436--").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
}

    private void mouseuSingInUsteneGit(WebDriver driver) {
        WebElement mouseSinInUstunde=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(mouseSinInUstunde).perform();
    }


}
