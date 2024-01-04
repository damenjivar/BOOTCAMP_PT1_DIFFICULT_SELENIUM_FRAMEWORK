package com.qa.tn.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tn.TestBase.TestBase;
import com.qa.tn.pages.HomePage;
import com.qa.tn.pages.SearchProductPage;
import com.qa.tn.pages.ValidProductPage;

public class SearchProductTest extends TestBase {

	public SearchProductTest() throws Exception {
		super();

	}

	public WebDriver driver;
	public HomePage homepage;
	public SearchProductPage searchproductpage;
	public ValidProductPage validproductpage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void verifyValidProductSearch() {
		homepage.enterProductDetail(dataProp.getProperty("validProduct"));
		searchproductpage = homepage.clickOnSearchButton();
		Assert.assertTrue(searchproductpage.verifyDisplayStatusOfValidProduct());
		validproductpage = searchproductpage.clickOnValidProductLink();
		
		Assert.assertTrue(validproductpage.verifyDisplayStatusOfValidProductDescription());
	}

	@Test(priority = 2)
	public void verifyInvalidProductSearch() {
		homepage.enterProductDetail(dataProp.getProperty("invalidProduct"));
		searchproductpage = homepage.clickOnSearchButton();
		Assert.assertTrue(searchproductpage.verifyDisplayStatusOfInvalidProduct());
	}

	@Test(priority = 3)
	public void verifyNoProductSearch() {
		searchproductpage = homepage.clickOnSearchButton();
		Assert.assertTrue(searchproductpage.verifyDisplayStatusOfInvalidProduct());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}