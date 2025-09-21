package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;

import cucumber.api.Scenario;

public class SearchEmployeePage {

	WebDriver driver;
	Scenario scenario;
	
	// page repository for search employee

	@FindBy(xpath = "//a[text()='Employee List']")
	WebElement empListPageLink;

	@FindBy(xpath = "//label[text()='Employee Name']/following::input[1]")
	WebElement searchByEmpNamefield;

	@FindBy(xpath = "//button[text()=' Search ']")
	WebElement empSearchButton;

	@FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/child::div[3]/child::div[1]")
	WebElement searchedEmpFandMname;
	
	public SearchEmployeePage(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToEmpListPage(){
		ElementActions.clickElement(driver, empListPageLink, scenario);
	}
	
	public  String searchEmp(String fName,String mName){
		
		ElementActions.sendKeys(driver, searchByEmpNamefield, scenario, fName+mName);
		ElementActions.clickElement(driver, empSearchButton, scenario);
		return ElementActions.getText(driver, searchedEmpFandMname, scenario);
	}

}
