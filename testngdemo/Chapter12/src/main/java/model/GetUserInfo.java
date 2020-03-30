package model;

import lombok.Data;

@Data
public class GetUserInfo {
    private int id;
    private int userid;
    private String expected;
}
