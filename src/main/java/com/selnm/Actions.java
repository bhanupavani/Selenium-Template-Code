package com.selnm;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class Actions {
		WebDriver obj;

		public void openBrowser(String l, String d, String c) {
			 obj = new FirefoxDriver();
		}

		public void navigate(String l, String d, String c) {
			obj.get("http:\\www.gmail.com");
			obj.manage().window().maximize();

		}

		public void waitFor(String l, String d, String c)
				throws InterruptedException {
			long x = Long.parseLong(d);
			Thread.sleep(x);
		}

		public void input(String l, String d, String c) {
			By loc = null;
			if (l.contains("id")) {
				loc = By.id(l.substring(3));
			} else if (l.contains("name")) {
				loc = By.name(l.substring(5));
			} else if (l.contains("xpath")) {
				loc = By.xpath(l.substring(6));

			} else if (l.contains("linkText")) {
				loc = By.linkText(l.substring(9));

			} else if (l.contains("partialLinkText")) {
				loc = By.partialLinkText(l.substring(16));

			} else if (l.contains("cssSelector")) {
				loc = By.cssSelector(l.substring(12));

			} else if (l.contains("tagName")) {
				loc = By.tagName(l.substring(8));

			} else if (l.contains("className")) {
				loc = By.className(l.substring(10));
			} else {
				System.exit(0);

			}
			obj.findElement(loc).sendKeys(d);
		}

		public void click(String l, String d, String c) {
			By loc = null;
			if (l.contains("id")) {
				loc = By.id(l.substring(3));
			} else if (l.contains("name")) {
				loc = By.name(l.substring(5));
			} else if (l.contains("xpath")) {
				loc = By.xpath(l.substring(6));

			} else if (l.contains("linkText")) {
				loc = By.linkText(l.substring(9));

			} else if (l.contains("partialLinkText")) {
				loc = By.partialLinkText(l.substring(16));

			} else if (l.contains("cssSelector")) {
				loc = By.cssSelector(l.substring(12));

			} else if (l.contains("tagName")) {
				loc = By.tagName(l.substring(8));

			} else if (l.contains("className")) {
				loc = By.className(l.substring(10));
			} else {
				System.exit(0);

			}
			obj.findElement(loc).click();

		}

		public void closeBrowser(String l, String d, String c) {
			obj.quit();
		}
	}


