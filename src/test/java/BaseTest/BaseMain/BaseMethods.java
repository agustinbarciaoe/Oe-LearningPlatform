package BaseTest.BaseMain;

import com.google.common.collect.ImmutableMap;
import com.gurok.APIClient;
import com.gurok.APIException;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseMethods {

    //variables

    public static WebDriver driver;
    public static Select dropdown;
    public static int caseID;
    public static String ckName = new String();
    public static String ckValue = new String();
    public static String caseComment = new String();

    //Inicializacion del web driver

    @BeforeClass
    public static void inizialitation(){

       // String respath = "/usr/local/bin/chromedriver";
       // System.setProperty("webdriver.chrome.driver", respath); // "C:\\Users\\Agustin Barcia\\IdeaProjects\\oemaven\\src\\main\\resources\\chromedriver.exe");

       // WebDriverManager.chromedriver().setup();

        WebDriverManager.firefoxdriver().setup();

/*
        ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
        builder.withVerbose(false);
        builder.withEnvironment(ImmutableMap.of("DISPLAY", ":1"));
      / ChromeDriverService chromeDriverService = builder.build();


        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");

        options.addArguments("–no-sandbox");
        options.addArguments("–disable-dev-shm-usage");
        options.setExperimentalOption("useAutomationExtension", false);

        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only


        //options.setBinary("/usr/local/bin/chromedriver");
*/
        // driver = new ChromeDriver(chromeDriverService,options);
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    //setter

    public static void setCaseID(int value){
        caseID = value;
        }
    public static void setCaseComment(String comentario){
        caseComment = comentario;
        }
    public static void setLangCookieName(String name){ckName = name;}
    public static void setLangCookieValue(String value){ckValue = value;}


    // Random email

    public static String randomEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }


    //get cookie value




    //post a test rail para un test ok

    public void testPassed() throws IOException, APIException {

        APIClient client = new APIClient("https://openeducation.testrail.net/");
        client.setUser("agustin.barcia@openenglish.com");
        client.setPassword("0232049021Ajb!");
        Map data = new HashMap();
        data.put("status_id", new Integer(1));
        data.put("custom_environment", new Integer(1));
        data.put("comment", caseComment);
        JSONObject r = (JSONObject) client.sendPost("add_result/"+caseID, data);

    }

    //post a test rail para un test ok

    public void testFailed() throws IOException, APIException {

        APIClient client = new APIClient("https://openeducation.testrail.net/");
        client.setUser("agustin.barcia@openenglish.com");
        client.setPassword("0232049021Ajb!");
        Map data = new HashMap();
        data.put("status_id", new Integer(5));
        data.put("custom_environment", new Integer(1));
        data.put("comment", caseComment);
        JSONObject r = (JSONObject) client.sendPost("add_result/"+caseID, data);

    }

    @AfterClass
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }

    }

}
