package Steps;

import Base.BaseUtil;
import Pages.BookFlight;
import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class BookFlightStep extends BaseUtil{

    private  BaseUtil base;

    public BookFlightStep(BaseUtil base) {
        this.base = base;
        //
    }



    @And("^I select trip type \"([^\"]*)\"$")
    public void iSelectTripType(String tripType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BookFlight page=new BookFlight(base.driver);
        page.selectTripType(tripType);

        //throw new PendingException();
    }

    @And("^I select number of passengers as \"([^\"]*)\"$")
    public void iSelectNumberOfPassengersAs(String passCount) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BookFlight page=new BookFlight(base.driver);
        page.selectNumberOfPass(passCount);
        //throw new PendingException();
    }

    @And("^I select departing from \"([^\"]*)\"$")
    public void iSelectDepartingFrom(String depFrom) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BookFlight page=new BookFlight(base.driver);
        page.selectDepartFrom(depFrom);
        //throw new PendingException();
    }

    @And("^I select departing on \"([^\"]*)\"$")
    public void iSelectDepartingOn(String depOn) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BookFlight page=new BookFlight(base.driver);
        page.selectDepartOn(depOn);
    //    throw new PendingException();
    }

    @And("^I select arriving in \"([^\"]*)\"$")
    public void iSelectArrivingIn(String arriveIn) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BookFlight page=new BookFlight(base.driver);
        page.selectArriveTo(arriveIn);
      //  throw new PendingException();
    }

    @And("^I select service class as \"([^\"]*)\"$")
    public void iSelectServiceClassAs(String serClass) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BookFlight page=new BookFlight(base.driver);
        page.selectServiceClass(serClass);
        //throw new PendingException();
    }

    @And("^I click Continue button$")
    public void iClickContinueButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BookFlight page=new BookFlight(base.driver);
        page.clickContinue();
        //throw new PendingException();
    }

    @And("^set trip type to \"([^\"]*)\"$")
    public void setTripTypeTo(String tripType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BookFlight page=new BookFlight(base.driver);
        page.setTripType(tripType);
        //throw new PendingException();
    }

    @And("^set number of passengers to \"([^\"]*)\"$")
    public void setNumberOfPassengersTo(String noOfPassengers) throws Throwable {
        BookFlight page=new BookFlight(base.driver);
        page.setNumberOfPassengers(noOfPassengers);
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @And("^set departing from to \"([^\"]*)\"$")
    public void setDepartingFromTo(String departingFrom) throws Throwable {
        BookFlight page=new BookFlight(base.driver);
        page.setDepartingFrom(departingFrom);
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @And("^set departing on to \"([^\"]*)\"$")
    public void setDepartingOnTo(String departingOn) throws Throwable {
        BookFlight page=new BookFlight(base.driver);
        page.setDepartingOn(departingOn);
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @And("^set arriving in to \"([^\"]*)\"$")
    public void setArrivingInTo(String arrivingIn) throws Throwable {
        BookFlight page=new BookFlight(base.driver);
        page.setArrivingIn(arrivingIn);
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @And("^set service class to \"([^\"]*)\"$")
    public void setServiceClassTo(String serviceClass) throws Throwable {
        BookFlight page=new BookFlight(base.driver);
        page.setServiceClass(serviceClass);
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @When("^user perform flight booking action$")
    public void userPerformFlightBookingAction() throws Throwable {
        BookFlight bookFlight=new BookFlight(base.driver);
        LoginPage loginPage=new LoginPage(base.driver);
        loginPage.doLogin();
        bookFlight.doBookflight();

        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }


}
