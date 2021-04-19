package com.qnck.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author zhangfuwei
 **/
@Data
public class First_Permissions {
    private int firstPermissionsId;
    private String firstPermissionsName;
    private List<Second_Permissions> secondPermissionsList;
}
