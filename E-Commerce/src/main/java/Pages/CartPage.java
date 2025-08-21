package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends PageBase {

	public CartPage(WebDriver driver) {
		super(driver);
		
	}
	 @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout') or contains(@href,'/checkout')]")
	    public WebElement proceedToCheckoutBtn;

	    @FindBy(xpath = "//u[contains(text(),'Register / Login')]")
	    public WebElement registerLoginBtn;
	    
	    @FindBy(name = "name")
	    public WebElement nameField;

	    @FindBy(xpath = "//input[@data-qa='signup-email']")
	    public WebElement emailField;

	    @FindBy(xpath = "//*[@id=\\\"form\\\"]/div/div/div[3]/div/form/button")
	
	    public WebElement signupBtn;

	    @FindBy(linkText = "Cart")
		public WebElement cartBtn;
	    
	    @FindBy(id ="address_delivery")
	    public WebElement AddressDetails;
	    
	    @FindBy(id = "cart_info")
	    public WebElement ReviewYourOrder;
	    
	    @FindBy(name = "message")
	    public WebElement commentTextArea;
	    
	    @FindBy(xpath ="  //*[@id=\"cart_items\"]/div/div[7]/a")
	    public WebElement placeOrderBtn;
	    
	    @FindBy(css ="#cart_item .container .step_one h2")
		WebElement paymentt;
	    
	    @FindBy(name = "name_on_card")
	    public WebElement namecardField;
	    
	    @FindBy(name = "card_number")
	    public WebElement cardnumberField;
	    
	    @FindBy(name = "cvc")
	    public WebElement cvcField;
	    
	    @FindBy(name = "expiry_month")
	    public WebElement  expirymonthField;
	    
	    @FindBy(name = "expiry_year")
	    public WebElement expiryyearField ;
	    
	    @FindBy(id = "submit")
		WebElement payBtn;
	    
	    @FindBy(css = "a[data-product-id='1']")
	    public WebElement RemoveBtn;
	    
	    @FindBy(xpath=" //*[@id=\"empty_cart\"]/p/b")
         public WebElement epmtyMsg;
	    
	    @FindBy(id = "address_delivery")
	    public WebElement deliveryAddress;

	    @FindBy(id = "address_invoice")
	    public WebElement billingAddress;
	    
	    @FindBy(xpath="//*[@id=\"form\"]/div/div/div/a")
	    public WebElement DownloadBtn;
   
	    
	
	    
	 //   @FindBy(id = "success_message")
		//WebElement orderSuccessMsg;
	    @FindBy(xpath="//*[@id=\"form\"]/div/div/div/p")
	         WebElement orderSuccessMsg;
	    
	    @FindBy(partialLinkText = "Delete Account")
	  		public WebElement DeleteBtn;
	  	    
	    
	    @FindBy(xpath ="//*[@id=\"form\"]/div/div/div/h2/b//")
	    public WebElement accountDeletedMsg;
	
	    @FindBy(className = "btn-primary")
		WebElement continuebutton;

	
	    
	    public void clickProceedToCheckout() {
	        proceedToCheckoutBtn.click();
	    }

	    public void clickRegisterLogin() {
	        registerLoginBtn.click();
	    }
	    
	    public void signup(String name, String email) {
	        nameField.sendKeys(name);
	        emailField.sendKeys(email);
	        signupBtn.click();
	    }
	    public boolean verifyAddressDetailsVisible() {
	    	
	        return AddressDetails.isDisplayed();
			
	    }
	    
	   public boolean verifyReviewYourOrder() {
	       return ReviewYourOrder.isDisplayed();
	    }
	   
	    
         
	    public void enterComment(String comment) {
	        commentTextArea.sendKeys(comment);
	    }

	    public void clickPlaceOrder() {
	        placeOrderBtn.click();
	    }
	
	    public void enterPaymentDetails(String name, String cardNumber, String cvc, String month, String year) {
	    	namecardField.sendKeys(name);
	    	cardnumberField.sendKeys(cardNumber);
	        cvcField.sendKeys(cvc);
	        expirymonthField.sendKeys(month);
	        expiryyearField.sendKeys(year);
	    }

	    public void clickPayAndConfirmOrder() {
	    	payBtn.click();
	    }

	    public boolean verifyOrderSuccess() {
	        return orderSuccessMsg.isDisplayed();
	    }
	    public void clickDeleteAccount() {
	    	DeleteBtn.click();
	    }

	    public boolean verifyAccountDeleted() {
	        return accountDeletedMsg.isDisplayed();
	    }

	    public boolean verifyEmptyCart() {
		       return epmtyMsg.isDisplayed();
		    }
	
		
	
		}

	









	    
	    
	 
	    

		
	
	    
	    
	    
	    

