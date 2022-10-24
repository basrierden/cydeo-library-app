package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[text()='173']")
    public WebElement userNumber;

    @FindBy(xpath = "//a[@href='#users']")
    public WebElement usersLink;

    @FindBy (xpath = "(//tr[@role='row'])/th")
    public List<WebElement> actualColumns;

    @FindBy(xpath= "//img[@src='img/default_avatar.jpg']/following-sibling::span")
    public WebElement userName;
}
