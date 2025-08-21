package Tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.LoadPropertiesData;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.productDetailsPage;

public class QuantityNegative extends TestBase{
	HomePage home;
	ProductPage product;
	productDetailsPage details;
	 @DataProvider(name="quantityData")
	 public Object[][] quantityData(){
		 Properties p =LoadPropertiesData.invalidQData;
			Object[][] data = {
					{p.getProperty("q")}
			};
			return data;
	 }
	   
	   @Test(dataProvider = "quantityData")
	   public void QuantityValidValue(String num) {
		   home=new HomePage(driver);
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.elementToBeClickable(home.HomeBtn)).click();
	 	  product=new ProductPage(driver);
	 	  details=new productDetailsPage(driver);
		  home.goToProductPage();
		  Assert.assertEquals("ALL PRODUCTS",product.ProductConfermMessage.getText());
		  Assert.assertTrue(product.products.size()>0);
		  product.goTODetailsPage();
	 	  details.quantityEnter(num);
	 	  int number = Integer.parseInt(num);
	 	  Assert.assertNotEquals(number,product.cquantity.getText());
	 	  
	   }
}
