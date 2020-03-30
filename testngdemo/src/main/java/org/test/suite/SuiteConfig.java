package org.test.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("====  @BeforeSuite  ====");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("====  @AfterSuite  ====");
    }
    @BeforeTest
    public void BeforeTest(){
        System.out.println("====  @BeforeTest  ====");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("====  @AfterTest  ====");
    }

}
