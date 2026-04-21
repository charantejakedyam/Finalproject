package test_cases;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;

public class HomePageTest extends BaseTest {
	
	@Test(priority = 1)
	public void testHomePage() throws Exception {
			HomePage h=new HomePage(driver);
			ConfigReader readData=new ConfigReader();
			String category=readData.getCategory();
			h.enterCategory(category);
	}
	
}
