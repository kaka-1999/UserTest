package org.test.exception;

import org.testng.annotations.Test;

public class ExpectedException {
    /**
     * 期望结果为某一个异常
     * */

    //测试结果为失败的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionfaild(){
        System.out.println("======  runTimeExceptionfaild   =======");
    }


    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionsuccess(){
        System.out.println("======  runTimeExceptionsuccess   =======");
        throw new RuntimeException();

    }

}
