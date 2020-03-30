package org.test.Depend;

import org.testng.annotations.Test;

/**
 * 参数dependsOnMethods
 * 譬如：下单需要先登录
 */
public class DependTest {
    @Test(expectedExceptions = RuntimeException.class)
    public void test1(){
        System.out.println("=====    test1     ====");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("=====    test2     ====");
    }
}
