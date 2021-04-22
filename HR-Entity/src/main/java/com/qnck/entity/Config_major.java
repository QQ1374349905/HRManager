package com.qnck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 职位设置
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Config_major {
    private int mak_id;
    private int major_kind_id;
    private String major_kind_name;
    private int major_id;
    private String major_name;
    private int test_amount;
}
