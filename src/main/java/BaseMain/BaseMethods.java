package BaseMain;

import com.gurok.APIClient;
import com.gurok.APIException;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.mail.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.IOException;


public class BaseMethods  {

    //variables

    public static WebDriver driver;
    public static Select dropdown;
    public static int caseID;
    public static String ckName = new String();
    public static String ckValue = new String();
    public static String caseComment = new String();
    //public static String runID = System.getProperty("RunId");
    public static String runID = "336";
    public static ArrayList<String> caseIDs = new ArrayList<String>();
    public String urlScreenshot;
    public static String className;
    public static String testName;
    public static String nameRandom;
    public static String emailRandom;

    public static String projectName;

    //Inicializacion del web driver

    //public static EmailUtils emailUtils;

    /*@BeforeClass

    public static void connectToEmail() {
        try {
            emailUtils = new EmailUtils("tester.openenglish@gmail.com", "trinity110", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
*/



   //@BeforeClass
    @BeforeSuite
    public static void initialization(){


        WebDriverManager.chromedriver().setup();

        //driver = new FirefoxDriver();
        driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        System.out.println("Run ID: "+runID);


    }

    @BeforeSuite
    public void initializeNameEmail(){
       nameRandom = "NAME" + randomEmail();
       emailRandom = "tester.openenglish+" + nameRandom + "@gmail.com";

    }


    //@BeforeClass
    @BeforeSuite
    public static void getTestCases() throws IOException, APIException {

        APIClient client = new APIClient("https://openeducation.testrail.net/");
        client.setUser("agustin.barcia@openenglish.com");
        client.setPassword("0232049021Ajb!");

        // JSONObject r = (JSONObject) client.sendPost("add_result_for_case/"+runID+"/"+caseID, data);
        JSONArray jArray  = (JSONArray) client.sendGet("get_tests/"+runID);



        for(int i=0;i<jArray.size();i++){
            JSONObject json_obj = (JSONObject) jArray.get(i);
            //String cID = (Long) json_obj.get("case_id");
            caseIDs.add( json_obj.get("case_id").toString());
            //System.out.println(json_obj.get("case_id"));

        }

        //System.out.println(jArray .toJSONString());
        System.out.println(caseIDs);

    }


    //setter

    public static void setCaseID(int value){
        caseID = value;
        }
    public static void setCaseComment(String comentario){
        caseComment = comentario;
        }

    public static void setTestName(String tName){
        testName = tName;
    }
    public static void setClassName(String cName){
        className = cName;
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
        JSONObject r = (JSONObject) client.sendPost("add_result_for_case/"+runID+"/"+caseID, data);
        System.out.println("Case ID: "+caseID+" PASSED");

    }

    //post a test rail para un test failed

    public void testFailed(ITestResult result) throws IOException, APIException {

        try
        {
// Create refernce of TakesScreenshot
            TakesScreenshot ts=(TakesScreenshot)driver;

// Call method to capture screenshot
            File source=ts.getScreenshotAs(OutputType.FILE);

// Copy files to specific location here it will save all screenshot in our project home directory and
// result.getName() will return name of test case so that screenshot name will be same
            //FileUtils.copyFile(source, new File("Screenshots/"+runID+"-"+result.getName()+".png"));

            System.out.println("Screenshot taken");
            String fileName ="public_html/Screenshots/"+runID+"-"+result.getName()+".png";
            urlScreenshot = "https://testrailtrigger.000webhostapp.com/Screenshots/"+runID+"-"+result.getName()+".png";

            uploadFile(source,fileName);




        }
        catch (Exception e)
        {

            System.out.println("Exception while taking screenshot "+e.getMessage());
        }

        // Información del test fallido a Test Rail
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
        data.put("comment", "Error en:" + ' ' + sStackTrace+"        " +
                "Screenshot: "+urlScreenshot);
        JSONObject r = (JSONObject) client.sendPost("add_result_for_case/"+runID+"/"+caseID, data);
        sendSlackMessage();
        System.out.println("Case ID: "+caseID+" FAILED");

    }

    public void sendSlackMessage () throws IOException {
        //JSONObject json = new JSONObject();
        //json.put("someKey", "someValue");


        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
            HttpPost request = new HttpPost("https://hooks.slack.com/services/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");
            StringEntity params = new StringEntity(
                    "{\n" +
                            "    \"attachments\": [\n" +
                            "        {\n" +
                            "            \"fallback\": \"Failed test case during automation run\",\n" +
                            "            \"title\": \"Failed test case during Test Run "+runID+"\",\n" +
                            "            \"image_url\": \""+urlScreenshot+"\",\n" +
                            "            \"color\": \"#FF0000\",\n" +
                            "          \t\"fields\": [\n" +
                            "                {\n" +
                            "                    \"title\": \"Project\",\n" +
                            "                    \"value\": \"OE Adult\",\n" +
                            "                    \"short\": true\n" +
                            "                },\n" +
                            "                {\n" +
                            "                    \"title\": \"Environment\",\n" +
                            "                    \"value\": \"Production\",\n" +
                            "                    \"short\": true\n" +
                            "                },\n" +
                            "              \t{\n" +
                            "                    \"title\": \"TestClass\",\n" +
                            "                    \"value\": \""+className+"\",\n" +
                            //"                    \"value\": \"CLASSNAME\",\n" +
                            "                    \"short\": true\n" +
                            "                },\n" +
                            "              \t{\n" +
                            "                    \"title\": \"Test\",\n" +
                            "                    \"value\": \""+testName+"\",\n" +
                            "                    \"short\": true\n" +
                            "                }\n" +

                            "            ],\n" +
                            "          \"actions\": [\n" +
                            "        {\n" +
                            "          \"type\": \"button\",\n" +
                            "          \"text\": \"See it in TestRail\",\n" +
                            "          \"url\": \"https://openeducation.testrail.net/index.php?/runs/view/"+runID+"\"\n" +
                            "        },\n" +
                            "            {\n" +
                            "          \"type\": \"button\",\n" +
                            "          \"text\": \"See it in Jenkins\",\n" +
                            "          \"url\": \"http://jenkins.openenglish.com/job/Automation-OE-Adult-NEW/\"\n" +
                            "        }\n" +
                            "      ]\n" +
                            "        }\n" +
                            "    ]\n" +
                            "}"
            );
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            httpClient.execute(request);
// handle response here...
        } catch (Exception ex) {
            // handle exception here
        } finally {
            httpClient.close();
        }

    }


    public static boolean verifyMailSubject(String userName, String password, String message) {
        Folder folder = null;
        Store store = null;
        boolean found = false;
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
                    found = true;
                    break;
                }
            }
            return found;
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
        return found;
    }

    public  boolean verifyMailContent(String userName, String password, String message1, String message2) {
        Folder folder = null;
        Store store = null;
        boolean found = false;
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
                strMailSubject = (String) subject;
                System.out.println("Subject del mail evaluado: "+strMailSubject);

                //System.out.println("Body del mail evaluado: "+strMailBody);
                //---- This is what you want to do------
                if (strMailBody.contains(message1)&&strMailSubject.contains(message2)) {
                    System.out.println("Mail con Subject: "+message2+" y contenido: "+message1+" encontrado!");
                    found = true;
                    break;
                }
            }
            return found;
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
        return found;
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

    public static boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }


    public String getActivationLink(String userName, String password, String message, String titulo) {
        Folder folder = null;
        Store store = null;
        String retorno = "No encontrado";
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
            String strMailSubject = "";
            String strMailBody = "";
            for (int i = messages.length - 1; i >= 0; i--) {
                System.out.println("Reading MESSAGE # " + (i + 1) + "...");

                Message msg = messages[i];

                // Getting mail subject
                Object subject = msg.getSubject();
                // Getting mail body
                Object content = msg.getContent();
                // Casting objects of mail subject and body into String
                strMailSubject = (String) subject;
                //strMailBody = (String) content;
                strMailBody = (String) getText(msg);
                System.out.println("Subject del mail evaluado: "+strMailSubject);
                System.out.println("Titulo buscado: "+titulo);
                System.out.println("Mensaje buscado: "+ message);
                //System.out.println("Body: "+ strMailBody);
                //---- This is what you want to do------
                if (strMailSubject.contains(titulo)&&strMailBody.contains(message)) {
                    System.out.println(strMailSubject);

                    int indexInicio = strMailBody.indexOf("https://lp3-ui.stg.openenglish.com/activation/");
                    //int indexFin = strMailBody.indexOf("target");
                    System.out.println("IndexInicio: "+indexInicio);
                    //System.out.println("IndexFin: "+indexFin);
                    retorno = strMailBody.substring(indexInicio,indexInicio+107);

                    break;
                }
            }

            return retorno;

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
        return "No encontrado";
    }

    public void uploadFile (File fileToUpload, String uploadName) {
        String server = "files.000webhost.com";
        String user = "testrailtrigger";
        String pass = "123456";

        FTPClient ftpClient = new FTPClient();

        try {

            ftpClient.connect(server);
            System.out.println("Connected to " + server + ".");
            System.out.print(ftpClient.getReplyString());

            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // uploads first file using an InputStream
            //File firstLocalFile = new File("/tmp/PAR.TXT");

            //String firstRemoteFile = "./Screenshots/"+runID+"/"+result.getName()+".png";
            InputStream inputStream = new FileInputStream(fileToUpload);

            System.out.println("Start uploading file");
            boolean done = ftpClient.storeFile(uploadName, inputStream);
            System.out.println("done:" + done);

            inputStream.close();
            if (done) {
                System.out.println("The file is uploaded successfully.");
            }


        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

/*
    @AfterMethod
    public void tearDown(ITestResult result)
    {

// Here will compare if test is failing then only it will enter into if condition
        if(ITestResult.FAILURE==result.getStatus())
        {


            try
            {
// Create refernce of TakesScreenshot
                TakesScreenshot ts=(TakesScreenshot)driver;

// Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);

// Copy files to specific location here it will save all screenshot in our project home directory and
// result.getName() will return name of test case so that screenshot name will be same
                //FileUtils.copyFile(source, new File("Screenshots/"+runID+"-"+result.getName()+".png"));
                System.out.println("Screenshot taken");
                String fileName ="public_html/Screenshots/"+runID+"-"+result.getName()+".png";
                urlScreenshot = "https://testrailtrigger.000webhostapp.com/Screenshots/"+runID+"-"+result.getName()+".png";

                uploadFile(source,fileName);




            }
            catch (Exception e)
            {

                System.out.println("Exception while taking screenshot "+e.getMessage());
            }


        }

    }
*/

    //@AfterClass
    @AfterSuite
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }

    }

}
