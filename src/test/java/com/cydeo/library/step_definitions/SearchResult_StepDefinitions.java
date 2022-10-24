package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResult_StepDefinitions {

    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage= new DashboardPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.app.url_1"));
    }

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("librarian.username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("librarian.password"));
        loginPage.signInButton.click();
    }

    @Given("I click on Users link")
    public void i_click_on_users_link() {
        dashboardPage.usersLink.click();
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {

        List<String> actualColumnNames= new ArrayList<>();


        for (WebElement eachColumnName : dashboardPage.actualColumns) {
            actualColumnNames.add(eachColumnName.getText());
        }

        Assert.assertEquals(expectedColumnNames,actualColumnNames);

    }



}
