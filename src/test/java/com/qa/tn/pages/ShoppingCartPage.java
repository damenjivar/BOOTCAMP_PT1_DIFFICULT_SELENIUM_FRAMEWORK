package com.qa.tn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	public WebDriver driver;

	@FindBy(xpath = "//td[@class = 'text-left']/following::a[contains(text(), 'HP LP3065')]")
	private WebElement validProductInShoppingCart;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyDisplayStatusOfValidProductInShoppingCart() {
		boolean presenceOfValidProductInShoppingCart = validProductInShoppingCart.isDisplayed();
		return presenceOfValidProductInShoppingCart;
	}
}
