package com.gautam.appium.appium_mobile;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookMyShow {

	WebDriver driver;
	
	@BeforeClass
	public void setup () throws MalformedURLException, InterruptedException {
		String appPath = System.getProperty("user.dir") + "\\config\\BookMyShow.apk";
		DesiredCapabilities desCapabilities = new DesiredCapabilities();
		desCapabilities.setCapability("app", appPath);
		desCapabilities.setCapability("BROWSER_NAME", "Android");
		desCapabilities.setCapability("VERSION", "6.0.1");
		desCapabilities.setCapability("deviceName", "ZY22335S4D");
		desCapabilities.setCapability("platformName", "Android");
		desCapabilities.setCapability("appPackage", "com.bt.bms");
		desCapabilities.setCapability("appActivity", "com.movie.bms.splash.views.activities.SplashScreenActivity");
		
		driver = new  RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), desCapabilities);
	}

	public void waitForElement (By element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		
	}
	
	@Test(priority = 1)
	public void selectEnglishLanguage() throws InterruptedException {
		waitForElement(By.id("com.bt.bms:id/language_text_view_label"));
		driver.findElement(By.id("com.bt.bms:id/language_text_view_label")).click();
		String buttonName = driver.findElement(By.id("com.bt.bms:id/launcher_tv_for_skip")).getText();
		Assert.assertEquals(buttonName, "SKIP");
	}
	
	@Test(priority = 2)
	public void verifyLoginPageControls() {
		WebElement facebookButton = driver.findElement(By.id("com.bt.bms:id/social_bt_facebook"));
		Assert.assertTrue(facebookButton.isEnabled());
		System.out.println("Button - " + facebookButton.getText());
		Assert.assertEquals(facebookButton.getText(), "Connect with Facebook");
		
		WebElement googleButton = driver.findElement(By.id("com.bt.bms:id/social_bt_google"));
		Assert.assertTrue(googleButton.isEnabled());
		System.out.println("Button - " + googleButton.getText());
		Assert.assertEquals(googleButton.getText(), "Connect with Google");
		
		WebElement loginButton = driver.findElement(By.id("com.bt.bms:id/launcher_tv_for_login"));
		Assert.assertTrue(loginButton.isEnabled());
		System.out.println("Button - " + loginButton.getText());
		Assert.assertEquals(loginButton.getText(), "LOG IN");
	
		WebElement signUpButton = driver.findElement(By.id("com.bt.bms:id/launcher_tv_for_signup"));
		Assert.assertTrue(signUpButton.isEnabled());
		System.out.println("Button - " + signUpButton.getText());
		Assert.assertEquals(signUpButton.getText(), "SIGN UP");
	
	}
	
	@Test(priority = 3)
	public void skipLogin() throws InterruptedException {
		driver.findElement(By.id("com.bt.bms:id/launcher_tv_for_skip")).click();
		
		waitForElement(By.name("OK"));
		WebElement ok = driver.findElement(By.name("OK"));
		if (ok.isDisplayed()) {
			ok.click();
		}
		waitForElement(By.name("Now Showing"));
		System.out.println("Text - " + driver.findElement(By.name("Now Showing")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.name("Now Showing")).isDisplayed());
	}
}
