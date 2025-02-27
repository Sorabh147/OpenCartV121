package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() 
	{
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		try {
		HomePage hp=new HomePage(driver);
		logger.info("Clicked on MyAccount Link");
		hp.clickMyAccount();
		logger.info("Clicked on Register Link");
		hp.clickRegister();
			
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
			regpage.setfirstName(randomeString().toUpperCase());
			regpage.setlastName(randomeString().toUpperCase());
			regpage.setemail(randomeString()+"@gmail.com");
			regpage.setpassword(randomeAlphaNumberic());
			regpage.setSubscribe();
			regpage.setPrivacyPolicy();
			regpage.continueBtn();
		logger.info("Validating expected message");	
			String confmsg=regpage.getConfirmationMsg();
			
			if(confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}else {
				logger.error("Test Failed...");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			//Assert.assertEquals(confmsg, "Your Account Has Been Created!!");
		}catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
	
	
}
