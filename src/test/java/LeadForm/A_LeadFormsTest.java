package LeadForm;

import BaseMain.BaseMethods;
import BaseMain.CustomTestListener;
import Pages.OE_LeadForm;
import Pages.OE_ThankYou;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class A_LeadFormsTest extends BaseMethods {

    @Test
    public void A_leadSubmission_C39742() {

        if (!caseIDs.contains("39742")) throw new SkipException("Skipping this testCase: 39742");
        setCaseID(39742);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "8",true,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por tu interés"));
    }

    @Test
    public void A_leadSubmission_C41241() {

        if (!caseIDs.contains("41241")) throw new SkipException("Skipping this testCase: 41241");
        setCaseID(39741);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "8",false,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por tu interés"));
    }

    @Test
    public void A_leadSubmission_C41222() {

        if (!caseIDs.contains("41222")) throw new SkipException("Skipping this testCase: 41222");
        setCaseID(41222);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "9", true,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por tu interés"));
    }

    @Test
    public void A_leadSubmission_C41242() {

        if (!caseIDs.contains("41242")) throw new SkipException("Skipping this testCase: 41242");
        setCaseID(41242);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "9", false,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por tu interés"));
    }

    @Test
    public void A_leadSubmission_C41223() {

        if (!caseIDs.contains("41223")) throw new SkipException("Skipping this testCase: 41223");
        setCaseID(41223);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "10", true,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por tu interés"));
    }

    @Test
    public void A_leadSubmission_C41243() {

        if (!caseIDs.contains("41243")) throw new SkipException("Skipping this testCase: 41243");
        setCaseID(41243);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "10", false,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por tu interés"));
    }

    @Test
    public void A_leadSubmission_C41224() {

        if (!caseIDs.contains("41224")) throw new SkipException("Skipping this testCase: 41224");
        setCaseID(41224);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "11",true,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por dar el primer paso"));
    }

    @Test
    public void A_leadSubmission_C41244() {

        if (!caseIDs.contains("41244")) throw new SkipException("Skipping this testCase: 41244");
        setCaseID(41244);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "11",false,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por dar el primer paso"));
    }



    @Test
    public void A_leadSubmission_C41225() {

        if (!caseIDs.contains("41225")) throw new SkipException("Skipping this testCase: 41225");
        setCaseID(41225);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "4",true,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por dar el primer paso para lograr tu objetivo"));
    }

    @Test
    public void A_leadSubmission_C41245() {

        if (!caseIDs.contains("41245")) throw new SkipException("Skipping this testCase: 41245");
        setCaseID(41245);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "4",false,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por dar el primer paso para lograr tu objetivo"));
    }

    @Test
    public void A_leadSubmission_C41226() {

        if (!caseIDs.contains("41226")) throw new SkipException("Skipping this testCase: 41226");
        setCaseID(41226);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "5",true,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por dar el primer paso para lograr tu objetivo"));
    }

    @Test
    public void A_leadSubmission_C41246() {

        if (!caseIDs.contains("41246")) throw new SkipException("Skipping this testCase: 41246");
        setCaseID(41246);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "5",false,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por dar el primer paso para lograr tu objetivo"));
    }

    @Test
    public void A_leadSubmission_C41227() {

        if (!caseIDs.contains("41227")) throw new SkipException("Skipping this testCase: 41227");
        setCaseID(41227);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "5",true,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por dar el primer paso para lograr tu objetivo"));
    }

    @Test
    public void A_leadSubmission_C41247() {

        if (!caseIDs.contains("41247")) throw new SkipException("Skipping this testCase: 41247");
        setCaseID(41247);
        setCaseComment("Happy path lead submission");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName+", UserName: "+nameRandom);

        OE_LeadForm objOE_LeadForm = new OE_LeadForm(driver);
        OE_ThankYou objOE_ThankYou = new OE_ThankYou(driver);

        objOE_LeadForm.submitLeadForm(nameRandom, "TestName", emailRandom,"ar", "178", "245", "2222", "2222", "5",false,true);
        assertTrue(objOE_ThankYou.getTitleBox().getText().contains("Gracias por dar el primer paso para lograr tu objetivo"));
    }

}
