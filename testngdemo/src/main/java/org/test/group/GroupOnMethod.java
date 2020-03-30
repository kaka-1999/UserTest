package org.test.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {

    @Test(groups ="server")
    public  void  GroupOnMethod001(){
        System.out.println("=====  group:server     GroupOnMethod001  =====");
    }

    @Test(groups ="server")
    public  void  GroupOnMethod002(){
        System.out.println("=====  group:server     GroupOnMethod002  =====");
    }

    @Test(groups ="client")
    public  void  GroupOnMethod003(){
        System.out.println("=====  group:client     GroupOnMethod003  =====");
    }

    @Test(groups ="client")
    public  void  GroupOnMethod004(){
        System.out.println("=====  group:client     GroupOnMethod004  =====");
    }

    @BeforeGroups("server")
    public  void  BeforeGroupserver(){
        System.out.println("=====  BeforeGroup server  =====");
    }


    @AfterGroups("server")
    public  void  AfterGroupserver(){
        System.out.println("=====  AfterGroup server  =====");
    }

    @BeforeGroups("client")
    public  void  BeforeGroupclient(){
        System.out.println("=====  BeforeGroups client =====");
    }


    @AfterGroups("client")
    public  void  AfterGroupclient(){
        System.out.println("=====  AfterGroups client =====");
    }
}
