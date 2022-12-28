package pages.google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.AbstractPage;
import pages.skySports.SkySportsPage;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.page;

public class GoogleResultPage extends AbstractPage {

    private final ElementsCollection resultLinks = Selenide.$$("#search #rso a [role=text]");
    @Step("Looking for the correct result and CLICK")
    public SkySportsPage findAndClickResult(String text) {

        for (SelenideElement el: resultLinks) {
            if (Objects.equals("https://www."+text+".com", el.getText())) {
                safeClick(el);

                return page(SkySportsPage.class);
            }
        }
        return null;
    }
}
