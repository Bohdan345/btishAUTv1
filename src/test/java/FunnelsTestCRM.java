import Pages.CRMPage;
import Pages.LoginPage;
import Utils.MyListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Utils.RandomData.getRandomInt;
import static Utils.RandomData.getRandomName;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MyListener.class)
public class FunnelsTestCRM {

    @Order(2)
    @Test
    @Feature("Funnel")
    public void createFunnel() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String name = getRandomName();

        new LoginPage()
                .login();
        CRMPage crmPage = new CRMPage()
                .goToCrm()
                .clickFunnelDropDown()
                .clickNewPiplineButton()
                .setNameInputModal(name)
                .clickConfirmModalButton()

                .waitLoader()
                .clickFunnelDropDown();


        assertThat(name,
                is(containsString(crmPage.getCurrentNameFunnel()))
        );


    }

    @Order(1)
    @Test
    @Feature("Funnel")

    public void deleteFunnel() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        new LoginPage()
                .login();
        CRMPage crmPage = new CRMPage()
                .goToCrm()
                .clickFunnelDropDown()
                .getFunnel(3);
        String name = crmPage.getCurrentNameFunnel();

        crmPage.clickToolBarBtn()
                .clickDeleteFunnelButton()
                .clickConfirmModalButton()
                .clickFunnelDropDown();

        assertThat(name, not(containsString(crmPage.getCurrentNameFunnel())));


    }

    @Order(3)
    @Test
    @Feature("Funnel")

    public void renameFunnel() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        new LoginPage()

                .login();

        CRMPage crmPage = new CRMPage()
                .goToCrm()
                .clickFunnelDropDown()
                .getFunnel(2);
        String name = crmPage.getCurrentNameFunnel();

        crmPage.clickToolBarBtn()
                .setFunnelNameToolBar("Rename" + getRandomInt(1, 100))
                .backToCRMPage()
                .waitInvisibleLoader();

        assertThat(name, not(containsString(crmPage.getCurrentNameFunnel())));

    }


}
