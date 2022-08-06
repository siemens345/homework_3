package githubsearch;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class GithubSearch {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void searchSelenide() {
        open("/selenide/selenide");
        $(By.id("wiki-tab")).click();
        $(byCssSelector(".js-wiki-more-pages-link")).click();
        $(byCssSelector(".Box--condensed")).shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();
        $(By.id("wiki-body")).shouldHave(text("Using JUnit5 extend test class"));
    }

    @AfterAll
    static void closing() {
        closeWebDriver();
    }
}

