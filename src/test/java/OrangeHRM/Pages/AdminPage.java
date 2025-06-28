package OrangeHRM.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage {
    WebDriver driver;
    private By adminTab = By.xpath("//span[text()='Admin']");
    private By userRows = By.xpath("//div[@class='oxd-table-body']/div");
    private By addButtonTab = By.xpath("//button[normalize-space()='Add']");
    private By userRoleList = By.xpath("//label[text()='User Role']/following::div[contains(@class,'oxd-select-text-input')][1]");
    private By roleOptions = By.xpath("//div[@role='option']/span");
    private By statusList = By.xpath("//label[text()='Status']/following::div[contains(@class,'oxd-select-text-input')][1]");
    private By statusOptions = By.xpath("//div[@role='option']/span");
    private By empName = By.xpath("//input[@placeholder='Type for hints...']");
    private By newUsername = By.xpath("//label[text()='Username']/following::input[1]");
    private By newPassword = By.xpath("//label[text()='Password']/following::input[1]");
    private By passwordConfirmation = By.xpath("//label[text()='Confirm Password']/following::input[1]");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");
    private By searchUsernameField = By.xpath("//label[text()='Username']/following::input[1]");
    private By searchButton = By.xpath("//button[normalize-space()='Search']");
    private By deleteButton = By.xpath("//i[@class='oxd-icon bi-trash']");
    private By confirmButton = By.xpath("//button[normalize-space()='Yes, Delete']");
    private By resetButton = By.xpath("//button[normalize-space()='Reset']");


    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAdmin() {
        driver.findElement(adminTab).click();
    }

    public int getNumberOfRecords() {
        return driver.findElements(userRows).size();
    }

    public void clickOnAddButton() {
        driver.findElement(addButtonTab).click();
    }

    public void clickOnUserRoleList(String roleName) {

        driver.findElement(userRoleList).click();   // Click to expand the dropdown

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));     // Wait for options to become visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(roleOptions));

        List<WebElement> options = driver.findElements(roleOptions);    // Click the desired option
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(roleName)) {
                option.click();
                break;
            }
        }
    }

    public void employeeName(String eName) {
        driver.findElement(empName).sendKeys(eName);      // send the name as input to search
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));      // Wait for the input field to be visible

        WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@role='listbox']//span[contains(text(),'" + eName + "')]")
        ));                                                                    // Wait for the dropdown to populate suggestions

        suggestion.click();                                                     // Click the needed suggestion to select it

    }

    public void selectStatus(String status) {

        driver.findElement(statusList).click();      // Click to expand

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));             // Wait until options are visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(statusOptions));

        for (WebElement option : driver.findElements(statusOptions)) {
            if (option.getText().equalsIgnoreCase(status)) {
                option.click();     // Iterate options and click matching
                break;
            }

        }
    }

    public void newUser(String userName, String pass, String confirmPass) {
        driver.findElement(newUsername).sendKeys(userName);
        driver.findElement(newPassword).sendKeys(pass);
        driver.findElement(passwordConfirmation).sendKeys(confirmPass);
    }

    public void saveUser() {
        driver.findElement(saveButton).click();
    }

    public void searchByUsername(String searchName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchUsernameField));
        searchInput.sendKeys(searchName);

    }

    public void clickOnSearchButton() throws InterruptedException {
        driver.findElement(searchButton).click();
        Thread.sleep(2000);
    }


    public void deleteUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(deleteButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }
    public void clickOnResetButton() throws InterruptedException {
        driver.findElement(resetButton).click();
        Thread.sleep(2000);
    }
}
