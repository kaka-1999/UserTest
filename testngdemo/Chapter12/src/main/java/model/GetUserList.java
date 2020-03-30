package model;

import lombok.Data;

@Data
public class GetUserList {
    private int id;
    private String username;
    private int age;
    private String sex;
    private String expected;
}
