package pages;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchInput")
    private WebElement searchBox;

    public void enterCategory(String category) {
        WebElement box = wait.until(ExpectedConditions.visibilityOf(searchBox));
        box.clear();
        wait.until(ExpectedConditions.elementToBeClickable(box))
            .sendKeys(category + Keys.ENTER);
    }
}