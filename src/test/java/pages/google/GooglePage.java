package pages.google;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.page;

public class GooglePage extends AbstractPage {

    private final SelenideElement googleLogo = Selenide.$("#hplogo");

    public GooglePage(String page) {
        Selenide.open(page);
    }

    @Step("Accepting Google cookies ...")
    public GooglePage acceptCookies() {
        safeClick(Selenide.$("#CXQnmb #L2AGLb"));

        return this;
    }

    @Step("Searching Google for ...")
    public GoogleResultPage searchFor(String text) {
        WebElement search = Selenide.$("input[class=gLFyf]");

        search.clear();
        search.sendKeys(text);
        search.submit();

        return page(GoogleResultPage.class) ;
    }
}


