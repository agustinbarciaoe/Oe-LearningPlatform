package BaseTest.BaseMain;

import com.google.gson.JsonArray;
import com.gurok.APIClient;
import com.gurok.APIException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static BaseTest.BaseMain.BaseMethods.caseID;
import static BaseTest.BaseMain.BaseMethods.runID;

public class GetTestCases {

    @Test
    public void getTests() throws IOException, APIException {

        APIClient client = new APIClient("https://openeducation.testrail.net/");
        client.setUser("agustin.barcia@openenglish.com");
        client.setPassword("0232049021Ajb!");

        // JSONObject r = (JSONObject) client.sendPost("add_result_for_case/"+runID+"/"+caseID, data);
        JSONArray jArray  = (JSONArray) client.sendGet("get_tests/313");
        ArrayList <Long> caseIDs = new ArrayList<Long>();


        for(int i=0;i<jArray.size();i++){
            JSONObject json_obj = (JSONObject) jArray.get(i);
            caseIDs.add((Long) json_obj.get("case_id"));
            //System.out.println(json_obj.get("case_id"));

        }

       //System.out.println(jArray .toJSONString());
        System.out.println(caseIDs);

    }
}

