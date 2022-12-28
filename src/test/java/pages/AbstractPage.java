package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class AbstractPage {

    protected void safeClick(SelenideElement element) {
        element.shouldBe(Condition.interactable, Duration.ofSeconds(10)).click();
    }
}

