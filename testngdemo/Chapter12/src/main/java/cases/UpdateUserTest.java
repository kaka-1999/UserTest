package cases;

import config.Log;
import config.TestConfig;
import model.Admin_User;
import model.UpdateUser;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DatebaseUtil;

import java.io.IOException;

public class UpdateUserTest {
    @Test(groups = "LoginTure", description = "修改用户用例")
    public void updateUser() throws IOException, InterruptedException {
        SqlSession session = DatebaseUtil.getSqlSession();
        UpdateUser updateUser = session.selectOne("UpdateOrDeleteUser", 1);
        Log.info("更新数据：" + updateUser);
        int result = getResult(updateUser, TestConfig.updateuserurl);
        Thread.sleep(1000);
        Admin_User user = session.selectOne(updateUser.getExpected(), updateUser);
        Thread.sleep(1000);
        Log.info("更新结果：" + result);
        Log.info("更新期望结果：" + user);
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);
    }

    private int getResult(UpdateUser updateUser, String url) throws IOException {
        HttpPost post = new HttpPost(url);
        JSONObject object = new JSONObject();
        object.put("id", updateUser.getUserid());
        object.put("username", updateUser.getUsername());
        object.put("age", updateUser.getAge());
        object.put("sex", updateUser.getSex());
        object.put("permission", updateUser.getPermission());
        object.put("isDelete", updateUser.getIsDelete());
        post.setHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(object.toString(), "utf-8");
        post.setEntity(entity);
        String result = EntityUtils.toString(TestConfig.closeableHttpClient.execute(post).getEntity());
        return Integer.parseInt(result);
    }

    @Test(groups = "LoginTure", description = "删除用户用例")
    public void deleteUser() throws IOException, InterruptedException {
        SqlSession session = DatebaseUtil.getSqlSession();
        UpdateUser updateUser = session.selectOne("UpdateOrDeleteUser", 2);
        Log.info("删除数据：" + updateUser);
        int result = getResult(updateUser, TestConfig.updateuserurl);
        Thread.sleep(1000);
        Admin_User user = session.selectOne(updateUser.getExpected(), updateUser);
        Thread.sleep(1000);
        Log.info("删除结果：" + result);
        Log.info("删除期望结果：" + user);
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);
    }
}
