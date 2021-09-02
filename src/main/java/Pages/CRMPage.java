package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CRMPage {


    private static final SelenideElement crmLoader = $x(" //div[@class='loader']");
    private static final SelenideElement quickAddButton = $(".deal__quick");
    private static final SelenideElement dealNameInput = $x("//input[@placeholder = 'Deal name']");
    private static final SelenideElement priceInput = $x("//input[@placeholder='$0']");
    private static final SelenideElement nameProspectInput = $x("//input[@placeholder='Prospect name']");
    private static final SelenideElement emailProspectInput = $x("//input[@placeholder='Prospect email']");
    private static final SelenideElement prospectsListDropDown = $x("//input[@placeholder='Prospect list']");
    private static final SelenideElement saveQickDeal = $x(" //div[@class='deal__btns']/button[1]");
    private static final ElementsCollection nameDeals = $$("[data-index='0'].deal__name");
    private static final SelenideElement funnelDropDown = $(".toolbar__funnels");
    private static final ElementsCollection funnelList = $$x(".//ul[@class= 'snovio-dropdown__list']/li");
    private static final SelenideElement newPipelineButton = $x("//span[text()='New pipeline']");
    private static final SelenideElement pipelineModal = $x("//div[text()='Add new pipeline']");
    private static final SelenideElement modalNameInput = $(".snovio-modal__window input");
    private static final SelenideElement funnelName = $(".snovio-dropdown__name");
    private static final SelenideElement modalConfirmButton = $(".snovio-btn--gray + button");
    private static final ElementsCollection prospectsLists = $$x("//div[@class='deal__create']//ul[@class='snovio-dropdown__list']");
    private static final ElementsCollection createdDeals = $$(".deal__name");
    private static final ElementsCollection listSticky = $$(".snovio-dropdown__list--sticky    span");
    private static final SelenideElement dealTitle = $(".deal-head__name");
    private static final SelenideElement checkIcon = $(".icon-small");
    private static final SelenideElement toolBarSettings = $(".toolbar__settings");
    private static final SelenideElement errorsSnovio = $(".snovio-input__error");
    private static final SelenideElement leadInFirstDeal = $("//div[@class='deal'][2]//div[@class='deal__name']");
    private static final SelenideElement deleteZone = $x("//div[@data-status='delete'])");
    private static final SelenideElement tableViewButton = $x(" //div[@class ='toolbar__tabs']/a[2]");


    BasePage basePage = new BasePage();


    public TableViewPage clickTableViewBtn() {
        basePage.click(tableViewButton);
        return new TableViewPage();
    }

    public CRMPage moveDealToDeleteZone() {
        basePage.dragAndDrop(leadInFirstDeal, deleteZone);
        return this;
    }


    public String getDealFromStage(String dealName) {
        return createdDeals.findBy(exactText(dealName)).getText();
    }

    public CRMPage clickQuickDealBtn() {
        basePage.click(quickAddButton);
        return this;

    }

    public CRMPage setDealName(String name) {
        basePage.cleanInput(dealNameInput);
        basePage.setValue(dealNameInput, name);

        return this;

    }

    public CRMPage setDealPrice(String price) {
        basePage.cleanInput(priceInput);
        basePage.setValue(priceInput, price);


        return this;

    }

    public CRMPage setDealProspect(String name) {
        basePage.cleanInput(nameProspectInput);
        basePage.setValue(nameProspectInput, name);

        return this;

    }

    public CRMPage setDealEmail(String email) {
        basePage.cleanInput(emailProspectInput);
        basePage.setValue(emailProspectInput, email);
        return this;
    }


    public CRMPage clickProspectDropDown() {
        basePage.click(prospectsListDropDown);
        return this;
    }

    public CRMPage chooseFirstProspectList() {
        basePage.clickAndChooseFirstItem(prospectsLists);
        return this;

    }

    public CRMPage clickSaveQuickDealBtn() {
        basePage.click(saveQickDeal);
        return this;
    }


    public String getErrorsText() {
        String text = errorsSnovio.getText();
        return text;
    }

    public int getFunnelNumber() {
        int size = funnelList.size();
        return size;
    }


    public CRMPage clickFunnelDropDown() {

        basePage.click(funnelDropDown);
        return this;
    }

    public CRMPage checkChooseIcon() {
        basePage.click(checkIcon);
        return this;
    }

    public CRMPage checkIconVisible() {
        funnelDropDown.click();
        checkIcon.shouldBe(visible);
        return this;
    }


    public CRMPage clickNewPiplineButton() {
        listSticky.findBy(exactText("New pipeline")).click();
        return this;
    }


    public CRMPage setNameInputModal(String text) {
        modalNameInput.val(text);
        return this;
    }


    public CRMPage clickConfirmModalButton() {
        basePage.click(modalConfirmButton);
        return this;
    }


    public CRMPage getFirstFunnel() {
        funnelList.first().shouldBe(visible).click();
        return this;
    }


    public CRMPage waitLoader() {
        crmLoader.shouldNotBe(visible);
        return this;
    }


    public String getCurrentNameFunnel() {
        return funnelName.shouldBe(visible).getText();
    }


    public CRMPage waitInvisibleLoader() {
        crmLoader.shouldNotBe(visible);
        return this;
    }

    public ToolBarSettingsPage clickToolBarBtn() {
        toolBarSettings.shouldBe(enabled).click();
        return new ToolBarSettingsPage();

    }

    public CRMPage goToCrm() {
        basePage.startBrowser("https://preprod.snov.io/crm");
        crmLoader.shouldNotBe(visible);
        return new CRMPage();
    }


}


