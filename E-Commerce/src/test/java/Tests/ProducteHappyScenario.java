package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductPage;
import Pages.productDetailsPage;

public class ProducteHappyScenario extends TestBase{
	HomePage home;
	ProductPage product;
	productDetailsPage details;
	Actions action;
	
	
  @Test(priority = 1)
  public void CheckallFeildAreWorkCorrectly() {
	  home=new HomePage(driver);
	  product=new ProductPage(driver);
	  details=new productDetailsPage(driver);
	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
	  home.goToProductPage();
	  Assert.assertEquals("ALL PRODUCTS",product.ProductConfermMessage.getText());
	  Assert.assertTrue(product.products.size()>0);
	  product.goTODetailsPage();
	  Assert.assertEquals("WRITE YOUR REVIEW",product.ViewConfermMessage.getText());
	  Assert.assertEquals("Blue Top",details.name.getText());
	  Assert.assertEquals("Rs. 500",details.price.getText());
	  Assert.assertEquals("Category: Women > Tops",details.category.getText());
	  Assert.assertEquals("Availability:",details.Availability.getText());
	  Assert.assertEquals("Brand:",details.Brand.getText());
	  Assert.assertEquals("Condition:",details.Condition.getText());  
  }
 

@Test(priority = 2)
	public void CategoryCheck() {
	  home=new HomePage(driver);
	  product=new ProductPage(driver);
	  home.goToProductPage();
	  product.check("CATEGORY");
	  product.goToCategoryWomen();
	  Assert.assertEquals("WOMEN -  DRESS PRODUCTS",product.categoryConferm.getText());
	  product.goToCategoryMen();
	  Assert.assertEquals("MEN -  JEANS PRODUCTS",product.categoryConferm.getText());
	}

	@Test(priority = 3)
	public void checkBrandProducts() {
	  home=new HomePage(driver);
	  product=new ProductPage(driver);
	  product.check("BRANDS");
	  product.poloBrandBtn.click();
	  Assert.assertEquals("BRAND - POLO PRODUCTS",product.categoryConferm.getText());
	  Assert.assertTrue(product.products.size()>0);
	  product.HMBrandBtn.click();
	  Assert.assertEquals("BRAND - H&M PRODUCTS",product.categoryConferm.getText());
	  Assert.assertTrue(product.products.size()>0);
	}
	
  
  @Test(priority = 4)
  public void HoverCard() {
	  home=new HomePage(driver);
	  product=new ProductPage(driver);
	  action=new Actions(driver);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView(true);", product.hovercard);
	  action.moveToElement(product.hovercard).perform();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf(product.hoverAddBtn));
	  product.hoverAddBtn.click();
	  product.viewBtn.click();
	  Assert.assertEquals("Rs. 400",product.cPice.getText());
	  Assert.assertEquals("1",product.cquantity.getText());
	  Assert.assertEquals("Rs. 400",product.cTotal.getText());
	  
  }
  
 
}
