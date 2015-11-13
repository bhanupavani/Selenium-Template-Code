package com.selnm;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class code {

	WebDriver driver = new FirefoxDriver();

	// verify title of page
	public void verifyTitle()

	{
		String x = driver.getTitle();
		System.out.println("page title is :" + x);
		Assert.assertTrue(x.equals("Guru99 Bank Manager HomePage"));
	}

	public void isAlertPresent() {
		Alert alert = driver.switchTo().alert();
		System.out.println("alert message is : " + alert.getText());
		alert.accept();
		driver.switchTo().defaultContent();
	}

	public void scrollDown() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().refresh();
		Thread.sleep(5000);
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,4500)", ""); // scroll down
		Thread.sleep(3000);
		jsx.executeScript("window.scroll(4500,0)", "");// scroll up

	}

	public void verifyCheckboxSelection() {
		boolean t = driver.findElement(By.xpath("xpath of button"))
				.isSelected();
		System.out.println("checkbox selection is" + t);
	}

	public void verifyRadiobuttonSelection() {
		boolean t = driver.findElement(By.xpath("xpath of button"))
				.isSelected();
		System.out.println("radiobutton selection is" + t);
	}

	public void getWidthOfTextbox() {
		driver.findElement(By.xpath("xpath of textbox")).getSize().getWidth();

	}

	public void screenshot() throws IOException {
		/*
		 * EventFiringWebDriver eDriver = new EventFiringWebDriver(driver); File
		 * srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(srcFile, new File(
		 * "C:\\Users\\Pretty\\Desktop\\personal\\sreenshot.png"));
		 */
		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(
				"C:\\Users\\Pretty\\Desktop\\personal\\sreenshot1.png"));

	}

	/*
	 * public void doubleClick(){ Actions act = new Actions(driver);
	 * //act.doubleClick(webelement);
	 */
	public void windowMinimize() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_WINDOWS);
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_WINDOWS);
		r.keyRelease(KeyEvent.VK_M);
	}

	public void moveBwsrToSpefcLocation() {
		Point p = new Point(0, 100);
		driver.manage().window().setPosition(p);
	}

	public void resizeBrowser() {
		Dimension d = new Dimension(10, 10);
		driver.manage().window().setSize(d);
	}

	public void changeUrl() {
		driver.navigate().to("url");
	}

	public void refreshBrowser() {
		driver.navigate().refresh();
	}

	public void clickBack() {
		driver.navigate().back();
	}

	public void clickForward() {
		driver.navigate().forward();
	}

	public void tileOfBrowser() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String name = (String) js.executeScript("return navigator.userAgent");
		System.out.println(name);
	}

	public void currentUrl() {
		System.out.println(driver.getCurrentUrl());
	}

	public void getPageSource() {
		System.out.println(driver.getPageSource());
	}

	public void displayTextInTextbox() {
		driver.findElement(By.id("hghghgh")).sendKeys("admin");
		String un = driver.findElement(By.id("hghghgh")).getAttribute("value");
		System.out.println(un);
	}

	public void clear() {
		driver.findElement(By.id("hghghgh")).clear();
	}

	public void copyTextFromTextboxToOther() {
		driver.findElement(By.xpath("//span[text()='Contact Us']")).sendKeys(
				"admin");
		String t = driver.findElement(By.xpath("//span[text()='Contact Us']"))
				.getAttribute("value");
		System.out.println(t);

	}

	public void countNoofOptionsInListbox() {
		WebElement t = driver.findElement(By.id("under_ststyy"));
		Select s = new Select(t);
		List<WebElement> po = s.getOptions();
		System.out.println(po);
		for (int i = 0; i < po.size(); i++) {
			System.out.println(po.get(i).getText());
		}
	}

	// using xpath
	/*
	 * List<WebElement> t = driver.findElements(By.xpath
	 * ("//span[text()='Contact Us']/option")); System.out.println(t); for(int
	 * i=0;i<t.size();i++) { System.out.println(t.get(i).getText()); }
	 */
	public void SearchOptionInListbox() {
		WebElement t = driver.findElement(By.id("under_ststyy"));
		Select s = new Select(t);
		List<WebElement> po = s.getOptions();
		System.out.println(po);
		for (int i = 0; i < po.size(); i++) {
			String v = po.get(i).getText();
			if (v.contains("pak")) {
				System.out.println(po);
			}
		}
	}

	public void checkForOptionsSort() {
		WebElement t = driver.findElement(By.id("under_ststyy"));
		Select s = new Select(t);
		List<WebElement> po = s.getOptions();
		System.out.println(po);
		String msg = "sorted";
		for (int i = 0; i < po.size() - 1; i++) {
			String s1 = po.get(i).getText();
			String s2 = po.get(i + 1).getText();
			if (s1.compareTo(s2) > 0) {
				msg = "Not Sorted";
			}
		}
		System.out.println(msg);

	}

	public void rowCount() {
		List<WebElement> t = driver.findElements(By.xpath("//tr"));
		System.out.println(t.size());
	}

	public void rowText() {
		List<WebElement> t = driver.findElements(By.xpath("//tr"));
		System.out.println(t.size());
		for (int i = 0; i < t.size(); i++) {
			String s1 = t.get(i).getText();
			System.out.println(s1);
		}
	}

	public void coloumnCount() {
		List<WebElement> t = driver.findElements(By.xpath("//td"));
		System.out.println(t.size());

	}

	public void coloumnText() {
		List<WebElement> t = driver.findElements(By.xpath("//td"));
		System.out.println(t.size());
		for (int i = 0; i < t.size(); i++) {
			String s1 = t.get(i).getText();
			System.out.println(s1);
		}
	}

	public void PageLoadedOrNot() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String name = (String) js.executeScript("alert(document.readtstate");
		System.out.println(name);
	}
}
