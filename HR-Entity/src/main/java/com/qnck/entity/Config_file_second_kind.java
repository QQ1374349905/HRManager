package com.qnck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 二级机构设置
 * @author 32548
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config_file_second_kind {
    private int fsk_id;
    private int first_kind_id;
    private String  first_kind_name;
    private int  second_kind_id;
    private String  second_kind_name;
    private int  second_salary_id;
    private int  second_sale_id;
}
