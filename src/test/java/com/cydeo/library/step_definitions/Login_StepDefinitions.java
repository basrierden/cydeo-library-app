package com.cydeo.library.step_definitions;

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

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the library login page")
    public void user_is_on_the_library_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.app.url_1"));
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("librarian.username"));
    }

    @And("user enters librarian password")
    public void user_enters_librarian_password() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("librarian.password"));
        loginPage.signInButton.click();
    }

    @When("user enters student username")
    public void user_enters_student_username() {
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("student.username"));
    }

    @And("user enters student password")
    public void user_enters_student_password() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("student.password"));
        loginPage.signInButton.click();
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Library"));

        String expectedTitle= "Library";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }



}
