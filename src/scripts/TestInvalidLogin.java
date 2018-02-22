package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest{
	@Test
	public void InvalidLogin() throws InterruptedException{
		LoginPage l=new LoginPage(driver);
		int rowCount = Lib.getRowCount("InvalidLogin");
		for (int i = 1; i <= rowCount; i++) 
		{
			String un = Lib.getCellValue("InvalidLogin", i, 0);
			String pwd = Lib.getCellValue("InvalidLogin", i, 1);
			l.setUsername(un);
			Thread.sleep(2000);
			l.setPassword(pwd);
			Thread.sleep(2000);
			l.clickLogin();
		}

	}
}
