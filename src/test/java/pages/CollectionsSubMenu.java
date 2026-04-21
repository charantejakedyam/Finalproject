/*package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollectionsSubMenu {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CollectionsSubMenu(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@data-testid='navigation-desktop-category-10']")
	private WebElement furnishingMenu;
	
	public void clickCollections() {

		driver.navigate().back();
		
		wait.until(ExpectedConditions.elementToBeClickable(furnishingMenu));
		furnishingMenu.click();
		wait.until(ExpectedConditions.attributeToBe(furnishingMenu, "aria-expanded", "true"));
		
	}
	
	public void displaySubMenu() {
		
		System.out.println("in display sub menu");
		
	    List<String> subItemList = new ArrayList<>();

	    List<WebElement> subItems = driver.findElements(By.xpath("//div[contains(@class,'BvXT1')]//a"));

	    System.out.println("before display sub menu for loop");
	    
	    for(WebElement item : subItems) {
	        
	    	System.out.println("in display sub menu for loop");
	    	String text = item.getText();
	        	System.out.println("in display sub menu if");
	        	System.out.println("text: " +text);
	            subItemList.add(text);
	            
	    }

	    // Display all subitems
	    System.out.println("Home Linen Sub Items:");
	    for (String subItem : subItemList) {
	    	System.out.println("Home Linen Sub Items:");
	        System.out.println(subItem);
	    }
		
	}	
}*/
package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollectionsSubMenu {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public CollectionsSubMenu(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // ✅ XPath taken from FurnishingMenu
    @FindBy(xpath = "//img[contains(@class,'vMDdy')]")
    private WebElement homeIcon;

    // ✅ XPath taken from FurnishingMenu
    @FindBy(xpath = "//span[normalize-space()='Furnishing']")
    private WebElement furnishingMenu;

    // ✅ Hover on Furnishing (IMPORTANT)
    public void clickCollections() {

        wait.until(ExpectedConditions.elementToBeClickable(homeIcon)).click();

        wait.until(ExpectedConditions.visibilityOf(furnishingMenu));
        actions.moveToElement(furnishingMenu).perform();

        // ensure submenu container appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='category-menu-10']/div[1]/div")));
    }

    // ✅ Print submenu items (using your FurnishingMenu container XPath)
    public void displaySubMenu() {

        System.out.println("Home Linen Sub Items:");

        List<String> subItemList = new ArrayList<>();

        WebElement submenuContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='category-menu-10']/div[1]/div")));

        List<WebElement> subItems = submenuContainer.findElements(By.tagName("a"));

        for (WebElement item : subItems) {
            String text = item.getText().trim();
            if (!text.isEmpty()) {
                subItemList.add(text);
            }
        }

        for (String item : subItemList) {
            System.out.println(item);
        }
    }
}