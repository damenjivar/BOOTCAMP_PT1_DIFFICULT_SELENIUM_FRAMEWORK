package com.qa.tn.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tn.TestBase.TestBase;
import com.qa.tn.pages.HomePage;
import com.qa.tn.pages.SearchProductPage;
import com.qa.tn.pages.ShoppingCartPage;
import com.qa.tn.pages.ValidProductPage;

public class AddToCartTest extends TestBase {

	public AddToCartTest() throws Exception {
		super();

	}

	public WebDriver driver;
	public HomePage homepage;
	public SearchProductPage searchproductpage;
	public ValidProductPage validproductpage;
	public ShoppingCartPage shoppingcartpage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	}

	@Test(priority = 1)
	public void verifyAddValidProductToCart() {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(dataProp.getProperty("validProduct"));
		searchproductpage = homepage.clickOnSearchButton();
		validproductpage = searchproductpage.clickOnValidProductLink();
		validproductpage.clickOnAddToCartButton();
		Assert.assertTrue(validproductpage.retrieveValidProductAddedToCartSuccessMessageText()
				.contains(dataProp.getProperty("productAddedSuccessfullyToCartMessage")));
		validproductpage.clickOnShoppingCart();
		shoppingcartpage = validproductpage.clickOnViewCartLink();
		Assert.assertTrue(shoppingcartpage.verifyDisplayStatusOfValidProductInShoppingCart());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}