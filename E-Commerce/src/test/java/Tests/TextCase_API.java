package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class TextCase_API extends TestBase{
	HomePage home;
  @Test
  public void TextCase_API() {
	  home=new HomePage(driver);
	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
	  home.testCase.click();
	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.testCase.getCssValue("color"));
	  home.APICase.click();
	  Assert.assertEquals("rgba(255, 165, 0, 1)", home.APICase.getCssValue("color"));
  }
}
