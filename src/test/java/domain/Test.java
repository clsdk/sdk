package domain;


import com.chuanglan.gsou.request.ChHttpClient;
import org.json.JSONObject;

public class Test {

    public static JSONObject konghao(){
        JSONObject object = new JSONObject();

            ChHttpClient httpClient = new ChHttpClient();
            JSONObject json = new JSONObject();
            json.put("appId","");
            json.put("appKey","");
            json.put("companyKey","佛山市三水区德润渔业科技有限公司");
            json.put("keyType","1");
            object = httpClient.legalRiskPromiseBreak(json);

            System.out.println(object);

        return object;
    }


    public static void main(String[] args) {
        JSONObject jsonObject;
        for (int i = 0; i < 1; i++) {
            jsonObject = konghao();
            System.out.println("返回结果= "+jsonObject.toString());
        }

    }

}
