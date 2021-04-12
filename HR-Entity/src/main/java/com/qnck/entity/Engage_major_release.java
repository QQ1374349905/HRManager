package com.qnck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 职位发表登记表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Engage_major_release {
    private int mre_id;
    private Config_file_first_kind config_file_first_kinds;
    private String first_kind_name;
    private Config_file_second_kind config_file_second_kinds;
    private String second_kind_name;
    private Config_file_third_kind config_file_third_kinds;
    private String third_kind_name;
    private Config_major Config_major;
    private String major_kind_name;
    private String major_name;
    private int human_amount;
    private String engage_type;
    private Date deadline;
    private String register;
    private String changer;
    private Date regist_time;
    private Date change_time;
    private String major_describe;
    private String engage_required;
}
