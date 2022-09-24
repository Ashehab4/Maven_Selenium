package TMKN.Tamkeen;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class SimpliLearnLogin extends BaseClass {
    
    
    @Test (enabled = true)
    public void Test1() throws InterruptedException {
    	test.log(LogStatus.INFO, "Test 1 has started");
    	Thread.sleep(4000);
        // Step1. Click  on the Login Link
        LoginPage lp = new LoginPage(driver);
        lp.login("test@test.com", "Test@123");
        
        //Step6: Validate the error message on screen
        WebElement Error = driver.findElement(By.id("msg_box"));
        
        String ActError = Error.getText();
        String ExpError = "The email or password you have entered is invalid.";
        
        // Assert Displayed message
        Assert.assertEquals(ActError, ExpError);
  
        
    }
    @Test(enabled = true)
    @Parameters({"Uname","pwd"})
    public void login2(String UserName,String Pssw) throws InterruptedException {
    	test.log(LogStatus.INFO, "Test 2 has started");
    	Thread.sleep(4000);
    	LoginPage lp = new LoginPage(driver);
        lp.login(UserName, Pssw);
    }
    
    
    @Test(enabled = true)
    public void test3() throws InterruptedException {
    	
    	test.log(LogStatus.INFO, "Test 3 has started");
    	String UsName =  sheet.getRow(1).getCell(0).getStringCellValue();
        String Passwrd = sheet.getRow(1).getCell(1).getStringCellValue();
    	Thread.sleep(4000);
    	LoginPage lp = new LoginPage(driver);
    	lp.login(UsName, Passwrd);
    	
    	
    	
    }
}
