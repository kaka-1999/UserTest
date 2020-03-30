package org.test.suite;

import org.testng.annotations.Test;

public class PayTest {

    @Test
    public  void PayTest(){
        System.out.println("====  支付测试成功  ====");
    }
    @Test(enabled = false)
    public  void PayTest2(){
        System.out.println("====  支付测试成功 2 ====");
    }
}
