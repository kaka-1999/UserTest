package model;

import lombok.Data;

@Data
public class UpdateUser {
    private int id;
    private int userid;
    private  String username;
    private String password;
    private int age;
    private String sex;
    private int permission;
    private int isDelete;
    private String expected;
}
