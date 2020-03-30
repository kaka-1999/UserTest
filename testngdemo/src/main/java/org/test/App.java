package org.test;

import org.testng.annotations.*;

/**执行顺序为
 * BeforeTest
 * BeforeClass
 * BeforeMethod
 * Test001
 * AfterMethod
 * BeforeMethod
 * Test002
 * AfterMethod
 * AfterClass
 * AfterTest
 *
 */
public class App {
    @Test
    public void testcase() {
        System.out.println("====  @Test  ====");
    }
    @Test
    public void testcase2() {
        System.out.println("====  @Test2  ====");
    }
    @BeforeTest
    public void beforecase() {
        System.out.println("====  @BeforeTest  ====");
    }

    @AfterTest
    public void aftercase() {
        System.out.println("====  @AfterTest  ====");

    }
    @BeforeMethod
    public  void BeforeMethod(){
        System.out.println("====  @BeforeMethod  ====");
    }
    @AfterMethod
    public  void AfterMethod(){
        System.out.println("====  @AfterMethod  ====");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("====  @BeforeClass  ====");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("====  @AfterClass  ====");
    }
    @BeforeSuite
    public  void BeforeSuite(){
        System.out.println("====  @BeforeSuite  ====");
    }
    @AfterSuite
    public  void beforeSuite(){
        System.out.println("====  @AfterSuite  ====");
    }
}