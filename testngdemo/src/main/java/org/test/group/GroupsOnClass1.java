package org.test.group;

import org.testng.annotations.Test;

@Test(groups = "Class1")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println("=====  GroupsOnClass1  stu1  =====");
    }

    public void stu2(){
        System.out.println("=====  GroupsOnClass1  stu2  =====");
    }
}
