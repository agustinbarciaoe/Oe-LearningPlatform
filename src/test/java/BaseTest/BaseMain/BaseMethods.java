package BaseTest.BaseMain;

import com.gurok.APIClient;
import com.gurok.APIException;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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

        String respath = "src/main/resources/chromedriver";
        System.setProperty("webdriver.chrome.driver", respath); // "C:\\Users\\Agustin Barcia\\IdeaProjects\\oemaven\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
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
        Exception e = null;
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String sStackTrace = sw.toString(); // stack trace as a string
        System.out.println(sStackTrace);
        Map data = new HashMap();
        data.put("status_id", new Integer(5));
        data.put("custom_environment", new Integer(1));
        data.put("comment", caseComment + ' ' + sStackTrace);
        JSONObject r = (JSONObject) client.sendPost("add_result/"+caseID, data);

    }

    @AfterClass
    public static void tearDownDriver() {
        driver.close();
        driver.quit();
    }

}
