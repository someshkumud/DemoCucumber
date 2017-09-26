package Pages;

import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookFlight extends BaseUtil{

    public BookFlight(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how =How.CSS, using = "Input[value='oneway']")
    public WebElement radioOneWay;

    @FindBy(how =How.CSS, using = "Input[value='roundtrip']")
    public WebElement radioRoundTrip;

    @FindBy(how = How.NAME, using = "passCount")
    public WebElement ddPassCount;

    @FindBy(how = How.NAME, using = "fromPort")
    public WebElement ddFromPort;

    @FindBy(how = How.NAME, using = "fromMonth")
    public WebElement ddFromMonth;

    @FindBy(how = How.NAME, using = "fromDay")
    public WebElement ddFromDay;

    @FindBy(how = How.NAME, using = "toPort")
    public WebElement ddToPort;

    @FindBy(how = How.NAME, using = "toMonth")
    public WebElement ddToMonth;

    @FindBy(how = How.NAME, using = "toDay")
    public WebElement ddToDay;


    @FindBy(how = How.NAME, using = "airline")
    public WebElement ddAirline;


    @FindBy(how = How.CSS, using = "Input[value='Business']")
    public WebElement radioBusiness;

    @FindBy(how = How.CSS, using = "Input[value='First']")
    public WebElement radioFirst;

    @FindBy(how = How.CSS, using = "Input[value='Coach']")
    public WebElement radioEconomy;

    @FindBy(how = How.NAME, using = "findFlights")
    public WebElement btnFindFlights;


    public void selectTripType(String tripType){
        if(tripType.equalsIgnoreCase("One Way")){
            radioOneWay.click();
        }else{
            radioRoundTrip.click();
        }

    }

    public void selectNumberOfPass(String passCount){
        Select ddNumberOfPass = new Select(ddPassCount);
        ddNumberOfPass.selectByValue(passCount);
    }

    public void selectDepartFrom(String depFrom){
        Select ddDepartFrom = new Select(ddFromPort);
        ddDepartFrom.selectByValue(depFrom);
    }

    public void selectArriveTo(String arrTo){
        Select ddArriveTo = new Select(ddToPort);
        ddArriveTo.selectByValue(arrTo);
    }

    public void selectDepartOn(String fromDate){
        Select ddDepFromMonth = new Select(ddFromMonth);
        Select ddDepFromDay = new Select(ddFromDay);

        String arDate[]=fromDate.split("/");
        String dd=arDate[0];
        String mm=arDate[1];

        ddDepFromMonth.selectByValue(mm);
        ddDepFromDay.selectByValue(dd);
    }

    public void selectServiceClass(String serviceClass){
        if(serviceClass.equalsIgnoreCase("Business")){
            radioBusiness.click();
        }else if(serviceClass.equalsIgnoreCase("First"))
            {
                radioFirst.click();
            }else{
            radioEconomy.click();
        }
    }

    public void clickContinue(){
        btnFindFlights.click();
    }
}
