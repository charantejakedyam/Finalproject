package test_cases;

import org.testng.annotations.Test;
import pages.GiftCardPage;

public class GiftCardTest extends BaseTest {
  @Test(priority = 4, dependsOnMethods = {"testHomePage"})
  public void giftCardFromFill() throws Exception {
	  GiftCardPage g = new GiftCardPage(driver);
	  
	  g.navigateToGiftPage();
	  Thread.sleep(2000);
	  g.enterDetails();
	  Thread.sleep(2000);
	  g.takeScreenshot();
	  Thread.sleep(2000);
	  g.printErrorMsg();
	  Thread.sleep(2000);
//	  g.clickPreviewBtn();
	  
  }
}
