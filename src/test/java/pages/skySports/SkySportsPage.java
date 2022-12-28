package pages.skySports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.AbstractPage;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class SkySportsPage extends AbstractPage {
    @Step("Accepting Sky Sports cookies")
    public SkySportsPage acceptCookies() {
        Selenide.switchTo().frame("sp_message_iframe_734511");
        safeClick($("button[title=\"Accept all\"]"));

        return page(this);
    }
    @Step("Choosing the navBar menu ...")
    public SkySportsPage clickOnNavBar(String string) {
        ElementsCollection navBar = $$("[class=site-nav-desktop__item]");
        $("[class=site-nav-desktop__item]").shouldBe(Condition.visible, Duration.ofSeconds(10));

        for (SelenideElement el: navBar) {
            if (Objects.equals(string, el.getText())) {
                safeClick(el);
                $("#site-nav-desktop-sports-more-nav").shouldBe(Condition.visible, Duration.ofSeconds(10));
                return page(this);
            }
        }
        return null;
    }
    @Step("Choosing the navBar subMenu ...")
    public SkySportsFootballPage clickInSubMenu(String string) {
        ElementsCollection navBar = $$("#site-nav-desktop-sports-more-nav li");

        for (SelenideElement el: navBar) {
            if (Objects.equals(string, el.getText())) {
                safeClick(el);

                return page(SkySportsFootballPage.class);
            }
        }
        return null;
    }
}
