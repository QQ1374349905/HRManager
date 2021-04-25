package com.qnck.entity;

import lombok.Data;

/**
 * 角色管理
 */
@Data
public class Rights {
    private int r_id;
    private String r_name;
    private String r_explain;
    private int r_type;
    private  rights_control rc;
}
