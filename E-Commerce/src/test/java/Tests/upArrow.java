package Tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class upArrow extends TestBase{
	HomePage home;
	
  @Test
  public void scrollUpWithArrow() {
	  home=new HomePage(driver);
	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView(true);", home.subscriptionMessage);
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf(home.subscriptionMessage));
	  Assert.assertTrue(home.subscriptionMessage.isDisplayed());
	  home.upArrow.click();
	  wait.until(ExpectedConditions.visibilityOf(home.bannerMessage));
	  Assert.assertTrue(home.bannerMessage.isDisplayed()); 
  }
  public void scrollUpWithOutArrow() {
	  home=new HomePage(driver);
	  WebDriverWait wait;
	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView(false);", home.subscriptionMessage);
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf(home.subscriptionMessage));
	  Assert.assertTrue(home.subscriptionMessage.isDisplayed());
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf(home.bannerMessage));
	  js.executeScript("arguments[0].scrollIntoView(true);", home.bannerMessage);
	  Assert.assertTrue(home.bannerMessage.isDisplayed()); 
  }
  
}
