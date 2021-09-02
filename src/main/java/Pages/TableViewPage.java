package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TableViewPage {

    private static final ElementsCollection checkBoxes = $$(".checkbox-div");
    private static final SelenideElement tableViewButton = $x(" //div[@class ='toolbar__tabs']/a[2]");
    private static final SelenideElement deleteDealButton = $(".delete");
    private static final ElementsCollection dealNameColumn = $$("//td[@class='row__cell']");
    private static final SelenideElement table = $("#table");


    BasePage basePage = new BasePage();

   
    public String getDealNameFromTable() {

        return dealNameColumn.first().getText();
    }


    public TableViewPage setCheckBox() {

        checkBoxes.get(1).click();
        return this;

    }

    public TableViewPage clickDeleteButton() {

        basePage.click(deleteDealButton);
        return this;
    }


}

