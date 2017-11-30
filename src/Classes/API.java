package Classes;


import org.apache.http.*;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class API {
    ArrayList<Curse> arrcurse = new ArrayList<>();
    String val;


    public static void main(String[] args) throws IOException, JSONException {


        }


    public static JSONObject getResponse(String url) throws IOException, JSONException {
        CloseableHttpClient httpClient = HttpClients.createMinimal();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        String responseString = EntityUtils.toString(httpResponse.getEntity());
        Header[] headers = httpResponse.getAllHeaders();
        JSONObject response = null;
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].getName().equals("Content-Type")) {
                if (headers[i].getValue().equals("application/json")) {
                    response = new JSONObject(responseString);
                }

            }
            //  System.out.println(headers[i]);//чтобы вывести все хидеры
        }
        if (response == null) {
            System.out.println(httpResponse.getStatusLine()); //получить код статуса http(200 Ok, 404 Not Found)
        }

        //System.out.println(responseString);
        return response;
    }

    public API() {
    }

    public ArrayList<Curse> getcurse(String val) throws IOException {
        JSONObject js = getResponse("http://api.fixer.io/latest?base="+val);
        JSONObject newjs = (JSONObject) js.get("rates");

        ArrayList<String> arrayList = new ArrayList(newjs.keySet());

        for (int i = 0; i < arrayList.size() ; i++) {
            arrcurse.add(new Curse(arrayList.get(i), newjs.getDouble(arrayList.get(i)) ));
        }
        return arrcurse;


    }
}
