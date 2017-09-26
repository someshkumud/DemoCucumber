package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by Somesh.
 */
public class Hook extends BaseUtil{


    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {

        System.out.println("Opening the browser : MOCK");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\somesh12339\\Downloads\\chromedriver.exe");
        base.driver=new ChromeDriver();
        //System.setProperty("webdriver.ie.driver","C:\\Users\\somesh12339\\Downloads\\IEDriverServer_x64_3.5.1\\IEDriverServer.exe");
        //base.driver=new InternetExplorerDriver();
        base.driver.manage().window().maximize();

    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
        //base.driver.quit();
    }

}
