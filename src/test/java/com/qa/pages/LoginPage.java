package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;

import cucumber.api.Scenario;

/**
 * @author user this class included page factor code of the Login Page of Orange
 *         HRM application
 */
public class LoginPage {

	WebDriver driver;
	Scenario scenario;
	// Page Object Repository
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;

	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement loginButton;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement homepageTitle;

	// Page Class Constructor
	/**
	 * @param driver - to refer the Webdriver
	 * @param scenario
	 */
	public LoginPage(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
	}

	// Page Operation Methods
	/**
	 * @param userName - this is used to pass the text to the username field
	 * @param userPassword - this is used to pass the password to the password field
	 * @return
	 * 
	 * 		This method will login into the orangeHRM application and return the page title
	 * 
	 */
	public String logintoApplication(String userName, String userPassword) {

		ElementActions.sendKeys(driver, userNameField, scenario, userName);
		ElementActions.sendKeys(driver, passwordField, scenario, userPassword);
		ElementActions.clickElement(driver, loginButton, scenario);
		return ElementActions.getText(driver, homepageTitle, scenario);

	}

}
