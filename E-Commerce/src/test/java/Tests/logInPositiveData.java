package Tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.LoadPropertiesData;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.productDetailsPage;

public class logInPositiveData extends TestBase{
	HomePage home;
	ProductPage product;
	productDetailsPage details;
	LoginPage login;
	@DataProvider(name="LogInData")
	  public Object[][] LogInData(){
		Properties p =LoadPropertiesData.validLogInData;
		Object[][] data = {
				{p.getProperty("email"),p.getProperty("password")}
		};
		return data;
	  }

	  @Test(dataProvider = "LogInData")
	  public void AddProduct(String email,String pass) {
		  home=new HomePage(driver);
		  product=new ProductPage(driver);
		  login = new LoginPage(driver);
		  home.goToProductPage();
		  Assert.assertEquals("ALL PRODUCTS",product.searchConferm.getText());
		  Assert.assertTrue(product.products.size()>0);
		  product.resultOfSearchToAdd();
		  home.Signup_LoginBtn.click();
		  login.loginData(email, pass);
		  home.cartBtn.click();
		  product.checkCart();
		  Assert.assertEquals("rgba(255, 165, 0, 1)", home.cartBtn.getCssValue("color"));
		  login.logoutBtn.click();
		  Assert.assertEquals("rgba(255, 165, 0, 1)", home.Signup_LoginBtn.getCssValue("color"));
	  }
	 
	  
}
