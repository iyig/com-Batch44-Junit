import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class BaseTest {

protected static WebDriver driver;
    static PraticeFormPage practiceFormPage;

    @BeforeClass
public  static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        System.out.println("Test initiated");
        practiceFormPage =new PraticeFormPage(driver);
}

@AfterClass
    public static void tearDown(){
   driver.quit();
    System.out.println("Test finished");
}
}




