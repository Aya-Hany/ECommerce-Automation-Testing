package Tests;

import java.util.Properties;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.LoadPropertiesData;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.productDetailsPage;

public class searchPoitiveData extends TestBase{
	HomePage home;
	ProductPage product;
	productDetailsPage details;
	Actions action;
	 @DataProvider(name ="searchData")
	 public Object[][] searchData(){
		 Properties p =LoadPropertiesData.validSearchData;
			Object[][] data = {
					{p.getProperty("search")}
			};
			return data;
	 }
	  
	  @Test(dataProvider = "searchData")
		public void searchProduct(String searchData) {
		  home=new HomePage(driver);
		  product=new ProductPage(driver);
		  home.goToProductPage();
		  product.search(searchData);
		  Assert.assertEquals("SEARCHED PRODUCTS",product.searchConferm.getText());
		  Assert.assertTrue(product.resultOfSearch(searchData));
		}
}
