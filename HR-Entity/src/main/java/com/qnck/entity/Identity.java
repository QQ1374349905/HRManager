package com.qnck.entity;

import lombok.Data;

import java.util.List;

@Data
public class Identity {
    private int identityId;
    private String identityName;
    private String identityRemark;
    private int identityStatus;
    private List<First_Permissions> firstPermissionsList;
}
