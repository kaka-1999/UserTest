package cases;

import config.TestConfig;
import lombok.extern.log4j.Log4j2;
import model.AddUser;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DatebaseUtil;

import java.io.IOException;

@Log4j2
public class AddUserTest {
//    ExtentReports extent = new ExtentReports("/user/build/");

    @Test(groups = "LoginTure", description = "新增用户用例")
    public void addUser() throws IOException, InterruptedException {
        SqlSession session = DatebaseUtil.getSqlSession();
        AddUser user = session.selectOne("AddUserCase", 1);
        log.info("新增用户：" + user);
        String result = getResult(user);
        log.info("期望结果");
        Thread.sleep(3000);
        Assert.assertEquals(user.getExpected(), result);

    }

    public String getResult(AddUser adduser) throws IOException {
        HttpPost post = new HttpPost(TestConfig.adduserurl);
        JSONObject object = new JSONObject();
        object.put("username", adduser.getUsername());
        object.put("password", adduser.getPassword());
        object.put("age", adduser.getAge());
        object.put("sex", adduser.getSex());
        object.put("permission", adduser.getPermission());
        object.put("isDelete", adduser.getIsDelete());
        post.setHeader("content-type", "application/json");
        post.setEntity(new StringEntity(object.toString()));
        String result = EntityUtils.toString(TestConfig.closeableHttpClient.execute(post).getEntity());
        return result;
    }
}
