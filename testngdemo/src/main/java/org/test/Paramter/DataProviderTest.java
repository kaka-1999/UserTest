package org.test.Paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        System.out.println("======    " + name + "  " + age + "  =====");
    }

    @DataProvider(name = "data")
    public Object[][] ProviderData() {
        Object[][] o = new Object[][]{
                {"zhangsan", 10},
                {"lisi", 20},
                {"wangwu", 30}
        };
        return o;
    }

    @Test(dataProvider = "method")
    public void test1(String name, int age) {
        System.out.println("======test1    " + name + "  " + age + "  =====");
    }

    @Test(dataProvider = "method")
    public void test2(String name, int age) {
        System.out.println("======test2    " + name + "  " + age + "  =====");
    }


    @DataProvider(name = "method")
    public Object[][] ProviderDatamethod(Method method) {
        Object[][] o = null;
        if (method.getName().equals("test1")) {
            o = new Object[][]{{"zhangsan", 10},
                    {"lisi", 20}
            };
        } else if (method.getName().equals("test2")) {
            o = new Object[][]{
                    {"lisi", 20},
                    {"wangwu", 30}
            };
        }
        return o;
    }
}
