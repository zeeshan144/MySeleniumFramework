package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest {
	@Test
	public void testValidLogin() throws InterruptedException{

		LoginPage l=new LoginPage(driver);
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		l.setUsername(username);
		String password = Lib.getCellValue("ValidLogin", 1, 1);
        l.setPassword(password);
        l.clickLogin();
       // Thread.sleep(5000);
        
        WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
        
        
        String expectedTitle = Lib.getCellValue("ValidLogin", 1, 2);
        String actualTitle = driver.getTitle();
        SoftAssert s=new SoftAssert();
        s.assertEquals(expectedTitle, actualTitle);
        s.assertAll();
	}
	
}
