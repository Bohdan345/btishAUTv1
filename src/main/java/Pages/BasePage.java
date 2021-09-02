package Pages;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static ReadData.DataFromProperty.BROWSER;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {


    protected void startBrowser(String url) {

        Configuration.browser = BROWSER;
        Configuration.startMaximized = true;
        Configuration.timeout = Duration.of(30, ChronoUnit.SECONDS).toMillis();
        open(url);

    }


    public void clickAndChooseFirstItem(ElementsCollection elements) {
        elements.first().shouldBe(enabled).click();
    }

    public void click(SelenideElement element) {
        element.shouldBe(enabled).click();
    }

    public void setValue(SelenideElement element, String text) {
        element.shouldBe(visible).setValue(text);
    }

    public void setValueAndPressEnter(SelenideElement element, String text) {
        element.shouldBe(visible).val(text).pressEnter();
    }

    protected void cleanInput(SelenideElement element) {
        element.shouldBe(visible).clear();
    }

    protected void dragAndDrop(SelenideElement element, SelenideElement target) {
        actions().moveToElement(element).clickAndHold().moveToElement(target).release().perform();

    }


    public static void destroy() {
        Selenide.closeWebDriver();

    }

}
