package model;

import lombok.Data;

@Data
public class Admin_User {
    private int id;
    private  String username;
    private String password;
    private int age;
    private String sex;
    private int permission;
    private int isDelete;
}
