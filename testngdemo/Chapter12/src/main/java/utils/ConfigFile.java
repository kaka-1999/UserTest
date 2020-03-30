package utils;

import model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 添加备注
 */
public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name) {
        String url = bundle.getString("test.url");
        String uri = "";
        if (name == InterfaceName.LOGINUSER) {
            uri = bundle.getString("login.uri");
        }
        if (name == InterfaceName.ADDUSER) {
            uri = bundle.getString("adduser.uri");
        }
        if (name == InterfaceName.UPDATEUSER) {
            uri = bundle.getString("updateuser.uri");
        }
        if (name == InterfaceName.GETUSERINFO) {
            uri = bundle.getString("userinfo.uri");
        }
        if (name == InterfaceName.GETUSERLIST) {
            uri = bundle.getString("userlist.uri");
        }
        String result = url + uri;
        return result;
    }
}
