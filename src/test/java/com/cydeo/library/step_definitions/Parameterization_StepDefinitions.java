package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class Parameterization_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user is on the Library Login page")
    public void user_is_on_the_library_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.app.url_1"));
    }

    @When("user enters librarian username {string}")
    public void user_enters_librarian_username(String string) {
        loginPage.inputUsername.sendKeys(string);

    }

    @When("user enters librarian password {string}")
    public void user_enters_librarian_password(String string) {
        loginPage.inputPassword.sendKeys(string);
        loginPage.signInButton.click();
    }

    @Then("user should see the title {string}")
    public void user_should_see_the_title(String string) {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Library"));

        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle= "Library";

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("user enters student username {string}")
    public void user_enters_student_username(String string) {
        loginPage.inputUsername.sendKeys(string);
    }

    @When("user enters student password {string}")
    public void user_enters_student_password(String string) {
        loginPage.inputPassword.sendKeys(string);
        loginPage.signInButton.click();
    }

    @Then("user should see the the title {string}")
    public void user_should_see_the_the_title(String string) {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Library"));
        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle= "Library";

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String string, String string2) {
        loginPage.inputUsername.sendKeys(string);
        loginPage.inputPassword.sendKeys(string2);

    }

    @And("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        loginPage.signInButton.click();
    }

    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {

        String userNumber=dashboardPage.userNumber.getText();

        Integer actualUserNumber= Integer.valueOf(userNumber);
        Integer expectedUserNumber = int1;

        Assert.assertEquals(expectedUserNumber,actualUserNumber);

    }

    @When("librarian enter below credentials")
    public void librarian_enter_below_credentials(Map<String,String> credentials1) {

        loginPage.inputUsername.sendKeys(credentials1.get("username"));
        loginPage.inputPassword.sendKeys(credentials1.get("password"));
        loginPage.signInButton.click();

    }



    @When("student enter below credentials")
    public void student_enter_below_credentials(Map<String,String> credentials2) {
        loginPage.inputUsername.sendKeys(credentials2.get("username"));
        loginPage.inputPassword.sendKeys(credentials2.get("password"));

        loginPage.signInButton.click();

    }


    @Then("user should see the the title is {string}")
    public void user_should_see_the_the_title_is(String string) {

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Library"));
        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle= "Library";

        Assert.assertEquals(expectedTitle,actualTitle);

    }


}
