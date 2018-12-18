package BaseTest.BaseMain;

import com.google.common.collect.ImmutableMap;
import com.gurok.APIClient;
import com.gurok.APIException;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.mail.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseMethods  {

    //variables

    public static WebDriver driver;
    public static Select dropdown;
    public static int caseID;
    public static String ckName = new String();
    public static String ckValue = new String();
    public static String caseComment = new String();

    //Inicializacion del web driver

    @BeforeClass
    public static void initialization(){

       // String respath = "/usr/local/bin/chromedriver";
       // System.setProperty("webdriver.chrome.driver", respath); // "C:\\Users\\Agustin Barcia\\IdeaProjects\\oemaven\\src\\main\\resources\\chromedriver.exe");

        //WebDriverManager.chromedriver().setup();

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
         //driver = new ChromeDriver(chromeDriverService,options);
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.get("https://www.stg.openenglish.com/");
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
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
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

    //post a test rail para un test failed

    public void testFailed() throws IOException, APIException {

        APIClient client = new APIClient("https://openeducation.testrail.net/");
        client.setUser("agustin.barcia@openenglish.com");
        client.setPassword("0232049021Ajb!");
        //Exception e = null;
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        new Error().printStackTrace(pw);
        String sStackTrace = sw.toString(); // stack trace as a string
        Map data = new HashMap();
        data.put("status_id", new Integer(5));
        data.put("custom_environment", new Integer(1));
        data.put("comment", "Error en:" + ' ' + sStackTrace);
        JSONObject r = (JSONObject) client.sendPost("add_result/"+caseID, data);

    }

    public static boolean verifyMailSubject(String userName, String password, String message) {
        Folder folder = null;
        Store store = null;
        System.out.println("***READING MAILBOX...");
        try {
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");
            Session session = Session.getInstance(props);
            store = session.getStore("imaps");
            store.connect("imap.gmail.com", userName, password);

            folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message[] messages = folder.getMessages();
            System.out.println("No of Messages : " + folder.getMessageCount());
            System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
            for (int i = messages.length - 1; i >= 0; i--) {
                System.out.println("Reading MESSAGE # " + (i + 1) + "...");

                Message msg = messages[i];
                String strMailSubject = "", strMailBody = "";
                // Getting mail subject
                Object subject = msg.getSubject();
                // Getting mail body
                Object content = msg.getContent();
                // Casting objects of mail subject and body into String
                strMailSubject = (String) subject;
                System.out.println("Subject del mail evaluado: "+strMailSubject);
                //---- This is what you want to do------
                if (strMailSubject.contains(message)) {
                    System.out.println(strMailSubject);
                    break;
                }
            }
            return true;
        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (folder != null) {
                try {
                    folder.close(true);
                } catch (MessagingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (store != null) {
                try {
                    store.close();
                } catch (MessagingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public  boolean verifyMailContent(String userName, String password, String message1, String message2) {
        Folder folder = null;
        Store store = null;
        System.out.println("***READING MAILBOX...");
        try {
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");
            Session session = Session.getInstance(props);
            store = session.getStore("imaps");
            store.connect("imap.gmail.com", userName, password);
            folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message[] messages = folder.getMessages();
            System.out.println("No of Messages : " + folder.getMessageCount());
            System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
            for (int i = messages.length - 1; i >= 0; i--) {
                System.out.println("Reading MESSAGE # " + (i + 1) + "...");

                Message msg = messages[i];
                String strMailSubject = "", strMailBody = "";
                // Getting mail subject
                Object subject = msg.getSubject();
                // Getting mail body
                Object content = msg.getContent();
                // Casting objects of mail subject and body into String
                strMailBody = (String) getText(msg);


                System.out.println("Body del mail evaluado: "+strMailBody);
                //---- This is what you want to do------
                if (strMailBody.contains(message1)&&strMailBody.contains(message2)) {
                    System.out.println(strMailBody);
                    break;
                }
            }
            return true;
        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (folder != null) {
                try {
                    folder.close(true);
                } catch (MessagingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (store != null) {
                try {
                    store.close();
                } catch (MessagingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private boolean textIsHtml = false;

    /**
     * Return the primary text content of the message.
     */
    private String getText(Part p) throws
            MessagingException, IOException {
        if (p.isMimeType("text/*")) {
            String s = (String)p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return s;
        }

        if (p.isMimeType("multipart/alternative")) {
            // prefer html text over plain text
            Multipart mp = (Multipart)p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getText(bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(bp);
                    if (s != null)
                        return s;
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart)p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }

        return null;
    }

    protected boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    @AfterClass
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }

    }

}
