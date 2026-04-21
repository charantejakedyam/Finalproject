package test_cases;

import org.testng.annotations.Test;
import pages.CategoryResultPage;

public class CategoryResultPageTest extends BaseTest {
	
	@Test(priority = 2, dependsOnMethods = {"testHomePage"})
	public void testHotelResults() throws InterruptedException {
		CategoryResultPage p=new CategoryResultPage(driver);
		p.selectOpenStorage();
		p.setFilterByPrice();
		Thread.sleep(2000);
		p.displayBookshelves();
	}
}
