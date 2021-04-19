package com.qnck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//职位分类
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Config_major_kind {
    private int mfk_id;//主键，自动增长列
    private int major_kind_id;//职位分类编号
    private String major_kind_name;//职分类位名称
}
