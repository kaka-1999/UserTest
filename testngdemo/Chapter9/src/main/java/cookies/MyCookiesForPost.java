package cookies;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private ResourceBundle bundle;
    private String url;
    private CookieStore store;
    @BeforeTest
    public void beforeBundle() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("local.url");

    }

    @Test
    public void testPostCookies() throws IOException {
        String request_url = url + bundle.getString("postcookes.url");
        CloseableHttpClient http = HttpClients.createDefault();
//        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(store).build();
        CloseableHttpClient httpClient=HttpClients.createDefault();
        HttpPost post = new HttpPost(request_url);
        JSONObject object = new JSONObject();
        object.put("stu", "kaka");
        object.put("age", "88");
        post.addHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(object.toString(), "utf-8");
        post.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        JSONObject resultobject = new JSONObject(result);
        String name = (String) resultobject.get("name");
        String age = (String) resultobject.get("age");
        System.out.println(name + "   " + age);
    }
}
