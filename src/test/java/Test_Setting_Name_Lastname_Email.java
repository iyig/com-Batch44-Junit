import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class Test_Setting_Name_Lastname_Email extends BaseTest{



    @Test
public  void setName(){
       practiceFormPage.setName("Ugur");
      Assert.assertEquals("Ugur",practiceFormPage.getName());



}
@Test
    public void setLastName(){
    practiceFormPage.setLastName("iyigunler");
    Assert.assertEquals("iyigunler",practiceFormPage.getLastname());
}
@Test
    public void setEmail(){
practiceFormPage.setMail("iyigunlerugur@gmail.com");
Assert.assertEquals("iyigunlerugur@gmail.com",practiceFormPage.getEmail());
}

}
