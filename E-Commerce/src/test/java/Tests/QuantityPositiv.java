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

public class QuantityPositiv extends TestBase{
	HomePage home;
	ProductPage product;
	productDetailsPage details;
	 @DataProvider(name="quantityData")
	 public Object[][] quantityData(){
		 Properties p =LoadPropertiesData.validQData;
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
	 	  home.HomeBtn.click();
	 	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
		  home.goToProductPage();
		  Assert.assertEquals("ALL PRODUCTS",product.ProductConfermMessage.getText());
		  Assert.assertTrue(product.products.size()>0);
		  product.goTODetailsPage();
	 	  details.quantityEnter(num);
	 	 Assert.assertEquals(num, product.cquantity.getText());

	 	  
	   }
}
