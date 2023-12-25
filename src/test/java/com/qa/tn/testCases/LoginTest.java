package com.qa.tn.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tn.TestBase.TestBase;
import com.qa.tn.pages.AccountPage;
import com.qa.tn.pages.HomePage;
import com.qa.tn.pages.LoginPage;
import com.qa.tn.testData.ExcelCode;
import com.qa.tn.utilities.Util;

public class LoginTest extends TestBase {

	public LoginTest() throws Exception {
		super();

	}

	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropdown();
		loginpage = homepage.selectLoginOption();
	}

	@Test(priority = 1, dataProvider = "TNLogin", dataProviderClass = ExcelCode.class)
	public void verifyLoginWithValidCredentials(String username, String password) {
		accountpage = loginpage.navigateToLoginPage(username, password);
		Assert.assertTrue(accountpage.getDisplayedStatusOfEditAccountInfo());
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		loginpage.navigateToLoginPage(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(dataProp.getProperty("emailPasswordNoMatchWarningMessage"),
				loginpage.retrieveEmailPasswordNoMatchWarningText());
	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailValidPassword() {
		loginpage.navigateToLoginPage(Util.emailWithDateTimeStamp(), prop.getProperty("validPassword"));
		Assert.assertEquals(dataProp.getProperty("emailPasswordNoMatchWarningMessage"),
				loginpage.retrieveEmailPasswordNoMatchWarningText());
	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailInvalidPassword() {
		loginpage.navigateToLoginPage(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(dataProp.getProperty("emailPasswordNoMatchWarningMessage"),
				loginpage.retrieveEmailPasswordNoMatchWarningText());
	}

	@Test(priority = 5)
	public void verifyLoginWithNoCredentials() {
		loginpage.clickOnLoginButton();
		Assert.assertEquals(dataProp.getProperty("emailPasswordNoMatchWarningMessage"),
				loginpage.retrieveEmailPasswordNoMatchWarningText());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
