package com.qnck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一级机构设置
 * @author 32548
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config_file_first_kind {
    private int ffk_id;
    private int first_kind_id;
    private String first_kind_name;
    private String first_kind_salary_id;
    private int first_kind_sale_id;
}
