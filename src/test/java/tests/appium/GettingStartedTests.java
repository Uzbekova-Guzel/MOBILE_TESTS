package tests.appium;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tags({@Tag("emulator"),@Tag("device")})
public class GettingStartedTests extends TestBase {

    @DisplayName("Verify primaryTextView in Wikipedia")
    @Test
    @Feature("Wikipedia tests")
    @Story("Mobile tests")
    @Owner("UzbekovaGV")
    void gettingStartedTest() {
        String firstPageText = "The Free Encyclopedia …in over 300 languages";
        String secondPageText = "New ways to explore";
        String pageThreeText = "Reading lists with sync";
        String pageFourText = "Send anonymous data";

        step("Check " + firstPageText + " text and tap Continue", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text(firstPageText));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check " + secondPageText + " text and tap Continue", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text(secondPageText));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check " + pageThreeText + " text and tap Continue", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text(pageThreeText));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check " + pageFourText + " text", () ->
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text(pageFourText)));
    }

    @DisplayName("Verify skip button")
    @Test
    @Feature("Wikipedia tests")
    @Story("Mobile tests")
    @Owner("UzbekovaGV")
    void skipButtonTest() {
        step("Click onboarding skip button", () ->
            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).shouldBe(visible).click());
        step("Check click", () ->
            $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldBe(exist));
    }
}