package cases;

import config.Log;
import config.TestConfig;
import model.InterfaceName;
import model.LoginCase;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConfigFile;
import utils.DatebaseUtil;

import java.io.IOException;

public class LoginTest {

    @BeforeTest(groups = "LoginTure", description = "执行登录前的准备工作")
    public void beforeTest() {
        TestConfig.loginurl = ConfigFile.getUrl(InterfaceName.LOGINUSER);
        TestConfig.adduserurl = ConfigFile.getUrl(InterfaceName.ADDUSER);
        TestConfig.updateuserurl = ConfigFile.getUrl(InterfaceName.UPDATEUSER);
        TestConfig.getuserinfourl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getuserlisturl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.cookieStore = new BasicCookieStore();
        TestConfig.closeableHttpClient = HttpClients.custom().setDefaultCookieStore(TestConfig.cookieStore).build();
    }

    @Test(groups = "LoginTure", description = "登录成功用例")
    public void loginTest() throws IOException, InterruptedException {
        SqlSession session = DatebaseUtil.getSqlSession();
        LoginCase user = session.selectOne("LoginUser", 1);
        //发送请求
        String result = getResult(user);
        Log.info("登录账号："+user);
        Log.info("登录结果："+result);
        Thread.sleep(3000);
        //验证结果
        Assert.assertEquals(user.getExpected(), result);

    }

    private String getResult(LoginCase user) throws IOException {
        HttpPost post = new HttpPost(TestConfig.loginurl);
        post.setHeader("content-type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", user.getUsername());
        jsonObject.put("password", user.getPassword());
        StringEntity entity = new StringEntity(jsonObject.toString(), "utf-8");
        post.setEntity(entity);
        CloseableHttpResponse response = TestConfig.closeableHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        return result;
    }


//    @Test(groups = "loginFail", description = "登录失败用例")
//    public void loginFail() throws IOException {
//        SqlSession session = DatebaseUtil.getSqlSession();
//        Admin_User user = session.selectOne("LoginUser", 2);
//        System.out.println(user.toString());
//    }
}
