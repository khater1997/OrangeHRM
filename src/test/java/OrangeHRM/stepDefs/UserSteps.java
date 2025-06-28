package OrangeHRM.stepDefs;

import OrangeHRM.Pages.AdminPage;
import OrangeHRM.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserSteps {
    int initialRecords;
    LoginPage loginPage = new LoginPage(Hooks.driver);
    AdminPage adminPage = new AdminPage(Hooks.driver);

    @When("User login with username {string} and password {string}")
    public void user_login_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @And("User Click to Admin Button and Navigate to Admin Section")
    public void userClickToAdminButtonAndNavigateToAdminSection() {
        adminPage.goToAdmin();
    }

    @And("User get the current number of records found in the Admin Section")
    public void userGetTheCurrentNumberOfRecordsFoundInTheAdminSection() {
        initialRecords = adminPage.getNumberOfRecords();
        System.out.println("No.existing Records =" + initialRecords);    // print The Number of founded Records
    }

    @And("User add a new user with username {string} and password {string} and confirm password {string}")
    public void userAddANewUserWithUsernameAndPasswordAndConfirmPassword(String userName, String pass, String confirmPass) {
        adminPage.clickOnAddButton();
        adminPage.clickOnUserRoleList("Admin");
        adminPage.employeeName("Orange");
        adminPage.selectStatus("Enabled");
        adminPage.newUser(userName, pass, confirmPass);
        adminPage.saveUser();
    }

    @Then("User Verify that the number of records increased by one after adding the user")
    public void userVerifyThatTheNumberOfRecordsIncreasedByOneAfterAddingTheUser() {
        int updatedRecordsNumber = adminPage.getNumberOfRecords();
        Assert.assertEquals(updatedRecordsNumber, initialRecords + 1);
        System.out.println("No.Records after adding = " + updatedRecordsNumber);   // print the number of record after adding the new user
    }

    @When("User search for the user {string}")
    public void userSearchForTheUser(String searchName) throws InterruptedException {
        adminPage.searchByUsername(searchName);
        adminPage.clickOnSearchButton();
    }

    @And("User delete the user")
    public void userDeleteTheUser() {
        adminPage.deleteUser();
    }

    @And("User Reset the search to get all records list")
    public void userResetTheSearchToGetAllRecordsList() throws InterruptedException {
        adminPage.clickOnResetButton();
    }

    @Then("User Verify that the number of records decreased by one after deleting the user")
    public void userVerifyThatTheNumberOfRecordsDecreasedByOneAfterDeletingTheUser() {
        int finalRecords = adminPage.getNumberOfRecords();
        Assert.assertEquals(finalRecords, initialRecords);
        System.out.println("No.Records after deleting =  " + finalRecords);          // print the number of record after removing the new user
    }

}
