package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class ToolBarSettingsPage {

    private static final SelenideElement deleteFunnelButton = $(".toolbar__delete");
    private static final SelenideElement modalConfirmButton = $(".snovio-btn--gray + button");
    private static final SelenideElement modalNameInput = $(".snovio-modal__window input");
    private static final SelenideElement funnelNameToolBar = $(".toolbar__name input");
    private static final SelenideElement backBtn = $("#backId");

    BasePage basePage = new BasePage();

    public void setNameInputModal(String text) {
        modalNameInput.val(text);

    }


    public CRMPage clickConfirmModalButton() {
        modalConfirmButton.shouldBe(enabled).click();
        return new CRMPage();
    }

    public ToolBarSettingsPage clickDeleteFunnelButton() {
        deleteFunnelButton.shouldBe(enabled).click();
        return this;
    }


    public ToolBarSettingsPage setFunnelNameToolBar(String name) {
        basePage.click(funnelNameToolBar);
        basePage.cleanInput(funnelNameToolBar);
        basePage.setValue(funnelNameToolBar, name);
        return this;
    }

    public CRMPage backToCRMPage() {
        backBtn.shouldBe(enabled).click();
        return new CRMPage();
    }

}
