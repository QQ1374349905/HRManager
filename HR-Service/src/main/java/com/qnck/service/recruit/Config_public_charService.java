package com.qnck.service.recruit;

import com.qnck.entity.Config_public_char;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Config_public_charService {
    List<Config_public_char> queryNationality(String attribute);
    List<Config_public_char> selectNationality();
}
