package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DataPickerTest {

@Test
    public void test(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://demoqa.com/data-picker");

    WebElement dateSelection=driver.findElement(By.id("datePickerMonthYearInput"));
    dateSelection.click();
WebElement monthElement=driver.findElement(By.className("react-datepicker__month-select"));
Select select=new Select(monthElement);
select.selectByVisibleText("December");


WebElement yearElement=driver.findElement(By.className("react-datepicker__year-select"));
select=new Select(yearElement);
select.selectByVisibleText("1995");

List<WebElement> daysElement=driver.findElements(By.cssSelector("div.react-datepicker__day"));

for(WebElement dayElement: daysElement){

    //System.out.println(dayElement.getText());


    String text= dayElement.getText();
    if(text.equals("19")){
        dayElement.click();
        break;

    }
}



}

private void selectDate(String year,String month, String day){
    /*
     WebElement dateSelection=driver.findElement(By.id("datePickerMonthYearInput"));
    dateSelection.click();
WebElement monthElement=driver.findElement(By.className("react-datepicker__month-select"));
Select select=new Select(monthElement);
select.selectByVisibleText("December");


WebElement yearElement=driver.findElement(By.className("react-datepicker__year-select"));
select=new Select(yearElement);
select.selectByVisibleText("1995");

List<WebElement> daysElement=driver.findElements(By.cssSelector("div.react-datepicker__day"));

for(WebElement dayElement: daysElement){

    //System.out.println(dayElement.getText());


    String text= dayElement.getText();
    if(text.equals("19")){
        dayElement.click();
        break;

    }
}


     */
}

}
