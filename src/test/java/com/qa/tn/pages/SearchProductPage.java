package com.qa.tn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {

	public WebDriver driver;

	@FindBy(linkText = "HP LP3065")
	private WebElement validProduct;

	@FindBy(xpath = "//p[contains(text(), 'There is no product that matches the search criteria.')]")
	private WebElement invalidProductWarningMessage;

	@FindBy(xpath = "//a[contains(text(), 'HP LP3065')]")
	private WebElement validProductLink;

	public SearchProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyDisplayStatusOfValidProduct() {
		boolean presenceOfValidProduct = validProduct.isDisplayed();
		return presenceOfValidProduct;
	}

	public boolean verifyDisplayStatusOfInvalidProduct() {
		boolean presenceOfInvalidProduct = invalidProductWarningMessage.isDisplayed();
		return presenceOfInvalidProduct;
	}

	public ValidProductPage clickOnValidProductLink() {
		validProductLink.click();
		return new ValidProductPage(driver);
	}

}
