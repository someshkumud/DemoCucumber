package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Somesh.
 */
public class LoginStep extends BaseUtil{

    private  BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }
    //LoginPage page=new LoginPage(base.driver);


    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {

        System.out.println("I should see userform page");
        Assert.assertEquals(base.driver.findElement(By.linkText("SIGN-OFF")).getText(),"SIGN-OFF");


    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {

        System.out.println("Navigate Login Page");
        base.driver.get("http://newtours.demoaut.com/");
        //driver.navigate().to("http://newtours.demoaut.com/");
    }


    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        LoginPage page=new LoginPage(base.driver);

        //System.out.println("Click login button");
        Thread.sleep(2000);
        //base.driver.findElement(By.name("login")).click();
        page.ClickLoginButton();
        Thread.sleep(4000);
    }


    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        LoginPage page=new LoginPage(base.driver);
        //Create an ArrayList
        List<User> users =  new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);

        for (User user: users){

            page.enterCredentials(user.username,user.password);
        }

    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password) throws Throwable {
        System.out.println("UserName is : " + userName);
        System.out.println("Password is : " + password);
    }

    @Given("^default properties loded into hashmap$")
    public void defaualltPropertiesLodedIntoHashmap() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        LoginPage page=new LoginPage(base.driver);
        page.load_default_props();

        throw new PendingException();
    }


    @And("^set login username to \"([^\"]*)\"$")
    public void setLoginUsernameTo(String uName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        LoginPage page=new LoginPage(base.driver);
        page.setLoginUsername(uName);
        throw new PendingException();
    }

    @And("^set login password to \"([^\"]*)\"$")
    public void setLoginPasswordTo(String passWord) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        LoginPage page=new LoginPage(base.driver);
        page.setLoginPassword(passWord);
        throw new PendingException();
    }

    @When("^user perform flight booking action$")
    public void userPerformFlightBookingAction() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        LoginPage page=new LoginPage(base.driver);
        page.doLogin();
        throw new PendingException();
    }

    @Then("^user should see message \"([^\"]*)\"$")
    public void userShouldSeeMessage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username= userName;
            password = passWord;
        }
    }

}
