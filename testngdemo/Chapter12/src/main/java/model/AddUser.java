package model;

import lombok.Data;

@Data
public class AddUser {
    private int id;
    private  String username;
    private String password;
    private int age;
    private String sex;
    private int permission;
    private int isDelete;
    private String expected;
}
