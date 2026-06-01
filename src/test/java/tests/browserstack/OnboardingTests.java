package tests.browserstack;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.xpath;

public class OnboardingTests extends TestBase {

    @Test
    void successfulOnboardingTest() {
        step("Verify first onboarding screen", () -> {
            $(xpath("//android.widget.TextView[@text=\"All the world's knowledge\"]"))
                    .shouldBe(visible);
        });

        step("Go to second onboarding screen", () -> {
            $(accessibilityId("Forward"))
                    .shouldBe(visible)
                    .click();
        });

        step("Verify second onboarding screen", () -> {
            $(xpath("//android.widget.TextView[@text='Data & Privacy']"))
                    .shouldBe(visible);
        });

        step("Go to third onboarding screen", () -> {
            $(accessibilityId("Forward"))
                    .shouldBe(visible)
                    .click();
        });

        step("Verify third onboarding screen", () -> {
            $(xpath("//android.widget.TextView[@text='Read in more than 300 languages']"))
                    .shouldBe(visible);
        });

        step("Go to fourth onboarding screen", () -> {
            $(accessibilityId("Forward"))
                    .shouldBe(visible)
                    .click();
        });

        step("Verify fourth onboarding screen", () -> {
            $(xpath("//android.widget.TextView[@text='Follow your curiosity']"))
                    .shouldBe(visible);
        });
    }
}