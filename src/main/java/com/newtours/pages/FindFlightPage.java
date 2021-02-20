package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(id = "reserveFlights")
    private WebElement firstSubmitBtn;
    @FindBy(id = "buyFlights")
    private WebElement secondSubmitBtn;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void submitFindFlightPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(firstSubmitBtn));
        this.firstSubmitBtn.click();
    }

    public void goToOrderConfirmationPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(secondSubmitBtn));
        this.secondSubmitBtn.click();
    }
}
