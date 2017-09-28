package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Somesh.
 */
public class Hook extends BaseUtil{

    public Properties OR=new Properties();
    //public WebDriver dr;
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }
/*
    @Before
    public void InitializeTest() {

        System.out.println("Opening the browser : MOCK");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\chromedriver.exe");
        base.driver=new ChromeDriver();
        //System.setProperty("webdriver.ie.driver","C:\\Users\\somesh12339\\Downloads\\IEDriverServer_x64_3.5.1\\IEDriverServer.exe");
        //base.driver=new InternetExplorerDriver();
        base.driver.manage().window().maximize();

    }*/

    @Before
    public void setUp() throws IOException{
        init();

    }

    public void init() throws IOException{
        loadPropertiesFile();
        selectBrowser(OR.getProperty("browser"));
        getURL(OR.getProperty("url"));
    }


    public void loadPropertiesFile() throws IOException{
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
        FileInputStream fileInput = new FileInputStream(file);
        OR.load(fileInput);
    }

    public void getURL(String url) {
        dr.get(url);
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void selectBrowser(String browser) {
        if(browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\geckodriver.exe");
            base.dr =new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
            base.dr=new ChromeDriver();
        }else if(browser.equalsIgnoreCase("IE"))
        {
            base.dr=new InternetExplorerDriver();
        }
        base.driver=new EventFiringWebDriver(base.dr);
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
        base.dr.quit();
    }

}
