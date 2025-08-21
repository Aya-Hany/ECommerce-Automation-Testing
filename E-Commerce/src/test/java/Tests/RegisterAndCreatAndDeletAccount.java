package Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.LoadPropertiesData;
import Pages.HomePage;
import Pages.NewAccount;
import Pages.RegisterPage;

public class RegisterAndCreatAndDeletAccount extends TestBase {
	HomePage home;
	NewAccount acc;
	RegisterPage Register;
	@DataProvider(name="getAData")
	public Object[][] getData() throws IOException{
		Properties p =LoadPropertiesData.NewAccountData;
		Object[][] data = {
				{p.getProperty("title"),p.getProperty("email"),p.getProperty("name"),p.getProperty("password"),p.getProperty("day"),p.getProperty("month"),
				 p.getProperty("year"),p.getProperty("FName"),p.getProperty("LName"),p.getProperty("Company"),p.getProperty("Address"),
		         p.getProperty("Address2"),p.getProperty("Country"),p.getProperty("State"),p.getProperty("City"),p.getProperty("Zipcode"),
		         p.getProperty("Mobile_Number")}
		};
		return data;
	}
  @Test(dataProvider = "getAData")
  public void CreateAccount(String title,String name,String email,String password,String day,String month,String year,String FName,String LName,String Company,String Address,
			String Address2,String Country,String State,String City,String Zipcode,String Mobile_Number) {
	  
	  home=new HomePage(driver);
	  acc=new NewAccount(driver);
	  Register = new RegisterPage(driver);
	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
	  home.goToRegisterPage();
	  WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf(Register.RegisterMessage));
	  Assert.assertEquals("New User Signup!",Register.RegisterMessage.getText());
	  Register.fillRegisterField(email, name);
	  wait.until(ExpectedConditions.visibilityOf(Register.confirmRegister));
	  Assert.assertEquals("ENTER ACCOUNT INFORMATION", Register.confirmRegister.getText());
	  home.closeGoogleAdIfPresent();
	  acc.fillTheAccountInformationFields(title,name,password,day,month,year);
	 
	  if(acc.FirstCheckBox.getText().contains("Sign up for our newsletter!")&& (!acc.FirstCheckBox.isSelected())) {
		  acc.FirstCheckBox.click();
	  }
	  if(acc.SecondCheckBox.getText().contains("Receive special offers from our partners!")&& (!acc.SecondCheckBox.isSelected())) {
		  acc.SecondCheckBox.click();
	  }
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView(false);", home.subscriptionMessage);
	  acc.fillTheAddressInformationFields(FName, LName, Company, Address, Address2, Country, State, City, Zipcode, Mobile_Number);
	  Assert.assertEquals("ACCOUNT CREATED!",acc.createdMessage.getText());
	  acc.goToHomePage();
	  wait.until(ExpectedConditions.visibilityOf(home.verifyLoggedin));
	  Assert.assertTrue(home.verifyLoggedin.getText().contains("Logged in as"));
	  home.deletAccount();
	  wait.until(ExpectedConditions.visibilityOf(home.deletMessage));
	  Assert.assertEquals("ACCOUNT DELETED!",home.deletMessage.getText());
	  home.backToHomePage();
  }
}
