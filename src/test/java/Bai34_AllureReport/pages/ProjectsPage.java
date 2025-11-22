package Bai34_AllureReport.pages;


import keyword.WebUI;
import org.openqa.selenium.By;

public class ProjectsPage extends BasePage {

    //Khai báo các element của trang Projects
    private By labelProjectToNotStarted = By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='Not Started'])/preceding-sibling::span");
    private By labelProjectToInProgress = By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='In Progress'])/preceding-sibling::span");
    private By labelProjectToFinished = By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='Finished'])/preceding-sibling::span");
    private By labelProjectToOnHold = By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='On Hold'])/preceding-sibling::span");
    private By labelProjectToCancelled = By.xpath("(//div[@class='_filters _hidden_inputs']//span[normalize-space()='Cancelled'])/preceding-sibling::span");

    // Khai báo các hàm xử lý trong nội bộ trang Projects

    public String getTotalProjectNotStarted() {
        String totalProject_NotStarted = WebUI.getElementText(labelProjectToNotStarted);
        return totalProject_NotStarted;
    }
    public String getTotalProjectInProgress() {
        String totalProject_Inprogess = WebUI.getElementText(labelProjectToInProgress);
        return totalProject_Inprogess;
    }
    public String getTotalProjectFinished() {
        String totalProject_Finished = WebUI.getElementText(labelProjectToFinished);
        return totalProject_Finished;
    }
    public String getTotalProjectOnHold() {
        String totalProject_OnHold = WebUI.getElementText(labelProjectToOnHold);
        return totalProject_OnHold;
    }
    public String getTotalProjectCancelled() {
        String totalProject_Cancelled = WebUI.getElementText(labelProjectToCancelled);
        return totalProject_Cancelled;
    }
    public String getTotalProjects(){
        int totalProjects = Integer.parseInt(getTotalProjectNotStarted()) +
                Integer.parseInt(getTotalProjectInProgress()) +
                Integer.parseInt(getTotalProjectFinished()) +
                Integer.parseInt(getTotalProjectOnHold()) +
                Integer.parseInt(getTotalProjectCancelled());
        return String.valueOf(totalProjects);
    }
}

