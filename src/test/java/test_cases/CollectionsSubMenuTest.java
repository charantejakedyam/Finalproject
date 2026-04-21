package test_cases;

import org.testng.annotations.Test;

import pages.CollectionsSubMenu;

public class CollectionsSubMenuTest extends BaseTest {
    
  @Test(priority = 3, dependsOnMethods = {"testHomePage"})
  public void testCollectionsSubmenu() throws InterruptedException {
      CollectionsSubMenu c = new CollectionsSubMenu(driver);
      c.clickCollections();
      Thread.sleep(2000);
      c.displaySubMenu();
  }
}