package pratice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q2 {
// method: createButtons(100)
    //deleteButtonsAndValidate()
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();

    driver.get("htttp://the-internet.herokuapp.com/add_remove_elements/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    createButtons(driver,100);
    deleteButtonsAndValidate(driver,60);
}

    private static void createButtons(WebDriver driver, int eklenecekSayi) {
        WebElement addButton= driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int j = 0; j < eklenecekSayi; j++) {
            addButton.click();
        }
    }

    private static void deleteButtonsAndValidate(WebDriver driver, int number) {

List<WebElement> elements=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
 int sizebeforeDelete=elements.size();
        List<WebElement> buttonsDelete=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));

        int sayac=0;
        for (WebElement w :buttonsDelete){
            sayac ++;
            if(sayac>number){
                break;

            }
w.click();
        }
        List<WebElement> elementsAfter=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeafterDelete= elements.size();

        if((sizebeforeDelete-number)==sizeafterDelete){

        System.out.println("sizeafterDelete =" +sizeafterDelete);
        System.out.println("SUCCESS");
    }else{
            System.out.println("FAİL!");
        }

    }


}
