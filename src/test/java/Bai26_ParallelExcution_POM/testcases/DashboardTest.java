package Bai26_ParallelExcution_POM.testcases;

import common.BaseTest;
import Bai26_ParallelExcution_POM.pages.DashboardPage;
import Bai26_ParallelExcution_POM.pages.LoginPage;
import Bai26_ParallelExcution_POM.pages.ProjectsPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    private LoginPage loginpage;
    private DashboardPage dashboardpage;
    private ProjectsPage projectsPage;

    @Test
    public void testLabelProjectInProgress() {
        loginpage = new LoginPage();

        dashboardpage = loginpage.loginCRM();

        dashboardpage.verifyDashBoardPageDisplay();
        dashboardpage.verifyTotalProjectsInProgress();

    }



}
