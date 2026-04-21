package stepdefinitions;

import io.cucumber.java.en.*;

import pages.HomePage;
import pages.CategoryResultPage;
import pages.CollectionsSubMenu;
import pages.GiftCardPage;

public class EndToEndSteps {

    HomePage homePage;
    CategoryResultPage categoryResultPage;
    CollectionsSubMenu collectionsSubMenu;
    GiftCardPage giftCardPage;

    // ✅ Step 1: Home page
    @Given("user is on UrbanLadder home page")
    public void user_is_on_urban_ladder_home_page() {
        // Driver already initialized in Hooks
        homePage = new HomePage(Hooks.driver);
    }

    // ✅ Step 2: Search category
    @When("user searches for {string}")
    public void user_searches_for_category(String category) {
        homePage.enterCategory(category);
    }

    // ✅ Step 3: Apply filters and display products
    @And("user applies storage and price filters")
    public void user_applies_filters_and_views_products() {

        categoryResultPage = new CategoryResultPage(Hooks.driver);

        categoryResultPage.selectOpenStorage();
        categoryResultPage.setFilterByPrice();
        categoryResultPage.displayBookshelves();
    }

    // ✅ Step 4: Collections submenu
    @And("user views collections submenu")
    public void user_views_collections_submenu() {

        collectionsSubMenu = new CollectionsSubMenu(Hooks.driver);

        collectionsSubMenu.clickCollections();
        collectionsSubMenu.displaySubMenu();
    }

    // ✅ Step 5: Gift card validation
    @Then("user validates gift card flow")
    public void user_validates_gift_card_flow() throws Exception {

        giftCardPage = new GiftCardPage(Hooks.driver);

        giftCardPage.navigateToGiftPage();
        giftCardPage.enterDetails();
        giftCardPage.takeScreenshot();
        giftCardPage.printErrorMsg();
    }
}
