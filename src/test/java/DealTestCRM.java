import Pages.CRMPage;
import Pages.LoginPage;
import Pages.TableViewPage;
import Utils.MyListener;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.extension.ExtendWith;

import static Utils.RandomData.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MyListener.class)
public class DealTestCRM {


    @Ignore
    public void createDeal() {

    }


    public void createQuickDeal() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String name = getRandomName();
        new LoginPage()
                .login();

        CRMPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickQuickDealBtn()
                .setDealName(name)
                .setDealPrice(String.valueOf(getRandomInt(1, 100)))
                .setDealProspect(getRandomName())
                .setDealEmail(getRandomEmail())
                .clickProspectDropDown()
                .chooseFirstProspectList()
                .clickSaveQuickDealBtn();
        assertThat(name, is(containsString(crm.getDealFromStage(name))));


    }

    /**
     * @Test public void removeDealDragAndDrop() {
     * <p>
     * <p>
     * new LoginPage()
     * .login();
     * <p>
     * CRMPage crm = new CRMPage()
     * .goToCrm()
     * .waitLoader();
     * crm.moveDealToDeleteZone();
     * Selenide.sleep(3000);
     * <p>
     * }
     **/

    @Ignore
    public void removeDealFromTable() {
        new LoginPage()
                .login();

        TableViewPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickTableViewBtn()
                .setCheckBox();
        Selenide.sleep(3000);


    }


    @Ignore
    public void bulkRemoveDeal() {
    }

}
