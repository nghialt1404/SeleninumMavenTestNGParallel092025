package Bai26_ParallelExcution_POM.pages;

import keyword.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardPage extends BasePage {

    // Khai báo các element của trang Dashboard
    private By buttonDashboardOption = By.xpath("//div[@class='screen-options-btn']");
    private By labelTotalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");

    // Khai báo các hàm xử lý trong nội bộ trang Dashboard
    public void verifyDashBoardPageDisplay() {
        boolean isDashboardOptionDisplayed = WebUI.checkElementExist(buttonDashboardOption);
        Assert.assertTrue(isDashboardOptionDisplayed," Dashboard page is not displayed");
    }

    public void verifyTotalProjectsInProgress() {
        String totalProjectsOnDashboard = WebUI.getElementText(labelTotalProjectsInProgress);
        System.out.println("Total Projects on Dashboard: " + totalProjectsOnDashboard);

        //Click vào menu Projects để kiểm tra tổng số lượng trên trang Projects
        clickMenuProject();

        ProjectsPage projectsPage = new ProjectsPage();

        Assert.assertEquals(totalProjectsOnDashboard, projectsPage.getTotalProjectInProgress() + " / " + projectsPage.getTotalProjects(),
                "Total Projects on Dashboard does not match total Projects on Projects Page.");

    }

}
