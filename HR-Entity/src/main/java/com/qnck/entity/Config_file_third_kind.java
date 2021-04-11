package com.qnck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 三级机构设置
 * @author 32548
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config_file_third_kind {
    private int ftk_id;
    private int first_kind_id;
    private String first_kind_name;
    private int second_kind_id;
    private String second_kind_name;
    private int third_kind_id;
    private String third_kind_name;
    private int third_kind_sale_id;
    private int third_kind_is_retail;

}
