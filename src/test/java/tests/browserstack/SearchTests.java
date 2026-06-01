package tests.browserstack;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.xpath;

public class SearchTests extends TestBase {

    @Test
    void openArticleTest() {
        step("Wait for onboarding and close it with Android Back", () -> {
            Selenide.back();
        });

        step("Open search tab and type search", () -> {
            $(id("org.wikipedia.alpha:id/nav_tab_search"))
                    .shouldBe(visible)
                    .click();

            $(id("org.wikipedia.alpha:id/search_card"))
                    .shouldBe(visible)
                    .click();

            $(id("org.wikipedia.alpha:id/search_src_text"))
                    .shouldBe(visible)
                    .sendKeys("Appium");
        });

        step("Open article page", () -> {
            $(xpath("//android.widget.TextView[@text='Appium']/.."))
                    .shouldBe(visible)
                    .click();
        });

        step("Verify article opened", () -> {
            $(id("org.wikipedia.alpha:id/page_contents_container"))
                    .shouldBe(exist);
        });
    }
}