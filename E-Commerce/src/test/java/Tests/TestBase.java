package Tests;
import org.testng.annotations.BeforeTest;
import Helper.TakeScreenShotUtils;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;



public class TestBase {
  protected WebDriver driver;
  String Url="https://www.automationexercise.com";
  @BeforeTest
  public void openWebSite() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.navigate().to(Url);
  }
  
  @AfterMethod
	public void takeScreenShot(ITestResult result) throws IOException {
		String status = result.getStatus() == ITestResult.FAILURE ? "FAILURE":"PASSED";
		
		if(result.getStatus() == ITestResult.FAILURE) {
			/// take screen shot
			TakeScreenShotUtils.takeScreenShot(driver, result.getName()+"_"+status+"_"+UUID.randomUUID().toString());
		}
	}
  
  @AfterTest
  public void closeWebSite() {
	  driver.close();
  }

}
