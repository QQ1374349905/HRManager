package com.qnck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共字段表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Config_public_char {
    private int pbc_id;
    private String attribute_kind;
    private String attribute_name;
}
