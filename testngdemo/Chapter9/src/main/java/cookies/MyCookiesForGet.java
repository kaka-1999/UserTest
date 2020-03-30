package cookies;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private ResourceBundle bundle;
    private String url;
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("local.url");
        System.out.println(url);
    }

    //接收cookies
    @Test
    public void testGetCookie() throws IOException {
        String uri = bundle.getString("getcookes.url");
        String res_url = this.url + uri;
        this.store = new BasicCookieStore();
        HttpGet get = new HttpGet(res_url);
        //请求中会获取cookie
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(store).build();
        CloseableHttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        List<Cookie> list = store.getCookies();
        for (Cookie cookie : list) {
            String key = cookie.getName();
            String value = cookie.getValue();
            System.out.println(key + "   " + value);
        }
    }

    //请求携带cookies
    @Test(dependsOnMethods = {"testGetCookie"})
    public void testSetCookies() throws IOException {
        String request_url = this.url + bundle.getString("request_cookie_uri");
        HttpGet get = new HttpGet(request_url);
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(store).build();
        CloseableHttpResponse response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }
}
