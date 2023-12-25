package com.qa.tn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(css = "input.form-control.input-lg")
	private WebElement searchTextboxField;

	@FindBy(css = "i.fa.fa-search")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnMyAccountDropdown() {
		myAccountDropdown.click();
	}

	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}

	public void enterProductDetail(String productNameText) {
		searchTextboxField.sendKeys(productNameText);
	}

	public SearchProductPage clickOnSearchButton() {
		searchButton.click();
		return new SearchProductPage(driver);
	}

}
