package Pages;

import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseUtil{

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.NAME, using = "userName")
    public WebElement txtUsername;

    @FindBy(how = How.NAME, using = "password")
    public WebElement txtPassword;

    @FindBy(how = How.NAME, using = "login")
    public WebElement btnLogin;

    @FindBy(how = How.LINK_TEXT, using = "SIGN-OFF")
    public WebElement lnkSignOff;


    public void enterCredentials(String username, String password){
        txtUsername.sendKeys(username);

        txtPassword.sendKeys(password);


    }

    public void setLoginUsername(String uName) {

        sys_default_prop.put("uname",uName);
    }

    public void setLoginPassword(String uName) {

        sys_default_prop.put("pwd",uName);
    }


    public void ClickLoginButton(){
        btnLogin.click();
    }


    public void doLogin(){

        enterCredentials(sys_default_prop.get("uname"), sys_default_prop.get("pwd"));
        ClickLoginButton();

    }
}
