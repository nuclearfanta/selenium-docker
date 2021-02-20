package com.newtours.tests;

import com.newtours.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupParameters(String noOfPassengers, String expectedPrice) {
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }


    @Test
    public void registrationPage(){
        RegistrationPage reg = new RegistrationPage(driver);
        reg.goTo();
        reg.enterUserDetails("selenium", "docker");
        reg.enterUserCredentials("selenium", "docker");
        reg.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationPage reg = new RegistrationConfirmationPage(driver);
        reg.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage f = new FlightDetailsPage(driver);
        f.selectPassengers(noOfPassengers);
        f.goToBookFlightPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        FindFlightPage f = new FindFlightPage(driver);
        f.submitFindFlightPage();
        f.goToOrderConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
        FlightConfirmationPage f = new FlightConfirmationPage(driver);
        String actualPrice = f.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);

    }






}
