package com.mybatis.model;

import lombok.Data;

@Data
public class UpdateLog {
    private int id;
    private String content;
    private int create_time;
    private int update_time;
    private int operator_id;
    private String title;
}
