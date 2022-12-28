package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.google.GooglePage;
import pages.google.GoogleResultPage;
import pages.skySports.SkySportsFootballPage;
import pages.skySports.SkySportsPage;

public class SkySportsTestCase extends AbstractTest {

    private final static String SEARCH_TEXT = getConfig("testParams.SEARCH_TEXT");
    private final static String SPORTS = getConfig("testParams.SPORTS");
    private final static String FOOTBALL = getConfig("testParams.FOOTBALL");
    private final static String NEWS = getConfig("testParams.NEWS");
    private final static String BASE_URL = getConfig("testParams.BASE_URL");

    @Test
    @Description("This is my Selenide TEST - get 3 latest football news on Sky Sports")
    @Owner("JaanTesting")
    @Step("Running ...")
    @Attachment(value = "ScreenShot", type = "image/png", fileExtension = ".png")
    public void thisIsMySelenideTest() {

        GooglePage googlePage = new GooglePage(BASE_URL);

        googlePage
                .acceptCookies();
        GoogleResultPage googleResultPage =
                googlePage
                        .searchFor(SEARCH_TEXT);

        SkySportsPage skySportsPage =
                googleResultPage
                        .findAndClickResult(SEARCH_TEXT)
                        .acceptCookies();

        SkySportsFootballPage skySportsFootballPage =
                skySportsPage
                        .clickOnNavBar(SPORTS)
                        .clickInSubMenu(FOOTBALL);

        skySportsFootballPage
                .clickOnNavBar(NEWS);

        skySportsFootballPage.isLatestNewsHeaderDisplayed();
        skySportsFootballPage.Are3LatestNewsDisplayed();
    }
}
