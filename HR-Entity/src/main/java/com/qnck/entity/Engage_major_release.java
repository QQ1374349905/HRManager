package com.qnck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 职位发表登记表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Engage_major_release {
    private int mre_id;
    private List<Config_file_first_kind> config_file_first_kinds;
    private String first_kind_name;
    private List<Config_file_second_kind> config_file_second_kinds;
    private String second_kind_name;
    private List<Config_file_third_kind> config_file_third_kinds;
    private String third_kind_name;
    private int major_kind_id;
    private String major_kind_name;
    private int major_id;
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
