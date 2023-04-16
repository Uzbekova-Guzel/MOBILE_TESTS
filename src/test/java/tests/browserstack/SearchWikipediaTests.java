package tests.browserstack;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;


public class SearchWikipediaTests extends TestBase {

    @DisplayName("Verify content found in Search Wikipedia")
    @Test
    @Tag("android")
    @Feature("Wikipedia tests")
    @Story("Mobile tests")
    @Owner("UzbekovaGV")
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
        });
        step("Check content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @DisplayName("Verify error first page in Search Wikipedia")
    @Test
    @Tag("android")
    @Feature("Wikipedia tests")
    @Story("Mobile tests")
    @Owner("UzbekovaGV")
    void unSuccessfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("JUnit");
        });
        step("Open first page", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click()
        );
        step("Check error message in page", () ->
                $(id("org.wikipedia.alpha:id/view_wiki_error_text"))
                        .shouldHave(exactText("An error occurred"))
        );
    }

    @DisplayName("Verify output text in Search Wikipedia")
    @Test
    @Tag("ios")
    @Feature("Wikipedia tests")
    @Story("Mobile tests")
    @Owner("UzbekovaGV")
    public void searchTest() {
        step("iOS type search", () -> {
            $(id("Text Button")).click();
            $(id("Text Input")).sendKeys("FITMOST");
            $(id("Text Input")).pressEnter();
        });
        step("Check output text", () -> {
            $(id("Text Output")).shouldHave((text("FITMOST")));
        });
    }
}