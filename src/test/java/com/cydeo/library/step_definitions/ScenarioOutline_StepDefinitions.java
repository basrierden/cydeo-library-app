package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScenarioOutline_StepDefinitions {

    LoginPage loginPage= new LoginPage();
    DashboardPage dashboardPage= new DashboardPage();

    @Given("I am on the Login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.app.url_2"));
    }


    @When("I login the page using {string} and {string}")
    public void i_login_the_page_using_and(String string, String string2) {
        loginPage.inputUsername.sendKeys(string);
        loginPage.inputPassword.sendKeys(string2);
        loginPage.signInButton.click();
    }


    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String string) {

        String actualUserName= dashboardPage.userName.getText();
        System.out.println("actualUserName = " + actualUserName);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.userName));
        Assert.assertEquals(string, actualUserName);

    }


}
