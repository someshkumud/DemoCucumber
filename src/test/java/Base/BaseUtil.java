package Base;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by Somesh.
 */
public class BaseUtil {

public static void main_test(String[] args){

    WebDriver driver;

    HashMap<String, String> sys_default_prop=new HashMap<String, String>();
    Properties load_props=new Properties();
    get_default_props(load_props,sys_default_prop);
    process_properties(load_props,sys_default_prop);

}

    private static void process_properties(Properties load_props, HashMap<String, String> default_prop) {

        default_prop.put("uname",load_props.getProperty("uname"));
        default_prop.put("pwd",load_props.getProperty("pwd"));

    }


    public static void get_default_props(Properties load_props,HashMap<String, String> sys_default_prop){
        FileInputStream input=null;
        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\default.properties");
            input = new FileInputStream(file);
            load_props.load(input);
            //load_props.load(BaseUtil.class.getResourceAsStream("default.properties"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        finally {
            {
                if(input!=null){
                    try{
                        input.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

