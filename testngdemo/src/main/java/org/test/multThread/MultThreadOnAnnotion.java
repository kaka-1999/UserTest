package org.test.multThread;

import org.testng.annotations.Test;

public class MultThreadOnAnnotion {

    @Test(invocationCount = 10,threadPoolSize = 2)
    public void test(){
        System.out.println("====    多线程   ==="+Thread.currentThread().getId());
    }
}
