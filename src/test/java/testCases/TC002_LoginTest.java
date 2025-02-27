package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verify_login() 
	{
		logger.info("***** Stating TC002_LoginTest ****");
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macp=new MyAccountPage(driver);
		boolean targetPge=macp.isMyAccountPageExists();
		//Assert.assertEquals(targetPge, true,"Login Failed");
		Assert.assertTrue(targetPge);
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("***** Finished TC002_LogoutTest ****");
	}

}
