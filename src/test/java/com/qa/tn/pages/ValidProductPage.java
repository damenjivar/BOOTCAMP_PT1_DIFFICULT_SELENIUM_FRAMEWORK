package com.qa.tn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidProductPage {

	public WebDriver driver;

	@FindBy(xpath = "//li[contains(text(), 'Product Code:Product 21')]")
	private WebElement validProductDescription;

	@FindBy(css = "button.btn.btn-primary.btn-lg.btn-block")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement validProductAddedToCartSuccessMessage;

	@FindBy(css = "button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")
	private WebElement shoppingCart;

	@FindBy(xpath = "//strong[text() = 'View Cart']")
	private WebElement viewCartLink;

	public ValidProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyDisplayStatusOfValidProductDescription() {
		boolean displayStatusOfValidProductDescription = validProductDescription.isDisplayed();
		return displayStatusOfValidProductDescription;
	}

	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}

	public String retrieveValidProductAddedToCartSuccessMessageText() {
		String validProductAddedToCartSuccessMessageText = validProductAddedToCartSuccessMessage.getText();
		return validProductAddedToCartSuccessMessageText;
	}

	public void clickOnShoppingCart() {
		shoppingCart.click();
	}

	public ShoppingCartPage clickOnViewCartLink() {
		viewCartLink.click();
		return new ShoppingCartPage(driver);
	}
}