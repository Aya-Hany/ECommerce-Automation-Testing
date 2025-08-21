package Tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.LoadPropertiesData;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.productDetailsPage;

public class ReviewNegative extends TestBase{
	HomePage home;
	ProductPage product;
	productDetailsPage details;
	Actions action;
	 @DataProvider(name="reviewData")
	  public Object[][] review(){
		 Properties p =LoadPropertiesData.invalidRewiewData;
		  Object[][] data= {
				  {p.getProperty("name"),p.getProperty("email"),p.getProperty("message")}
		  };
		return data;
	  }
	@Test(priority = 2,dataProvider = "reviewData")
	public void reviewCheck(String name,String email,String message){
		details=new productDetailsPage(driver);
		home=new HomePage(driver);
		product=new ProductPage(driver);
		home.goToProductPage();
		product.goTODetailsPage();
		Assert.assertEquals("WRITE YOUR REVIEW",product.ViewConfermMessage.getText());
		details.reviewData(name, email, message);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", details.reviewConfermMessage);
	    Assert.assertTrue(!details.reviewConfermMessage.isDisplayed());
		driver.navigate().back();
	}
}
