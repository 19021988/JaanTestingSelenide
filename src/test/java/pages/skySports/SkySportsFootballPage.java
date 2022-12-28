package pages.skySports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.AbstractPage;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class SkySportsFootballPage extends AbstractPage {
    @Step("Navigating to NEWS ...")
    public SkySportsFootballPage clickOnNavBar(String string) {
        ElementsCollection navBar = $$("[class=\"page-nav__frame\"] li");

        for (SelenideElement el: navBar) {
            if (Objects.equals(string, el.getText())) {
                safeClick(el);

                return page(this);
            }
        }
        return null;
    }

    public ElementsCollection latestNews = $$("[class*=\"news-list__item\"] h4 a");
    @Step("Is the 'latest' header there ?")
    public void isLatestNewsHeaderDisplayed() {
        $("h3[class=\"page-filters__title\"]").shouldBe(Condition.visible);
    }
    @Step("Are the news there ?")
    public void Are3LatestNewsDisplayed() {
        if ($("span[data-role=\"new-items-count\"]").isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                System.out.println(latestNews.get(i).shouldBe(Condition.visible).getText());
            }
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.println(latestNews.get(i).shouldBe(Condition.exist).getText());
            }
        }
    }
}
