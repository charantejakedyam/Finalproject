package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ConfigReader;

public class GiftCardPage {

    WebDriver driver;
    WebDriverWait wait;
    ConfigReader config;

    String amt;
    String qty;
    String fName;
    String lName;
    String emailId;
    String mobile;

    public GiftCardPage(WebDriver driver) throws Exception {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        
        config = new ConfigReader();
        amt = config.getAmount();
        qty = config.getQuantity();
        fName = config.getFirstName();
        lName = config.getLastName();
        emailId = config.getEmailId();
        mobile = config.getMobile();
    }

    @FindBy(xpath = "//a[text()='Gift Cards']")
    private WebElement giftCardLink;
    
    @FindBy(id = "denomination")
    private WebElement amount;

    @FindBy(id = "quantity")
    private WebElement quantity;

    @FindBy(id = "radiogift")
    private WebElement sendAsGift;

    @FindBy(id = "giftNow")
    private WebElement today;

    @FindBy(id = "deliveryModeEMAIL")
    private WebElement email;

    @FindBy(xpath = "//*[@id='design-theme']//div[1]")
    private WebElement happyBirthdayTheme;

    @FindBy(id = "firstname")
    private WebElement senderFirstName;

    @FindBy(id = "lastname")
    private WebElement senderLastName;

    @FindBy(id = "email")
    private WebElement senderEmail;

    @FindBy(id = "telephone")
    private WebElement senderMobile;
    
    @FindBy(xpath = "//div[contains(@class,'invalid-address')]")
    private WebElement emailErrorMessage;

    @FindBy(id = "sameAsSender")
    private WebElement checkbox;

//    @FindBy(xpath = "//button[normalize-space()='PREVIEW E-GIFT-CARD']")
//    private WebElement previewBtn;

    public void navigateToGiftPage() {

        String originalHandle = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(giftCardLink)).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allHandles = driver.getWindowHandles();

        for (String handle : allHandles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
    
    public void enterDetails() {

        wait.until(ExpectedConditions.elementToBeClickable(amount)).clear();
        amount.sendKeys(amt);

        wait.until(ExpectedConditions.elementToBeClickable(quantity)).clear();
        quantity.sendKeys(qty);

        System.out.println("Before filling sender details");
        
        senderFirstName.sendKeys(fName);
        senderLastName.sendKeys(lName);
        senderEmail.sendKeys(emailId);
        senderMobile.sendKeys(mobile);
        
        System.out.println("Before filling sender details");
        
        checkbox.click();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300)");
        
    }

    public void takeScreenshot() throws IOException {
    	
    	System.out.println("In screenshot");
    	
    	
    	
    	TakesScreenshot screen = (TakesScreenshot) driver;
		File src  = screen.getScreenshotAs(OutputType.FILE);
		File destfile = new File(System.getProperty("user.dir") + "/screenshots/TestScreen.png");
		FileUtils.copyFile(src, destfile);
		System.out.println("Taken screenshot");
		
    }
    
    public void printErrorMsg() {
    	System.out.println("In print error msg");
        try {
            System.out.println("Error message displayed: " );
        } catch (Exception e) {
            System.out.println("No validation error message displayed.");
        }
    }
    
//    public void clickPreviewBtn() {
//    	System.out.println("In btn click" );
//        previewBtn.click();
//    }
    
}