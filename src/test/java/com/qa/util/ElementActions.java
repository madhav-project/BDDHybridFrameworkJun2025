package com.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;

/**
 * @author Madhav This class has the all selenium web element wait methods with
 *         wait machanism & handled by exception handeling
 *
 */
public class ElementActions {

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * @param texttoType
	 * 
	 *            this method will access the type and wait for fluent wait time
	 *            until element is clickable and then type text.
	 */
	public static void sendKeys(WebDriver driver, WebElement elem, Scenario scenario, String texttoType) {

		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for clicking on Emmenet ");
		}

		try {
			elem.sendKeys(texttoType);
		} catch (Exception E) {
			scenario.write(" Error on typeing the text in element after wating !");
		}

	}

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * @return this method will wait for fluent wait time and when web element
	 *         is visible get the text and return the value in string type
	 */
	public static String getText(WebDriver driver, WebElement elem, Scenario scenario) {

		String texttoReturn = null;
		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_VISIBLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for Element visibility  ");
		}
		try {
			texttoReturn = elem.getText();
		} catch (Exception E) {
			scenario.write(" Error on fetching  the text in element after wating !");
		}
		return texttoReturn;

	}

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * @param option
	 * 
	 *            This method will accept the option as parameter and select the
	 *            value from the dropdown, we are using selectByValue() method
	 *            under Select class
	 */
	public static void selectOptionFromDropDown(WebDriver driver, WebElement elem, Scenario scenario, String option) {

		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for Element to be clickable   ");
		}

		Select objselect = new Select(elem);

		try {
			objselect.selectByValue(option);
		} catch (Exception E) {
			scenario.write(" Error while selecting the option from Dropdown! ");

		}

	}

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * 
	 *            This method will wait for element to be clickable and click on
	 *            the element once it is loaded on the webpage
	 * 
	 */
	public static void clickElement(WebDriver driver, WebElement elem, Scenario scenario) {

		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for clicking on Emmenet ");
		}
		try {
			elem.click();
		} catch (Exception E) {
			scenario.write(" Error on clicking the element after wating !");
		}

	}

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * 
	 *            This method will clear the existing value from the texbox
	 *            field
	 */
	public static void clearFieldvalue(WebDriver driver, WebElement elem, Scenario scenario) {

		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for clicking on Emmenet ");
		}
		try {
			elem.clear();
		} catch (Exception E) {
			scenario.write(" Error on clicking the element after wating !");
		}

	}

}
