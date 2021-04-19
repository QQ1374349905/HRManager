package com.qnck.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author zhangfuwei
 **/
@Data
public class Second_Permissions {
    private int secondPermissionsId;
    private String secondPermissionsName;
    private List<Third_Permissions> thirdPermissionsList;
}
