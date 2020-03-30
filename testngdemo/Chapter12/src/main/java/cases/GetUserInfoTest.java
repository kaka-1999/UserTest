package cases;

import config.Log;
import config.TestConfig;
import model.Admin_User;
import model.GetUserInfo;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DatebaseUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetUserInfoTest {

    @Test(groups = "LoginTure", description = "查询用户信息")
    public void getUserInfo() throws IOException, InterruptedException {
        SqlSession session = DatebaseUtil.getSqlSession();
        GetUserInfo userInfo = session.selectOne("GetUserInfo", 1);
        Log.info("获取用户信息："+userInfo);
        JSONArray result = getResult(userInfo);
        Log.info("获取用户信息结果："+result);
        Admin_User user = session.selectOne(userInfo.getExpected(), userInfo);
        List list = new ArrayList();
        list.add(user);
        Thread.sleep(3000);
        JSONArray array = new JSONArray(list);
        Log.info("获取用户信息期望值："+array);
        Assert.assertEquals(result.toString(), array.toString());

    }

    private JSONArray getResult(GetUserInfo userInfo) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getuserinfourl);
        JSONObject object = new JSONObject();
        object.put("id", userInfo.getUserid());
        post.setHeader("content-type", "application/json");
        post.setEntity(new StringEntity(object.toString()));
        String result = EntityUtils.toString(TestConfig.closeableHttpClient.execute(post).getEntity());
        JSONArray array = new JSONArray(result);
        JSONObject result_object = new JSONObject(array.get(0).toString());
        return array;
    }
}
