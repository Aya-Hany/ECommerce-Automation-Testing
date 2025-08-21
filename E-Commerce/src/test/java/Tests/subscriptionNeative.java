package Tests;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.LoadPropertiesData;
import Pages.HomePage;

public class subscriptionNeative extends TestBase{
	HomePage home;
	
	@DataProvider(name="LogInData")
	  public Object[][] LogInData(){
		Properties p =LoadPropertiesData.invalidLogInData;
		Object[][] data = {
				{p.getProperty("email")}
		};
		return data;
	  }
  @Test(dataProvider = "LogInData",priority = 1)
  public void subscriptionInHome(String email) {
	  home = new HomePage(driver);
	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView(false);", home.subscriptionMessage);
	  home.subscribtion(email);
	  Assert.assertFalse(home.subscribtionSuccess.isDisplayed());
  }
  @Test(dataProvider = "LogInData",priority = 2)
  public void subscriptionInCart(String email) {
	  home = new HomePage(driver);
	  home.cartBtn.click();
	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.cartBtn.getCssValue("color"));
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView(false);", home.subscriptionMessage);
	  home.subscribtion(email);
	  Assert.assertFalse(home.subscribtionSuccess.isDisplayed());
  }
  
}
