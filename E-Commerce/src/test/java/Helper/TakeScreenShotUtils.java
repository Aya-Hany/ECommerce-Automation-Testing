package Helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShotUtils {
	public static void takeScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		
		String filePath = System.getProperty("user.dir")+"\\ScreenShot\\"+screenShotName+".png";
		File Destination = new File(filePath); 
		
		FileUtils.copyFile(Source, Destination);
		
	}
}
