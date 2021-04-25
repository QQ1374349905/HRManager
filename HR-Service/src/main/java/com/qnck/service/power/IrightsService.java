package com.qnck.service.power;

import com.github.pagehelper.Page;
import com.qnck.entity.Rights;
import com.qnck.entity.rights_control;

import java.util.List;

public interface IrightsService {

    List<Rights> queryAll();

    Page<Rights> queryBypage(int pageNum,int pageSize);

    Rights queryAndcontro(int id);

    void updaterights(Rights r, rights_control rc);

    void addrights(Rights r);

    void deleteRole(int id);
}
