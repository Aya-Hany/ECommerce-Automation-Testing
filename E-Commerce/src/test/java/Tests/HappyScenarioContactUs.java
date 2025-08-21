package Tests;


import java.awt.AWTException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.LoadPropertiesData;
import Pages.ContactUsRobotway;
import Pages.HomePage;

public class HappyScenarioContactUs extends TestBase{
	ContactUsRobotway contact;
	HomePage home;
	@DataProvider(name="ContactValidDate")
	  public Object[][] LogInData(){
		Properties p =LoadPropertiesData.ContactValidDate;
		Object[][] data = {
				 {p.getProperty("name"), p.getProperty("email")}
					};
		return data;
	  }
  @Test(dataProvider = "ContactValidDate")
  public void testValidNameAndValidEmail(String name,String email) throws  AWTException {
	  contact=new ContactUsRobotway(driver);
	  home=new HomePage(driver);
	  home.Contact.click();
	  
	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.Contact.getCssValue("color"));
	  contact.userCanFillTheField(name,email);
	 
  	  Assert.assertEquals("Press OK to proceed!",contact.alert.getText());
  	  contact.continueContactUs();
  	  
	  Assert.assertTrue(contact.successMessage.getText().contains("Success! Your details have been submitted successfully."));
	  contact.userCanGoToHomePage();
	  
	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
	      
  }

}
