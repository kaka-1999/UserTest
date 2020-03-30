package cases;

import config.Log;
import config.TestConfig;
import model.Admin_User;
import model.GetUserList;
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
import java.util.List;

public class GetUserListTest {
    @Test(groups = "LoginTure", description = "查询用户列表用例")
    public void getUserList() throws IOException {
        SqlSession session = DatebaseUtil.getSqlSession();
        GetUserList list = session.selectOne("GetUserList", 1);
        Log.info("获取用户列表参数：" + list);
        JSONArray jsonArray = getResult(list);
        Log.info("获取用户列表实际结果：" + jsonArray);
        List<Admin_User> admin_users = session.selectList(list.getExpected(), list);
        Assert.assertEquals(jsonArray.length(), admin_users.size());
        JSONArray user = new JSONArray(admin_users);
        Log.info("获取用户列表期望结果：" + user);
        for (int i = 0; i < admin_users.size(); i++) {
            JSONObject expect = (JSONObject) jsonArray.get(i);
            JSONObject actual = (JSONObject) user.get(i);
            Assert.assertEquals(expect.toString(), actual.toString());
        }
    }

    private JSONArray getResult(GetUserList list) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getuserlisturl);
        JSONObject object = new JSONObject();
//        object.put("id", list.getId());
        object.put("username", list.getUsername());
        object.put("age", list.getAge());
        object.put("sex", list.getSex());
        StringEntity entity = new StringEntity(object.toString(), "utf-8");
        post.setHeader("content-type", "application/json");
        post.setEntity(entity);
        String result = EntityUtils.toString(TestConfig.closeableHttpClient.execute(post).getEntity());
        JSONArray array = new JSONArray(result);
        return array;
    }
}
