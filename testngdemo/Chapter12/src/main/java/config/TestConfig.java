package config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.CloseableHttpClient;

public class TestConfig {
    public static String loginurl;
    public static String adduserurl;
    public static String updateuserurl;
    public static String getuserinfourl;
    public static String getuserlisturl;

    public static CloseableHttpClient closeableHttpClient;
//    public static DefaultHttpClient
    public static CookieStore cookieStore;
}
