package org.test.multThread;

import org.testng.annotations.Test;

public class MultThreadOnXML {

    @Test
    public void test() {
        System.out.println("====    多线程   ===" + Thread.currentThread().getId());
    }
    @Test
    public void test2() {
        System.out.println("====    多线程   ===" + Thread.currentThread().getId());
    }
    @Test
    public void test3() {
        System.out.println("====    多线程   ===" + Thread.currentThread().getId());
    }
}
