package com.gautam.appium.appium_mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MoviesHome {

	WebDriver driver;
	
//	@BeforeTest
//	public void initailize() {
//	}
//	
	@Test(priority = 1)
	public void verifyHeaderControls() {
		BookMyShow bms = new BookMyShow();
		driver = bms.getDriver();
		
//		WebElement justForYou = driver.findElement(By.name("Just For You"));
//		System.out.println("Just for You is selected - " + justForYou.isSelected());
//		Assert.assertTrue(justForYou.isDisplayed());

		WebElement comingSoon = driver.findElement(By.name("Coming Soon"));
		Assert.assertTrue(comingSoon.isDisplayed());

		WebElement otherActivites = driver.findElement(By.id("com.bt.bms:id/main_activity_toolbar_img_arrow_down"));
		Assert.assertTrue(otherActivites.isDisplayed());

		WebElement selectedActivity = driver.findElement(By.id("com.bt.bms:id/main_activity_toolbar_text"));
		Assert.assertEquals(selectedActivity.getText(), "Movies");
		
		WebElement selectedLocation = driver.findElement(By.id("com.bt.bms:id/main_activity_toolbar_location"));
		Assert.assertEquals(selectedLocation.getText(), "In Delhi-NCR");
	
		WebElement offers = driver.findElement(By.id("com.bt.bms:id/main_activity_offers_text"));
		Assert.assertTrue(offers.isDisplayed());
	}
	
	@Test(priority = 2)
	public void verifyFilteringControls() {
		
		WebElement filterIcon = driver.findElement(By.id("com.bt.bms:id/now_showing_language_img_view"));
		Assert.assertTrue(filterIcon.isDisplayed());
		
		WebElement filters = driver.findElement(By.name("Filters"));
		Assert.assertTrue(filters.isDisplayed());

		WebElement cinemaIcon = driver.findElement(By.id("com.bt.bms:id/now_showing_cinema_img_view"));
		Assert.assertTrue(cinemaIcon.isDisplayed());
		
		WebElement cinemas = driver.findElement(By.name("Cinemas"));
		Assert.assertTrue(cinemas.isDisplayed());
	}
	
	@Test(priority = 3)
	public void verifyFooterControls() {
		
		WebElement home = driver.findElement(By.name("Home"));
		Assert.assertTrue(home.isDisplayed());

		WebElement search = driver.findElement(By.name("Search"));
		Assert.assertTrue(search.isDisplayed());

		WebElement justForYou = driver.findElement(By.name("Just For You"));
		Assert.assertTrue(justForYou.isDisplayed());

		WebElement myProfile = driver.findElement(By.name("My Profile"));
		Assert.assertTrue(myProfile.isDisplayed());
	}
	
	
}
