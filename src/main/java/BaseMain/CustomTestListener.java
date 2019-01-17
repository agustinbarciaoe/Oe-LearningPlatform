package BaseMain;

import com.gurok.APIClient;
import com.gurok.APIException;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomTestListener<context> extends BaseMethods implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {


    }

    @Override
    public void onTestSuccess(ITestResult result) {

        try {
            
            testPassed();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (APIException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestFailure(ITestResult result) {

            try {
                testFailed(result);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (APIException e) {
                e.printStackTrace();
            }
        }
    @Override
    public void onTestSkipped(ITestResult result) {

    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
    @Override
    public void onStart(ITestContext context) {

    }
    @Override
    public void onFinish(ITestContext context) {

    }


}
