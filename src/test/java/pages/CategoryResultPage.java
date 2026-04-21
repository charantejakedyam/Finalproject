package pages;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryResultPage {

    WebDriver driver;
    WebDriverWait wait;

    public CategoryResultPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@role='button' and @aria-label='Storage Type filter']")
    private WebElement storageTypeFilter;

	@FindBy(xpath = "//div[@id='dropdown-menu-storage-type']")
	private WebElement openStorageOption;

    @FindBy(id = "productsContainer")
    private WebElement productsContainer;

    @FindBy(xpath = "//div[@role='button' and @aria-label='Price']")
    private WebElement price;

    @FindBy(xpath = "//input[contains(@aria-label,'Minimum value')]")
    private WebElement setPrice;

    @FindBy(xpath = "//button[@data-testid='plp-filter-apply-button' and not(@disabled)]")
    private WebElement applySort;

    public void selectOpenStorage() {

        wait.until(ExpectedConditions.elementToBeClickable(storageTypeFilter)).click();
        wait.until(ExpectedConditions.elementToBeClickable(openStorageOption)).click();
        
    }

    public void setFilterByPrice() {

        wait.until(ExpectedConditions.elementToBeClickable(productsContainer)).click();

        wait.until(ExpectedConditions.elementToBeClickable(price)).click();
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(setPrice));

        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys("15000");

        wait.until(ExpectedConditions.elementToBeClickable(price)).click();

        wait.until(ExpectedConditions.elementToBeClickable(applySort)).click();
        
    }

	
    public void displayBookshelves() {

        Map<String, String> bookshelfMap = new LinkedHashMap<>();

        List<WebElement> products = driver.findElements(By.xpath("(//div[@role='link' and @aria-label])[position()<=3]"));

        for (WebElement product : products) {
            String name = product.getAttribute("aria-label");
            String price = product.findElement(By.xpath(".//div[contains(@class,'UYQNp')]")).getText();
            bookshelfMap.put(name, price);
        }

        for (Map.Entry<String, String> entry : bookshelfMap.entrySet()) {
            System.out.println("Name: " + entry.getKey() + " | Price: " + entry.getValue());
        }
    }
}
