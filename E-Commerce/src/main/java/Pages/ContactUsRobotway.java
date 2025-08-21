package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class ContactUsRobotway extends PageBase{
	public ContactUsRobotway(WebDriver driver) {
		super(driver); 
	} 
	
	
	@FindBy(name="name")
	public WebElement nameTxt;
	
	@FindBy(name="email")
	public WebElement emailTxt;
	
	@FindBy(name="subject")
	public WebElement subjectTxt;
	
	@FindBy(name="message")
	public WebElement messageTxt;
	
	@FindBy(name="upload_file")
	public WebElement uploadFileBtn;
	@FindBy(name="submit")
	public WebElement submitBtn;
	
	@FindBy(className="btn-success")
	public WebElement homeBtn;
	
	@FindBy(css="#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success")
	public WebElement successMessage;
	String filePath = "C:\\Users\\huawei\\Desktop\\tasks.txt";
	public void clear() {
		nameTxt.clear();
		emailTxt.clear();
		subjectTxt.clear();
		messageTxt.clear();
		uploadFileBtn.clear();
	}
	
	
	public Alert alert;
	public void userCanFillTheField(String name ,String email) throws AWTException {
		nameTxt.sendKeys(name);
		emailTxt.sendKeys(email);
		subjectTxt.sendKeys("late order");
		messageTxt.sendKeys("order is confermed 20 days ago");
		
		Actions builder = new Actions (driver);		
		builder.click(uploadFileBtn).build().perform();
		StringSelection selection = new StringSelection(filePath);
		//search
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot = new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		submitBtn.click();
		alert = driver.switchTo().alert();
	}
	
	public void continueContactUs() {
		alert.accept();
	}
	
	public void userCanGoToHomePage() {
		homeBtn.click();
	}
		
}
	
	