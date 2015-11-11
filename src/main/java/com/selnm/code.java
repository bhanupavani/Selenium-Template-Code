package com.selnm;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class code {

	WebDriver obj = new FirefoxDriver();

	// verify title of page
	public void getTitle()

	{
		String x = obj.getTitle();
		System.out.println("page title is :" + x);
		Assert.assertTrue(x.equals("Guru99 Bank Manager HomePage"));
	}

	public void isAlertPresent() {
		Alert alert = obj.switchTo().alert();
		System.out.println("alert message is : " + alert.getText());
		alert.accept();
		obj.switchTo().defaultContent();
	}

}
